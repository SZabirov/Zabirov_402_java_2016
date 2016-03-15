//package ru.itis.inform.store;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import ru.itis.inform.store.dao.ItemsDao;
//import ru.itis.inform.store.dao.ItemsDaoCsvBasedImpl;
//import ru.itis.inform.store.dao.models.Item;
//import ru.itis.inform.store.services.StoreService;
//
//import java.io.IOException;
//import ru.itis.inform.store.StoreConfiguration;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Mockito.*;
//
//
//@RunWith(MockitoJUnitRunner.class)
////@ContextConfiguration(locations = { "/ru/itis/inform/store/StoreConfiguration.java"})
//public class StoreServiceImplTest {
//
////    StoreServiceFactory storeServiceFactory = StoreServiceFactory.getInstance();
////    StoreService testedStoreService = storeServiceFactory.getStoreService();
////
////
////    @Mock
////    ItemsDao itemsDao = storeServiceFactory.getItemsDao();
////
////    @Before
////    public void setUp() throws Exception {
////        // Выброс исключения, если пришла какая-либо строка, которая не Tovar
////        doThrow(new IllegalArgumentException()).when(itemsDao).delete(anyString());
////        // Делаем stubbing на удаление товара с именем Tovar
////        doNothing().when(itemsDao).delete("Tovar");
////        doReturn(null).when(itemsDao).select("Not tovar");
////        doReturn(new Item("Tovar")).when(itemsDao).select("Tovar");
////        testedStoreService.setItemsDao(itemsDao);
////    }
//
////    ApplicationContext context =
////            new ClassPathXmlApplicationContext("app-context.xml");
////    StoreService testedStoreService = (StoreService)context.getBean("storeService");
//
////        ApplicationContext context =
////        new AnnotationConfigApplicationContext(StoreConfiguration.class);
////    StoreService testedStoreService = (StoreService)context.getBean(StoreService.class);
//
//    StoreService testedStoreService;
//
//
////    @Mock
////    ItemsDao itemsDao = (ItemsDao)context.getBean("itemsDao");
//
//    //    @Mock
////    ItemsDao itemsDao = (ItemsDao)context.getBean(ItemsDao.class);
//    @Mock
//    ItemsDao itemsDao;
//
//
//    @Before
//    public void setUp() throws Exception {
//        // Выброс исключения, если пришла какая-либо строка, которая не Tovar
//        doThrow(new IllegalArgumentException()).when(itemsDao).delete(anyString());
//        // Делаем stubbing на удаление товара с именем Tovar
//        doNothing().when(itemsDao).delete("Tovar");
//        doReturn(null).when(itemsDao).select("Not tovar");
//        doReturn(new Item("Tovar")).when(itemsDao).select("Tovar");
//        testedStoreService.setItemsDao(itemsDao);
//    }
//
//    // Проверяем, корректно ли прошло выполнение метода buy при входном значении Tovar
//    @Test
//    public void testBuy() throws Exception {
//        testedStoreService.buy("Tovar");
//        // Проверяем, был ли вызван метод delete
//        verify(itemsDao).delete("Tovar");
//    }
//
//    // Проверяем, была ли вызвана ошибка при других входных данных
//    @Test(expected = IllegalArgumentException.class)
//    public void testBuyOnIncorrectData() {
//        testedStoreService.buy("Not tovar");
//    }
//
//    @Test
//    public void serviceWithDaoTestIsExistWithExisting() throws IOException {
//        testedStoreService.isExist("Tovar");
//        verify(itemsDao).select("Tovar");
//    }
//
//    @Test
//    public void testIsExistOnIncorrectData() {
//        assertFalse(testedStoreService.isExist("Not tovar"));
//    }
//
//    @Test
//    public void testIsExistsOnCorrectData() {
//        assertTrue(testedStoreService.isExist("Tovar"));
//    }
//
//
//}