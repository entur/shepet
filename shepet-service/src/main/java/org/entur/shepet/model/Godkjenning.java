package org.entur.shepet.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Godkjenning {

  private ForstegangsGodkjenning forstegangsGodkjenning;
  private List<Kjoretoymerknad> kjoretoymerknad;
  private Registreringsbegrensninger registreringsbegrensninger;
  private TekniskGodkjenning tekniskGodkjenning;
  private List<Tilleggsgodkjenning> tilleggsgodkjenninger;
}
