package ru.itis.inform.store;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

    @Test
    public void testSelect(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("app-context.xml");
        ItemsDao itemsDao = (ItemsDao)context.getBean("itemsDao");
        if (itemsDao instanceof ItemsDaoCsvBasedImpl || itemsDao instanceof ItemsDaoTsvBasedImpl) {
            Item expectedItem = new Item("Milk");
            expectedItem.setPrice(350);
            assertEquals(expectedItem, itemsDao.select("Milk"));
        }
    }


}
