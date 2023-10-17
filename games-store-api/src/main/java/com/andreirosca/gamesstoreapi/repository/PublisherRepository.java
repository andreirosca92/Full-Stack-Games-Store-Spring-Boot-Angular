package com.andreirosca.gamesstoreapi.repository;

import com.andreirosca.gamesstoreapi.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface  PublisherRepository extends JpaRepository<Publisher, UUID> {
    @Query(value= "SELECT g.game_id, p.name, p.publisher_id FROM games as g JOIN publishers as p ON g.publisher_id=p.publisher_id WHERE p.name=:name", nativeQuery = true)
    List<Publisher> getPublisherandGameByName(@Param("name") String name);
}
