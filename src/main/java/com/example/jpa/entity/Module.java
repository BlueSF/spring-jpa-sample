package com.example.jpa.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Module extends BaseEntity {
  @Column(unique = true)
  private String name;
}
