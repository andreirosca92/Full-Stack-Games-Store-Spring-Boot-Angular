package com.andreirosca.gamesstoreapi.controller;

import com.andreirosca.gamesstoreapi.model.Developer;
import com.andreirosca.gamesstoreapi.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/games")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;
    @PostMapping("/developers")
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer developer){
        Developer developer_= developerService.createDeveloper(developer);
        return new ResponseEntity<>(developer_, HttpStatus.CREATED);

    }
    @GetMapping("/developers")
    public ResponseEntity<List<Developer>>  getAllDevelopers(){
        List<Developer> developers = new ArrayList<>();
        developers = developerService.getAllDevelopers();
        if(developers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(developers, HttpStatus.OK);
    }
    @GetMapping("/developers/{id}")
    public ResponseEntity<Developer> getDeveloper(@PathVariable("id")UUID id){
        Developer developer = developerService.getDeveloper(id);

        return new ResponseEntity<>(developer, HttpStatus.OK);
    }
    @PutMapping("developers/{id}")
    public ResponseEntity<Developer> updateDeveloper(@PathVariable("id") UUID  id, @RequestBody Developer developer){
        Developer developer_ = developerService.updateDeveloper(id, developer);

        return new ResponseEntity<>(developer_, HttpStatus.OK);
    }
    @DeleteMapping("developers/{id}")
    public ResponseEntity<Developer> deleteDeveloper(@PathVariable("id") UUID id, Developer developer){
        developerService.deleteDeveloper(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
