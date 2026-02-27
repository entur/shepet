package org.entur.shepet.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public class ForstegangsGodkjenning {

  private Bruktimport bruktimport;
  private LocalDate forstegangRegistrertDato;
  private FortollingOgMva fortollingOgMva;
  private String godkjenningsId;
  private Kode godkjenningsundertype;
  private LocalDate gyldigFraDato;
  private OffsetDateTime gyldigFraDatoTid;
  private Kode kvalitetskodeForstegangRegDato;
  private OppbygdMedAvgiftsfritak oppbygdMedAvgiftsfritak;
  private List<UnntakWrapper> unntak;

  // getters and setters
  public Bruktimport getBruktimport() {
    return bruktimport;
  }

  public void setBruktimport(Bruktimport bruktimport) {
    this.bruktimport = bruktimport;
  }

  public LocalDate getForstegangRegistrertDato() {
    return forstegangRegistrertDato;
  }

  public void setForstegangRegistrertDato(LocalDate forstegangRegistrertDato) {
    this.forstegangRegistrertDato = forstegangRegistrertDato;
  }

  public FortollingOgMva getFortollingOgMva() {
    return fortollingOgMva;
  }

  public void setFortollingOgMva(FortollingOgMva fortollingOgMva) {
    this.fortollingOgMva = fortollingOgMva;
  }

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

  public Kode getKvalitetskodeForstegangRegDato() {
    return kvalitetskodeForstegangRegDato;
  }

  public void setKvalitetskodeForstegangRegDato(
    Kode kvalitetskodeForstegangRegDato
  ) {
    this.kvalitetskodeForstegangRegDato = kvalitetskodeForstegangRegDato;
  }

  public OppbygdMedAvgiftsfritak getOppbygdMedAvgiftsfritak() {
    return oppbygdMedAvgiftsfritak;
  }

  public void setOppbygdMedAvgiftsfritak(
    OppbygdMedAvgiftsfritak oppbygdMedAvgiftsfritak
  ) {
    this.oppbygdMedAvgiftsfritak = oppbygdMedAvgiftsfritak;
  }

  public List<UnntakWrapper> getUnntak() {
    return unntak;
  }

  public void setUnntak(List<UnntakWrapper> unntak) {
    this.unntak = unntak;
  }

  public static class Bruktimport {

    private Land importland;
    private Integer kilometerstand;
    private String tidligereUtenlandskKjennemerke;
    private String tidligereUtenlandskVognkortNummer;

    // getters and setters
    public Land getImportland() {
      return importland;
    }

    public void setImportland(Land importland) {
      this.importland = importland;
    }

    public Integer getKilometerstand() {
      return kilometerstand;
    }

    public void setKilometerstand(Integer kilometerstand) {
      this.kilometerstand = kilometerstand;
    }

    public String getTidligereUtenlandskKjennemerke() {
      return tidligereUtenlandskKjennemerke;
    }

    public void setTidligereUtenlandskKjennemerke(
      String tidligereUtenlandskKjennemerke
    ) {
      this.tidligereUtenlandskKjennemerke = tidligereUtenlandskKjennemerke;
    }

    public String getTidligereUtenlandskVognkortNummer() {
      return tidligereUtenlandskVognkortNummer;
    }

    public void setTidligereUtenlandskVognkortNummer(
      String tidligereUtenlandskVognkortNummer
    ) {
      this.tidligereUtenlandskVognkortNummer =
        tidligereUtenlandskVognkortNummer;
    }
  }

  public static class Land {

    private String landNavn;
    private String landkode;

    // getters and setters
    public String getLandNavn() {
      return landNavn;
    }

    public void setLandNavn(String landNavn) {
      this.landNavn = landNavn;
    }

    public String getLandkode() {
      return landkode;
    }

    public void setLandkode(String landkode) {
      this.landkode = landkode;
    }
  }

  public static class FortollingOgMva {

    private String annenReferanse;
    private String beskrivelse;
    private String dokumentreferanse;
    private String fortollingsreferanse;
    private Integer linje;

    // getters and setters
    public String getAnnenReferanse() {
      return annenReferanse;
    }

    public void setAnnenReferanse(String annenReferanse) {
      this.annenReferanse = annenReferanse;
    }

    public String getBeskrivelse() {
      return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
      this.beskrivelse = beskrivelse;
    }

    public String getDokumentreferanse() {
      return dokumentreferanse;
    }

    public void setDokumentreferanse(String dokumentreferanse) {
      this.dokumentreferanse = dokumentreferanse;
    }

    public String getFortollingsreferanse() {
      return fortollingsreferanse;
    }

    public void setFortollingsreferanse(String fortollingsreferanse) {
      this.fortollingsreferanse = fortollingsreferanse;
    }

    public Integer getLinje() {
      return linje;
    }

    public void setLinje(Integer linje) {
      this.linje = linje;
    }
  }

  public static class OppbygdMedAvgiftsfritak {

    private List<String> arkivreferanse;
    private List<Kjoretoy> delekjoretoy;
    private Kjoretoy erstattetKjoretoy;

    // getters and setters
    public List<String> getArkivreferanse() {
      return arkivreferanse;
    }

    public void setArkivreferanse(List<String> arkivreferanse) {
      this.arkivreferanse = arkivreferanse;
    }

    public List<Kjoretoy> getDelekjoretoy() {
      return delekjoretoy;
    }

    public void setDelekjoretoy(List<Kjoretoy> delekjoretoy) {
      this.delekjoretoy = delekjoretoy;
    }

    public Kjoretoy getErstattetKjoretoy() {
      return erstattetKjoretoy;
    }

    public void setErstattetKjoretoy(Kjoretoy erstattetKjoretoy) {
      this.erstattetKjoretoy = erstattetKjoretoy;
    }
  }

  public static class Kjoretoy {

    private String kuid;
    private UnderstellsbasertId understellsbasertId;

    // getters and setters
    public String getKuid() {
      return kuid;
    }

    public void setKuid(String kuid) {
      this.kuid = kuid;
    }

    public UnderstellsbasertId getUnderstellsbasertId() {
      return understellsbasertId;
    }

    public void setUnderstellsbasertId(
      UnderstellsbasertId understellsbasertId
    ) {
      this.understellsbasertId = understellsbasertId;
    }
  }

  public static class UnderstellsbasertId {

    private String merkekode;
    private String understellsnummer;

    // getters and setters
    public String getMerkekode() {
      return merkekode;
    }

    public void setMerkekode(String merkekode) {
      this.merkekode = merkekode;
    }

    public String getUnderstellsnummer() {
      return understellsnummer;
    }

    public void setUnderstellsnummer(String understellsnummer) {
      this.understellsnummer = understellsnummer;
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
