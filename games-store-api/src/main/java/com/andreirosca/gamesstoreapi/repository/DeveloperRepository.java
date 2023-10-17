package com.andreirosca.gamesstoreapi.repository;

import com.andreirosca.gamesstoreapi.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, UUID> {
}
