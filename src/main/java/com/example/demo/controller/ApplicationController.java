package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Application;
import com.example.demo.repository.ApplicationRepository;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    // get application by id
    @GetMapping("/application/{id}")
    public Application getApplication(@PathVariable Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    // get all applications
    @GetMapping("/applications")
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // add application
    @GetMapping("/application/add/{name}")
    public Application addApplication(@PathVariable String name) {
        Application application = new Application();
        application.setName(name);
        return applicationRepository.save(application);
    }

    // update application
    @GetMapping("/application/update/{id}/{name}")
    public Application updateApplication(@PathVariable Long id, @PathVariable String name) {
        Application application = applicationRepository.findById(id).orElse(null);
        if (application != null) {
            application.setName(name);
            return applicationRepository.save(application);
        }
        return null;
    }

    // delete application
    @GetMapping("/application/delete/{id}")
    public void deleteApplication(@PathVariable Long id) {
        applicationRepository.deleteById(id);
    }
}

