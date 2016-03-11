package ru.itis.inform.store;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.ItemsDaoCsvBasedImpl;
import ru.itis.inform.store.dao.ItemsDaoTsvBasedImpl;
import ru.itis.inform.store.dao.models.Item;

import static org.junit.Assert.assertEquals;

public class ItemsDaoCsvOrTsvBasedImplTest {


//    @Test
//    public void testSelect(){
//        ItemsDao itemsDao = StoreServiceFactory.getInstance().getItemsDao();
//        Item expectedItem = new Item("Milk");
//        expectedItem.setPrice(350);
//        assertEquals(expectedItem, itemsDao.select("Milk"));
//    }

    ItemsDao itemsDao;

    @Before
    public void setup(){
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("app-context.xml");
//        itemsDao = (ItemsDao)context.getBean("itemsDao");
        ApplicationContext context =
                new AnnotationConfigApplicationContext(StoreConfiguration.class);
        //@Qualifier("itemsDaoCsv")
        itemsDao = (ItemsDao)context.getBean(ItemsDao.class);
    }

    @Test
    public void testSelect(){

        if (itemsDao instanceof ItemsDaoCsvBasedImpl || itemsDao instanceof ItemsDaoTsvBasedImpl) {
            System.out.println("Yes, it is");
            Item expectedItem = new Item("Milk");
            expectedItem.setPrice(350);
            assertEquals(expectedItem, itemsDao.select("Milk"));
        }
    }
}
