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

    /**
     * Добавляет <code>Item item</code>
     * @param item
     */
    void addItem(Item item);

    /**
     * Возвращает <code>Item item</code> с заданным <code>id</code>
     * @param id
     * @return
     */
    Item selectItemById(int id);
}
