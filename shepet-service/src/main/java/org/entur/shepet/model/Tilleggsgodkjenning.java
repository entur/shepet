package org.entur.shepet.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
public class Tilleggsgodkjenning {
  private Kode godkjenningstype;
  private LocalDate godkjentFra;
  private OffsetDateTime godkjentFraDatoTid;
  private LocalDate godkjentTil;
  private OffsetDateTime godkjentTilDatoTid;
  private Korreksjon korreksjon;
  private List<Krav> krav;
  private TilleggsgodkjenningSpesifikkeData tilleggsgodkjenningSpesifikkeData;

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
  public static class TilleggsgodkjenningSpesifikkeData {
    private AdrGodkjenning adrGodkjenning;
    private DyretransportGodkjenning dyretransportGodkjenning;
    private LarevognGodkjenning larevognGodkjenning;
  }

  @Getter
  @Setter
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
  }

  @Getter
  @Setter
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
  }

  @Getter
  @Setter
  public static class AdrTankGodkjentGods {
      private String adrTankGodkjentFor;
      private Boolean adrTankStofferIhhtTankkode;
  }

  @Getter
  @Setter
  public static class AdrTankInndeling {
      private List<Integer> adrTankInndelingVolum;
  }

  @Getter
  @Setter
  public static class DyretransportGodkjenning {
    private Boolean fornyelse;
    private Double gulvareal;
    private Kode hestetransporttype;
    private Integer takhoyde;
  }

  @Getter
  @Setter
  public static class LarevognGodkjenning {
    private Kode forekortklasser;
    private Kode larevogn;
  }
}
