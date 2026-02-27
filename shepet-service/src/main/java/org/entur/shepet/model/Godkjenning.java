package org.entur.shepet.model;

import java.util.List;

public class Godkjenning {

  private ForstegangsGodkjenning forstegangsGodkjenning;
  private List<Kjoretoymerknad> kjoretoymerknad;
  private Registreringsbegrensninger registreringsbegrensninger;
  private TekniskGodkjenning tekniskGodkjenning;
  private List<Tilleggsgodkjenning> tilleggsgodkjenninger;

  public ForstegangsGodkjenning getForstegangsGodkjenning() {
    return forstegangsGodkjenning;
  }

  public void setForstegangsGodkjenning(
    ForstegangsGodkjenning forstegangsGodkjenning
  ) {
    this.forstegangsGodkjenning = forstegangsGodkjenning;
  }

  public List<Kjoretoymerknad> getKjoretoymerknad() {
    return kjoretoymerknad;
  }

  public void setKjoretoymerknad(List<Kjoretoymerknad> kjoretoymerknad) {
    this.kjoretoymerknad = kjoretoymerknad;
  }

  public Registreringsbegrensninger getRegistreringsbegrensninger() {
    return registreringsbegrensninger;
  }

  public void setRegistreringsbegrensninger(
    Registreringsbegrensninger registreringsbegrensninger
  ) {
    this.registreringsbegrensninger = registreringsbegrensninger;
  }

  public TekniskGodkjenning getTekniskGodkjenning() {
    return tekniskGodkjenning;
  }

  public void setTekniskGodkjenning(TekniskGodkjenning tekniskGodkjenning) {
    this.tekniskGodkjenning = tekniskGodkjenning;
  }

  public List<Tilleggsgodkjenning> getTilleggsgodkjenninger() {
    return tilleggsgodkjenninger;
  }

  public void setTilleggsgodkjenninger(
    List<Tilleggsgodkjenning> tilleggsgodkjenninger
  ) {
    this.tilleggsgodkjenninger = tilleggsgodkjenninger;
  }
}
// Add other nested classes as needed, e.g. ForstegangsGodkjenning, TekniskGodkjenning, etc.
