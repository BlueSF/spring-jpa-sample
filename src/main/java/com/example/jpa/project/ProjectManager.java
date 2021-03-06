package com.example.jpa.project;

import com.example.jpa.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectManager extends BaseEntity {
  @Column(unique = true)
  private String name;

  @OneToOne
  @JoinColumn(name = "PROJECT_ID", foreignKey = @ForeignKey(name = "FK_PROJECT_MANAGER_PROJECT_ID"))
  private Project project;
}
