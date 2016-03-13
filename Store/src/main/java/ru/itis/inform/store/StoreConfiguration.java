package ru.itis.inform.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.itis.inform.store.services.StoreService;
import ru.itis.inform.store.services.StoreServiceImpl;

@Configuration
@ComponentScan("ru.itis.inform.store.dao")
public class StoreConfiguration {
//    @Bean
//    public ItemsDao itemsDaoCsv(){
//        return new ItemsDaoCsvBasedImpl(new File(getProperties().getProperty("filePath")));
//    }
//
//    @Bean
//    public ItemsDao itemsDaoTsv(){
//        return new ItemsDaoTsvBasedImpl(new File(getProperties().getProperty("filePath")));
//    }
//
//    @Bean
//    public ItemsDao itemsDaoFile(){
//        return new ItemsDaoFileBasedImpl(new File(getProperties().getProperty("filePath")));
//    }
//
    @Bean
    public StoreService storeService(){
        return new StoreServiceImpl();
    }
}
