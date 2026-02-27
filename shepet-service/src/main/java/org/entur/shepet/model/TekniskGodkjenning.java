package org.entur.shepet.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

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

  // getters and setters

  public String getGodkjenningsId() {
    return godkjenningsId;
  }

  public void setGodkjenningsId(String godkjenningsId) {
    this.godkjenningsId = godkjenningsId;
  }

  public Kode getGodkjenningsundertype() {
    return godkjenningsundertype;
  }

  public void setGodkjenningsundertype(Kode godkjenningsundertype) {
    this.godkjenningsundertype = godkjenningsundertype;
  }

  public LocalDate getGyldigFraDato() {
    return gyldigFraDato;
  }

  public void setGyldigFraDato(LocalDate gyldigFraDato) {
    this.gyldigFraDato = gyldigFraDato;
  }

  public OffsetDateTime getGyldigFraDatoTid() {
    return gyldigFraDatoTid;
  }

  public void setGyldigFraDatoTid(OffsetDateTime gyldigFraDatoTid) {
    this.gyldigFraDatoTid = gyldigFraDatoTid;
  }

  public Kjoretoyklassifisering getKjoretoyklassifisering() {
    return kjoretoyklassifisering;
  }

  public void setKjoretoyklassifisering(
    Kjoretoyklassifisering kjoretoyklassifisering
  ) {
    this.kjoretoyklassifisering = kjoretoyklassifisering;
  }

  public Korreksjon getKorreksjon() {
    return korreksjon;
  }

  public void setKorreksjon(Korreksjon korreksjon) {
    this.korreksjon = korreksjon;
  }

  public List<Krav> getKrav() {
    return krav;
  }

  public void setKrav(List<Krav> krav) {
    this.krav = krav;
  }

  public TekniskeData getTekniskeData() {
    return tekniskeData;
  }

  public void setTekniskeData(TekniskeData tekniskeData) {
    this.tekniskeData = tekniskeData;
  }

  public List<UnntakWrapper> getUnntak() {
    return unntak;
  }

  public void setUnntak(List<UnntakWrapper> unntak) {
    this.unntak = unntak;
  }

  public static class Kjoretoyklassifisering {

    private String beskrivelse;
    private EfTypegodkjenning efTypegodkjenning;
    private Kode kjoretoyAvgiftsKode;
    private NasjonalGodkjenning nasjonalGodkjenning;
    private String spesielleKjennetegn;
    private Kode tekniskKode;
    private Kode tekniskUnderkode;
    private Boolean iSamsvarMedTypegodkjenning;

    // getters and setters
    public String getBeskrivelse() {
      return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
      this.beskrivelse = beskrivelse;
    }

    public EfTypegodkjenning getEfTypegodkjenning() {
      return efTypegodkjenning;
    }

    public void setEfTypegodkjenning(EfTypegodkjenning efTypegodkjenning) {
      this.efTypegodkjenning = efTypegodkjenning;
    }

    public Kode getKjoretoyAvgiftsKode() {
      return kjoretoyAvgiftsKode;
    }

    public void setKjoretoyAvgiftsKode(Kode kjoretoyAvgiftsKode) {
      this.kjoretoyAvgiftsKode = kjoretoyAvgiftsKode;
    }

    public NasjonalGodkjenning getNasjonalGodkjenning() {
      return nasjonalGodkjenning;
    }

    public void setNasjonalGodkjenning(
      NasjonalGodkjenning nasjonalGodkjenning
    ) {
      this.nasjonalGodkjenning = nasjonalGodkjenning;
    }

    public String getSpesielleKjennetegn() {
      return spesielleKjennetegn;
    }

    public void setSpesielleKjennetegn(String spesielleKjennetegn) {
      this.spesielleKjennetegn = spesielleKjennetegn;
    }

    public Kode getTekniskKode() {
      return tekniskKode;
    }

    public void setTekniskKode(Kode tekniskKode) {
      this.tekniskKode = tekniskKode;
    }

    public Kode getTekniskUnderkode() {
      return tekniskUnderkode;
    }

    public void setTekniskUnderkode(Kode tekniskUnderkode) {
      this.tekniskUnderkode = tekniskUnderkode;
    }

    public Boolean isiSamsvarMedTypegodkjenning() {
      return iSamsvarMedTypegodkjenning;
    }

    public void setiSamsvarMedTypegodkjenning(
      Boolean iSamsvarMedTypegodkjenning
    ) {
      this.iSamsvarMedTypegodkjenning = iSamsvarMedTypegodkjenning;
    }
  }

  public static class EfTypegodkjenning {

    private String typegodkjenningNrTekst;
    private Typegodkjenningnummer typegodkjenningnummer;
    private String variant;
    private String versjon;

    // getters and setters
    public String getTypegodkjenningNrTekst() {
      return typegodkjenningNrTekst;
    }

    public void setTypegodkjenningNrTekst(String typegodkjenningNrTekst) {
      this.typegodkjenningNrTekst = typegodkjenningNrTekst;
    }

    public Typegodkjenningnummer getTypegodkjenningnummer() {
      return typegodkjenningnummer;
    }

    public void setTypegodkjenningnummer(
      Typegodkjenningnummer typegodkjenningnummer
    ) {
      this.typegodkjenningnummer = typegodkjenningnummer;
    }

    public String getVariant() {
      return variant;
    }

    public void setVariant(String variant) {
      this.variant = variant;
    }

    public String getVersjon() {
      return versjon;
    }

    public void setVersjon(String versjon) {
      this.versjon = versjon;
    }
  }

  public static class Typegodkjenningnummer {

    private String direktiv;
    private String land;
    private String serie;
    private String utvidelse;

    // getters and setters
    public String getDirektiv() {
      return direktiv;
    }

    public void setDirektiv(String direktiv) {
      this.direktiv = direktiv;
    }

    public String getLand() {
      return land;
    }

    public void setLand(String land) {
      this.land = land;
    }

    public String getSerie() {
      return serie;
    }

    public void setSerie(String serie) {
      this.serie = serie;
    }

    public String getUtvidelse() {
      return utvidelse;
    }

    public void setUtvidelse(String utvidelse) {
      this.utvidelse = utvidelse;
    }
  }

  public static class NasjonalGodkjenning {

    private String nasjonaltGodkjenningsAr;
    private String nasjonaltGodkjenningsHovednummer;
    private String nasjonaltGodkjenningsUndernummer;

    // getters and setters
    public String getNasjonaltGodkjenningsAr() {
      return nasjonaltGodkjenningsAr;
    }

    public void setNasjonaltGodkjenningsAr(String nasjonaltGodkjenningsAr) {
      this.nasjonaltGodkjenningsAr = nasjonaltGodkjenningsAr;
    }

    public String getNasjonaltGodkjenningsHovednummer() {
      return nasjonaltGodkjenningsHovednummer;
    }

    public void setNasjonaltGodkjenningsHovednummer(
      String nasjonaltGodkjenningsHovednummer
    ) {
      this.nasjonaltGodkjenningsHovednummer = nasjonaltGodkjenningsHovednummer;
    }

    public String getNasjonaltGodkjenningsUndernummer() {
      return nasjonaltGodkjenningsUndernummer;
    }

    public void setNasjonaltGodkjenningsUndernummer(
      String nasjonaltGodkjenningsUndernummer
    ) {
      this.nasjonaltGodkjenningsUndernummer = nasjonaltGodkjenningsUndernummer;
    }
  }

  public static class Korreksjon {

    private Boolean godkjenningErKorrigert;
    private LocalDate virkningsdato;
    private List<String> felterEndret;

    // getters and setters
    public Boolean isGodkjenningErKorrigert() {
      return godkjenningErKorrigert;
    }

    public void setGodkjenningErKorrigert(Boolean godkjenningErKorrigert) {
      this.godkjenningErKorrigert = godkjenningErKorrigert;
    }

    public LocalDate getVirkningsdato() {
      return virkningsdato;
    }

    public void setVirkningsdato(LocalDate virkningsdato) {
      this.virkningsdato = virkningsdato;
    }

    public List<String> getFelterEndret() {
      return felterEndret;
    }

    public void setFelterEndret(List<String> felterEndret) {
      this.felterEndret = felterEndret;
    }
  }

  public static class Krav {

    private Kode kravomrade;
    private Kode kravoppfyllelse;

    // getters and setters
    public Kode getKravomrade() {
      return kravomrade;
    }

    public void setKravomrade(Kode kravomrade) {
      this.kravomrade = kravomrade;
    }

    public Kode getKravoppfyllelse() {
      return kravoppfyllelse;
    }

    public void setKravoppfyllelse(Kode kravoppfyllelse) {
      this.kravoppfyllelse = kravoppfyllelse;
    }
  }

  public static class UnntakWrapper {

    private Kode unntak;

    // getters and setters

    public Kode getUnntak() {
      return unntak;
    }

    public void setUnntak(Kode unntak) {
      this.unntak = unntak;
    }
  }
}
