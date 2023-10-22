package com.andreirosca.gamesstoreapi.controller;



import com.andreirosca.gamesstoreapi.helpers.*;
import com.andreirosca.gamesstoreapi.model.*;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.SessionFactory;
import com.andreirosca.gamesstoreapi.service.GameService;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class GameController {


    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private GameService service;

    @GetMapping("/games")
    public ResponseEntity<List<Game>> getAllGames(@RequestParam(required = false) String name, @RequestParam(required = false) String genre, @RequestParam(required = false) String platform, @RequestParam(required = false) String condition, @RequestParam(required = false) Integer price, @RequestParam(required = false) String order){
    List<Game>  games = new ArrayList<>();


        if(name==null && genre==null && platform==null && condition==null && order==null && price==null) {

            games = service.getAllGames();

        }
         else if (name!=null) {
            games = service.getAllGamesByName(name);
        } else if(genre!=null) {
            games = service.findGamesByGenre(genre);
        }else if(platform != null){
            games = service.findGamesByPlatform(platform);
        }else if(condition!= null){
            games = service.findGamesByCondition(condition);
        }else if(price != null){
            games = service.findGamesByEqualsOrHigherPrice(price);
 }

        else if(order!=null && order.trim().toUpperCase().equals("ASC")){
            games= service.getSortedListOrderByASC(order.toUpperCase());

        } else if (order!=null && order.trim().toUpperCase().equals("DESC")) {
            games = service.getSortedListOrderByDESC(order.toUpperCase());

        }




        if (games.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(games, HttpStatus.OK);

    }
    @GetMapping("/games/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable("id") UUID id) {

        Game game = service.getGameById(id);

        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @PostMapping(value="/games",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Game> createGame(@RequestBody Game game) throws IOException {


        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper.enable(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES);
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
        mapper.enable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
        mapper.enable(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES);
        mapper.enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
        mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        HttpHeaders http = new HttpHeaders();
        http.setContentType(MediaType.APPLICATION_JSON);

        final SimpleModule module = new SimpleModule();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        module.addDeserializer(Game.class, new MyGameModel());
        module.addDeserializer(Genre.class, new MyGenreDeserializer());
        module.addDeserializer(Publisher.class, new MyPublisherModel());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addDeserializer(Platform.class, new MyPlatformDeserializer());
        module.addDeserializer(Condition.class, new MyConditionDeserializer());
        module.addDeserializer(Inventory.class, new MyInventoryDeserializer());
        mapper.registerModule(module);
        mapper.registerModule(javaTimeModule);

//
//        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();

//        Inventory inventory = new Inventory();
//        inventory.setGame(game);
//        inventory.setId(game.getId());
//
//        Inventory inventory = new Inventory();
//        inventory.setId(game.getId());


        Game game1 = new ObjectMapper().convertValue(game, Game.class);
        Inventory inv = new Inventory();
        Game res =game1.setInventory(inv);
//        map.add("name", game_.getName());
//        map.add("description", game_.getDescription());
//        map.add("price", game_.getPrice());
//        map.add("rating", game_.getRating());
////        map.add("orderitem", game.getOrderitem());
//        map.add("image", game_.getImage());
//        map.add("publisher", game_.getPublisher());
//        map.add("released", game_.getReleased());
////        map.add("developer", game.getDeveloper());
//        map.add("inventory", game_.getInventory());
//        map.add("genre", game_.getGenre());
//        map.add("platform", game_.getPlatform());
////        map.add("condition", game_.getCondition());
        Game gameNew = service.createGame(game);
        gameNew.setInventoryId(gameNew.getId());
//
//
//
//        System.out.println(res.toString());



       // inventory.setGame(_game);











        return new ResponseEntity<>(gameNew, HttpStatus.CREATED);
    }

    @PutMapping("/games/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable("id") UUID id, @RequestBody Game game) {
        Game _game= service.updateGame(id, game);



        return new ResponseEntity<>(_game, HttpStatus.OK);
    }

    @DeleteMapping("/games/{id}")
    public ResponseEntity<HttpStatus> deleteGame(@PathVariable("id") UUID id) {

        service.deleteGame(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/games")
    public ResponseEntity<HttpStatus> deleteAllGames() {
        service.deleteAllGames();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
