package org.entur.shepet.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
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

  @Getter
  @Setter
  public static class Bruktimport {
    private Land importland;
    private Integer kilometerstand;
    private String tidligereUtenlandskKjennemerke;
    private String tidligereUtenlandskVognkortNummer;
  }

  @Getter
  @Setter
  public static class Land {
    private String landNavn;
    private String landkode;
  }

  @Getter
  @Setter
  public static class FortollingOgMva {
    private String annenReferanse;
    private String beskrivelse;
    private String dokumentreferanse;
    private String fortollingsreferanse;
    private Integer linje;
  }

  @Getter
  @Setter
  public static class OppbygdMedAvgiftsfritak {
    private List<String> arkivreferanse;
    private List<Kjoretoy> delekjoretoy;
    private Kjoretoy erstattetKjoretoy;
  }

  @Getter
  @Setter
  public static class Kjoretoy {
    private String kuid;
    private UnderstellsbasertId understellsbasertId;
  }

  @Getter
  @Setter
  public static class UnderstellsbasertId {
    private String merkekode;
    private String understellsnummer;
  }

  @Getter
  @Setter
  public static class UnntakWrapper {
    private Kode unntak;
  }
}
