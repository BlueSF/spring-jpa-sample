package com.example.jpa;

import com.example.jpa.module.Module;
import com.example.jpa.module.ModuleRepository;
import com.example.jpa.project.Project;
import com.example.jpa.project.ProjectModule;
import com.example.jpa.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import java.util.*;
import java.util.stream.IntStream;

@DataJpaTest
public class JpaUnitTest {
  @Autowired
  ProjectRepository projectRepository;
  @Autowired
  ModuleRepository moduleRepository;

  protected Map<Integer, Module> addDummyModule() {
    Map<Integer, Module> result = new HashMap<>();
    IntStream.range(1, 10).forEach(i -> {
      Module module = new Module();
      module.setName("module" + i);
      Module save = moduleRepository.save(module);
      result.put(save.getId(), save);
    });

    return result;
  }

  protected Project addDummyProject() {
    List<Module> moduleList = moduleRepository.findAll(PageRequest.of(0, 3)).getContent();

    Project project = Project.builder().name("test").build();
    Set<ProjectModule> projectModuleSet = new HashSet<>();
    for (Module module : moduleList) {
      ProjectModule e = new ProjectModule();
      e.setModule(module);
      projectModuleSet.add(e);
    }
    project.setProjectModuleSet(projectModuleSet);
    return projectRepository.save(project);
  }
}
