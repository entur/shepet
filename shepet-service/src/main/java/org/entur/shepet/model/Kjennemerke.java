package org.entur.shepet.model;

import java.time.OffsetDateTime;

public class Kjennemerke {

  private OffsetDateTime fomTidspunkt; /// 2025-10-13T08:34:00.484Z - stemmer dette?
  private String kjennemerke;
  private String kjennemerkekategori;
  private Kode kjennemerketype;
  private OffsetDateTime tilTidspunkt;

  // getters and setters
  public OffsetDateTime getFomTidspunkt() {
    return fomTidspunkt;
  }

  public void setFomTidspunkt(OffsetDateTime fomTidspunkt) {
    this.fomTidspunkt = fomTidspunkt;
  }

  public String getKjennemerke() {
    return kjennemerke;
  }

  public void setKjennemerke(String kjennemerke) {
    this.kjennemerke = kjennemerke;
  }

  public String getKjennemerkekategori() {
    return kjennemerkekategori;
  }

  public void setKjennemerkekategori(String kjennemerkekategori) {
    this.kjennemerkekategori = kjennemerkekategori;
  }

  public Kode getKjennemerketype() {
    return kjennemerketype;
  }

  public void setKjennemerketype(Kode kjennemerketype) {
    this.kjennemerketype = kjennemerketype;
  }

  public OffsetDateTime getTilTidspunkt() {
    return tilTidspunkt;
  }

  public void setTilTidspunkt(OffsetDateTime tilTidspunkt) {
    this.tilTidspunkt = tilTidspunkt;
  }
}
