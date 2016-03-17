package ru.itis.inform.store.dao;


import ru.itis.inform.store.dao.models.Item;

import java.util.List;

public interface ItemsDao {

    /**
     * Удаляет товар из хранилища
     * @param itemName
     */
    void delete(String itemName);

    /**
     * Возвращает описание товара из БД
     * @param itemName
     * @return
     */
    Item select(String itemName);

    /**
     * Возвращает список всех <code>Item</code>
     * @return
     */
    List<Item> getAllItems();
}
