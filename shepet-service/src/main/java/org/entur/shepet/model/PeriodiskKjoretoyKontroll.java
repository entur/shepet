package org.entur.shepet.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PeriodiskKjoretoyKontroll {
    private LocalDate kontrollfrist;
  private LocalDate sistGodkjent;
}
