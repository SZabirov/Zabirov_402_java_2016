package ru.itis.inform.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

}
