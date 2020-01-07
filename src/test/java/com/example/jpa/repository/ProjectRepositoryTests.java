package com.example.jpa.repository;

import com.example.jpa.JpaUnitTest;
import com.example.jpa.ModuleRepository;
import com.example.jpa.ProjectModuleRepository;
import com.example.jpa.ProjectRepository;
import com.example.jpa.entity.Module;
import com.example.jpa.entity.Project;
import com.example.jpa.entity.ProjectModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProjectRepositoryTests extends JpaUnitTest {

  @Autowired
  ProjectRepository projectRepository;
  @Autowired
  ModuleRepository moduleRepository;
  @Autowired
  ProjectModuleRepository projectModuleRepository;

  @Test
  @Sql(scripts = {"classpath:test.sql"})
  public void test_addModule() {
    List<Module> moduleList = moduleRepository.findAll();

    Project project = new Project();
    project.setName("junit");

    for (Module module : moduleList) {
      ProjectModule e = new ProjectModule();
      e.setModule(module);
      project.addProjectModuleSet(e);
    }

    Project saved = projectRepository.save(project);

    Optional<Project> byId = projectRepository.findById(saved.getId());

    Assertions.assertTrue(byId.isPresent());
    Assertions.assertEquals(byId.get().getProjectModuleSet().size(), 9);
    for (ProjectModule e : byId.get().getProjectModuleSet()) {
      Assertions.assertNotNull(e.getProject());
    }
  }

  @Test
  @Sql(scripts = {"classpath:test.sql"})
  public void test_modifyGoods() {
    List<Module> moduleList = moduleRepository.findAll();

    Project project = new Project();
    project.setName("test");
    Set<ProjectModule> projectModuleSet = new HashSet<>();
    Optional<Project> one = projectRepository.findById(1);
    Assertions.assertTrue(one.isPresent());
    for (Module module : moduleList) {
      ProjectModule e = new ProjectModule();
      e.setProject(one.get());
      e.setModule(module);
      projectModuleSet.add(e);
    }
    one.get().setProjectModuleSet(projectModuleSet);
    projectRepository.save(one.get());

    Optional<Project> byId = projectRepository.findById(one.get().getId());

    Assertions.assertTrue(byId.isPresent());
    Assertions.assertEquals(byId.get().getProjectModuleSet().size(), 9);
  }

  @Test
  @Sql(scripts = {"classpath:test.sql"})
  public void test_modifyGoodsCategory() {
    Optional<Project> byId = projectRepository.findById(1);
    Assertions.assertTrue(byId.isPresent());
    Project byIdProject = byId.get();
    Set<ProjectModule> projectModuleSet = byIdProject.getProjectModuleSet();
    List<Module> updateModuleList = moduleRepository.findAll();
    for (Module module : updateModuleList) {
      ProjectModule e = new ProjectModule();
      e.setProject(byIdProject);
      e.setModule(module);
      projectModuleSet.add(e);
    }

    Project update = projectRepository.save(byIdProject);

    Optional<Project> updatedById = projectRepository.findById(update.getId());

    Assertions.assertTrue(updatedById.isPresent());
    Project find1Project = updatedById.get();
    Set<ProjectModule> projectModuleSet1 = find1Project.getProjectModuleSet();
    int size = projectModuleSet1.size();
    Assertions.assertEquals(9, size);
    for (ProjectModule projectModule : projectModuleSet1) {
      Assertions.assertNotNull(projectModule.getProject());
    }
  }

  @Test
  @Sql(scripts = {"classpath:test.sql"})
  public void test_findProject() {
    Optional<Project> byId = projectRepository.findById(1);
    Assertions.assertTrue(byId.isPresent());
    Project byIdProject = byId.get();
    Assertions.assertEquals(3, byIdProject.getProjectModuleSet().size());
  }
}
