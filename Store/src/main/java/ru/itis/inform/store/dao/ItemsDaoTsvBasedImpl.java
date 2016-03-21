package ru.itis.inform.store.dao;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;
import com.univocity.parsers.tsv.TsvWriter;
import com.univocity.parsers.tsv.TsvWriterSettings;
import org.springframework.stereotype.Component;
import ru.itis.inform.store.dao.models.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

@Component
public class ItemsDaoTsvBasedImpl implements ItemsDao {

    TsvParserSettings settings;
    TsvParser parser;
    List<String[]> allRows;
    File file;

    Properties getProperties(){
        Properties properties = new Properties();
        try {
            properties.load(
                    new FileInputStream("C:\\javaclasses\\Store\\src\\main\\resources\\store.properties"));
        } catch (IOException e){
            throw new IllegalArgumentException();
        }
        return properties;
    }

    public ItemsDaoTsvBasedImpl() {
        file = new File(getProperties().getProperty("filePath"));
        settings = new TsvParserSettings();
        settings.getFormat().setLineSeparator("\n");
        parser = new TsvParser(settings);
        parseLines(this.file);
    }

    private void parseLines(File file){
        try {
            allRows = parser.parseAll(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        }
    }

    private void recordFile(File file){
        List<Object[]> list = new LinkedList<Object[]>();
        for (int i = 0; i < allRows.size(); i++) {
            list.add(allRows.get(i));
        }
        try {
            FileWriter fw = new FileWriter(file);
            TsvWriter writer = new TsvWriter(fw, new TsvWriterSettings());
            writer.writeRowsAndClose(list);
        } catch (IOException e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void delete(String itemName) {
        for (int i = 0; i < allRows.size(); i++) {
            if (allRows.get(i)[0].equals(itemName)) {
                allRows.remove(i);
            }
        }
        recordFile(file);
    }

    @Override
    public Item select(String itemName) {
        Item item = null;
        for (int i = 0; i < allRows.size(); i++){
            if (allRows.get(i)[1].equals(itemName)){
                item = new Item(itemName);
                item.setId(Integer.parseInt(allRows.get(i)[0]));
                item.setPrice(Integer.parseInt(allRows.get(i)[2]));
            }
        }
        return item;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        int n = allRows.size();
        for (int i = 0; i < n; i++){
            String[] stringArray = allRows.get(i);
            Item item = new Item(stringArray[1]);
            item.setPrice(Double.parseDouble(stringArray[2]));
            item.setId(Integer.parseInt(stringArray[0]));
            list.add(item);
        }
        return list;
    }

    @Override
    public void addItem(Item item) {
        String[] array = new String[3];
        array[0] = ((Integer) item.getId()).toString();
        array[1] = item.getItemName();
        array[2] = ((Double) item.getPrice()).toString();
        allRows.add(array);
        recordFile(file);
    }

    @Override
    public Item selectItemById(int id) {
        Item item = null;
        for (int i = 0; i < allRows.size(); i++){
            if (Integer.parseInt(allRows.get(i)[0]) == id){
                item = new Item(allRows.get(i)[1]);
                item.setId(Integer.parseInt(allRows.get(i)[0]));
                item.setPrice(Integer.parseInt(allRows.get(i)[2]));
            }
        }
        return item;
    }
}
