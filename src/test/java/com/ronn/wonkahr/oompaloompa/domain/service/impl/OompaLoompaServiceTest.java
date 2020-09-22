package com.ronn.wonkahr.oompaloompa.domain.service.impl;

import com.ronn.wonkahr.oompaloompa.domain.model.OompaLoompa;
import com.ronn.wonkahr.oompaloompa.repository.OompaLoompaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class OompaLoompaServiceTest {

  private final OompaLoompaRepository repository = Mockito.mock(OompaLoompaRepository.class);
  private final OompaLoompaServiceImpl oompaLoompaService = new OompaLoompaServiceImpl(repository);

  @BeforeEach
  public void setUp(){
  }

  @Test
  void when_no_OLs_stored_getAll_should_return_empty_list() {
    List<OompaLoompa> all = oompaLoompaService.getAll();
    assertTrue(all.isEmpty());
  }

  @Test
  void when_OLs_stored_getAll_should_return_list_with_correct_size() {
    when(repository.findAll()).thenReturn(Arrays.asList(new OompaLoompa(), new OompaLoompa()));
    List<OompaLoompa> all = oompaLoompaService.getAll();

    assertEquals(2, all.size());
  }

  @Test
  void when_saving_new_OL_it_should_be_returned() {
    when(repository.findOompaLoompaByName(any())).thenReturn(Optional.empty());
    when(repository.save(any())).thenReturn(new OompaLoompa("Ronn"));

    Optional<Object> saved = oompaLoompaService.save(new OompaLoompa("Ronn"));
    assertTrue(saved.isPresent());
  }

  @Test
  void when_saving_an_already_existing_OL_result_should_be_empty() {
    when(repository.findOompaLoompaByName(any())).thenReturn(Optional.of(new OompaLoompa("Ronn")));
    when(repository.save(any())).thenReturn(new OompaLoompa("Ronn"));

    Optional<Object> saved = oompaLoompaService.save(new OompaLoompa("Ronn"));
    assertFalse(saved.isPresent());
  }

  @Test
  void when_searching_a_non_existing_OL_no_result_should_be_empty() {
    Optional<OompaLoompa> noName = oompaLoompaService.getBy("NoName");

    assertFalse(noName.isPresent());
  }

  @Test
  void when_searching_an_existing_OL_no_result_should_be_present() {
    when(repository.findOompaLoompaByName(any())).thenReturn(Optional.of(new OompaLoompa("Name")));
    Optional<OompaLoompa> noName = oompaLoompaService.getBy("Name");

    assertTrue(noName.isPresent());
  }

  @Test
  void when_updating_a_non_existing_user_result_should_be_empty() {
    when(repository.findOompaLoompaByName(any())).thenReturn(Optional.empty());

    Optional<Object> saved = oompaLoompaService.update(new OompaLoompa("Ronn"));
    assertFalse(saved.isPresent());
  }

  @Test
  void when_updating_an_existing_user_result_should_be_present() {
    when(repository.findOompaLoompaByName(any())).thenReturn(Optional.of(new OompaLoompa("Ronn")));
    when(repository.save(any())).thenReturn(new OompaLoompa("Ronn"));

    Optional<Object> saved = oompaLoompaService.update(new OompaLoompa("Ronn"));
    assertTrue(saved.isPresent());
  }
}
