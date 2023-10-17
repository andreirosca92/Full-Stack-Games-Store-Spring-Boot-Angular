package com.andreirosca.gamesstoreapi.service;


import com.andreirosca.gamesstoreapi.model.Game;
import com.andreirosca.gamesstoreapi.model.Publisher;
import com.andreirosca.gamesstoreapi.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PublisherService {

    @Autowired
    PublisherRepository repository;


    public Publisher createPublisher(Publisher publisher) {
        return repository.save(publisher);
    }

    public List<Publisher> getAllPublisher() {
        return repository.findAll(Sort.by("name"));
    }

    public void deletePublisher(UUID id) {
         repository.deleteById(id);
    }

    public Publisher getPublisher(UUID id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException());
    }
    public List<Publisher> getPublisherandGameByName(String name) {
        return repository.getPublisherandGameByName(name);
    }
}
