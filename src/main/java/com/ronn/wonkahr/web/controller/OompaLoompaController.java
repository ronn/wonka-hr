package com.ronn.wonkahr.web.controller;

import com.ronn.wonkahr.oompaloompa.model.OompaLoompa;
import com.ronn.wonkahr.oompaloompa.service.OompaLoompaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/oompa-loompa")
public class OompaLoompaController {

  @Autowired
  OompaLoompaService service;

  @GetMapping
  ResponseEntity<List<OompaLoompa>> getAll(){
    List<OompaLoompa> all = service.getAll();

    return new ResponseEntity<>(all, HttpStatus.OK);
  }
}
