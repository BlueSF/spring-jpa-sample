package com.example.jpa.project;

import com.example.jpa.project.ProjectManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectManagerRepository extends JpaRepository<ProjectManager, Integer> {
}
