package com.ronn.wonkahr.oompaloompa.service;

import com.ronn.wonkahr.oompaloompa.model.OompaLoompa;
import com.ronn.wonkahr.oompaloompa.repository.OompaLoompaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OompaLoompaService {

  @Autowired
  OompaLoompaRepository repo;

  public List<OompaLoompa> getAll(){
    return repo.findAll();
  }
}
