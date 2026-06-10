# shepet
API that exposes information from Statens Veivesen's Autosys as NeTEx 2.0 data

## Build & run

**Build with JDK 21.** The superpom enables JaCoCo 0.8.13, which cannot instrument newer class files — building under JDK 26 fails with `Unsupported class file major version 70`.

```bash
export JAVA_HOME=/path/to/jdk-21
mvn clean install
```

Tests are live integration tests against SVV Autosys (`akfell-datautlevering.atlas.vegvesen.no`) — they require `AUTOSYS_API_APIKEY` and network access to SVV; there are no mocks.

Run locally (local profile, port 37998):
```bash
AUTOSYS_API_APIKEY=… mvn -pl shepet-app spring-boot:run
```

Required environment:
- `AUTOSYS_API_APIKEY` — sent as `SVV-Authorization: Apikey <key>`.
- `SHEPET_OAUTH2_RESOURCESERVER_AUTH0_ENTUR_PARTNER_JWT_AUDIENCE`
- `SHEPET_OAUTH2_RESOURCESERVER_AUTH0_ENTUR_PARTNER_JWT_ISSUER_URI`

The two OAuth2 values are required for any non-`test` profile — without them the `multiIssuerAuthenticationManagerResolver` bean fails at startup (`Could not resolve placeholder …`).

Endpoint: `GET /services/autosys?registrationNumber=<plate>` → NeTEx XML.

### Note on dependencies

`sobek-common` transitively pulls `spring-boot-starter-webclient:4.0.4` (Spring Boot 4 / Jackson 3) into this Spring Boot 3.5 application, breaking context startup. `shepet-app/pom.xml` excludes that starter as a workaround (shepet uses `RestClient`, not WebClient). The proper fix belongs upstream in sobek.
