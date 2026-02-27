package org.entur.shepet.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class Registrering {
  private OffsetDateTime fomTidspunkt;
  private Kode kjoringensArt;
  private String neringskode;
  private String neringskodeBeskrivelse;
  private Kode registreringsstatus;
  private OffsetDateTime registrertForstegangPaEierskap;
  private OffsetDateTime tilTidspunkt;
  private VektarsavgiftOppgittGrunnlag vektarsavgiftOppgittGrunnlag;
  private OffsetDateTime avregistrertSidenDato;
}

@Getter
@Setter
class VektarsavgiftOppgittGrunnlag {
    private Integer antallAkslerTilhenger;
  private Integer totalvektTilhenger;
}
