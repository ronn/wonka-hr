package com.ronn.wonkahr.oompaloompa.repository;

import com.ronn.wonkahr.oompaloompa.domain.model.OompaLoompa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OompaLoompaRepository extends JpaRepository<OompaLoompa, String> {

  Optional<OompaLoompa> findOompaLoompaByName(String name);
}
