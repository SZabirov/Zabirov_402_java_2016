package ru.itis.inform.store.services;


import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.models.Item;

import java.util.List;

public interface StoreService {
    /**
     * Покупка товара по имени
     * @param itemName имя товара
     */
    void buy(String itemName);

    /**
     * Проверяет, есть ли товар на складе
     * @param itemName название товара
     * @return true - если товар найден,
     * false - в противном случае
     */
    boolean isExist(String itemName);

    /**
     * Добавляет экземпляр <code>itemsDao</code>
     * @param itemsDao
     */
    void setItemsDao(ItemsDao itemsDao);

    /**
     * Возвращает список всех <code>Items</code>
     * @return
     */
    List<Item> getAllItems();

    /**
     * Возвращает <code>Item</code> по <code>id</code>
     * @param id
     * @return
     */
    Item getItem (int id);

    void postItem(Item item);
}