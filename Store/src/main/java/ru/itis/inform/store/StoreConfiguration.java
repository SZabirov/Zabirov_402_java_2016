package ru.itis.inform.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.ItemsDaoCsvBasedImpl;
import ru.itis.inform.store.services.StoreService;
import ru.itis.inform.store.services.StoreServiceImpl;

import java.io.File;

@Configuration
public class StoreConfiguration {

    @Bean
    public ItemsDao itemsDao(){
        return new ItemsDaoCsvBasedImpl(new File("C:\\javaclasses\\Store\\src\\test\\resources\\example.csv"));
    }

    @Bean
    public StoreService storeService(){
        StoreService storeService = new StoreServiceImpl();
        storeService.setItemsDao(itemsDao());
        return storeService;
    }
}
