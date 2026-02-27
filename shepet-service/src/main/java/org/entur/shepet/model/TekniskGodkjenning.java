package org.entur.shepet.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
public class TekniskGodkjenning {
  private String godkjenningsId;
  private Kode godkjenningsundertype;
  private LocalDate gyldigFraDato;
  private OffsetDateTime gyldigFraDatoTid;
  private Kjoretoyklassifisering kjoretoyklassifisering;
  private Korreksjon korreksjon;
  private List<Krav> krav;
  private TekniskeData tekniskeData;
  private List<UnntakWrapper> unntak;

  @Getter
  @Setter
  public static class Kjoretoyklassifisering {
    private String beskrivelse;
    private EfTypegodkjenning efTypegodkjenning;
    private Kode kjoretoyAvgiftsKode;
    private NasjonalGodkjenning nasjonalGodkjenning;
    private String spesielleKjennetegn;
    private Kode tekniskKode;
    private Kode tekniskUnderkode;
    private Boolean iSamsvarMedTypegodkjenning;
  }

  @Getter
  @Setter
  public static class EfTypegodkjenning {
    private String typegodkjenningNrTekst;
    private Typegodkjenningnummer typegodkjenningnummer;
    private String variant;
    private String versjon;
  }

  @Getter
  @Setter
  public static class Typegodkjenningnummer {
    private String direktiv;
    private String land;
    private String serie;
    private String utvidelse;
  }

  @Getter
  @Setter
  public static class NasjonalGodkjenning {
    private String nasjonaltGodkjenningsAr;
    private String nasjonaltGodkjenningsHovednummer;
    private String nasjonaltGodkjenningsUndernummer;
  }

  @Getter
  @Setter
  public static class Korreksjon {
    private Boolean godkjenningErKorrigert;
    private LocalDate virkningsdato;
    private List<String> felterEndret;
  }

  @Getter
  @Setter
  public static class Krav {
    private Kode kravomrade;
    private Kode kravoppfyllelse;
  }

  @Getter
  @Setter
  public static class UnntakWrapper {
    private Kode unntak;
  }
}
