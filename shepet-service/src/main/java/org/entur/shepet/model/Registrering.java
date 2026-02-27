package org.entur.shepet.model;

import java.time.OffsetDateTime;

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

  public OffsetDateTime getFomTidspunkt() {
    return fomTidspunkt;
  }

  public void setFomTidspunkt(OffsetDateTime fomTidspunkt) {
    this.fomTidspunkt = fomTidspunkt;
  }

  public Kode getKjoringensArt() {
    return kjoringensArt;
  }

  public void setKjoringensArt(Kode kjoringensArt) {
    this.kjoringensArt = kjoringensArt;
  }

  public String getNeringskode() {
    return neringskode;
  }

  public void setNeringskode(String neringskode) {
    this.neringskode = neringskode;
  }

  public String getNeringskodeBeskrivelse() {
    return neringskodeBeskrivelse;
  }

  public void setNeringskodeBeskrivelse(String neringskodeBeskrivelse) {
    this.neringskodeBeskrivelse = neringskodeBeskrivelse;
  }

  public Kode getRegistreringsstatus() {
    return registreringsstatus;
  }

  public void setRegistreringsstatus(Kode registreringsstatus) {
    this.registreringsstatus = registreringsstatus;
  }

  public OffsetDateTime getRegistrertForstegangPaEierskap() {
    return registrertForstegangPaEierskap;
  }

  public void setRegistrertForstegangPaEierskap(
    OffsetDateTime registrertForstegangPaEierskap
  ) {
    this.registrertForstegangPaEierskap = registrertForstegangPaEierskap;
  }

  public OffsetDateTime getTilTidspunkt() {
    return tilTidspunkt;
  }

  public void setTilTidspunkt(OffsetDateTime tilTidspunkt) {
    this.tilTidspunkt = tilTidspunkt;
  }

  public VektarsavgiftOppgittGrunnlag getVektarsavgiftOppgittGrunnlag() {
    return vektarsavgiftOppgittGrunnlag;
  }

  public void setVektarsavgiftOppgittGrunnlag(
    VektarsavgiftOppgittGrunnlag vektarsavgiftOppgittGrunnlag
  ) {
    this.vektarsavgiftOppgittGrunnlag = vektarsavgiftOppgittGrunnlag;
  }

  public OffsetDateTime getAvregistrertSidenDato() {
    return avregistrertSidenDato;
  }

  public void setAvregistrertSidenDato(OffsetDateTime avregistrertSidenDato) {
    this.avregistrertSidenDato = avregistrertSidenDato;
  }
}

class VektarsavgiftOppgittGrunnlag {

  private Integer antallAkslerTilhenger;
  private Integer totalvektTilhenger;

  public Integer getAntallAkslerTilhenger() {
    return antallAkslerTilhenger;
  }

  public void setAntallAkslerTilhenger(Integer antallAkslerTilhenger) {
    this.antallAkslerTilhenger = antallAkslerTilhenger;
  }

  public Integer getTotalvektTilhenger() {
    return totalvektTilhenger;
  }

  public void setTotalvektTilhenger(Integer totalvektTilhenger) {
    this.totalvektTilhenger = totalvektTilhenger;
  }
}
