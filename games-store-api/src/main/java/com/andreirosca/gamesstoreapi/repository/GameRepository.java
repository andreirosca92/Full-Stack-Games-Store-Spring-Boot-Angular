package com.andreirosca.gamesstoreapi.repository;

import com.andreirosca.gamesstoreapi.model.Game;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface GameRepository extends JpaRepository<Game, UUID> {
    @Query(value = "SELECT * FROM Games g WHERE g.name LIKE %:name%", nativeQuery = true)
   List<Game> findByTitleContaining(@Param("name") String name);

    @Query(value="SELECT * FROM Games g WHERE g.genre LIKE %:genre%", nativeQuery = true)
    List<Game> findByGenre(@Param("genre") String genre);

    @Query(value="SELECT * FROM Games g WHERE g.platform LIKE %:platform%", nativeQuery = true)
    List<Game> findGamesByPlatform(@Param("platform") String platform);

    @Query(value = "SELECT * FROM Games g WHERE g.condition LIKE %:condition%", nativeQuery = true)
    List<Game> findGamesByCondition(@Param("condition") String condition);


    @Query(value = "SELECT * FROM Games g WHERE g.price>= %:price%", nativeQuery = true)
    List<Game> findGamesByEqualsOrHigherPrice(@Param("price") Integer price);

    @Query(value = "SELECT * FROM Games g ORDER BY g.name DESC", nativeQuery = true)
    List<Game> getSortedListOrderByDESC(@Param("order")String order);

    @Query(value = "SELECT * FROM Games g ORDER BY g.name ASC", nativeQuery = true)
    List<Game> getSortedListOrderByASC( @Param("order") String order);
}
