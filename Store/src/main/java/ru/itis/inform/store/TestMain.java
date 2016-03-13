package ru.itis.inform.store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.store.services.StoreService;

public class TestMain {

    static StoreService storeService;

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(StoreConfiguration.class);
        storeService = (StoreService) context.getBean("storeService");
        System.out.println(storeService.isExist("Bread"));
    }
}
