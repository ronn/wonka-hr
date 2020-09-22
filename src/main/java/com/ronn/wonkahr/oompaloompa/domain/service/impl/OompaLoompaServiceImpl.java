package com.ronn.wonkahr.oompaloompa.service;

import com.ronn.wonkahr.oompaloompa.model.OompaLoompa;
import com.ronn.wonkahr.oompaloompa.repository.OompaLoompaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OompaLoompaServiceImpl {

  private final OompaLoompaRepository repo;

  public OompaLoompaServiceImpl(OompaLoompaRepository repo) {
    this.repo = repo;
  }

  public List<OompaLoompa> getAll(){
    return repo.findAll();
  }

  public Optional<Object> save(OompaLoompa oompaLoompa){
    return getBy(oompaLoompa.getName())
        .map(ol -> Optional.empty())
        .orElse(Optional.of(repo.save(oompaLoompa)));
  }

  public Optional<OompaLoompa> getBy(String name){
    return repo.findOompaLoompaByName(name);
  }

  public Optional<Object> update(OompaLoompa oompaLoompa){
    return getBy(oompaLoompa.getName())
        .map(x -> repo.save(oompaLoompa));
  }
}
