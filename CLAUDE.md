# CLAUDE.md

Guide Claude Code (claude.ai/code) for code in this repo.

> Part of Entur vehicle-registry workspace — see `../CLAUDE.md` for cross-project context (NeTEx, auth, sobek/hathor data flow). This file = shepet specifics.

## What shepet is

Read-only adapter: fetch single vehicle from **Statens Vegvesen (SVV) Autosys** by registration number, re-express as **NeTEx 2.0** XML. No DB, no writes, no persistence.

Request flow:
```
GET /services/autosys?registrationNumber=EV25288
  → AutosysAPIResource              (shepet-app, Jersey JAX-RS)
  → ShepetService.getVehicle()      (shepet-service, RestClient → Autosys REST)
      returns GetKjoretoyResponse    (Norwegian-named POJO tree)
  → MapperService.exportPublicationDeliveryWithAutosysVehicle()
      maps to NeTEx CompositeFrame/ResourceFrame (vehicle types, models, deck plans, vehicles)
  → PublicationDeliveryStreamingOutput.stream()   marshals to NeTEx XML (optional schema validation)
```

## Modules (`mvn` reactor, parent POM at root)

| Module | Packaging | Role |
|--------|-----------|------|
| `shepet-parent` | pom | Dependency mgmt + plugin config. Parent = `org.entur.ror:superpom`. Pins `netex-java-model`, `sobek`, `entur.helpers` versions. |
| `shepet-service` | jar | Library: Autosys REST client (`ShepetService`) + Norwegian-named model POJOs (Lombok `@Getter/@Setter`). No Spring web. |
| `shepet-app` | jar | Spring Boot app: Jersey REST, `MapperService` (Autosys→NeTEx), OAuth2 security, streaming output. Depends on `shepet-service`. Final artifact: `shepet-app/target/shepet.jar`. |

Key external deps: `org.entur:netex-java-model` (NeTEx JAXB model, SNAPSHOT), `org.rutebanken.sobek:sobek-common` (provides `PublicationDeliveryCreator`, `SobekResourceFrameExporter`, `SobekComositeFrameExporter`, `KeyValuesHelper`), `org.entur.ror.helpers:{oauth2,organisation,permission-store-proxy}`.

**sobek-common leaks Spring Boot 4.** It transitively pulls `spring-boot-starter-webclient:4.0.4` (Boot 4 / Jackson 3) into this Boot 3.5 / Jackson 2 app → duplicate `JacksonAutoConfiguration` + `tools.jackson` `NoClassDefFound`, context won't start. `shepet-app/pom.xml` excludes that starter (shepet uses `RestClient`, not WebClient). Real fix is upstream in sobek.

## Build & test

**Build with JDK 21.** Superpom enables JaCoCo 0.8.13, which can't instrument newer class files — JDK 26 (the SDKMAN default) fails with `Unsupported class file major version 70`. Use the installed 21:
```bash
export JAVA_HOME=~/.sdkman/candidates/java/21.0.10-oracle
```

```bash
mvn clean install          # full build, runs tests
mvn verify                 # what CI runs
mvn -pl shepet-app test -Dtest=MapperServiceTest        # single test class
mvn -pl shepet-app test -Dtest=MapperServiceTest#TestBusVehicleMapping   # single method
```

**Tests hit live Autosys API.** `ShepetServiceTest` and `MapperServiceTest` call `getVehicle(...)` with real registration numbers against `akfell-datautlevering.atlas.vegvesen.no`. Require:
- `AUTOSYS_API_APIKEY` env var (sent as `SVV-Authorization: Apikey <key>` header), and
- network access to SVV.

No mocks. `MapperServiceTest` writes marshalled NeTEx to `target/*.xml` for inspection. `ShepetTestApplication` excludes `ShepetSecurityConfig` and `SecurityAutoConfiguration` so `test` profile runs unauthenticated.

## Run locally

```bash
AUTOSYS_API_APIKEY=… mvn -pl shepet-app spring-boot:run   # local profile, port 37998
```
Default (non-local) server port = 8080 (see Dockerfile). Required env: `AUTOSYS_API_APIKEY`, plus for secured profiles `SHEPET_OAUTH2_RESOURCESERVER_AUTH0_ENTUR_PARTNER_JWT_{AUDIENCE,ISSUER_URI}`.

## Endpoints (Jersey servlets, `JerseyConfig`)

- `GET /services/autosys?registrationNumber=<plate>` → NeTEx XML. Public servlet mounted at `/services/*`.
- `/health/*` → `HealthResource`, separate servlet, `permitAll`.
- OpenAPI via `OpenApiResource` on both servlets.

## Security (`ShepetSecurityConfig`, `@Profile("!test")`)

OAuth2 resource server with `MultiIssuerAuthenticationManagerResolver` (Auth0 Entur partner issuer). `/health/*` open; everything else needs valid JWT. CORS allows all origins. Disabled entirely under `test` profile.

## Working with the mapping (`MapperService`)

Autosys model = deep, optional tree with **Norwegian field names**. Two dominant patterns:

1. **Null-guard chains** — every nested accessor (`getGodkjenning()`, `getTekniskGodkjenning()`, `getTekniskeData()`, …) checked for null before descending; id helpers fall back to `AUTOSYS:<Type>:<index>`.
2. **Reflection writes** — NeTEx `*_RelStructure` list fields (`vehicle`, `vehicleModel`, `deckPlan`, `transportType_Dummy`) have no public setter, so `setField(...)` sets via reflection. Reuse that helper rather than fighting the model.

Code/enum translations to know:
- `mapTransportMode` — Norwegian vehicle-class codes → NeTEx modes. `M2/M3` → `BUS`; `M1/M1G` (personbil) → **`TAXI`** (deliberate assumption: registered personal cars assumed taxis); tracked vehicles → `SNOW_AND_ICE`; else `OTHER`.
- `mapFuelType`, `mapPropulsionType`, `isLowFloor` — similar code→enum switches.

### Norwegian glossary (Autosys model, `shepet-service/.../model`)
| Norwegian | Meaning |
|-----------|---------|
| Kjøretøy (`Kjoretoy`) | Vehicle |
| Kjennemerke | Registration plate |
| Kjøretøydata (`Kjoretoydata`) | Vehicle data record |
| Godkjenning | Approval |
| Teknisk godkjenning | Technical approval |
| Tekniske data | Technical data |
| Registrering / Førstegangsregistrering | Registration / first-time registration |
| Karosseri og lasteplan | Body & load plan |
| Persontall | Passenger count (seating/standing) |
| Vekter / Dimensjoner | Weights / dimensions |
| Motor og drivverk | Engine & drivetrain |
| Miljødata | Environmental data |

## NeTEx output config (properties)

- `publicationDeliveryStreamingOutput.validateAgainstSchema` — validate marshalled XML against NeTEx 2.0 schema (`true` local/default, `false` in prod `application.properties`).
- `netex.validPrefix=NMR`, `netex.profile.version=2.0:NO-NeTEx:2.0`.

## Conventions

EUPL-1.2 license header on `shepet-app` source files. Java 21, Spring Boot, Lombok (annotation processing configured in `shepet-parent`). Generated NeTEx ids prefixed `AUTOSYS:<Type>:<key>`.