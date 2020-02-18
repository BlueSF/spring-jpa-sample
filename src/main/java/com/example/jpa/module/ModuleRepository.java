package com.example.jpa.module;

import com.example.jpa.module.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Integer> {

}
