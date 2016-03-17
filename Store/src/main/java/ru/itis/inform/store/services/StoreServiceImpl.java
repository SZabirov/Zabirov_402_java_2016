package ru.itis.inform.store.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.itis.inform.store.dao.ItemsDao;

@Service
public class StoreServiceImpl implements StoreService {

    private Logger log = LoggerFactory.getLogger(StoreService.class);

    @Autowired
    @Qualifier("itemsDaoCsvBasedImpl")
    ItemsDao itemsDao;

    public StoreServiceImpl() {
    }

    public void setItemsDao(ItemsDao itemsDao) {
        this.itemsDao = itemsDao;
    }

    public void buy(String itemName) {
        itemsDao.delete(itemName);
    }

    public boolean isExist(String itemName) {
        return itemsDao.select(itemName) != null;
    }
}
