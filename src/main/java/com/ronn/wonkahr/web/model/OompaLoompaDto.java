package com.ronn.wonkahr.web.model;

import com.ronn.wonkahr.oompaloompa.domain.model.OompaLoompa;

public class OompaLoompaDto {

  private final String name;
  private final Integer age;
  private final String job;

  public static OompaLoompaDto fromEntity(OompaLoompa oompaLoompa) {
    return new OompaLoompaDto(oompaLoompa.getName(), oompaLoompa.getAge(), oompaLoompa.getJob());
  }

  private OompaLoompaDto(String name, Integer age, String job) {
    this.name = name;
    this.age = age;
    this.job = job;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public String getJob() {
    return job;
  }
}
