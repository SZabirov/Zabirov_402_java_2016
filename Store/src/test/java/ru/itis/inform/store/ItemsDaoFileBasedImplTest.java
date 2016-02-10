package ru.itis.inform.store;

import org.junit.*;
import org.junit.rules.TemporaryFolder;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.ItemsDaoFileBasedImpl;
import ru.itis.inform.store.services.StoreService;
import ru.itis.inform.store.services.StoreServiceImpl;
import static org.junit.Assert.*;
import java.io.*;


public class ItemsDaoFileBasedImplTest {

    File file;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();


    @Before
    public void setUp() throws Exception {
        file = folder.newFile();
        PrintWriter pw = new PrintWriter(file);
        pw.write("bread\n");
        pw.write("milk\n");
        pw.write("water\n");
        pw.flush();
        pw.close();
    }


    @Test
    public void serviceWithDaoTestBuy() throws IOException{
        ItemsDao impl = new ItemsDaoFileBasedImpl(file);
        StoreService storeService = new StoreServiceImpl(impl);
        storeService.buy("milk");
        BufferedReader in = null;
        String [] items = new String [] {"bread", "water"};
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            for (int i = 0; i < 2; i++){
                assertEquals(items[i], in.readLine());
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    @Test
    public void serviceWithDaoTestIsExistWithExisting() throws IOException{
        ItemsDao impl = new ItemsDaoFileBasedImpl(file);
        StoreService storeService = new StoreServiceImpl(impl);
        assertTrue(storeService.isExist("milk"));
    }

    @Test
    public void serviceWithDaoTestIsExistWithNotExisting() throws IOException{
        ItemsDao impl = new ItemsDaoFileBasedImpl(file);
        StoreService storeService = new StoreServiceImpl(impl);
        assertFalse(storeService.isExist("chocolate"));
    }
}
