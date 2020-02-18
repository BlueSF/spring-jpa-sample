package com.example.jpa.project;

import com.example.jpa.project.ProjectModule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectModuleRepository extends JpaRepository<ProjectModule, Integer> {
  List<ProjectModule> findAllByProjectId(Integer projectId);
}
