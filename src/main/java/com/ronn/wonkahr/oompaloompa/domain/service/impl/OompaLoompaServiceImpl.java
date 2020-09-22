package com.ronn.wonkahr.oompaloompa.domain.service.impl;

import com.ronn.wonkahr.oompaloompa.domain.model.OompaLoompa;
import com.ronn.wonkahr.oompaloompa.repository.OompaLoompaRepository;
import com.ronn.wonkahr.oompaloompa.domain.service.OompaLoompaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OompaLoompaServiceImpl implements OompaLoompaService {

  private final OompaLoompaRepository repo;

  public OompaLoompaServiceImpl(OompaLoompaRepository repo) {
    this.repo = repo;
  }

  public List<OompaLoompa> getAll() {
    return repo.findAll();
  }

  public Optional<Object> save(OompaLoompa oompaLoompa) {
    return getBy(oompaLoompa.getName())
        .map(ol -> Optional.empty())
        .orElse(Optional.of(repo.save(oompaLoompa)));
  }

  public Optional<OompaLoompa> getBy(String name) {
    return repo.findOompaLoompaByName(name);
  }

  public Optional<Object> update(OompaLoompa oompaLoompa) {
    return getBy(oompaLoompa.getName())
        .map(x -> repo.save(oompaLoompa));
  }
}
