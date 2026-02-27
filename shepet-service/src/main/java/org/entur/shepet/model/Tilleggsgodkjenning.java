package org.entur.shepet.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public class Tilleggsgodkjenning {

  private Kode godkjenningstype;
  private LocalDate godkjentFra;
  private OffsetDateTime godkjentFraDatoTid;
  private LocalDate godkjentTil;
  private OffsetDateTime godkjentTilDatoTid;
  private Korreksjon korreksjon;
  private List<Krav> krav;
  private TilleggsgodkjenningSpesifikkeData tilleggsgodkjenningSpesifikkeData;

  // getters and setters
  public Kode getGodkjenningstype() {
    return godkjenningstype;
  }

  public void setGodkjenningstype(Kode godkjenningstype) {
    this.godkjenningstype = godkjenningstype;
  }

  public LocalDate getGodkjentFra() {
    return godkjentFra;
  }

  public void setGodkjentFra(LocalDate godkjentFra) {
    this.godkjentFra = godkjentFra;
  }

  public OffsetDateTime getGodkjentFraDatoTid() {
    return godkjentFraDatoTid;
  }

  public void setGodkjentFraDatoTid(OffsetDateTime godkjentFraDatoTid) {
    this.godkjentFraDatoTid = godkjentFraDatoTid;
  }

  public LocalDate getGodkjentTil() {
    return godkjentTil;
  }

  public void setGodkjentTil(LocalDate godkjentTil) {
    this.godkjentTil = godkjentTil;
  }

  public OffsetDateTime getGodkjentTilDatoTid() {
    return godkjentTilDatoTid;
  }

  public void setGodkjentTilDatoTid(OffsetDateTime godkjentTilDatoTid) {
    this.godkjentTilDatoTid = godkjentTilDatoTid;
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

  public TilleggsgodkjenningSpesifikkeData getTilleggsgodkjenningSpesifikkeData() {
    return tilleggsgodkjenningSpesifikkeData;
  }

  public void setTilleggsgodkjenningSpesifikkeData(
    TilleggsgodkjenningSpesifikkeData tilleggsgodkjenningSpesifikkeData
  ) {
    this.tilleggsgodkjenningSpesifikkeData = tilleggsgodkjenningSpesifikkeData;
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

  public static class TilleggsgodkjenningSpesifikkeData {

    private AdrGodkjenning adrGodkjenning;
    private DyretransportGodkjenning dyretransportGodkjenning;
    private LarevognGodkjenning larevognGodkjenning;

    // getters and setters
    public AdrGodkjenning getAdrGodkjenning() {
      return adrGodkjenning;
    }

    public void setAdrGodkjenning(AdrGodkjenning adrGodkjenning) {
      this.adrGodkjenning = adrGodkjenning;
    }

    public DyretransportGodkjenning getDyretransportGodkjenning() {
      return dyretransportGodkjenning;
    }

    public void setDyretransportGodkjenning(
      DyretransportGodkjenning dyretransportGodkjenning
    ) {
      this.dyretransportGodkjenning = dyretransportGodkjenning;
    }

    public LarevognGodkjenning getLarevognGodkjenning() {
      return larevognGodkjenning;
    }

    public void setLarevognGodkjenning(
      LarevognGodkjenning larevognGodkjenning
    ) {
      this.larevognGodkjenning = larevognGodkjenning;
    }
  }

  public static class AdrGodkjenning {

    private String adrAnmerkninger;
    private String adrAttestnummer;
    private Kode adrBeskyttelseOverLastbarerKode;
    private String adrEX2EX3GodkjentGods;
    private Boolean adrKjoretoyLukket;
    private Boolean adrNasjonaleKrav;
    private Kode adrPabyggTypeKode;
    private AdrTankTekniskeData adrTankTekniskeData;
    private Boolean adrTidligereBestemmelser;
    private String adrTilleggsbremsEffekt;
    private Boolean adrTilleggsbremsIkkeAktuelt;
    private String adrTransportorAdresse;
    private String adrTransportorNavn;
    private String adrTransportorPostnrSted;
    private List<String> adrTypeKode;
    private String adrVekselbyggID;
    private String adrVekselbyggIDFra;
    private String adrVekselbyggIDTil;

    // getters and setters
    public String getAdrAnmerkninger() {
      return adrAnmerkninger;
    }

    public void setAdrAnmerkninger(String adrAnmerkninger) {
      this.adrAnmerkninger = adrAnmerkninger;
    }

    public String getAdrAttestnummer() {
      return adrAttestnummer;
    }

    public void setAdrAttestnummer(String adrAttestnummer) {
      this.adrAttestnummer = adrAttestnummer;
    }

    public Kode getAdrBeskyttelseOverLastbarerKode() {
      return adrBeskyttelseOverLastbarerKode;
    }

    public void setAdrBeskyttelseOverLastbarerKode(
      Kode adrBeskyttelseOverLastbarerKode
    ) {
      this.adrBeskyttelseOverLastbarerKode = adrBeskyttelseOverLastbarerKode;
    }

    public String getAdrEX2EX3GodkjentGods() {
      return adrEX2EX3GodkjentGods;
    }

    public void setAdrEX2EX3GodkjentGods(String adrEX2EX3GodkjentGods) {
      this.adrEX2EX3GodkjentGods = adrEX2EX3GodkjentGods;
    }

    public Boolean isAdrKjoretoyLukket() {
      return adrKjoretoyLukket;
    }

    public void setAdrKjoretoyLukket(Boolean adrKjoretoyLukket) {
      this.adrKjoretoyLukket = adrKjoretoyLukket;
    }

    public Boolean isAdrNasjonaleKrav() {
      return adrNasjonaleKrav;
    }

    public void setAdrNasjonaleKrav(Boolean adrNasjonaleKrav) {
      this.adrNasjonaleKrav = adrNasjonaleKrav;
    }

    public Kode getAdrPabyggTypeKode() {
      return adrPabyggTypeKode;
    }

    public void setAdrPabyggTypeKode(Kode adrPabyggTypeKode) {
      this.adrPabyggTypeKode = adrPabyggTypeKode;
    }

    public AdrTankTekniskeData getAdrTankTekniskeData() {
      return adrTankTekniskeData;
    }

    public void setAdrTankTekniskeData(
      AdrTankTekniskeData adrTankTekniskeData
    ) {
      this.adrTankTekniskeData = adrTankTekniskeData;
    }

    public Boolean isAdrTidligereBestemmelser() {
      return adrTidligereBestemmelser;
    }

    public void setAdrTidligereBestemmelser(Boolean adrTidligereBestemmelser) {
      this.adrTidligereBestemmelser = adrTidligereBestemmelser;
    }

    public String getAdrTilleggsbremsEffekt() {
      return adrTilleggsbremsEffekt;
    }

    public void setAdrTilleggsbremsEffekt(String adrTilleggsbremsEffekt) {
      this.adrTilleggsbremsEffekt = adrTilleggsbremsEffekt;
    }

    public Boolean isAdrTilleggsbremsIkkeAktuelt() {
      return adrTilleggsbremsIkkeAktuelt;
    }

    public void setAdrTilleggsbremsIkkeAktuelt(
      Boolean adrTilleggsbremsIkkeAktuelt
    ) {
      this.adrTilleggsbremsIkkeAktuelt = adrTilleggsbremsIkkeAktuelt;
    }

    public String getAdrTransportorAdresse() {
      return adrTransportorAdresse;
    }

    public void setAdrTransportorAdresse(String adrTransportorAdresse) {
      this.adrTransportorAdresse = adrTransportorAdresse;
    }

    public String getAdrTransportorNavn() {
      return adrTransportorNavn;
    }

    public void setAdrTransportorNavn(String adrTransportorNavn) {
      this.adrTransportorNavn = adrTransportorNavn;
    }

    public String getAdrTransportorPostnrSted() {
      return adrTransportorPostnrSted;
    }

    public void setAdrTransportorPostnrSted(String adrTransportorPostnrSted) {
      this.adrTransportorPostnrSted = adrTransportorPostnrSted;
    }

    public List<String> getAdrTypeKode() {
      return adrTypeKode;
    }

    public void setAdrTypeKode(List<String> adrTypeKode) {
      this.adrTypeKode = adrTypeKode;
    }

    public String getAdrVekselbyggID() {
      return adrVekselbyggID;
    }

    public void setAdrVekselbyggID(String adrVekselbyggID) {
      this.adrVekselbyggID = adrVekselbyggID;
    }

    public String getAdrVekselbyggIDFra() {
      return adrVekselbyggIDFra;
    }

    public void setAdrVekselbyggIDFra(String adrVekselbyggIDFra) {
      this.adrVekselbyggIDFra = adrVekselbyggIDFra;
    }

    public String getAdrVekselbyggIDTil() {
      return adrVekselbyggIDTil;
    }

    public void setAdrVekselbyggIDTil(String adrVekselbyggIDTil) {
      this.adrVekselbyggIDTil = adrVekselbyggIDTil;
    }
  }

  public static class AdrTankTekniskeData {

    private Integer adrTankAntallRom;
    private String adrTankFabrikat;
    private String adrTankGodkjenningsnummer;
    private List<AdrTankGodkjentGods> adrTankGodkjentGods;
    private AdrTankInndeling adrTankInndeling;
    private String adrTankKode;
    private Boolean adrTankKofferdam;
    private Boolean adrTankLos;
    private LocalDate adrTankNesteTetthetsproveDato;
    private LocalDate adrTankNesteTrykkproveDato;
    private String adrTankOverflyttetFra;
    private Integer adrTankProduksjonsAr;
    private String adrTankSerienummer;
    private String adrTankSpesielleBestemmelser;
    private Integer adrTankVolum;

    // getters and setters
    public Integer getAdrTankAntallRom() {
      return adrTankAntallRom;
    }

    public void setAdrTankAntallRom(Integer adrTankAntallRom) {
      this.adrTankAntallRom = adrTankAntallRom;
    }

    public String getAdrTankFabrikat() {
      return adrTankFabrikat;
    }

    public void setAdrTankFabrikat(String adrTankFabrikat) {
      this.adrTankFabrikat = adrTankFabrikat;
    }

    public String getAdrTankGodkjenningsnummer() {
      return adrTankGodkjenningsnummer;
    }

    public void setAdrTankGodkjenningsnummer(String adrTankGodkjenningsnummer) {
      this.adrTankGodkjenningsnummer = adrTankGodkjenningsnummer;
    }

    public List<AdrTankGodkjentGods> getAdrTankGodkjentGods() {
      return adrTankGodkjentGods;
    }

    public void setAdrTankGodkjentGods(
      List<AdrTankGodkjentGods> adrTankGodkjentGods
    ) {
      this.adrTankGodkjentGods = adrTankGodkjentGods;
    }

    public AdrTankInndeling getAdrTankInndeling() {
      return adrTankInndeling;
    }

    public void setAdrTankInndeling(AdrTankInndeling adrTankInndeling) {
      this.adrTankInndeling = adrTankInndeling;
    }

    public String getAdrTankKode() {
      return adrTankKode;
    }

    public void setAdrTankKode(String adrTankKode) {
      this.adrTankKode = adrTankKode;
    }

    public Boolean isAdrTankKofferdam() {
      return adrTankKofferdam;
    }

    public void setAdrTankKofferdam(Boolean adrTankKofferdam) {
      this.adrTankKofferdam = adrTankKofferdam;
    }

    public Boolean isAdrTankLos() {
      return adrTankLos;
    }

    public void setAdrTankLos(Boolean adrTankLos) {
      this.adrTankLos = adrTankLos;
    }

    public LocalDate getAdrTankNesteTetthetsproveDato() {
      return adrTankNesteTetthetsproveDato;
    }

    public void setAdrTankNesteTetthetsproveDato(
      LocalDate adrTankNesteTetthetsproveDato
    ) {
      this.adrTankNesteTetthetsproveDato = adrTankNesteTetthetsproveDato;
    }

    public LocalDate getAdrTankNesteTrykkproveDato() {
      return adrTankNesteTrykkproveDato;
    }

    public void setAdrTankNesteTrykkproveDato(
      LocalDate adrTankNesteTrykkproveDato
    ) {
      this.adrTankNesteTrykkproveDato = adrTankNesteTrykkproveDato;
    }

    public String getAdrTankOverflyttetFra() {
      return adrTankOverflyttetFra;
    }

    public void setAdrTankOverflyttetFra(String adrTankOverflyttetFra) {
      this.adrTankOverflyttetFra = adrTankOverflyttetFra;
    }

    public Integer getAdrTankProduksjonsAr() {
      return adrTankProduksjonsAr;
    }

    public void setAdrTankProduksjonsAr(Integer adrTankProduksjonsAr) {
      this.adrTankProduksjonsAr = adrTankProduksjonsAr;
    }

    public String getAdrTankSerienummer() {
      return adrTankSerienummer;
    }

    public void setAdrTankSerienummer(String adrTankSerienummer) {
      this.adrTankSerienummer = adrTankSerienummer;
    }

    public String getAdrTankSpesielleBestemmelser() {
      return adrTankSpesielleBestemmelser;
    }

    public void setAdrTankSpesielleBestemmelser(
      String adrTankSpesielleBestemmelser
    ) {
      this.adrTankSpesielleBestemmelser = adrTankSpesielleBestemmelser;
    }

    public Integer getAdrTankVolum() {
      return adrTankVolum;
    }

    public void setAdrTankVolum(Integer adrTankVolum) {
      this.adrTankVolum = adrTankVolum;
    }
  }

  public static class AdrTankGodkjentGods {

    private String adrTankGodkjentFor;
    private Boolean adrTankStofferIhhtTankkode;

    // getters and setters
    public String getAdrTankGodkjentFor() {
      return adrTankGodkjentFor;
    }

    public void setAdrTankGodkjentFor(String adrTankGodkjentFor) {
      this.adrTankGodkjentFor = adrTankGodkjentFor;
    }

    public Boolean isAdrTankStofferIhhtTankkode() {
      return adrTankStofferIhhtTankkode;
    }

    public void setAdrTankStofferIhhtTankkode(
      Boolean adrTankStofferIhhtTankkode
    ) {
      this.adrTankStofferIhhtTankkode = adrTankStofferIhhtTankkode;
    }
  }

  public static class AdrTankInndeling {

    private List<Integer> adrTankInndelingVolum;

    // getters and setters

    public List<Integer> getAdrTankInndelingVolum() {
      return adrTankInndelingVolum;
    }

    public void setAdrTankInndelingVolum(List<Integer> adrTankInndelingVolum) {
      this.adrTankInndelingVolum = adrTankInndelingVolum;
    }
  }

  public static class DyretransportGodkjenning {

    private Boolean fornyelse;
    private Double gulvareal;
    private Kode hestetransporttype;
    private Integer takhoyde;

    // getters and setters
    public Boolean isFornyelse() {
      return fornyelse;
    }

    public void setFornyelse(Boolean fornyelse) {
      this.fornyelse = fornyelse;
    }

    public Double getGulvareal() {
      return gulvareal;
    }

    public void setGulvareal(Double gulvareal) {
      this.gulvareal = gulvareal;
    }

    public Kode getHestetransporttype() {
      return hestetransporttype;
    }

    public void setHestetransporttype(Kode hestetransporttype) {
      this.hestetransporttype = hestetransporttype;
    }

    public Integer getTakhoyde() {
      return takhoyde;
    }

    public void setTakhoyde(Integer takhoyde) {
      this.takhoyde = takhoyde;
    }
  }

  public static class LarevognGodkjenning {

    private Kode forekortklasser;
    private Kode larevogn;

    // getters and setters
    public Kode getForekortklasser() {
      return forekortklasser;
    }

    public void setForekortklasser(Kode forekortklasser) {
      this.forekortklasser = forekortklasser;
    }

    public Kode getLarevogn() {
      return larevogn;
    }

    public void setLarevogn(Kode larevogn) {
      this.larevogn = larevogn;
    }
  }
}
