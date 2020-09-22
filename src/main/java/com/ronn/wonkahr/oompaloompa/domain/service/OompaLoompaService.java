package com.ronn.wonkahr.oompaloompa.domain.service;

import com.ronn.wonkahr.oompaloompa.domain.model.OompaLoompa;

import java.util.List;
import java.util.Optional;

public interface OompaLoompaService {

  List<OompaLoompa> getAll();

  Optional<Object> save(OompaLoompa oompaLoompa);

  Optional<OompaLoompa> getBy(String name);

  Optional<Object> update(OompaLoompa oompaLoompa);
}
