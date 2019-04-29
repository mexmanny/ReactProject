package com.udemy.application.repositories;

import com.udemy.application.domain.Project;
import org.springframework.data.repository.CrudRepository;



public interface ProjectRepository extends CrudRepository <Project, Long> {
    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);
}
