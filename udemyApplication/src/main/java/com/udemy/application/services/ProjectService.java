package com.udemy.application.services;

import com.udemy.application.domain.Project;
import com.udemy.application.exceptions.ProjectIdException;
import com.udemy.application.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {

       try{
           project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
           return projectRepository.save(project);
       }catch(Exception e){
           throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists!");

       }


    }

    public Project findProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null){
           throw new ProjectIdException("Project ID "+ projectId + "does not exist! " );
        }

        return project ;
    }

    public Iterable <Project> findAllProjects () {
        if(projectRepository.findAll().toString() == "[]") {

            throw new ProjectIdException("No Project ID's found, did you even save your first project, you fool?");
        }

        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectid){
        Project project = projectRepository.findByProjectIdentifier(projectid.toUpperCase());
        if (project == null) {

            throw new ProjectIdException("Project ID ' " + projectid + "' was not found, so nothing deleted.");
        }

        projectRepository.delete(project) ;

    }



}
