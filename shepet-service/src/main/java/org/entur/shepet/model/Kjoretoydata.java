package org.entur.shepet.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Kjoretoydata {
  private KjoretoyId kjoretoyId;
  private Forstegangsregistrering forstegangsregistrering;
  private List<Kjennemerke> kjennemerke;
  private Registrering registrering;
  private Godkjenning godkjenning;
  private PeriodiskKjoretoyKontroll periodiskKjoretoyKontroll;
}
