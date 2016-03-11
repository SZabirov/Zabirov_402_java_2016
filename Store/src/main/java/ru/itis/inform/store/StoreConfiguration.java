package ru.itis.inform.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.ItemsDaoCsvBasedImpl;
import ru.itis.inform.store.dao.ItemsDaoFileBasedImpl;
import ru.itis.inform.store.dao.ItemsDaoTsvBasedImpl;
import ru.itis.inform.store.services.StoreService;
import ru.itis.inform.store.services.StoreServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class StoreConfiguration {

    Properties getProperties(){
        Properties properties = new Properties();
        try {
            properties.load(
                    new FileInputStream("C:\\javaclasses\\Store\\src\\main\\resources\\store.properties"));
        } catch (IOException e){
            throw new IllegalArgumentException();
        }
        return properties;
    }

    @Bean
    public ItemsDao itemsDaoCsv(){
        return new ItemsDaoCsvBasedImpl(new File(getProperties().getProperty("filePath")));
    }

    @Bean
    public ItemsDao itemsDaoTsv(){
        return new ItemsDaoTsvBasedImpl(new File(getProperties().getProperty("filePath")));
    }

    @Bean
    public ItemsDao itemsDaoFile(){
        return new ItemsDaoFileBasedImpl(new File(getProperties().getProperty("filePath")));
    }

    @Bean

    public StoreService storeService(){
        return new StoreServiceImpl();
    }


}
