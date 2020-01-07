package com.example.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Module {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(unique = true)
  private String name;
}
