package com.udemy.application.services;

import com.udemy.application.domain.Project;
import com.udemy.application.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {

        //Logic


        return projectRepository.save(project);
    }

}
