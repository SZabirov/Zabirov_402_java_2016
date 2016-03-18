//package ru.itis.inform.store.dao;
//
//import org.springframework.stereotype.Component;
//import ru.itis.inform.store.dao.models.Item;
//
//import java.io.*;
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//
//@Component
//public class ItemsDaoFileBasedImpl implements ItemsDao {
//
//    private File file;
//    private List<Item> arr;
//
//    Properties getProperties(){
//        Properties properties = new Properties();
//        try {
//            properties.load(
//                    new FileInputStream("C:\\javaclasses\\Store\\src\\main\\resources\\store.properties"));
//        } catch (IOException e){
//            throw new IllegalArgumentException();
//        }
//        return properties;
//    }
//
//    public ItemsDaoFileBasedImpl() {
//        file = new File(getProperties().getProperty("filePath"));
//        arr = new ArrayList<Item>();
//            try {
//                loadItems(this.file, arr);
//            } catch (IOException e){
//                throw new IllegalArgumentException();
//            }
//    }
//
//
//    public void delete(String itemName) {
//        for (int i = 0; i < arr.size(); i++) {
//            if (arr.get(i).getItemName().equals(itemName)) {
//                arr.remove(i);
//            }
//        }
//        try {
//            recFile(file, arr);
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    public Item select(String itemName) {
//        for (Item item : arr){
//            if (item.getItemName().equals(itemName)){
//                return item;
//            }
//        }
//        return null;
//    }
//
//    private void loadItems (File file, List<Item> arr) throws IOException {
//        BufferedReader in = null;
//        try {
//            in = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.defaultCharset()));
//            String line;
//            while ((line = in.readLine()) != null){
//                arr.add(new Item(line));
//            }
//        } catch (FileNotFoundException e){
//            e.printStackTrace();
//        } finally {
//            if (in != null) {
//                in.close();
//            }
//        }
//    }
//
//    private void recFile(File file, List<Item> arr) throws IOException{
//        FileWriter fw = new FileWriter(file);
//        for (Item item : arr){
//            fw.write(item.getItemName() + "\n");
//        }
//        fw.flush();
//        fw.close();
//    }
//
//    @Override
//    public List<Item> getAllItems() {
//        return arr;
//    }
//
//    @Override
//    public void addItem(Item item) {
//
//    }
//
//    @Override
//    public Item selectItemById(int id) {
//        return null;
//    }
//}