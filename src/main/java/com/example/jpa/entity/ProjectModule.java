package com.example.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"project_id", "module_id"}))
public class ProjectModule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PROJECT_ID", foreignKey = @ForeignKey(name = "FK_PROJECT_MODULE_PROJECT_ID"))
  private Project project;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MODULE_ID", foreignKey = @ForeignKey(name = "FK_PROJECT_MODULE_MODULE_ID"))
  private Module module;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ProjectModule)) return false;
    ProjectModule that = (ProjectModule) o;
    return getProject().getId().equals(that.getProject().getId())
        && getModule().getId().equals(that.getModule().getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getProject().getId(), getModule().getId());
  }
}
