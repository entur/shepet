package org.entur.shepet.model;

import java.util.List;

public class GetKjoretoyResponse {

  private String feilmelding;
  private List<Kjoretoydata> kjoretoydataListe;

  // getters and setters
  public String getFeilmelding() {
    return feilmelding;
  }

  public void setFeilmelding(String feilmelding) {
    this.feilmelding = feilmelding;
  }

  public List<Kjoretoydata> getKjoretoydataListe() {
    return kjoretoydataListe;
  }

  public void setKjoretoydataListe(List<Kjoretoydata> kjoretoydataListe) {
    this.kjoretoydataListe = kjoretoydataListe;
  }
}
