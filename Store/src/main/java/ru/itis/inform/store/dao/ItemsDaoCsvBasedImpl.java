package ru.itis.inform.store.dao;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import org.springframework.stereotype.Component;
import ru.itis.inform.store.dao.models.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

@Component
public class ItemsDaoCsvBasedImpl implements ItemsDao {

    CsvParserSettings settings;
    CsvParser parser;
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


    public ItemsDaoCsvBasedImpl() {
        file = new File(getProperties().getProperty("filePath"));
        settings = new CsvParserSettings();
        settings.getFormat().setLineSeparator("\n");
        parser = new CsvParser(settings);
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
            CsvWriter writer = new CsvWriter(fw, new CsvWriterSettings());
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
        for (String[] stringArray : allRows){
            Item item = new Item(stringArray[0]);
            item.setPrice(Integer.parseInt(stringArray[1]));
            list.add(item);
        }
        return list;
    }

    @Override
    public void addItem(Item item) {
        for (int i = 0; i < allRows.size(); i++) {
            String [] array = new String[3];
            array[0] = ((Integer)item.getId()).toString();
            array[1] = item.getItemName();
            array[3] = ((Double)item.getPrice()).toString();
            allRows.add(array);
        }
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
