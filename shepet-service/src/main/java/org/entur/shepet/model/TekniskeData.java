package org.entur.shepet.model;

import java.util.List;

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

  // getters and setters

  public List<OvrigeTekniskeData> getOvrigeTekniskeData() {
    return ovrigeTekniskeData;
  }

  public void setOvrigeTekniskeData(
    List<OvrigeTekniskeData> ovrigeTekniskeData
  ) {
    this.ovrigeTekniskeData = ovrigeTekniskeData;
  }

  public Persontall getPersontall() {
    return persontall;
  }

  public void setPersontall(Persontall persontall) {
    this.persontall = persontall;
  }

  public Vekter getVekter() {
    return vekter;
  }

  public void setVekter(Vekter vekter) {
    this.vekter = vekter;
  }

  public MotorOgDrivverk getMotorOgDrivverk() {
    return motorOgDrivverk;
  }

  public void setMotorOgDrivverk(MotorOgDrivverk motorOgDrivverk) {
    this.motorOgDrivverk = motorOgDrivverk;
  }

  public Akslinger getAkslinger() {
    return akslinger;
  }

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

    // getters and setters
    public Integer getAntallGir() {
      return antallGir;
    }

    public void setAntallGir(Integer antallGir) {
      this.antallGir = antallGir;
    }

    public Integer getAntallGirBakover() {
      return antallGirBakover;
    }

    public void setAntallGirBakover(Integer antallGirBakover) {
      this.antallGirBakover = antallGirBakover;
    }

    public Integer getEffektKraftuttakKW() {
      return effektKraftuttakKW;
    }

    public void setEffektKraftuttakKW(Integer effektKraftuttakKW) {
      this.effektKraftuttakKW = effektKraftuttakKW;
    }

    public String getGirPlassering() {
      return girPlassering;
    }

    public void setGirPlassering(String girPlassering) {
      this.girPlassering = girPlassering;
    }

    public Kode getGirkassetype() {
      return girkassetype;
    }

    public void setGirkassetype(Kode girkassetype) {
      this.girkassetype = girkassetype;
    }

    public String getGiroverforingsType() {
      return giroverforingsType;
    }

    public void setGiroverforingsType(String giroverforingsType) {
      this.giroverforingsType = giroverforingsType;
    }

    public List<GirutvekslingPrGir> getGirutvekslingPrGir() {
      return girutvekslingPrGir;
    }

    public void setGirutvekslingPrGir(
      List<GirutvekslingPrGir> girutvekslingPrGir
    ) {
      this.girutvekslingPrGir = girutvekslingPrGir;
    }

    public Boolean isHybridElektriskKjoretoy() {
      return hybridElektriskKjoretoy;
    }

    public void setHybridElektriskKjoretoy(Boolean hybridElektriskKjoretoy) {
      this.hybridElektriskKjoretoy = hybridElektriskKjoretoy;
    }

    public Kode getHybridKategori() {
      return hybridKategori;
    }

    public void setHybridKategori(Kode hybridKategori) {
      this.hybridKategori = hybridKategori;
    }

    public List<Integer> getMaksimumHastighet() {
      return maksimumHastighet;
    }

    public void setMaksimumHastighet(List<Integer> maksimumHastighet) {
      this.maksimumHastighet = maksimumHastighet;
    }

    public List<Integer> getMaksimumHastighetMalt() {
      return maksimumHastighetMalt;
    }

    public void setMaksimumHastighetMalt(List<Integer> maksimumHastighetMalt) {
      this.maksimumHastighetMalt = maksimumHastighetMalt;
    }

    public List<Motor> getMotor() {
      return motor;
    }

    public void setMotor(List<Motor> motor) {
      this.motor = motor;
    }

    public Boolean isObd() {
      return obd;
    }

    public void setObd(Boolean obd) {
      this.obd = obd;
    }

    public Double getTotalUtvekslingHoyesteGir() {
      return totalUtvekslingHoyesteGir;
    }

    public void setTotalUtvekslingHoyesteGir(Double totalUtvekslingHoyesteGir) {
      this.totalUtvekslingHoyesteGir = totalUtvekslingHoyesteGir;
    }

    public Boolean isUtelukkendeElektriskDrift() {
      return utelukkendeElektriskDrift;
    }

    public void setUtelukkendeElektriskDrift(
      Boolean utelukkendeElektriskDrift
    ) {
      this.utelukkendeElektriskDrift = utelukkendeElektriskDrift;
    }
  }

  public static class GirutvekslingPrGir {

    private String girNummer;
    private Integer girutveksling;

    // getters and setters
    public String getGirNummer() {
      return girNummer;
    }

    public void setGirNummer(String girNummer) {
      this.girNummer = girNummer;
    }

    public Integer getGirutveksling() {
      return girutveksling;
    }

    public void setGirutveksling(Integer girutveksling) {
      this.girutveksling = girutveksling;
    }
  }

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

    // getters and setters
    public Integer getAntallSylindre() {
      return antallSylindre;
    }

    public void setAntallSylindre(Integer antallSylindre) {
      this.antallSylindre = antallSylindre;
    }

    public Kode getArbeidsprinsipp() {
      return arbeidsprinsipp;
    }

    public void setArbeidsprinsipp(Kode arbeidsprinsipp) {
      this.arbeidsprinsipp = arbeidsprinsipp;
    }

    public Boolean isAvgassResirkulering() {
      return avgassResirkulering;
    }

    public void setAvgassResirkulering(Boolean avgassResirkulering) {
      this.avgassResirkulering = avgassResirkulering;
    }

    public String getBlandingsDrivstoff() {
      return blandingsDrivstoff;
    }

    public void setBlandingsDrivstoff(String blandingsDrivstoff) {
      this.blandingsDrivstoff = blandingsDrivstoff;
    }

    public List<Drivstoff> getDrivstoff() {
      return drivstoff;
    }

    public void setDrivstoff(List<Drivstoff> drivstoff) {
      this.drivstoff = drivstoff;
    }

    public String getFabrikant() {
      return fabrikant;
    }

    public void setFabrikant(String fabrikant) {
      this.fabrikant = fabrikant;
    }

    public Boolean isFordampningsutslippKontrollSystem() {
      return fordampningsutslippKontrollSystem;
    }

    public void setFordampningsutslippKontrollSystem(
      Boolean fordampningsutslippKontrollSystem
    ) {
      this.fordampningsutslippKontrollSystem =
        fordampningsutslippKontrollSystem;
    }

    public Boolean isKatalysator() {
      return katalysator;
    }

    public void setKatalysator(Boolean katalysator) {
      this.katalysator = katalysator;
    }

    public String getKjolesystem() {
      return kjolesystem;
    }

    public void setKjolesystem(String kjolesystem) {
      this.kjolesystem = kjolesystem;
    }

    public Boolean isLadeluftkjoler() {
      return ladeluftkjoler;
    }

    public void setLadeluftkjoler(Boolean ladeluftkjoler) {
      this.ladeluftkjoler = ladeluftkjoler;
    }

    public Boolean isLuftInnsproytning() {
      return luftInnsproytning;
    }

    public void setLuftInnsproytning(Boolean luftInnsproytning) {
      this.luftInnsproytning = luftInnsproytning;
    }

    public String getMotorKode() {
      return motorKode;
    }

    public void setMotorKode(String motorKode) {
      this.motorKode = motorKode;
    }

    public String getMotorNummer() {
      return motorNummer;
    }

    public void setMotorNummer(String motorNummer) {
      this.motorNummer = motorNummer;
    }

    public Boolean isOksygenSensor() {
      return oksygenSensor;
    }

    public void setOksygenSensor(Boolean oksygenSensor) {
      this.oksygenSensor = oksygenSensor;
    }

    public Boolean isOverladet() {
      return overladet;
    }

    public void setOverladet(Boolean overladet) {
      this.overladet = overladet;
    }

    public Boolean isPartikkelfilterMotor() {
      return partikkelfilterMotor;
    }

    public void setPartikkelfilterMotor(Boolean partikkelfilterMotor) {
      this.partikkelfilterMotor = partikkelfilterMotor;
    }

    public Integer getSlagvolum() {
      return slagvolum;
    }

    public void setSlagvolum(Integer slagvolum) {
      this.slagvolum = slagvolum;
    }

    public Kode getSylinderArrangement() {
      return sylinderArrangement;
    }

    public void setSylinderArrangement(Kode sylinderArrangement) {
      this.sylinderArrangement = sylinderArrangement;
    }
  }

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

    // getters and setters
    public Kode getDrivstoffKode() {
      return drivstoffKode;
    }

    public void setDrivstoffKode(Kode drivstoffKode) {
      this.drivstoffKode = drivstoffKode;
    }

    public Double getEffektVektForhold() {
      return effektVektForhold;
    }

    public void setEffektVektForhold(Double effektVektForhold) {
      this.effektVektForhold = effektVektForhold;
    }

    public Double getMaksEffektPrTime() {
      return maksEffektPrTime;
    }

    public void setMaksEffektPrTime(Double maksEffektPrTime) {
      this.maksEffektPrTime = maksEffektPrTime;
    }

    public Double getMaksNettoEffekt() {
      return maksNettoEffekt;
    }

    public void setMaksNettoEffekt(Double maksNettoEffekt) {
      this.maksNettoEffekt = maksNettoEffekt;
    }

    public Integer getMaksNettoEffektVedOmdreiningstallMin1() {
      return maksNettoEffektVedOmdreiningstallMin1;
    }

    public void setMaksNettoEffektVedOmdreiningstallMin1(
      Integer maksNettoEffektVedOmdreiningstallMin1
    ) {
      this.maksNettoEffektVedOmdreiningstallMin1 =
        maksNettoEffektVedOmdreiningstallMin1;
    }

    public Integer getMaksNettoEffektVedOmdreiningstallMin1Maks() {
      return maksNettoEffektVedOmdreiningstallMin1Maks;
    }

    public void setMaksNettoEffektVedOmdreiningstallMin1Maks(
      Integer maksNettoEffektVedOmdreiningstallMin1Maks
    ) {
      this.maksNettoEffektVedOmdreiningstallMin1Maks =
        maksNettoEffektVedOmdreiningstallMin1Maks;
    }

    public Integer getMaksOmdreining() {
      return maksOmdreining;
    }

    public void setMaksOmdreining(Integer maksOmdreining) {
      this.maksOmdreining = maksOmdreining;
    }

    public Double getSpenning() {
      return spenning;
    }

    public void setSpenning(Double spenning) {
      this.spenning = spenning;
    }

    public Integer getTomgangsOmdreiningstall() {
      return tomgangsOmdreiningstall;
    }

    public void setTomgangsOmdreiningstall(Integer tomgangsOmdreiningstall) {
      this.tomgangsOmdreiningstall = tomgangsOmdreiningstall;
    }
  }

  public static class OvrigeTekniskeData {

    private Integer datafeltIndeks;
    private String datafeltNavn;
    private String datafeltVerdi;

    // getters and setters
    public Integer getDatafeltIndeks() {
      return datafeltIndeks;
    }

    public void setDatafeltIndeks(Integer datafeltIndeks) {
      this.datafeltIndeks = datafeltIndeks;
    }

    public String getDatafeltNavn() {
      return datafeltNavn;
    }

    public void setDatafeltNavn(String datafeltNavn) {
      this.datafeltNavn = datafeltNavn;
    }

    public String getDatafeltVerdi() {
      return datafeltVerdi;
    }

    public void setDatafeltVerdi(String datafeltVerdi) {
      this.datafeltVerdi = datafeltVerdi;
    }
  }

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

    // getters and setters
    public Integer getBareplasser() {
      return bareplasser;
    }

    public void setBareplasser(Integer bareplasser) {
      this.bareplasser = bareplasser;
    }

    public Integer getRullestolplasser() {
      return rullestolplasser;
    }

    public void setRullestolplasser(Integer rullestolplasser) {
      this.rullestolplasser = rullestolplasser;
    }

    public SitteplassListe getSitteplassListe() {
      return sitteplassListe;
    }

    public void setSitteplassListe(SitteplassListe sitteplassListe) {
      this.sitteplassListe = sitteplassListe;
    }

    public Integer getSitteplasserForan() {
      return sitteplasserForan;
    }

    public void setSitteplasserForan(Integer sitteplasserForan) {
      this.sitteplasserForan = sitteplasserForan;
    }

    public Integer getSitteplasserNede() {
      return sitteplasserNede;
    }

    public void setSitteplasserNede(Integer sitteplasserNede) {
      this.sitteplasserNede = sitteplasserNede;
    }

    public Integer getSitteplasserOppe() {
      return sitteplasserOppe;
    }

    public void setSitteplasserOppe(Integer sitteplasserOppe) {
      this.sitteplasserOppe = sitteplasserOppe;
    }

    public Integer getSitteplasserStillstand() {
      return sitteplasserStillstand;
    }

    public void setSitteplasserStillstand(Integer sitteplasserStillstand) {
      this.sitteplasserStillstand = sitteplasserStillstand;
    }

    public Integer getSitteplasserTotalt() {
      return sitteplasserTotalt;
    }

    public void setSitteplasserTotalt(Integer sitteplasserTotalt) {
      this.sitteplasserTotalt = sitteplasserTotalt;
    }

    public Integer getSitteplasserTotaltSomVarebilKlasse2() {
      return sitteplasserTotaltSomVarebilKlasse2;
    }

    public void setSitteplasserTotaltSomVarebilKlasse2(
      Integer sitteplasserTotaltSomVarebilKlasse2
    ) {
      this.sitteplasserTotaltSomVarebilKlasse2 =
        sitteplasserTotaltSomVarebilKlasse2;
    }

    public Integer getStaplasser() {
      return staplasser;
    }

    public void setStaplasser(Integer staplasser) {
      this.staplasser = staplasser;
    }
  }

  public static class SitteplassListe {

    private List<Sitteplass> sitteplass;

    // getters and setters

    public List<Sitteplass> getSitteplass() {
      return sitteplass;
    }

    public void setSitteplass(List<Sitteplass> sitteplass) {
      this.sitteplass = sitteplass;
    }
  }

  public static class Sitteplass {

    private Boolean beltekraftbegrenser;
    private Boolean beltestrammer;
    private Boolean frontairbag;
    private Boolean hodegardinairbag;
    private Boolean kneairbag;
    private String posisjon;
    private Integer rad;
    private Boolean sideairbag;

    // getters and setters
    public Boolean isBeltekraftbegrenser() {
      return beltekraftbegrenser;
    }

    public void setBeltekraftbegrenser(Boolean beltekraftbegrenser) {
      this.beltekraftbegrenser = beltekraftbegrenser;
    }

    public Boolean isBeltestrammer() {
      return beltestrammer;
    }

    public void setBeltestrammer(Boolean beltestrammer) {
      this.beltestrammer = beltestrammer;
    }

    public Boolean isFrontairbag() {
      return frontairbag;
    }

    public void setFrontairbag(Boolean frontairbag) {
      this.frontairbag = frontairbag;
    }

    public Boolean isHodegardinairbag() {
      return hodegardinairbag;
    }

    public void setHodegardinairbag(Boolean hodegardinairbag) {
      this.hodegardinairbag = hodegardinairbag;
    }

    public Boolean isKneairbag() {
      return kneairbag;
    }

    public void setKneairbag(Boolean kneairbag) {
      this.kneairbag = kneairbag;
    }

    public String getPosisjon() {
      return posisjon;
    }

    public void setPosisjon(String posisjon) {
      this.posisjon = posisjon;
    }

    public Integer getRad() {
      return rad;
    }

    public void setRad(Integer rad) {
      this.rad = rad;
    }

    public Boolean isSideairbag() {
      return sideairbag;
    }

    public void setSideairbag(Boolean sideairbag) {
      this.sideairbag = sideairbag;
    }
  }

  public static class Tilhengerkopling {

    private List<Kopling> kopling;

    // getters and setters

    public List<Kopling> getKopling() {
      return kopling;
    }

    public void setKopling(List<Kopling> kopling) {
      this.kopling = kopling;
    }
  }

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

    // getters and setters
    public Integer getAvstandFremstePktTilSenterKopling() {
      return avstandFremstePktTilSenterKopling;
    }

    public void setAvstandFremstePktTilSenterKopling(
      Integer avstandFremstePktTilSenterKopling
    ) {
      this.avstandFremstePktTilSenterKopling =
        avstandFremstePktTilSenterKopling;
    }

    public Integer getAvstandSenterKoplingTilBakerstePkt() {
      return avstandSenterKoplingTilBakerstePkt;
    }

    public void setAvstandSenterKoplingTilBakerstePkt(
      Integer avstandSenterKoplingTilBakerstePkt
    ) {
      this.avstandSenterKoplingTilBakerstePkt =
        avstandSenterKoplingTilBakerstePkt;
    }

    public Integer getAvstandSenterKoplingTilForsteAksel() {
      return avstandSenterKoplingTilForsteAksel;
    }

    public void setAvstandSenterKoplingTilForsteAksel(
      Integer avstandSenterKoplingTilForsteAksel
    ) {
      this.avstandSenterKoplingTilForsteAksel =
        avstandSenterKoplingTilForsteAksel;
    }

    public Integer getAvstandSisteAkselTilKingpinMaks() {
      return avstandSisteAkselTilKingpinMaks;
    }

    public void setAvstandSisteAkselTilKingpinMaks(
      Integer avstandSisteAkselTilKingpinMaks
    ) {
      this.avstandSisteAkselTilKingpinMaks = avstandSisteAkselTilKingpinMaks;
    }

    public Integer getAvstandSisteAkselTilKingpinMin() {
      return avstandSisteAkselTilKingpinMin;
    }

    public void setAvstandSisteAkselTilKingpinMin(
      Integer avstandSisteAkselTilKingpinMin
    ) {
      this.avstandSisteAkselTilKingpinMin = avstandSisteAkselTilKingpinMin;
    }

    public Integer getAvstandSisteAkselTilSenterKopling() {
      return avstandSisteAkselTilSenterKopling;
    }

    public void setAvstandSisteAkselTilSenterKopling(
      Integer avstandSisteAkselTilSenterKopling
    ) {
      this.avstandSisteAkselTilSenterKopling =
        avstandSisteAkselTilSenterKopling;
    }

    public Double getBelastningDverdi() {
      return belastningDverdi;
    }

    public void setBelastningDverdi(Double belastningDverdi) {
      this.belastningDverdi = belastningDverdi;
    }

    public Integer getBelastningLoddrettMaks() {
      return belastningLoddrettMaks;
    }

    public void setBelastningLoddrettMaks(Integer belastningLoddrettMaks) {
      this.belastningLoddrettMaks = belastningLoddrettMaks;
    }

    public Double getBelastningSverdi() {
      return belastningSverdi;
    }

    public void setBelastningSverdi(Double belastningSverdi) {
      this.belastningSverdi = belastningSverdi;
    }

    public Double getBelastningUverdi() {
      return belastningUverdi;
    }

    public void setBelastningUverdi(Double belastningUverdi) {
      this.belastningUverdi = belastningUverdi;
    }

    public Integer getBelastningVannrettMaks() {
      return belastningVannrettMaks;
    }

    public void setBelastningVannrettMaks(Integer belastningVannrettMaks) {
      this.belastningVannrettMaks = belastningVannrettMaks;
    }

    public Double getBelastningVverdi() {
      return belastningVverdi;
    }

    public void setBelastningVverdi(Double belastningVverdi) {
      this.belastningVverdi = belastningVverdi;
    }

    public String getEftype() {
      return eftype;
    }

    public void setEftype(String eftype) {
      this.eftype = eftype;
    }

    public String getFabrikantKopling() {
      return fabrikantKopling;
    }

    public void setFabrikantKopling(String fabrikantKopling) {
      this.fabrikantKopling = fabrikantKopling;
    }

    public String getHandelsbetegnelseKopling() {
      return handelsbetegnelseKopling;
    }

    public void setHandelsbetegnelseKopling(String handelsbetegnelseKopling) {
      this.handelsbetegnelseKopling = handelsbetegnelseKopling;
    }

    public Kode getType() {
      return type;
    }

    public void setType(Kode type) {
      this.type = type;
    }
  }

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

    // getters and setters
    public Integer getEgenvekt() {
      return egenvekt;
    }

    public void setEgenvekt(Integer egenvekt) {
      this.egenvekt = egenvekt;
    }

    public Integer getEgenvektMaksimum() {
      return egenvektMaksimum;
    }

    public void setEgenvektMaksimum(Integer egenvektMaksimum) {
      this.egenvektMaksimum = egenvektMaksimum;
    }

    public Integer getEgenvektMinimum() {
      return egenvektMinimum;
    }

    public void setEgenvektMinimum(Integer egenvektMinimum) {
      this.egenvektMinimum = egenvektMinimum;
    }

    public Integer getEgenvektTilhengerkopling() {
      return egenvektTilhengerkopling;
    }

    public void setEgenvektTilhengerkopling(Integer egenvektTilhengerkopling) {
      this.egenvektTilhengerkopling = egenvektTilhengerkopling;
    }

    public String getFrontOgHjulVekter() {
      return frontOgHjulVekter;
    }

    public void setFrontOgHjulVekter(String frontOgHjulVekter) {
      this.frontOgHjulVekter = frontOgHjulVekter;
    }

    public Integer getNyttelast() {
      return nyttelast;
    }

    public void setNyttelast(Integer nyttelast) {
      this.nyttelast = nyttelast;
    }

    public Integer getTekniskTillattForhoyetTotalvekt() {
      return tekniskTillattForhoyetTotalvekt;
    }

    public void setTekniskTillattForhoyetTotalvekt(
      Integer tekniskTillattForhoyetTotalvekt
    ) {
      this.tekniskTillattForhoyetTotalvekt = tekniskTillattForhoyetTotalvekt;
    }

    public Integer getTekniskTillattTotalvekt() {
      return tekniskTillattTotalvekt;
    }

    public void setTekniskTillattTotalvekt(Integer tekniskTillattTotalvekt) {
      this.tekniskTillattTotalvekt = tekniskTillattTotalvekt;
    }

    public Integer getTekniskTillattTotalvektVeg() {
      return tekniskTillattTotalvektVeg;
    }

    public void setTekniskTillattTotalvektVeg(
      Integer tekniskTillattTotalvektVeg
    ) {
      this.tekniskTillattTotalvektVeg = tekniskTillattTotalvektVeg;
    }

    public Integer getTekniskTillattVektPahengsvogn() {
      return tekniskTillattVektPahengsvogn;
    }

    public void setTekniskTillattVektPahengsvogn(
      Integer tekniskTillattVektPahengsvogn
    ) {
      this.tekniskTillattVektPahengsvogn = tekniskTillattVektPahengsvogn;
    }

    public Integer getTekniskTillattVektSemitilhenger() {
      return tekniskTillattVektSemitilhenger;
    }

    public void setTekniskTillattVektSemitilhenger(
      Integer tekniskTillattVektSemitilhenger
    ) {
      this.tekniskTillattVektSemitilhenger = tekniskTillattVektSemitilhenger;
    }

    public Integer getTillattHjulLastSidevogn() {
      return tillattHjulLastSidevogn;
    }

    public void setTillattHjulLastSidevogn(Integer tillattHjulLastSidevogn) {
      this.tillattHjulLastSidevogn = tillattHjulLastSidevogn;
    }

    public Integer getTillattTaklast() {
      return tillattTaklast;
    }

    public void setTillattTaklast(Integer tillattTaklast) {
      this.tillattTaklast = tillattTaklast;
    }

    public Integer getTillattTilhengervektMedBrems() {
      return tillattTilhengervektMedBrems;
    }

    public void setTillattTilhengervektMedBrems(
      Integer tillattTilhengervektMedBrems
    ) {
      this.tillattTilhengervektMedBrems = tillattTilhengervektMedBrems;
    }

    public Integer getTillattTilhengervektUtenBrems() {
      return tillattTilhengervektUtenBrems;
    }

    public void setTillattTilhengervektUtenBrems(
      Integer tillattTilhengervektUtenBrems
    ) {
      this.tillattTilhengervektUtenBrems = tillattTilhengervektUtenBrems;
    }

    public Integer getTillattTotalvekt() {
      return tillattTotalvekt;
    }

    public void setTillattTotalvekt(Integer tillattTotalvekt) {
      this.tillattTotalvekt = tillattTotalvekt;
    }

    public Integer getTillattVektSlepevogn() {
      return tillattVektSlepevogn;
    }

    public void setTillattVektSlepevogn(Integer tillattVektSlepevogn) {
      this.tillattVektSlepevogn = tillattVektSlepevogn;
    }

    public Integer getTillattVertikalKoplingslast() {
      return tillattVertikalKoplingslast;
    }

    public void setTillattVertikalKoplingslast(
      Integer tillattVertikalKoplingslast
    ) {
      this.tillattVertikalKoplingslast = tillattVertikalKoplingslast;
    }

    public Integer getTillattVogntogvekt() {
      return tillattVogntogvekt;
    }

    public void setTillattVogntogvekt(Integer tillattVogntogvekt) {
      this.tillattVogntogvekt = tillattVogntogvekt;
    }

    public Integer getTillattVogntogvektVeg() {
      return tillattVogntogvektVeg;
    }

    public void setTillattVogntogvektVeg(Integer tillattVogntogvektVeg) {
      this.tillattVogntogvektVeg = tillattVogntogvektVeg;
    }

    public List<VogntogvektAvhBremsesystem> getVogntogvektAvhBremsesystem() {
      return vogntogvektAvhBremsesystem;
    }

    public void setVogntogvektAvhBremsesystem(
      List<VogntogvektAvhBremsesystem> vogntogvektAvhBremsesystem
    ) {
      this.vogntogvektAvhBremsesystem = vogntogvektAvhBremsesystem;
    }
  }

  public static class VogntogvektAvhBremsesystem {

    private String bremseType;
    private Integer vogntogvekt;

    // getters and setters
    public String getBremseType() {
      return bremseType;
    }

    public void setBremseType(String bremseType) {
      this.bremseType = bremseType;
    }

    public Integer getVogntogvekt() {
      return vogntogvekt;
    }

    public void setVogntogvekt(Integer vogntogvekt) {
      this.vogntogvekt = vogntogvekt;
    }
  }

  public void setAkslinger(Akslinger akslinger) {
    this.akslinger = akslinger;
  }

  public Bremser getBremser() {
    return bremser;
  }

  public void setBremser(Bremser bremser) {
    this.bremser = bremser;
  }

  public DekkOgFelg getDekkOgFelg() {
    return dekkOgFelg;
  }

  public void setDekkOgFelg(DekkOgFelg dekkOgFelg) {
    this.dekkOgFelg = dekkOgFelg;
  }

  public Dimensjoner getDimensjoner() {
    return dimensjoner;
  }

  public void setDimensjoner(Dimensjoner dimensjoner) {
    this.dimensjoner = dimensjoner;
  }

  public Generelt getGenerelt() {
    return generelt;
  }

  public void setGenerelt(Generelt generelt) {
    this.generelt = generelt;
  }

  public KarosseriOgLasteplan getKarosseriOgLasteplan() {
    return karosseriOgLasteplan;
  }

  public void setKarosseriOgLasteplan(
    KarosseriOgLasteplan karosseriOgLasteplan
  ) {
    this.karosseriOgLasteplan = karosseriOgLasteplan;
  }

  public Miljodata getMiljodata() {
    return miljodata;
  }

  public void setMiljodata(Miljodata miljodata) {
    this.miljodata = miljodata;
  }

  public static class Akslinger {

    private List<AkselGruppe> akselGruppe;
    private Integer antallAksler;
    private Kode forbindelseMellomDrivaksler;

    // getters and setters
    public List<AkselGruppe> getAkselGruppe() {
      return akselGruppe;
    }

    public void setAkselGruppe(List<AkselGruppe> akselGruppe) {
      this.akselGruppe = akselGruppe;
    }

    public Integer getAntallAksler() {
      return antallAksler;
    }

    public void setAntallAksler(Integer antallAksler) {
      this.antallAksler = antallAksler;
    }

    public Kode getForbindelseMellomDrivaksler() {
      return forbindelseMellomDrivaksler;
    }

    public void setForbindelseMellomDrivaksler(
      Kode forbindelseMellomDrivaksler
    ) {
      this.forbindelseMellomDrivaksler = forbindelseMellomDrivaksler;
    }
  }

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

    // getters and setters
    public AkselListe getAkselListe() {
      return akselListe;
    }

    public void setAkselListe(AkselListe akselListe) {
      this.akselListe = akselListe;
    }

    public Integer getEgenvektAkselGruppe() {
      return egenvektAkselGruppe;
    }

    public void setEgenvektAkselGruppe(Integer egenvektAkselGruppe) {
      this.egenvektAkselGruppe = egenvektAkselGruppe;
    }

    public Integer getEgenvektAkselGruppeMaks() {
      return egenvektAkselGruppeMaks;
    }

    public void setEgenvektAkselGruppeMaks(Integer egenvektAkselGruppeMaks) {
      this.egenvektAkselGruppeMaks = egenvektAkselGruppeMaks;
    }

    public Integer getEgenvektAkselGruppeMin() {
      return egenvektAkselGruppeMin;
    }

    public void setEgenvektAkselGruppeMin(Integer egenvektAkselGruppeMin) {
      this.egenvektAkselGruppeMin = egenvektAkselGruppeMin;
    }

    public Integer getFordelingAvTillattTotalvektAkselGruppeMaks() {
      return fordelingAvTillattTotalvektAkselGruppeMaks;
    }

    public void setFordelingAvTillattTotalvektAkselGruppeMaks(
      Integer fordelingAvTillattTotalvektAkselGruppeMaks
    ) {
      this.fordelingAvTillattTotalvektAkselGruppeMaks =
        fordelingAvTillattTotalvektAkselGruppeMaks;
    }

    public Integer getFordelingAvTillattTotalvektAkselGruppeMin() {
      return fordelingAvTillattTotalvektAkselGruppeMin;
    }

    public void setFordelingAvTillattTotalvektAkselGruppeMin(
      Integer fordelingAvTillattTotalvektAkselGruppeMin
    ) {
      this.fordelingAvTillattTotalvektAkselGruppeMin =
        fordelingAvTillattTotalvektAkselGruppeMin;
    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public String getPlasseringAkselGruppe() {
      return plasseringAkselGruppe;
    }

    public void setPlasseringAkselGruppe(String plasseringAkselGruppe) {
      this.plasseringAkselGruppe = plasseringAkselGruppe;
    }

    public Integer getTekniskTillattAkselGruppeLast() {
      return tekniskTillattAkselGruppeLast;
    }

    public void setTekniskTillattAkselGruppeLast(
      Integer tekniskTillattAkselGruppeLast
    ) {
      this.tekniskTillattAkselGruppeLast = tekniskTillattAkselGruppeLast;
    }

    public Integer getTekniskTillattAkselGruppeLastVeg() {
      return tekniskTillattAkselGruppeLastVeg;
    }

    public void setTekniskTillattAkselGruppeLastVeg(
      Integer tekniskTillattAkselGruppeLastVeg
    ) {
      this.tekniskTillattAkselGruppeLastVeg = tekniskTillattAkselGruppeLastVeg;
    }
  }

  public static class AkselListe {

    private List<Aksel> aksel;

    // getters and setters

    public List<Aksel> getAksel() {
      return aksel;
    }

    public void setAksel(List<Aksel> aksel) {
      this.aksel = aksel;
    }
  }

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

    // getters and setters
    public Integer getAntallHjul() {
      return antallHjul;
    }

    public void setAntallHjul(Integer antallHjul) {
      this.antallHjul = antallHjul;
    }

    public Integer getAvstandTilNesteAksling() {
      return avstandTilNesteAksling;
    }

    public void setAvstandTilNesteAksling(Integer avstandTilNesteAksling) {
      this.avstandTilNesteAksling = avstandTilNesteAksling;
    }

    public Boolean isBelastbar() {
      return belastbar;
    }

    public void setBelastbar(Boolean belastbar) {
      this.belastbar = belastbar;
    }

    public Boolean isBremseAksel() {
      return bremseAksel;
    }

    public void setBremseAksel(Boolean bremseAksel) {
      this.bremseAksel = bremseAksel;
    }

    public Boolean isDrivAksel() {
      return drivAksel;
    }

    public void setDrivAksel(Boolean drivAksel) {
      this.drivAksel = drivAksel;
    }

    public Integer getEgenvektAksel() {
      return egenvektAksel;
    }

    public void setEgenvektAksel(Integer egenvektAksel) {
      this.egenvektAksel = egenvektAksel;
    }

    public Integer getEgenvektAkselMaks() {
      return egenvektAkselMaks;
    }

    public void setEgenvektAkselMaks(Integer egenvektAkselMaks) {
      this.egenvektAkselMaks = egenvektAkselMaks;
    }

    public Integer getEgenvektAkselMin() {
      return egenvektAkselMin;
    }

    public void setEgenvektAkselMin(Integer egenvektAkselMin) {
      this.egenvektAkselMin = egenvektAkselMin;
    }

    public Integer getFordelingAvTillattTotalvektAkselMaks() {
      return fordelingAvTillattTotalvektAkselMaks;
    }

    public void setFordelingAvTillattTotalvektAkselMaks(
      Integer fordelingAvTillattTotalvektAkselMaks
    ) {
      this.fordelingAvTillattTotalvektAkselMaks =
        fordelingAvTillattTotalvektAkselMaks;
    }

    public Integer getFordelingAvTillattTotalvektAkselMin() {
      return fordelingAvTillattTotalvektAkselMin;
    }

    public void setFordelingAvTillattTotalvektAkselMin(
      Integer fordelingAvTillattTotalvektAkselMin
    ) {
      this.fordelingAvTillattTotalvektAkselMin =
        fordelingAvTillattTotalvektAkselMin;
    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public Boolean isLoftbar() {
      return loftbar;
    }

    public void setLoftbar(Boolean loftbar) {
      this.loftbar = loftbar;
    }

    public Boolean isLuftfjaering() {
      return luftfjaering;
    }

    public void setLuftfjaering(Boolean luftfjaering) {
      this.luftfjaering = luftfjaering;
    }

    public Integer getMaksAvstandTilNesteAksling() {
      return maksAvstandTilNesteAksling;
    }

    public void setMaksAvstandTilNesteAksling(
      Integer maksAvstandTilNesteAksling
    ) {
      this.maksAvstandTilNesteAksling = maksAvstandTilNesteAksling;
    }

    public Integer getMaksimalSporvidde() {
      return maksimalSporvidde;
    }

    public void setMaksimalSporvidde(Integer maksimalSporvidde) {
      this.maksimalSporvidde = maksimalSporvidde;
    }

    public Integer getMinAvstandTilNesteAksling() {
      return minAvstandTilNesteAksling;
    }

    public void setMinAvstandTilNesteAksling(
      Integer minAvstandTilNesteAksling
    ) {
      this.minAvstandTilNesteAksling = minAvstandTilNesteAksling;
    }

    public Integer getMinimalSporvidde() {
      return minimalSporvidde;
    }

    public void setMinimalSporvidde(Integer minimalSporvidde) {
      this.minimalSporvidde = minimalSporvidde;
    }

    public String getPlasseringAksel() {
      return plasseringAksel;
    }

    public void setPlasseringAksel(String plasseringAksel) {
      this.plasseringAksel = plasseringAksel;
    }

    public Integer getSporvidde() {
      return sporvidde;
    }

    public void setSporvidde(Integer sporvidde) {
      this.sporvidde = sporvidde;
    }

    public Boolean isStyreAksel() {
      return styreAksel;
    }

    public void setStyreAksel(Boolean styreAksel) {
      this.styreAksel = styreAksel;
    }

    public Integer getTekniskTillattAkselLast() {
      return tekniskTillattAkselLast;
    }

    public void setTekniskTillattAkselLast(Integer tekniskTillattAkselLast) {
      this.tekniskTillattAkselLast = tekniskTillattAkselLast;
    }

    public Integer getTekniskTillattAkselLastForhoyet() {
      return tekniskTillattAkselLastForhoyet;
    }

    public void setTekniskTillattAkselLastForhoyet(
      Integer tekniskTillattAkselLastForhoyet
    ) {
      this.tekniskTillattAkselLastForhoyet = tekniskTillattAkselLastForhoyet;
    }

    public Integer getTekniskTillattAkselLastVeg() {
      return tekniskTillattAkselLastVeg;
    }

    public void setTekniskTillattAkselLastVeg(
      Integer tekniskTillattAkselLastVeg
    ) {
      this.tekniskTillattAkselLastVeg = tekniskTillattAkselLastVeg;
    }
  }

  public static class Bremser {

    private Boolean abs;
    private String bremsesystem;
    private String driftsbremsBak;
    private String driftsbremsForan;
    private List<String> tilhengerBremseforbindelse;
    private Double trykkMeterledningTilhengerkopling;
    private Double trykktilsluttning1;
    private Double trykktilsluttning2;

    // getters and setters
    public Boolean isAbs() {
      return abs;
    }

    public void setAbs(Boolean abs) {
      this.abs = abs;
    }

    public String getBremsesystem() {
      return bremsesystem;
    }

    public void setBremsesystem(String bremsesystem) {
      this.bremsesystem = bremsesystem;
    }

    public String getDriftsbremsBak() {
      return driftsbremsBak;
    }

    public void setDriftsbremsBak(String driftsbremsBak) {
      this.driftsbremsBak = driftsbremsBak;
    }

    public String getDriftsbremsForan() {
      return driftsbremsForan;
    }

    public void setDriftsbremsForan(String driftsbremsForan) {
      this.driftsbremsForan = driftsbremsForan;
    }

    public List<String> getTilhengerBremseforbindelse() {
      return tilhengerBremseforbindelse;
    }

    public void setTilhengerBremseforbindelse(
      List<String> tilhengerBremseforbindelse
    ) {
      this.tilhengerBremseforbindelse = tilhengerBremseforbindelse;
    }

    public Double getTrykkMeterledningTilhengerkopling() {
      return trykkMeterledningTilhengerkopling;
    }

    public void setTrykkMeterledningTilhengerkopling(
      Double trykkMeterledningTilhengerkopling
    ) {
      this.trykkMeterledningTilhengerkopling =
        trykkMeterledningTilhengerkopling;
    }

    public Double getTrykktilsluttning1() {
      return trykktilsluttning1;
    }

    public void setTrykktilsluttning1(Double trykktilsluttning1) {
      this.trykktilsluttning1 = trykktilsluttning1;
    }

    public Double getTrykktilsluttning2() {
      return trykktilsluttning2;
    }

    public void setTrykktilsluttning2(Double trykktilsluttning2) {
      this.trykktilsluttning2 = trykktilsluttning2;
    }
  }

  public static class DekkOgFelg {

    private List<AkselDekkOgFelgKombinasjon> akselDekkOgFelgKombinasjon;
    private DekkOgFelgSidevogn dekkOgFelgSidevogn;

    // getters and setters
    public List<AkselDekkOgFelgKombinasjon> getAkselDekkOgFelgKombinasjon() {
      return akselDekkOgFelgKombinasjon;
    }

    public void setAkselDekkOgFelgKombinasjon(
      List<AkselDekkOgFelgKombinasjon> akselDekkOgFelgKombinasjon
    ) {
      this.akselDekkOgFelgKombinasjon = akselDekkOgFelgKombinasjon;
    }

    public DekkOgFelgSidevogn getDekkOgFelgSidevogn() {
      return dekkOgFelgSidevogn;
    }

    public void setDekkOgFelgSidevogn(DekkOgFelgSidevogn dekkOgFelgSidevogn) {
      this.dekkOgFelgSidevogn = dekkOgFelgSidevogn;
    }
  }

  public static class AkselDekkOgFelgKombinasjon {

    private List<AkselDekkOgFelg> akselDekkOgFelg;
    private Integer tillattTotalvektTraktor;

    // getters and setters
    public List<AkselDekkOgFelg> getAkselDekkOgFelg() {
      return akselDekkOgFelg;
    }

    public void setAkselDekkOgFelg(List<AkselDekkOgFelg> akselDekkOgFelg) {
      this.akselDekkOgFelg = akselDekkOgFelg;
    }

    public Integer getTillattTotalvektTraktor() {
      return tillattTotalvektTraktor;
    }

    public void setTillattTotalvektTraktor(Integer tillattTotalvektTraktor) {
      this.tillattTotalvektTraktor = tillattTotalvektTraktor;
    }
  }

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

    // getters and setters
    public Integer getAkselId() {
      return akselId;
    }

    public void setAkselId(Integer akselId) {
      this.akselId = akselId;
    }

    public String getBelastningskodeDekk() {
      return belastningskodeDekk;
    }

    public void setBelastningskodeDekk(String belastningskodeDekk) {
      this.belastningskodeDekk = belastningskodeDekk;
    }

    public String getBelastningskodeDekkTraktor() {
      return belastningskodeDekkTraktor;
    }

    public void setBelastningskodeDekkTraktor(
      String belastningskodeDekkTraktor
    ) {
      this.belastningskodeDekkTraktor = belastningskodeDekkTraktor;
    }

    public String getDekkdimensjon() {
      return dekkdimensjon;
    }

    public void setDekkdimensjon(String dekkdimensjon) {
      this.dekkdimensjon = dekkdimensjon;
    }

    public String getFelgdimensjon() {
      return felgdimensjon;
    }

    public void setFelgdimensjon(String felgdimensjon) {
      this.felgdimensjon = felgdimensjon;
    }

    public String getHastighetskodeDekk() {
      return hastighetskodeDekk;
    }

    public void setHastighetskodeDekk(String hastighetskodeDekk) {
      this.hastighetskodeDekk = hastighetskodeDekk;
    }

    public String getInnpress() {
      return innpress;
    }

    public void setInnpress(String innpress) {
      this.innpress = innpress;
    }

    public Integer getTillattAkselLastTraktor() {
      return tillattAkselLastTraktor;
    }

    public void setTillattAkselLastTraktor(Integer tillattAkselLastTraktor) {
      this.tillattAkselLastTraktor = tillattAkselLastTraktor;
    }

    public Boolean isTvilling() {
      return tvilling;
    }

    public void setTvilling(Boolean tvilling) {
      this.tvilling = tvilling;
    }
  }

  public static class DekkOgFelgSidevogn {

    private String belastningskodeDekkSidevogn;
    private String dekkdimensjonSidevogn;
    private String felgdimensjonSidevogn;
    private String hastighetskodeDekkSidevogn;
    private String innpressSidevogn;

    // getters and setters
    public String getBelastningskodeDekkSidevogn() {
      return belastningskodeDekkSidevogn;
    }

    public void setBelastningskodeDekkSidevogn(
      String belastningskodeDekkSidevogn
    ) {
      this.belastningskodeDekkSidevogn = belastningskodeDekkSidevogn;
    }

    public String getDekkdimensjonSidevogn() {
      return dekkdimensjonSidevogn;
    }

    public void setDekkdimensjonSidevogn(String dekkdimensjonSidevogn) {
      this.dekkdimensjonSidevogn = dekkdimensjonSidevogn;
    }

    public String getFelgdimensjonSidevogn() {
      return felgdimensjonSidevogn;
    }

    public void setFelgdimensjonSidevogn(String felgdimensjonSidevogn) {
      this.felgdimensjonSidevogn = felgdimensjonSidevogn;
    }

    public String getHastighetskodeDekkSidevogn() {
      return hastighetskodeDekkSidevogn;
    }

    public void setHastighetskodeDekkSidevogn(
      String hastighetskodeDekkSidevogn
    ) {
      this.hastighetskodeDekkSidevogn = hastighetskodeDekkSidevogn;
    }

    public String getInnpressSidevogn() {
      return innpressSidevogn;
    }

    public void setInnpressSidevogn(String innpressSidevogn) {
      this.innpressSidevogn = innpressSidevogn;
    }
  }

  public static class Dimensjoner {

    private Integer bredde;
    private Integer hoyde;
    private Integer lengde;
    private Integer lengdeInnvendigLasteplan;
    private Integer maksimalBredde;
    private Integer maksimalHoyde;
    private Integer maksimalLengde;
    private Integer maksimalLengdeInnvendigLasteplan;

    // getters and setters
    public Integer getBredde() {
      return bredde;
    }

    public void setBredde(Integer bredde) {
      this.bredde = bredde;
    }

    public Integer getHoyde() {
      return hoyde;
    }

    public void setHoyde(Integer hoyde) {
      this.hoyde = hoyde;
    }

    public Integer getLengde() {
      return lengde;
    }

    public void setLengde(Integer lengde) {
      this.lengde = lengde;
    }

    public Integer getLengdeInnvendigLasteplan() {
      return lengdeInnvendigLasteplan;
    }

    public void setLengdeInnvendigLasteplan(Integer lengdeInnvendigLasteplan) {
      this.lengdeInnvendigLasteplan = lengdeInnvendigLasteplan;
    }

    public Integer getMaksimalBredde() {
      return maksimalBredde;
    }

    public void setMaksimalBredde(Integer maksimalBredde) {
      this.maksimalBredde = maksimalBredde;
    }

    public Integer getMaksimalHoyde() {
      return maksimalHoyde;
    }

    public void setMaksimalHoyde(Integer maksimalHoyde) {
      this.maksimalHoyde = maksimalHoyde;
    }

    public Integer getMaksimalLengde() {
      return maksimalLengde;
    }

    public void setMaksimalLengde(Integer maksimalLengde) {
      this.maksimalLengde = maksimalLengde;
    }

    public Integer getMaksimalLengdeInnvendigLasteplan() {
      return maksimalLengdeInnvendigLasteplan;
    }

    public void setMaksimalLengdeInnvendigLasteplan(
      Integer maksimalLengdeInnvendigLasteplan
    ) {
      this.maksimalLengdeInnvendigLasteplan = maksimalLengdeInnvendigLasteplan;
    }
  }

  public static class Generelt {

    private List<Fabrikant> fabrikant;
    private String ferdigbyggetEllerEndretSomFolger;
    private List<String> handelsbetegnelse;
    private List<Merke> merke;
    private Kode tekniskKode;
    private Kode tekniskUnderkode;
    private String typebetegnelse;
    private String unntakFra;

    public List<Fabrikant> getFabrikant() {
      return fabrikant;
    }

    public void setFabrikant(List<Fabrikant> fabrikant) {
      this.fabrikant = fabrikant;
    }

    public String getFerdigbyggetEllerEndretSomFolger() {
      return ferdigbyggetEllerEndretSomFolger;
    }

    public void setFerdigbyggetEllerEndretSomFolger(
      String ferdigbyggetEllerEndretSomFolger
    ) {
      this.ferdigbyggetEllerEndretSomFolger = ferdigbyggetEllerEndretSomFolger;
    }

    public List<String> getHandelsbetegnelse() {
      return handelsbetegnelse;
    }

    public void setHandelsbetegnelse(List<String> handelsbetegnelse) {
      this.handelsbetegnelse = handelsbetegnelse;
    }

    public List<Merke> getMerke() {
      return merke;
    }

    public void setMerke(List<Merke> merke) {
      this.merke = merke;
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

    public String getTypebetegnelse() {
      return typebetegnelse;
    }

    public void setTypebetegnelse(String typebetegnelse) {
      this.typebetegnelse = typebetegnelse;
    }

    public String getUnntakFra() {
      return unntakFra;
    }

    public void setUnntakFra(String unntakFra) {
      this.unntakFra = unntakFra;
    }
  }

  public static class Fabrikant {

    private String fabrikantAdresse;
    private String fabrikantNavn;
    private String fabrikantRepresentantAdresse;
    private String fabrikantRepresentantNavn;

    public String getFabrikantAdresse() {
      return fabrikantAdresse;
    }

    public void setFabrikantAdresse(String fabrikantAdresse) {
      this.fabrikantAdresse = fabrikantAdresse;
    }

    public String getFabrikantNavn() {
      return fabrikantNavn;
    }

    public void setFabrikantNavn(String fabrikantNavn) {
      this.fabrikantNavn = fabrikantNavn;
    }

    public String getFabrikantRepresentantAdresse() {
      return fabrikantRepresentantAdresse;
    }

    public void setFabrikantRepresentantAdresse(
      String fabrikantRepresentantAdresse
    ) {
      this.fabrikantRepresentantAdresse = fabrikantRepresentantAdresse;
    }

    public String getFabrikantRepresentantNavn() {
      return fabrikantRepresentantNavn;
    }

    public void setFabrikantRepresentantNavn(String fabrikantRepresentantNavn) {
      this.fabrikantRepresentantNavn = fabrikantRepresentantNavn;
    }
    // getters and setters
  }

  public static class Merke {

    private String merke;
    private String merkeKode;

    // getters and setters
    public String getMerke() {
      return merke;
    }

    public void setMerke(String merke) {
      this.merke = merke;
    }

    public String getMerkeKode() {
      return merkeKode;
    }

    public void setMerkeKode(String merkeKode) {
      this.merkeKode = merkeKode;
    }
  }

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

    // getters and setters
    public List<Integer> getAntallDorer() {
      return antallDorer;
    }

    public void setAntallDorer(List<Integer> antallDorer) {
      this.antallDorer = antallDorer;
    }

    public Integer getAvstandNavSkjermbueBak() {
      return avstandNavSkjermbueBak;
    }

    public void setAvstandNavSkjermbueBak(Integer avstandNavSkjermbueBak) {
      this.avstandNavSkjermbueBak = avstandNavSkjermbueBak;
    }

    public Integer getAvstandNavSkjermbueForan() {
      return avstandNavSkjermbueForan;
    }

    public void setAvstandNavSkjermbueForan(Integer avstandNavSkjermbueForan) {
      this.avstandNavSkjermbueForan = avstandNavSkjermbueForan;
    }

    public String getBussKategori() {
      return bussKategori;
    }

    public void setBussKategori(String bussKategori) {
      this.bussKategori = bussKategori;
    }

    public List<String> getDorUtforming() {
      return dorUtforming;
    }

    public void setDorUtforming(List<String> dorUtforming) {
      this.dorUtforming = dorUtforming;
    }

    public String getFargeFjar() {
      return fargeFjar;
    }

    public void setFargeFjar(String fargeFjar) {
      this.fargeFjar = fargeFjar;
    }

    public String getForankringSikkerhetsseler() {
      return forankringSikkerhetsseler;
    }

    public void setForankringSikkerhetsseler(String forankringSikkerhetsseler) {
      this.forankringSikkerhetsseler = forankringSikkerhetsseler;
    }

    public String getForervern() {
      return forervern;
    }

    public void setForervern(String forervern) {
      this.forervern = forervern;
    }

    public String getForervernBoyle() {
      return forervernBoyle;
    }

    public void setForervernBoyle(String forervernBoyle) {
      this.forervernBoyle = forervernBoyle;
    }

    public String getGodkjentADR() {
      return godkjentADR;
    }

    public void setGodkjentADR(String godkjentADR) {
      this.godkjentADR = godkjentADR;
    }

    public Boolean isHydrauliskLoft() {
      return hydrauliskLoft;
    }

    public void setHydrauliskLoft(Boolean hydrauliskLoft) {
      this.hydrauliskLoft = hydrauliskLoft;
    }

    public String getKarosseriArt() {
      return karosseriArt;
    }

    public void setKarosseriArt(String karosseriArt) {
      this.karosseriArt = karosseriArt;
    }

    public Kode getKarosseritype() {
      return karosseritype;
    }

    public void setKarosseritype(Kode karosseritype) {
      this.karosseritype = karosseritype;
    }

    public Kode getKjennemerketypeBak() {
      return kjennemerketypeBak;
    }

    public void setKjennemerketypeBak(Kode kjennemerketypeBak) {
      this.kjennemerketypeBak = kjennemerketypeBak;
    }

    public Kode getKjennemerkestorrelseBak() {
      return kjennemerkestorrelseBak;
    }

    public void setKjennemerkestorrelseBak(Kode kjennemerkestorrelseBak) {
      this.kjennemerkestorrelseBak = kjennemerkestorrelseBak;
    }

    public Kode getKjennemerketypeForan() {
      return kjennemerketypeForan;
    }

    public void setKjennemerketypeForan(Kode kjennemerketypeForan) {
      this.kjennemerketypeForan = kjennemerketypeForan;
    }

    public Kode getKjennemerkestorrelseForan() {
      return kjennemerkestorrelseForan;
    }

    public void setKjennemerkestorrelseForan(Kode kjennemerkestorrelseForan) {
      this.kjennemerkestorrelseForan = kjennemerkestorrelseForan;
    }

    public Kode getKjennemerketypeVenstre() {
      return kjennemerketypeVenstre;
    }

    public void setKjennemerketypeVenstre(Kode kjennemerketypeVenstre) {
      this.kjennemerketypeVenstre = kjennemerketypeVenstre;
    }

    public Kode getKjennemerkestorrelseVenstre() {
      return kjennemerkestorrelseVenstre;
    }

    public void setKjennemerkestorrelseVenstre(
      Kode kjennemerkestorrelseVenstre
    ) {
      this.kjennemerkestorrelseVenstre = kjennemerkestorrelseVenstre;
    }

    public String getKjoringSide() {
      return kjoringSide;
    }

    public void setKjoringSide(String kjoringSide) {
      this.kjoringSide = kjoringSide;
    }

    public String getOppbygningUnderstellsnummer() {
      return oppbygningUnderstellsnummer;
    }

    public void setOppbygningUnderstellsnummer(
      String oppbygningUnderstellsnummer
    ) {
      this.oppbygningUnderstellsnummer = oppbygningUnderstellsnummer;
    }

    public Integer getOverhengBak() {
      return overhengBak;
    }

    public void setOverhengBak(Integer overhengBak) {
      this.overhengBak = overhengBak;
    }

    public Kode getPabyggsKode() {
      return pabyggsKode;
    }

    public void setPabyggsKode(Kode pabyggsKode) {
      this.pabyggsKode = pabyggsKode;
    }

    public String getPassasjerHandtak() {
      return passasjerHandtak;
    }

    public void setPassasjerHandtak(String passasjerHandtak) {
      this.passasjerHandtak = passasjerHandtak;
    }

    public Kode getPlasseringAvDorer() {
      return plasseringAvDorer;
    }

    public void setPlasseringAvDorer(Kode plasseringAvDorer) {
      this.plasseringAvDorer = plasseringAvDorer;
    }

    public List<Kode> getPlasseringFabrikasjonsplate() {
      return plasseringFabrikasjonsplate;
    }

    public void setPlasseringFabrikasjonsplate(
      List<Kode> plasseringFabrikasjonsplate
    ) {
      this.plasseringFabrikasjonsplate = plasseringFabrikasjonsplate;
    }

    public String getPlasseringMerkeplateTrimming() {
      return plasseringMerkeplateTrimming;
    }

    public void setPlasseringMerkeplateTrimming(
      String plasseringMerkeplateTrimming
    ) {
      this.plasseringMerkeplateTrimming = plasseringMerkeplateTrimming;
    }

    public List<Kode> getPlasseringUnderstellsnummer() {
      return plasseringUnderstellsnummer;
    }

    public void setPlasseringUnderstellsnummer(
      List<Kode> plasseringUnderstellsnummer
    ) {
      this.plasseringUnderstellsnummer = plasseringUnderstellsnummer;
    }

    public List<Kode> getrFarge() {
      return rFarge;
    }

    public void setrFarge(List<Kode> rFarge) {
      this.rFarge = rFarge;
    }

    public String getSikkerhetsseler() {
      return sikkerhetsseler;
    }

    public void setSikkerhetsseler(String sikkerhetsseler) {
      this.sikkerhetsseler = sikkerhetsseler;
    }

    public String getStyremekanismeArt() {
      return styremekanismeArt;
    }

    public void setStyremekanismeArt(String styremekanismeArt) {
      this.styremekanismeArt = styremekanismeArt;
    }

    public Boolean isTemperaturregulertSkap() {
      return temperaturregulertSkap;
    }

    public void setTemperaturregulertSkap(Boolean temperaturregulertSkap) {
      this.temperaturregulertSkap = temperaturregulertSkap;
    }

    public Boolean isVendbarForerplass() {
      return vendbarForerplass;
    }

    public void setVendbarForerplass(Boolean vendbarForerplass) {
      this.vendbarForerplass = vendbarForerplass;
    }
  }

  public static class Miljodata {

    private Double co2BesparelsePgaOkoInnovasjon;
    private Kode euroKlasse;
    private String lyddemperUtblas;
    private List<MiljoOgdrivstoffGruppe> miljoOgdrivstoffGruppe;
    private Boolean okoInnovasjon;
    private String typeOkoInnovasjon;

    public Boolean isOkoInnovasjon() {
      return okoInnovasjon;
    }

    public void setOkoInnovasjon(Boolean okoInnovasjon) {
      this.okoInnovasjon = okoInnovasjon;
    }

    public String getTypeOkoInnovasjon() {
      return typeOkoInnovasjon;
    }

    public void setTypeOkoInnovasjon(String typeOkoInnovasjon) {
      this.typeOkoInnovasjon = typeOkoInnovasjon;
    }

    // getters and setters
    public Double getCo2BesparelsePgaOkoInnovasjon() {
      return co2BesparelsePgaOkoInnovasjon;
    }

    public void setCo2BesparelsePgaOkoInnovasjon(
      Double co2BesparelsePgaOkoInnovasjon
    ) {
      this.co2BesparelsePgaOkoInnovasjon = co2BesparelsePgaOkoInnovasjon;
    }

    public Kode getEuroKlasse() {
      return euroKlasse;
    }

    public void setEuroKlasse(Kode euroKlasse) {
      this.euroKlasse = euroKlasse;
    }

    public String getLyddemperUtblas() {
      return lyddemperUtblas;
    }

    public void setLyddemperUtblas(String lyddemperUtblas) {
      this.lyddemperUtblas = lyddemperUtblas;
    }

    public List<MiljoOgdrivstoffGruppe> getMiljoOgdrivstoffGruppe() {
      return miljoOgdrivstoffGruppe;
    }

    public void setMiljoOgdrivstoffGruppe(
      List<MiljoOgdrivstoffGruppe> miljoOgdrivstoffGruppe
    ) {
      this.miljoOgdrivstoffGruppe = miljoOgdrivstoffGruppe;
    }
  }

  public static class MiljoOgdrivstoffGruppe {

    private Kode drivstoffKodeMiljodata;
    private List<ForbrukOgUtslipp> forbrukOgUtslipp;
    private Lyd lyd;

    // getters and setters
    public Kode getDrivstoffKodeMiljodata() {
      return drivstoffKodeMiljodata;
    }

    public void setDrivstoffKodeMiljodata(Kode drivstoffKodeMiljodata) {
      this.drivstoffKodeMiljodata = drivstoffKodeMiljodata;
    }

    public List<ForbrukOgUtslipp> getForbrukOgUtslipp() {
      return forbrukOgUtslipp;
    }

    public void setForbrukOgUtslipp(List<ForbrukOgUtslipp> forbrukOgUtslipp) {
      this.forbrukOgUtslipp = forbrukOgUtslipp;
    }

    public Lyd getLyd() {
      return lyd;
    }

    public void setLyd(Lyd lyd) {
      this.lyd = lyd;
    }
  }

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

    // getters and setters
    public Double getAntallPartikler() {
      return antallPartikler;
    }

    public void setAntallPartikler(Double antallPartikler) {
      this.antallPartikler = antallPartikler;
    }

    public Double getCo2BlandetKjoring() {
      return co2BlandetKjoring;
    }

    public void setCo2BlandetKjoring(Double co2BlandetKjoring) {
      this.co2BlandetKjoring = co2BlandetKjoring;
    }

    public Double getCo2Bykjoring() {
      return co2Bykjoring;
    }

    public void setCo2Bykjoring(Double co2Bykjoring) {
      this.co2Bykjoring = co2Bykjoring;
    }

    public Double getCo2Landeveiskjoring() {
      return co2Landeveiskjoring;
    }

    public void setCo2Landeveiskjoring(Double co2Landeveiskjoring) {
      this.co2Landeveiskjoring = co2Landeveiskjoring;
    }

    public Double getCoProsent() {
      return coProsent;
    }

    public void setCoProsent(Double coProsent) {
      this.coProsent = coProsent;
    }

    public Integer getElEnergiforbruk() {
      return elEnergiforbruk;
    }

    public void setElEnergiforbruk(Integer elEnergiforbruk) {
      this.elEnergiforbruk = elEnergiforbruk;
    }

    public Double getForbrukBlandetKjoring() {
      return forbrukBlandetKjoring;
    }

    public void setForbrukBlandetKjoring(Double forbrukBlandetKjoring) {
      this.forbrukBlandetKjoring = forbrukBlandetKjoring;
    }

    public Double getForbrukBykjoring() {
      return forbrukBykjoring;
    }

    public void setForbrukBykjoring(Double forbrukBykjoring) {
      this.forbrukBykjoring = forbrukBykjoring;
    }

    public Double getForbrukLandeveiskjoring() {
      return forbrukLandeveiskjoring;
    }

    public void setForbrukLandeveiskjoring(Double forbrukLandeveiskjoring) {
      this.forbrukLandeveiskjoring = forbrukLandeveiskjoring;
    }

    public Kode getMalemetode() {
      return malemetode;
    }

    public void setMalemetode(Kode malemetode) {
      this.malemetode = malemetode;
    }

    public String getMalemetodeAnnen() {
      return malemetodeAnnen;
    }

    public void setMalemetodeAnnen(String malemetodeAnnen) {
      this.malemetodeAnnen = malemetodeAnnen;
    }

    public Boolean isPartikkelfilterFabrikkmontert() {
      return partikkelfilterFabrikkmontert;
    }

    public void setPartikkelfilterFabrikkmontert(
      Boolean partikkelfilterFabrikkmontert
    ) {
      this.partikkelfilterFabrikkmontert = partikkelfilterFabrikkmontert;
    }

    public Boolean isPartikkelfilterUtslipp() {
      return partikkelfilterUtslipp;
    }

    public void setPartikkelfilterUtslipp(Boolean partikkelfilterUtslipp) {
      this.partikkelfilterUtslipp = partikkelfilterUtslipp;
    }

    public Integer getRekkeviddeKm() {
      return rekkeviddeKm;
    }

    public void setRekkeviddeKm(Integer rekkeviddeKm) {
      this.rekkeviddeKm = rekkeviddeKm;
    }

    public Double getUtslippCOgPrKWh() {
      return utslippCOgPrKWh;
    }

    public void setUtslippCOgPrKWh(Double utslippCOgPrKWh) {
      this.utslippCOgPrKWh = utslippCOgPrKWh;
    }

    public Double getUtslippCOmgPrKm() {
      return utslippCOmgPrKm;
    }

    public void setUtslippCOmgPrKm(Double utslippCOmgPrKm) {
      this.utslippCOmgPrKm = utslippCOmgPrKm;
    }

    public Double getUtslippHCgPrKWh() {
      return utslippHCgPrKWh;
    }

    public void setUtslippHCgPrKWh(Double utslippHCgPrKWh) {
      this.utslippHCgPrKWh = utslippHCgPrKWh;
    }

    public Double getUtslippHCgPrMin() {
      return utslippHCgPrMin;
    }

    public void setUtslippHCgPrMin(Double utslippHCgPrMin) {
      this.utslippHCgPrMin = utslippHCgPrMin;
    }

    public Double getUtslippHCmgPrKm() {
      return utslippHCmgPrKm;
    }

    public void setUtslippHCmgPrKm(Double utslippHCmgPrKm) {
      this.utslippHCmgPrKm = utslippHCmgPrKm;
    }

    public Double getUtslippHCogNOxMgPrKm() {
      return utslippHCogNOxMgPrKm;
    }

    public void setUtslippHCogNOxMgPrKm(Double utslippHCogNOxMgPrKm) {
      this.utslippHCogNOxMgPrKm = utslippHCogNOxMgPrKm;
    }

    public Double getUtslippKorrigertAbsorpsjonskoeffisient() {
      return utslippKorrigertAbsorpsjonskoeffisient;
    }

    public void setUtslippKorrigertAbsorpsjonskoeffisient(
      Double utslippKorrigertAbsorpsjonskoeffisient
    ) {
      this.utslippKorrigertAbsorpsjonskoeffisient =
        utslippKorrigertAbsorpsjonskoeffisient;
    }

    public Double getUtslippNMHCmgPrKm() {
      return utslippNMHCmgPrKm;
    }

    public void setUtslippNMHCmgPrKm(Double utslippNMHCmgPrKm) {
      this.utslippNMHCmgPrKm = utslippNMHCmgPrKm;
    }

    public Double getUtslippNOxGPrKWh() {
      return utslippNOxGPrKWh;
    }

    public void setUtslippNOxGPrKWh(Double utslippNOxGPrKWh) {
      this.utslippNOxGPrKWh = utslippNOxGPrKWh;
    }

    public Double getUtslippNOxMgPrKm() {
      return utslippNOxMgPrKm;
    }

    public void setUtslippNOxMgPrKm(Double utslippNOxMgPrKm) {
      this.utslippNOxMgPrKm = utslippNOxMgPrKm;
    }

    public Double getUtslippPartikkelAntallPrKm() {
      return utslippPartikkelAntallPrKm;
    }

    public void setUtslippPartikkelAntallPrKm(
      Double utslippPartikkelAntallPrKm
    ) {
      this.utslippPartikkelAntallPrKm = utslippPartikkelAntallPrKm;
    }

    public Double getUtslippPartiklerGPrKWh() {
      return utslippPartiklerGPrKWh;
    }

    public void setUtslippPartiklerGPrKWh(Double utslippPartiklerGPrKWh) {
      this.utslippPartiklerGPrKWh = utslippPartiklerGPrKWh;
    }

    public Double getUtslippPartiklerMgPrKm() {
      return utslippPartiklerMgPrKm;
    }

    public void setUtslippPartiklerMgPrKm(Double utslippPartiklerMgPrKm) {
      this.utslippPartiklerMgPrKm = utslippPartiklerMgPrKm;
    }

    public Double getUtslippTHCmgPrKm() {
      return utslippTHCmgPrKm;
    }

    public void setUtslippTHCmgPrKm(Double utslippTHCmgPrKm) {
      this.utslippTHCmgPrKm = utslippTHCmgPrKm;
    }

    public Double getUtslippTHCogNOxMgPrKm() {
      return utslippTHCogNOxMgPrKm;
    }

    public void setUtslippTHCogNOxMgPrKm(Double utslippTHCogNOxMgPrKm) {
      this.utslippTHCogNOxMgPrKm = utslippTHCogNOxMgPrKm;
    }

    public Double getVektetKombinertDrivstoff() {
      return vektetKombinertDrivstoff;
    }

    public void setVektetKombinertDrivstoff(Double vektetKombinertDrivstoff) {
      this.vektetKombinertDrivstoff = vektetKombinertDrivstoff;
    }

    public Integer getVektetKombinertDrivstoffCO2() {
      return vektetKombinertDrivstoffCO2;
    }

    public void setVektetKombinertDrivstoffCO2(
      Integer vektetKombinertDrivstoffCO2
    ) {
      this.vektetKombinertDrivstoffCO2 = vektetKombinertDrivstoffCO2;
    }

    public WltpData getWltpKjoretoyspesifikk() {
      return wltpKjoretoyspesifikk;
    }

    public void setWltpKjoretoyspesifikk(WltpData wltpKjoretoyspesifikk) {
      this.wltpKjoretoyspesifikk = wltpKjoretoyspesifikk;
    }

    public WltpData getWltpTypegodkjenningMaks() {
      return wltpTypegodkjenningMaks;
    }

    public void setWltpTypegodkjenningMaks(WltpData wltpTypegodkjenningMaks) {
      this.wltpTypegodkjenningMaks = wltpTypegodkjenningMaks;
    }

    public WltpData getWltpTypegodkjenningMedium() {
      return wltpTypegodkjenningMedium;
    }

    public void setWltpTypegodkjenningMedium(
      WltpData wltpTypegodkjenningMedium
    ) {
      this.wltpTypegodkjenningMedium = wltpTypegodkjenningMedium;
    }

    public WltpData getWltpTypegodkjenningMin() {
      return wltpTypegodkjenningMin;
    }

    public void setWltpTypegodkjenningMin(WltpData wltpTypegodkjenningMin) {
      this.wltpTypegodkjenningMin = wltpTypegodkjenningMin;
    }
  }

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

    // getters and setters
    public Double getCo2EkstraHoy() {
      return co2EkstraHoy;
    }

    public void setCo2EkstraHoy(Double co2EkstraHoy) {
      this.co2EkstraHoy = co2EkstraHoy;
    }

    public Double getCo2Hoy() {
      return co2Hoy;
    }

    public void setCo2Hoy(Double co2Hoy) {
      this.co2Hoy = co2Hoy;
    }

    public Double getCo2Kombinert() {
      return co2Kombinert;
    }

    public void setCo2Kombinert(Double co2Kombinert) {
      this.co2Kombinert = co2Kombinert;
    }

    public Double getCo2Lav() {
      return co2Lav;
    }

    public void setCo2Lav(Double co2Lav) {
      this.co2Lav = co2Lav;
    }

    public Double getCo2Middels() {
      return co2Middels;
    }

    public void setCo2Middels(Double co2Middels) {
      this.co2Middels = co2Middels;
    }

    public Double getCo2VektetKombinert() {
      return co2VektetKombinert;
    }

    public void setCo2VektetKombinert(Double co2VektetKombinert) {
      this.co2VektetKombinert = co2VektetKombinert;
    }

    public Double getForbrukEkstraHoy() {
      return forbrukEkstraHoy;
    }

    public void setForbrukEkstraHoy(Double forbrukEkstraHoy) {
      this.forbrukEkstraHoy = forbrukEkstraHoy;
    }

    public Double getForbrukHoy() {
      return forbrukHoy;
    }

    public void setForbrukHoy(Double forbrukHoy) {
      this.forbrukHoy = forbrukHoy;
    }

    public Double getForbrukKombinert() {
      return forbrukKombinert;
    }

    public void setForbrukKombinert(Double forbrukKombinert) {
      this.forbrukKombinert = forbrukKombinert;
    }

    public Double getForbrukLav() {
      return forbrukLav;
    }

    public void setForbrukLav(Double forbrukLav) {
      this.forbrukLav = forbrukLav;
    }

    public Double getForbrukMiddels() {
      return forbrukMiddels;
    }

    public void setForbrukMiddels(Double forbrukMiddels) {
      this.forbrukMiddels = forbrukMiddels;
    }

    public Double getForbrukVektetKombinert() {
      return forbrukVektetKombinert;
    }

    public void setForbrukVektetKombinert(Double forbrukVektetKombinert) {
      this.forbrukVektetKombinert = forbrukVektetKombinert;
    }

    public Integer getRekkeviddeKmBlandetkjoring() {
      return rekkeviddeKmBlandetkjoring;
    }

    public void setRekkeviddeKmBlandetkjoring(
      Integer rekkeviddeKmBlandetkjoring
    ) {
      this.rekkeviddeKmBlandetkjoring = rekkeviddeKmBlandetkjoring;
    }

    public Integer getRekkeviddeKmBykjoring() {
      return rekkeviddeKmBykjoring;
    }

    public void setRekkeviddeKmBykjoring(Integer rekkeviddeKmBykjoring) {
      this.rekkeviddeKmBykjoring = rekkeviddeKmBykjoring;
    }

    public Integer getElEnergiforbruk() {
      return elEnergiforbruk;
    }

    public void setElEnergiforbruk(Integer elEnergiforbruk) {
      this.elEnergiforbruk = elEnergiforbruk;
    }

    public Double getNedcForbrukBykjoring() {
      return nedcForbrukBykjoring;
    }

    public void setNedcForbrukBykjoring(Double nedcForbrukBykjoring) {
      this.nedcForbrukBykjoring = nedcForbrukBykjoring;
    }

    public Double getNedcForbrukLandeveiskjoring() {
      return nedcForbrukLandeveiskjoring;
    }

    public void setNedcForbrukLandeveiskjoring(
      Double nedcForbrukLandeveiskjoring
    ) {
      this.nedcForbrukLandeveiskjoring = nedcForbrukLandeveiskjoring;
    }

    public Double getNedcForbrukBlandetKjoring() {
      return nedcForbrukBlandetKjoring;
    }

    public void setNedcForbrukBlandetKjoring(Double nedcForbrukBlandetKjoring) {
      this.nedcForbrukBlandetKjoring = nedcForbrukBlandetKjoring;
    }

    public Double getNedcCo2BykjoringGPrKm() {
      return nedcCo2BykjoringGPrKm;
    }

    public void setNedcCo2BykjoringGPrKm(Double nedcCo2BykjoringGPrKm) {
      this.nedcCo2BykjoringGPrKm = nedcCo2BykjoringGPrKm;
    }

    public Double getNedcCo2LandeveiskjoringGPrKm() {
      return nedcCo2LandeveiskjoringGPrKm;
    }

    public void setNedcCo2LandeveiskjoringGPrKm(
      Double nedcCo2LandeveiskjoringGPrKm
    ) {
      this.nedcCo2LandeveiskjoringGPrKm = nedcCo2LandeveiskjoringGPrKm;
    }

    public Double getNedcCo2BlandetKjoringGPrKm() {
      return nedcCo2BlandetKjoringGPrKm;
    }

    public void setNedcCo2BlandetKjoringGPrKm(
      Double nedcCo2BlandetKjoringGPrKm
    ) {
      this.nedcCo2BlandetKjoringGPrKm = nedcCo2BlandetKjoringGPrKm;
    }

    public Double getNedcVektetKombinertDrivstoffCo2() {
      return nedcVektetKombinertDrivstoffCo2;
    }

    public void setNedcVektetKombinertDrivstoffCo2(
      Double nedcVektetKombinertDrivstoffCo2
    ) {
      this.nedcVektetKombinertDrivstoffCo2 = nedcVektetKombinertDrivstoffCo2;
    }

    public Double getNedcVektetKombinertDrivstoff() {
      return nedcVektetKombinertDrivstoff;
    }

    public void setNedcVektetKombinertDrivstoff(
      Double nedcVektetKombinertDrivstoff
    ) {
      this.nedcVektetKombinertDrivstoff = nedcVektetKombinertDrivstoff;
    }

    public Integer getNedcEnergiforbruk() {
      return nedcEnergiforbruk;
    }

    public void setNedcEnergiforbruk(Integer nedcEnergiforbruk) {
      this.nedcEnergiforbruk = nedcEnergiforbruk;
    }

    public Integer getNedcRekkeviddeKm() {
      return nedcRekkeviddeKm;
    }

    public void setNedcRekkeviddeKm(Integer nedcRekkeviddeKm) {
      this.nedcRekkeviddeKm = nedcRekkeviddeKm;
    }

    public Double getVeilastkoeffisientf0() {
      return veilastkoeffisientf0;
    }

    public void setVeilastkoeffisientf0(Double veilastkoeffisientf0) {
      this.veilastkoeffisientf0 = veilastkoeffisientf0;
    }

    public Double getVeilastkoeffisientf1() {
      return veilastkoeffisientf1;
    }

    public void setVeilastkoeffisientf1(Double veilastkoeffisientf1) {
      this.veilastkoeffisientf1 = veilastkoeffisientf1;
    }

    public Double getVeilastkoeffisientf2() {
      return veilastkoeffisientf2;
    }

    public void setVeilastkoeffisientf2(Double veilastkoeffisientf2) {
      this.veilastkoeffisientf2 = veilastkoeffisientf2;
    }

    public Double getTestmasse() {
      return testmasse;
    }

    public void setTestmasse(Double testmasse) {
      this.testmasse = testmasse;
    }

    public Double getFrontalareal() {
      return frontalareal;
    }

    public void setFrontalareal(Double frontalareal) {
      this.frontalareal = frontalareal;
    }
  }

  public static class Lyd {

    private Integer innvendigStoyniva;
    private Integer kjorestoy;
    private Integer standstoy;
    private Kode stoyMalingOppgittAv;
    private Integer vedAntallOmdreininger;

    // getters and setters
    public Integer getInnvendigStoyniva() {
      return innvendigStoyniva;
    }

    public void setInnvendigStoyniva(Integer innvendigStoyniva) {
      this.innvendigStoyniva = innvendigStoyniva;
    }

    public Integer getKjorestoy() {
      return kjorestoy;
    }

    public void setKjorestoy(Integer kjorestoy) {
      this.kjorestoy = kjorestoy;
    }

    public Integer getStandstoy() {
      return standstoy;
    }

    public void setStandstoy(Integer standstoy) {
      this.standstoy = standstoy;
    }

    public Kode getStoyMalingOppgittAv() {
      return stoyMalingOppgittAv;
    }

    public void setStoyMalingOppgittAv(Kode stoyMalingOppgittAv) {
      this.stoyMalingOppgittAv = stoyMalingOppgittAv;
    }

    public Integer getVedAntallOmdreininger() {
      return vedAntallOmdreininger;
    }

    public void setVedAntallOmdreininger(Integer vedAntallOmdreininger) {
      this.vedAntallOmdreininger = vedAntallOmdreininger;
    }
  }
}
