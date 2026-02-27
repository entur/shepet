package org.entur.shepet.model;

import java.time.LocalDate;

public class PeriodiskKjoretoyKontroll {

  private LocalDate kontrollfrist;
  private LocalDate sistGodkjent;

  // getters and setters
  public LocalDate getKontrollfrist() {
    return kontrollfrist;
  }

  public void setKontrollfrist(LocalDate kontrollfrist) {
    this.kontrollfrist = kontrollfrist;
  }

  public LocalDate getSistGodkjent() {
    return sistGodkjent;
  }

  public void setSistGodkjent(LocalDate sistGodkjent) {
    this.sistGodkjent = sistGodkjent;
  }
}
