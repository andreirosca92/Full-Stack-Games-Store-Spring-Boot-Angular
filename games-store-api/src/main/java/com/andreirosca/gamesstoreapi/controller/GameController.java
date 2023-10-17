package com.andreirosca.gamesstoreapi.controller;


import com.andreirosca.gamesstoreapi.dto.GameRequest;

import com.andreirosca.gamesstoreapi.helpers.MyGameModel;
import com.andreirosca.gamesstoreapi.helpers.MyGenreDeserializer;
import com.andreirosca.gamesstoreapi.helpers.MyPublisherModel;
import com.andreirosca.gamesstoreapi.model.Genre;
import com.andreirosca.gamesstoreapi.model.Publisher;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.andreirosca.gamesstoreapi.dto.PublisherRequest;
import com.andreirosca.gamesstoreapi.helpers.MyRequestModelDeserializer;
import com.andreirosca.gamesstoreapi.model.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.andreirosca.gamesstoreapi.service.GameService;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class GameController {
    private static SessionFactory sessionFactory;

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

    @PostMapping(value="/games/fake",
            consumes = { MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Game> createGame(@RequestBody Game game) throws IOException {


        final ObjectMapper mapper = new ObjectMapper();
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
        module.addDeserializer(Game.class, new MyGameModel());
        module.addDeserializer(Genre.class, new MyGenreDeserializer());
        module.addDeserializer(Publisher.class, new MyPublisherModel());
        mapper.registerModule(module);

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("name", game.getName());
        map.add("description", game.getDescription());
        map.add("price", game.getPrice());
        map.add("rating", game.getRating());
//        map.add("orderitem", game.getOrderitem());
        map.add("image", game.getImage());
        map.add("publisher", game.getPublisher());
        map.add("released", game.getReleased());
//        map.add("developer", game.getDeveloper());
//        map.add("inventory", game.getInventory());
//        map.add("genre", game.getGenre());
//        map.add("platform", game.getPlatform());
//        map.add("condition", game.getCondition());

        Game _game = mapper.convertValue(game, Game.class);
        System.out.println(_game.toString());
        Game res = service.createGame(_game);




        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping("/games")
    public ResponseEntity<Game> createGame_(@RequestBody Game game){
        Game _game = service.createGame(game);
        return new ResponseEntity<>(_game, HttpStatus.CREATED);
    }

    @PutMapping("/games/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable("id") UUID id, @RequestBody Game game) {
        Game _game= service.updateGame(id, game);



        return new ResponseEntity<>(_game, HttpStatus.OK);
    }

    @DeleteMapping("/games/{id}")
    public ResponseEntity<Game> deleteGame(@PathVariable("id") UUID id) {

        service.deleteGame(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/games")
    public ResponseEntity<HttpStatus> deleteAllGames() {
        service.deleteAllGames();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/games/genre")
//    public ResponseEntity<List<Game>> findGamesByGenre(@RequestParam(required = true) String genre) {
//        List<Game> _games = new ArrayList<>();
//        _games = service.findGamesByGenre(genre);
//        if (_games.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        return new ResponseEntity<>(_games, HttpStatus.OK);
//    }
//    @GetMapping("/games/platform")
//    public ResponseEntity<List<Game>> findGamesByPlatform(@RequestParam(required = true) String platform) {
//        List<Game> _games = new ArrayList<>();
//        _games = service.findGamesByPlatform(platform);
//        if (_games.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        return new ResponseEntity<>(_games, HttpStatus.OK);
//    }

}
