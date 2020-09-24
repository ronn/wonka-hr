package com.ronn.wonkahr.web.controller;

import com.ronn.wonkahr.oompaloompa.domain.model.OompaLoompa;
import com.ronn.wonkahr.oompaloompa.domain.service.OompaLoompaService;
import com.ronn.wonkahr.oompaloompa.domain.service.impl.OompaLoompaServiceImpl;
import com.ronn.wonkahr.web.model.OompaLoompaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/oompa-loompa")
public class OompaLoompaController {

  private final OompaLoompaService service;

  public OompaLoompaController(OompaLoompaServiceImpl service) {
    this.service = service;
  }

  @GetMapping
  ResponseEntity<List<OompaLoompaDto>> getAll() {
    List<OompaLoompaDto> all = service.getAll()
        .stream()
        .map(OompaLoompaDto::fromEntity)
        .collect(toList());

    return ResponseEntity.ok(all);
  }

  @GetMapping("/{name}")
  ResponseEntity<OompaLoompa> getOneBy(@PathVariable String name) {
    Optional<OompaLoompa> oompaLoompa = service.getBy(name);

    return ResponseEntity.of(oompaLoompa);
  }

  @PostMapping
  ResponseEntity<Object> save(@RequestBody OompaLoompa oompaLoompa) {
    return service.save(oompaLoompa)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.status(HttpStatus.CONFLICT)
            .body("Oompa Loompa " + oompaLoompa.getName() + " already exists.")
        );
  }

  @PutMapping
  ResponseEntity<Object> update(@RequestBody OompaLoompa oompaLoompa) {
    return service.update(oompaLoompa)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Oompa Loompa " + oompaLoompa.getName() + " does not exists.")
        );
  }
}
