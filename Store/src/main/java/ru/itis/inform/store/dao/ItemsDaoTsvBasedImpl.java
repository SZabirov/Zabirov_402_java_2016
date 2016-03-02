package ru.itis.inform.store.dao;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;
import com.univocity.parsers.tsv.TsvWriter;
import com.univocity.parsers.tsv.TsvWriterSettings;
import ru.itis.inform.store.dao.models.Item;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ItemsDaoTsvBasedImpl implements ItemsDao {

    TsvParserSettings settings;
    TsvParser parser;
    List<String[]> allRows;
    File file;

    public ItemsDaoTsvBasedImpl(File file) {
        this.file = file;
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
            System.out.println(allRows.get(i)[0]/* + " " + allRows.get(i)[1]*/);
            if (allRows.get(i)[0].equals(itemName)){
                item = new Item(itemName);
                item.setPrice(Integer.parseInt(allRows.get(i)[1]));
            }
        }
        return item;
    }
}
