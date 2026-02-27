package org.entur.shepet.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class Kjennemerke {
  private OffsetDateTime fomTidspunkt; /// 2025-10-13T08:34:00.484Z - stemmer dette?
  private String kjennemerke;
  private String kjennemerkekategori;
  private Kode kjennemerketype;
  private OffsetDateTime tilTidspunkt;
}
