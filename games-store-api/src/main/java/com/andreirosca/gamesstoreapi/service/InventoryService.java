package com.andreirosca.gamesstoreapi.service;

import com.andreirosca.gamesstoreapi.model.Inventory;
import com.andreirosca.gamesstoreapi.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public Inventory createInventory(Inventory inventory) {
        return repository.save(inventory);
    }

    public List<Inventory> getAllInventory() {

        return repository.findAll();
    }

    public Inventory getInventory(UUID id) {

        Inventory inventory = repository.findById(id).orElseThrow(() -> new IllegalStateException("Not found Game with id = " + id));
        return  inventory;
    }

    public Inventory updateInventory(UUID id, Inventory inventory) {

        Inventory inventoryFound = repository.findById(id).orElseThrow(() -> new IllegalStateException("Not found Game with id = " + id) );
        inventoryFound.setSnew(inventoryFound.getSnew());
        inventoryFound.setSused(inventoryFound.getSused());
        inventoryFound.setGame(inventoryFound.getGame());

        return  inventoryFound;
    }
}
