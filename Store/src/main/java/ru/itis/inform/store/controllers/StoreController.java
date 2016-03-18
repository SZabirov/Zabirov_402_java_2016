package ru.itis.inform.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.inform.store.dao.models.Item;
import ru.itis.inform.store.services.StoreService;
import ru.itis.inform.store.services.StoreServiceImpl;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    StoreService storeService = new StoreServiceImpl();

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> getItems(){
        return storeService.getAllItems();
    }

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public void addUser(@RequestBody Item item){
        storeService.postItem(item);
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public Item getItemById(@PathVariable("id") int id){
        return storeService.getItem(id);
    }
}
