package org.entur.shepet.model;

import java.time.LocalDate;

public class Forstegangsregistrering {

  private LocalDate registrertForstegangNorgeDato;

  // getters and setters
  public LocalDate getRegistrertForstegangNorgeDato() {
    return registrertForstegangNorgeDato;
  }

  public void setRegistrertForstegangNorgeDato(
    LocalDate registrertForstegangNorgeDato
  ) {
    this.registrertForstegangNorgeDato = registrertForstegangNorgeDato;
  }
}
