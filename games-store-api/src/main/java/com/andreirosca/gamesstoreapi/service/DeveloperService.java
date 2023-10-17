package com.andreirosca.gamesstoreapi.service;

import com.andreirosca.gamesstoreapi.model.Developer;
import com.andreirosca.gamesstoreapi.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeveloperService {
    @Autowired
    private DeveloperRepository repository;
    public Developer createDeveloper(Developer developer) {
        return repository.save(developer);
    }

    public List<Developer> getAllDevelopers() {
        return  repository.findAll(Sort.by("development_company"));
    }

    public Developer getDeveloper(UUID id) {
        return repository.findById(id).orElseThrow(() -> new IllegalStateException("Not found Developer with id = " + id));
    }

    public Developer updateDeveloper(UUID id, Developer developer) {
        Developer developer1 = repository.findById(id).orElseThrow(() -> new IllegalStateException("Not found Developer with id = " + id));
        developer1.setDevelopment_company(developer.getDevelopment_company());
        developer1.setGames(developer.getGames());

        return  developer1;
    }

    public void deleteDeveloper(UUID id) {
        repository.deleteById(id);
    }
}
