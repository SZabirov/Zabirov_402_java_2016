package ru.itis.inform.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.models.Item;
import ru.itis.inform.store.services.StoreService;

public class TestMain {

    @Autowired
    @Qualifier("itemsDaoTsv")
    static StoreService storeService;

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(StoreConfiguration.class);
        storeService = (StoreService) context.getBean("storeService");
        System.out.println(storeService == null);
    }
}
