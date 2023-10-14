package com.andreirosca.gamesstoreapi.controller;


import com.andreirosca.gamesstoreapi.model.Game;
import com.andreirosca.gamesstoreapi.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class GameController {

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

    @PostMapping(path="/games", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
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
