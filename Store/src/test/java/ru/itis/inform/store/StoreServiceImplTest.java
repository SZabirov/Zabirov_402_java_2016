package ru.itis.inform.store;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.models.Item;
import ru.itis.inform.store.services.StoreServiceImpl;

import java.io.IOException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StoreServiceImplTest {

    StoreServiceImpl testedStoreService;

    @Mock
    ItemsDao itemsDao;

    @Before
    public void setUp() throws Exception {
        // Выброс исключения, если пришла какая-либо строка, которая не Tovar
        doThrow(new IllegalArgumentException()).when(itemsDao).delete(anyString());
        // Делаем stubbing на удаление товара с именем Tovar
        doNothing().when(itemsDao).delete("Tovar");
        doThrow(new IllegalArgumentException()).when(itemsDao).select(anyString());
        doReturn(new Item("Tovar")).when(itemsDao).select("Tovar");
        testedStoreService = new StoreServiceImpl(itemsDao);

    }

    // Проверяем, корректно ли прошло выполнение метода buy при входном значении Tovar
    @Test
    public void testBuy() throws Exception {
        testedStoreService.buy("Tovar");
        // Проверяем, был ли вызван метод delete
        verify(itemsDao).delete("Tovar");
    }

    // Проверяем, была ли вызвана ошибка при других входных данных
    @Test(expected = IllegalArgumentException.class)
    public void testBuyOnIncorrectData() {
        testedStoreService.buy("Not tovar");
    }

    @Test
    public void serviceWithDaoTestIsExistWithExisting() throws IOException {
        testedStoreService.isExist("Tovar");
        verify(itemsDao).select("Tovar");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectOnIncorrectData() {
        testedStoreService.isExist("Not tovar");
    }
}