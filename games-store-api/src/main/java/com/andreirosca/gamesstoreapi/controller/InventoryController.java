package com.andreirosca.gamesstoreapi.controller;

import com.andreirosca.gamesstoreapi.model.Game;
import com.andreirosca.gamesstoreapi.model.Inventory;
import com.andreirosca.gamesstoreapi.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/games")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping("/inventory")
    public ResponseEntity<List<Inventory>> getAllInventory(){
        List<Inventory> inventories = service.getAllInventory();

        if(inventories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }
    @GetMapping("/inventory/{id}")
    public ResponseEntity<Inventory> getInventory(@PathVariable("id") UUID id){
        Inventory inventoryNew = service.getInventory(id);

        return new ResponseEntity<>(inventoryNew, HttpStatus.OK);
    }
    @PutMapping("/inventory/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable("id") UUID id, @RequestBody Inventory inventory){

        Inventory inventoryModified= service.updateInventory(id, inventory);



        return new ResponseEntity<>(inventoryModified, HttpStatus.OK);
    }
}
