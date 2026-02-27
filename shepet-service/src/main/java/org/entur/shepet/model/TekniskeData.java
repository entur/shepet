package org.entur.shepet.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TekniskeData {
  private Akslinger akslinger;
  private Bremser bremser;
  private DekkOgFelg dekkOgFelg;
  private Dimensjoner dimensjoner;
  private Generelt generelt;
  private KarosseriOgLasteplan karosseriOgLasteplan;
  private Miljodata miljodata;
  private MotorOgDrivverk motorOgDrivverk;
  private List<OvrigeTekniskeData> ovrigeTekniskeData;
  private Persontall persontall;
  private Vekter vekter;

  @Getter
  @Setter
  public static class MotorOgDrivverk {
    private Integer antallGir;
    private Integer antallGirBakover;
    private Integer effektKraftuttakKW;
    private String girPlassering;
    private Kode girkassetype;
    private String giroverforingsType;
    private List<GirutvekslingPrGir> girutvekslingPrGir;
    private Boolean hybridElektriskKjoretoy;
    private Kode hybridKategori;
    private List<Integer> maksimumHastighet;
    private List<Integer> maksimumHastighetMalt;
    private List<Motor> motor;
    private Boolean obd;
    private Double totalUtvekslingHoyesteGir;
    private Boolean utelukkendeElektriskDrift;
  }

  @Getter
  @Setter
  public static class GirutvekslingPrGir {
    private String girNummer;
    private Integer girutveksling;
  }

  @Getter
  @Setter
  public static class Motor {
    private Integer antallSylindre;
    private Kode arbeidsprinsipp;
    private Boolean avgassResirkulering;
    private String blandingsDrivstoff;
    private List<Drivstoff> drivstoff;
    private String fabrikant;
    private Boolean fordampningsutslippKontrollSystem;
    private Boolean katalysator;
    private String kjolesystem;
    private Boolean ladeluftkjoler;
    private Boolean luftInnsproytning;
    private String motorKode;
    private String motorNummer;
    private Boolean oksygenSensor;
    private Boolean overladet;
    private Boolean partikkelfilterMotor;
    private Integer slagvolum;
    private Kode sylinderArrangement;
  }

  @Getter
  @Setter
  public static class Drivstoff {
    private Kode drivstoffKode;
    private Double effektVektForhold;
    private Double maksEffektPrTime;
    private Double maksNettoEffekt;
    private Integer maksNettoEffektVedOmdreiningstallMin1;
    private Integer maksNettoEffektVedOmdreiningstallMin1Maks;
    private Integer maksOmdreining;
    private Double spenning;
    private Integer tomgangsOmdreiningstall;
  }

  @Getter
  @Setter
  public static class OvrigeTekniskeData {
    private Integer datafeltIndeks;
    private String datafeltNavn;
    private String datafeltVerdi;
  }

  @Getter
  @Setter
  public static class Persontall {
    private Integer bareplasser;
    private Integer rullestolplasser;
    private SitteplassListe sitteplassListe;
    private Integer sitteplasserForan;
    private Integer sitteplasserNede;
    private Integer sitteplasserOppe;
    private Integer sitteplasserStillstand;
    private Integer sitteplasserTotalt;
    private Integer sitteplasserTotaltSomVarebilKlasse2;
    private Integer staplasser;
  }

  @Getter
  @Setter
  public static class SitteplassListe {
    private List<Sitteplass> sitteplass;
  }

  @Getter
  @Setter
  public static class Sitteplass {
    private Boolean beltekraftbegrenser;
    private Boolean beltestrammer;
    private Boolean frontairbag;
    private Boolean hodegardinairbag;
    private Boolean kneairbag;
    private String posisjon;
    private Integer rad;
    private Boolean sideairbag;
  }

  @Getter
  @Setter
  public static class Tilhengerkopling {
    private List<Kopling> kopling;
  }

  @Getter
  @Setter
  public static class Kopling {
    private Integer avstandFremstePktTilSenterKopling;
    private Integer avstandSenterKoplingTilBakerstePkt;
    private Integer avstandSenterKoplingTilForsteAksel;
    private Integer avstandSisteAkselTilKingpinMaks;
    private Integer avstandSisteAkselTilKingpinMin;
    private Integer avstandSisteAkselTilSenterKopling;
    private Double belastningDverdi;
    private Integer belastningLoddrettMaks;
    private Double belastningSverdi;
    private Double belastningUverdi;
    private Integer belastningVannrettMaks;
    private Double belastningVverdi;
    private String eftype;
    private String fabrikantKopling;
    private String handelsbetegnelseKopling;
    private Kode type;
  }

  @Getter
  @Setter
  public static class Vekter {
    private Integer egenvekt;
    private Integer egenvektMaksimum;
    private Integer egenvektMinimum;
    private Integer egenvektTilhengerkopling;
    private String frontOgHjulVekter;
    private Integer nyttelast;
    private Integer tekniskTillattForhoyetTotalvekt;
    private Integer tekniskTillattTotalvekt;
    private Integer tekniskTillattTotalvektVeg;
    private Integer tekniskTillattVektPahengsvogn;
    private Integer tekniskTillattVektSemitilhenger;
    private Integer tillattHjulLastSidevogn;
    private Integer tillattTaklast;
    private Integer tillattTilhengervektMedBrems;
    private Integer tillattTilhengervektUtenBrems;
    private Integer tillattTotalvekt;
    private Integer tillattVektSlepevogn;
    private Integer tillattVertikalKoplingslast;
    private Integer tillattVogntogvekt;
    private Integer tillattVogntogvektVeg;
    private List<VogntogvektAvhBremsesystem> vogntogvektAvhBremsesystem;
  }

  @Getter
  @Setter
  public static class VogntogvektAvhBremsesystem {
    private String bremseType;
    private Integer vogntogvekt;
  }

  @Getter
  @Setter
  public static class Akslinger {
    private List<AkselGruppe> akselGruppe;
    private Integer antallAksler;
    private Kode forbindelseMellomDrivaksler;
  }

  @Getter
  @Setter
  public static class AkselGruppe {
    private AkselListe akselListe;
    private Integer egenvektAkselGruppe;
    private Integer egenvektAkselGruppeMaks;
    private Integer egenvektAkselGruppeMin;
    private Integer fordelingAvTillattTotalvektAkselGruppeMaks;
    private Integer fordelingAvTillattTotalvektAkselGruppeMin;
    private Integer id;
    private String plasseringAkselGruppe;
    private Integer tekniskTillattAkselGruppeLast;
    private Integer tekniskTillattAkselGruppeLastVeg;
  }

  @Getter
  @Setter
  public static class AkselListe {
    private List<Aksel> aksel;
  }

  @Getter
  @Setter
  public static class Aksel {
    private Integer antallHjul;
    private Integer avstandTilNesteAksling;
    private Boolean belastbar;
    private Boolean bremseAksel;
    private Boolean drivAksel;
    private Integer egenvektAksel;
    private Integer egenvektAkselMaks;
    private Integer egenvektAkselMin;
    private Integer fordelingAvTillattTotalvektAkselMaks;
    private Integer fordelingAvTillattTotalvektAkselMin;
    private Integer id;
    private Boolean loftbar;
    private Boolean luftfjaering;
    private Integer maksAvstandTilNesteAksling;
    private Integer maksimalSporvidde;
    private Integer minAvstandTilNesteAksling;
    private Integer minimalSporvidde;
    private String plasseringAksel;
    private Integer sporvidde;
    private Boolean styreAksel;
    private Integer tekniskTillattAkselLast;
    private Integer tekniskTillattAkselLastForhoyet;
    private Integer tekniskTillattAkselLastVeg;
  }

  @Getter
  @Setter
  public static class Bremser {
    private Boolean abs;
    private String bremsesystem;
    private String driftsbremsBak;
    private String driftsbremsForan;
    private List<String> tilhengerBremseforbindelse;
    private Double trykkMeterledningTilhengerkopling;
    private Double trykktilsluttning1;
    private Double trykktilsluttning2;
  }

  @Getter
  @Setter
  public static class DekkOgFelg {
    private List<AkselDekkOgFelgKombinasjon> akselDekkOgFelgKombinasjon;
    private DekkOgFelgSidevogn dekkOgFelgSidevogn;
  }

  @Getter
  @Setter
  public static class AkselDekkOgFelgKombinasjon {
    private List<AkselDekkOgFelg> akselDekkOgFelg;
    private Integer tillattTotalvektTraktor;
  }

  @Getter
  @Setter
  public static class AkselDekkOgFelg {
    private Integer akselId;
    private String belastningskodeDekk;
    private String belastningskodeDekkTraktor;
    private String dekkdimensjon;
    private String felgdimensjon;
    private String hastighetskodeDekk;
    private String innpress;
    private Integer tillattAkselLastTraktor;
    private Boolean tvilling;
  }

  @Getter
  @Setter
  public static class DekkOgFelgSidevogn {
    private String belastningskodeDekkSidevogn;
    private String dekkdimensjonSidevogn;
    private String felgdimensjonSidevogn;
    private String hastighetskodeDekkSidevogn;
    private String innpressSidevogn;
  }

  @Getter
  @Setter
  public static class Dimensjoner {
    private Integer bredde;
    private Integer hoyde;
    private Integer lengde;
    private Integer lengdeInnvendigLasteplan;
    private Integer maksimalBredde;
    private Integer maksimalHoyde;
    private Integer maksimalLengde;
    private Integer maksimalLengdeInnvendigLasteplan;
  }

  @Getter
  @Setter
  public static class Generelt {
    private List<Fabrikant> fabrikant;
    private String ferdigbyggetEllerEndretSomFolger;
    private List<String> handelsbetegnelse;
    private List<Merke> merke;
    private Kode tekniskKode;
    private Kode tekniskUnderkode;
    private String typebetegnelse;
    private String unntakFra;
  }

  @Getter
  @Setter
  public static class Fabrikant {
    private String fabrikantAdresse;
    private String fabrikantNavn;
    private String fabrikantRepresentantAdresse;
    private String fabrikantRepresentantNavn;
  }

  @Getter
  @Setter
  public static class Merke {
    private String merke;
    private String merkeKode;
  }

  @Getter
  @Setter
  public static class KarosseriOgLasteplan {
    private List<Integer> antallDorer;
    private Integer avstandNavSkjermbueBak;
    private Integer avstandNavSkjermbueForan;
    private String bussKategori;
    private List<String> dorUtforming;
    private String fargeFjar;
    private String forankringSikkerhetsseler;
    private String forervern;
    private String forervernBoyle;
    private String godkjentADR;
    private Boolean hydrauliskLoft;
    private String karosseriArt;
    private Kode karosseritype;
    private Kode kjennemerketypeBak;
    private Kode kjennemerkestorrelseBak;
    private Kode kjennemerketypeForan;
    private Kode kjennemerkestorrelseForan;
    private Kode kjennemerketypeVenstre;
    private Kode kjennemerkestorrelseVenstre;
    private String kjoringSide;
    private String oppbygningUnderstellsnummer;
    private Integer overhengBak;
    private Kode pabyggsKode;
    private String passasjerHandtak;
    private Kode plasseringAvDorer;
    private List<Kode> plasseringFabrikasjonsplate;
    private String plasseringMerkeplateTrimming;
    private List<Kode> plasseringUnderstellsnummer;
    private List<Kode> rFarge;
    private String sikkerhetsseler;
    private String styremekanismeArt;
    private Boolean temperaturregulertSkap;
    private Boolean vendbarForerplass;
  }

  @Getter
  @Setter
  public static class Miljodata {
    private Double co2BesparelsePgaOkoInnovasjon;
    private Kode euroKlasse;
    private String lyddemperUtblas;
    private List<MiljoOgdrivstoffGruppe> miljoOgdrivstoffGruppe;
    private Boolean okoInnovasjon;
    private String typeOkoInnovasjon;
  }

  @Getter
  @Setter
  public static class MiljoOgdrivstoffGruppe {
    private Kode drivstoffKodeMiljodata;
    private List<ForbrukOgUtslipp> forbrukOgUtslipp;
    private Lyd lyd;
  }

  @Getter
  @Setter
  public static class ForbrukOgUtslipp {
    private Double antallPartikler;
    private Double co2BlandetKjoring;
    private Double co2Bykjoring;
    private Double co2Landeveiskjoring;
    private Double coProsent;
    private Integer elEnergiforbruk;
    private Double forbrukBlandetKjoring;
    private Double forbrukBykjoring;
    private Double forbrukLandeveiskjoring;
    private Kode malemetode;
    private String malemetodeAnnen;
    private Boolean partikkelfilterFabrikkmontert;
    private Boolean partikkelfilterUtslipp;
    private Integer rekkeviddeKm;
    private Double utslippCOgPrKWh;
    private Double utslippCOmgPrKm;
    private Double utslippHCgPrKWh;
    private Double utslippHCgPrMin;
    private Double utslippHCmgPrKm;
    private Double utslippHCogNOxMgPrKm;
    private Double utslippKorrigertAbsorpsjonskoeffisient;
    private Double utslippNMHCmgPrKm;
    private Double utslippNOxGPrKWh;
    private Double utslippNOxMgPrKm;
    private Double utslippPartikkelAntallPrKm;
    private Double utslippPartiklerGPrKWh;
    private Double utslippPartiklerMgPrKm;
    private Double utslippTHCmgPrKm;
    private Double utslippTHCogNOxMgPrKm;
    private Double vektetKombinertDrivstoff;
    private Integer vektetKombinertDrivstoffCO2;
    private WltpData wltpKjoretoyspesifikk;
    private WltpData wltpTypegodkjenningMaks;
    private WltpData wltpTypegodkjenningMedium;
    private WltpData wltpTypegodkjenningMin;
  }

  @Getter
  @Setter
  public static class WltpData {
    private Double co2EkstraHoy;
    private Double co2Hoy;
    private Double co2Kombinert;
    private Double co2Lav;
    private Double co2Middels;
    private Double co2VektetKombinert;
    private Double forbrukEkstraHoy;
    private Double forbrukHoy;
    private Double forbrukKombinert;
    private Double forbrukLav;
    private Double forbrukMiddels;
    private Double forbrukVektetKombinert;
    private Integer rekkeviddeKmBlandetkjoring;
    private Integer rekkeviddeKmBykjoring;
    private Integer elEnergiforbruk;
    private Double nedcForbrukBykjoring;
    private Double nedcForbrukLandeveiskjoring;
    private Double nedcForbrukBlandetKjoring;
    private Double nedcCo2BykjoringGPrKm;
    private Double nedcCo2LandeveiskjoringGPrKm;
    private Double nedcCo2BlandetKjoringGPrKm;
    private Double nedcVektetKombinertDrivstoffCo2;
    private Double nedcVektetKombinertDrivstoff;
    private Integer nedcEnergiforbruk;
    private Integer nedcRekkeviddeKm;
    private Double veilastkoeffisientf0;
    private Double veilastkoeffisientf1;
    private Double veilastkoeffisientf2;
    private Double testmasse;
    private Double frontalareal;
  }

  @Getter
  @Setter
  public static class Lyd {
    private Integer innvendigStoyniva;
    private Integer kjorestoy;
    private Integer standstoy;
    private Kode stoyMalingOppgittAv;
    private Integer vedAntallOmdreininger;
  }
}
