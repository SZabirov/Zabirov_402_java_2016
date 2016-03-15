package ru.itis.inform.store;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.itis.inform.store")
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
//    @Bean
//    public StoreService storeService(){
//        return new StoreServiceImpl();
//    }
}
