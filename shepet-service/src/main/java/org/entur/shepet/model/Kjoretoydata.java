package org.entur.shepet.model;

import java.util.List;

public class Kjoretoydata {

  private KjoretoyId kjoretoyId;
  private Forstegangsregistrering forstegangsregistrering;
  private List<Kjennemerke> kjennemerke;
  private Registrering registrering;
  private Godkjenning godkjenning;
  private PeriodiskKjoretoyKontroll periodiskKjoretoyKontroll;

  // getters and setters
  public KjoretoyId getKjoretoyId() {
    return kjoretoyId;
  }

  public void setKjoretoyId(KjoretoyId kjoretoyId) {
    this.kjoretoyId = kjoretoyId;
  }

  public Forstegangsregistrering getForstegangsregistrering() {
    return forstegangsregistrering;
  }

  public void setForstegangsregistrering(
    Forstegangsregistrering forstegangsregistrering
  ) {
    this.forstegangsregistrering = forstegangsregistrering;
  }

  public List<Kjennemerke> getKjennemerke() {
    return kjennemerke;
  }

  public void setKjennemerke(List<Kjennemerke> kjennemerke) {
    this.kjennemerke = kjennemerke;
  }

  public Registrering getRegistrering() {
    return registrering;
  }

  public void setRegistrering(Registrering registrering) {
    this.registrering = registrering;
  }

  public Godkjenning getGodkjenning() {
    return godkjenning;
  }

  public void setGodkjenning(Godkjenning godkjenning) {
    this.godkjenning = godkjenning;
  }

  public PeriodiskKjoretoyKontroll getPeriodiskKjoretoyKontroll() {
    return periodiskKjoretoyKontroll;
  }

  public void setPeriodiskKjoretoyKontroll(
    PeriodiskKjoretoyKontroll periodiskKjoretoyKontroll
  ) {
    this.periodiskKjoretoyKontroll = periodiskKjoretoyKontroll;
  }
}
