package com.ronn.wonkahr.oompaloompa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OompaLoompa {

  @Id
  private String name;
  private Integer age;
  private String job;
  private Double height;
  private Double weight;
  private String description;

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public String getJob() {
    return job;
  }

  public Double getHeight() {
    return height;
  }

  public Double getWeight() {
    return weight;
  }

  public String getDescription() {
    return description;
  }
}
