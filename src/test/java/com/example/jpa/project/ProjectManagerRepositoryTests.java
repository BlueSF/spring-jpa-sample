package com.example.jpa.project;

import com.example.jpa.project.ProjectManagerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProjectManagerRepositoryTests {
  @Autowired
  ProjectManagerRepository projectManagerRepository;

  @Test
  public void test_addProjectManager() {

  }
}
