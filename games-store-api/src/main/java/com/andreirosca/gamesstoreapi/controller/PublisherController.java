package com.andreirosca.gamesstoreapi.controller;



import com.andreirosca.gamesstoreapi.model.Game;
import com.andreirosca.gamesstoreapi.model.Genre;
import com.andreirosca.gamesstoreapi.model.Publisher;
import com.andreirosca.gamesstoreapi.service.PublisherService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/games/")
public class PublisherController {
    @Autowired
    private static RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private PublisherService service;


    @PostMapping(path="/publisher", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) {


        Publisher _publisher = service.createPublisher(publisher);
        return new ResponseEntity<>(_publisher, HttpStatus.CREATED);
    }


    private ResponseEntity<List<Publisher>> getAllPublisher(){

        List<Publisher> res = new ArrayList<>();

        res = service.getAllPublisher();



        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @GetMapping("/publisher/{id}")
    public ResponseEntity<?> getPublisherById( @PathVariable("id") UUID id){
        Publisher publisher_ = service.getPublisher(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity entity = new HttpEntity<>(null,headers);

        ResponseEntity<List<Game>> result = restTemplate.exchange("http://localhost:8080/api/games",HttpMethod.GET, entity, new ParameterizedTypeReference<List<Game>>() {
        });

        List<Game> games = result.getBody();



        Game games_ = games.stream().filter(game->game.getPublisher().getId().equals(publisher_.getId())).findAny().orElse(null);
        Set<Game> games1 = new HashSet<>();
        games1.add(games_);
        publisher_.setGame(games1);


    System.out.println(publisher_.toString());






        return new ResponseEntity<>(publisher_,HttpStatus.OK);
    }
    @GetMapping("/publisher")
    public ResponseEntity<List<Publisher>> getPublisherAndGameByName(@RequestParam(required = false) String name){
        List<Publisher> res = new ArrayList<>();
        if(name==null){
           return getAllPublisher();
        }else{
            res = service.getPublisherandGameByName(name);
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            HttpEntity entity = new HttpEntity<>(null,headers);

            ResponseEntity<List<Game>> result = restTemplate.exchange("http://localhost:8080/api/games",HttpMethod.GET, entity, new ParameterizedTypeReference<List<Game>>() {
            });

            List<Game> games = result.getBody();

            Set<Game> games1 = new HashSet<>();

            for (Publisher publisher:res) {
                Game games_ = games.stream().filter(game -> game.getPublisher().getName().equals(publisher.getName())).findFirst().orElse(null);

                games1.add(games_);
                publisher.setGame(games1);
            }

            if(res.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(res, HttpStatus.OK);
        }





    }



    @DeleteMapping("/publisher/{id}")
    public ResponseEntity<Game> deletePublisher(@PathVariable("id") UUID id) {

        service.deletePublisher(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

//    @PostMapping("/{gameId}/publisher/{id}")
//    public ResponseEntity<Game> getPublisher(@PathVariable("gameId") UUID gameId,@PathVariable("id") UUID id){
//        String url ="http://localhost:8080/api/games";
//
//        ResponseEntity<Game> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null, Game.class, gameId);
//        Game game = responseEntity.getBody();
//
//        Publisher publisher =service.getPublisher(id);
//
//
//    }
}
