package com.example.jpa.project;

import com.example.jpa.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Project extends BaseEntity {
  @Column(unique = true)
  private String name;
  @OneToMany(mappedBy = "project", targetEntity = ProjectModule.class,
      cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  private Set<ProjectModule> projectModuleSet;

  public Project() {
    this.projectModuleSet = new HashSet<>();
  }

  public void addProjectModuleSet(ProjectModule projectModule) {
    if (this.projectModuleSet == null) {
      this.projectModuleSet = new HashSet<>();
    }
    projectModule.setProject(this);
    this.projectModuleSet.add(projectModule);
  }

  public void removeProjectModuleSet(ProjectModule projectModule) {
    this.projectModuleSet.remove(projectModule);
    projectModule.setProject(null);
  }

  public void setProjectModuleSet(Set<ProjectModule> projectModuleSet) {
    if (this.projectModuleSet == null) {
      this.projectModuleSet = new HashSet<>();
    }
    for (ProjectModule projectModule : projectModuleSet) {
      projectModule.setProject(this);
    }
    this.projectModuleSet.addAll(projectModuleSet);
  }
}
