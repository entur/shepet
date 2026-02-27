package org.entur.shepet.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetKjoretoyResponse {
  private String feilmelding;
  private List<Kjoretoydata> kjoretoydataListe;
}
