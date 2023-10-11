package com.andreirosca.gamesstoreapi.service;

import com.andreirosca.gamesstoreapi.model.Game;
import com.andreirosca.gamesstoreapi.model.Order;
import com.andreirosca.gamesstoreapi.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameService  {

    @Autowired
    private GameRepository repository;


    public List<Game> getAllGames() {


        return repository.findAll(Sort.by("name"));

    }

    public Game getGameById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new IllegalStateException("Not found Game with id = " + id));

    }

    public Game createGame(Game game) {

        return repository.save(game);
    }

    public Game updateGame(UUID id, Game game) {

        Game _game = repository.findById(id).orElseThrow(() -> new IllegalStateException("Not found Game with id = " + id));

        _game.setName(game.getName());
        _game.setGenre(game.getGenre());
        _game.setCondition(game.getCondition());
        _game.setDescription(game.getDescription());
        _game.setDeveloper(game.getDeveloper());
        _game.setInventory(game.getInventory());
        _game.setPlatform(game.getPlatform());
        _game.setPlatform(game.getPlatform());
        _game.setPrice(game.getPrice());
        _game.setOrderitem(game.getOrderitem());
        _game.setReleased(game.getReleased());
        _game.setRating(game.getRating());

        return repository.save(_game);

    }

    public void deleteGame(UUID id) {
        repository.deleteById(id);
    }

    public List<Game> findGamesByGenre(String genre) {
        return repository.findByGenre(genre);
    }

    public void deleteAllGames() {
        repository.deleteAll();
    }

    public List<Game> findGamesByPlatform(String platform) {
        return repository.findGamesByPlatform(platform);
    }

    public List<Game> findGamesByCondition(String condition) {
        return repository.findGamesByCondition(condition);
    }

    public List<Game> findGamesByEqualsOrHigherPrice(Integer price) {
        return repository.findGamesByEqualsOrHigherPrice(price);
    }




    public List<Game> getSortedListOrderByDESC(String order) {
        return repository.getSortedListOrderByDESC(order);
    }

    public List<Game> getSortedListOrderByASC( String order) {
        return repository.getSortedListOrderByASC(order);
    }

    public List<Game> getAllGamesByName(String name) {
        return repository.findByTitleContaining(name);
    }
}
