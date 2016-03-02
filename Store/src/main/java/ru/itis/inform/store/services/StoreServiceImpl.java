package ru.itis.inform.store.services;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import ru.itis.inform.store.dao.ItemsDao;

public class StoreServiceImpl implements StoreService {

    private Logger log = LoggerFactory.getLogger(StoreService.class);

    ItemsDao itemsDao;

    public StoreServiceImpl() {
    }

    public void setItemsDao(ItemsDao itemsDao) {
        this.itemsDao = itemsDao;
    }

    public void buy(String itemName) {
        log.info("Customer's buying product '" + itemName + "'");
        itemsDao.delete(itemName);
    }

    public boolean isExist(String itemName) {
        log.info("Customer checks whether product '" + itemName + "' exists");
        return itemsDao.select(itemName) != null;
    }
}
