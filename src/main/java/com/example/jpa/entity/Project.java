package com.example.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(unique = true)
  private String name;
  @OneToMany(mappedBy = "project", targetEntity = ProjectModule.class,
      cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  private Set<ProjectModule> projectModuleSet = new HashSet<>();

  public void addProjectModuleSet(ProjectModule projectModule) {
    this.projectModuleSet.add(projectModule);
    projectModule.setProject(this);
  }

  public void removeProjectModuleSet(ProjectModule projectModule) {
    this.projectModuleSet.remove(projectModule);
    projectModule.setProject(null);
  }

  public void setProjectModuleSet(Set<ProjectModule> projectModuleSet) {
    for (ProjectModule projectModule : projectModuleSet) {
      projectModule.setProject(this);
    }
    this.projectModuleSet.addAll(projectModuleSet);
  }
}