package ru.itis.inform.store;

import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.services.StoreService;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class StoreServiceFactory {

    private static StoreServiceFactory instance;

    private Properties properties;

    private StoreService storeService;
    private ItemsDao itemsDao;

    private StoreServiceFactory() {
        properties = new Properties();

        try {
            properties.load(
                    new FileInputStream("C:\\javaclasses\\Store\\src\\main\\resources\\store.properties"));

            String storeServiceClass = properties.getProperty("storeService.class");
            String itemsDaoClass = properties.getProperty("itemsDao.class");
            String filePath = properties.getProperty("filePath");

            this.storeService = (StoreService)Class.forName(storeServiceClass).getConstructor().newInstance();
            this.itemsDao = (ItemsDao)Class.forName(itemsDaoClass).getDeclaredConstructor(File.class).newInstance(new File(filePath));
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    static {
        instance = new StoreServiceFactory();
    }

    public static StoreServiceFactory getInstance() {
        return instance;
    }

    public StoreService getStoreService() {
        return storeService;
    }

    public ItemsDao getItemsDao() {
        return itemsDao;
    }
}
