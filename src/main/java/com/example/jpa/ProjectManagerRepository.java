package com.example.jpa;

import com.example.jpa.entity.ProjectManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectManagerRepository extends JpaRepository<ProjectManager, Integer> {
}
