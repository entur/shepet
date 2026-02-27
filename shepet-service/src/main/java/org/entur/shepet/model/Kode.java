package org.entur.shepet.model;

import java.util.List;

public class Kode {

  private String kodeBeskrivelse;
  private String kodeNavn;
  private String kodeTypeId;
  private String kodeVerdi;
  private List<String> tidligereKodeVerdi;

  // getters and setters
  public String getKodeBeskrivelse() {
    return kodeBeskrivelse;
  }

  public void setKodeBeskrivelse(String kodeBeskrivelse) {
    this.kodeBeskrivelse = kodeBeskrivelse;
  }

  public String getKodeNavn() {
    return kodeNavn;
  }

  public void setKodeNavn(String kodeNavn) {
    this.kodeNavn = kodeNavn;
  }

  public String getKodeTypeId() {
    return kodeTypeId;
  }

  public void setKodeTypeId(String kodeTypeId) {
    this.kodeTypeId = kodeTypeId;
  }

  public String getKodeVerdi() {
    return kodeVerdi;
  }

  public void setKodeVerdi(String kodeVerdi) {
    this.kodeVerdi = kodeVerdi;
  }

  public List<String> getTidligereKodeVerdi() {
    return tidligereKodeVerdi;
  }

  public void setTidligereKodeVerdi(List<String> tidligereKodeVerdi) {
    this.tidligereKodeVerdi = tidligereKodeVerdi;
  }
}
