package org.entur.shepet.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Kode {
  private String kodeBeskrivelse;
  private String kodeNavn;
  private String kodeTypeId;
  private String kodeVerdi;
  private List<String> tidligereKodeVerdi;
}
