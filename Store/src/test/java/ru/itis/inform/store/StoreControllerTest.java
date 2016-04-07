package ru.itis.inform.store;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.itis.inform.store.dao.models.Item;
import ru.itis.inform.store.services.StoreService;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.itis.inform.store.dao.ItemsDaoData.ITEM_1;
import static ru.itis.inform.store.dao.ItemsDaoData.ITEM_2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestStoreContext.class})
@WebAppConfiguration
public class StoreControllerTest {

    private MockMvc mockMvc;

    @Autowired
    StoreService storeService;

    @Autowired
    WebApplicationContext webApplicationContext;

    final ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        Mockito.reset(storeService);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Mockito.doThrow(RuntimeException.class).when(storeService).getItem(Matchers.anyInt());
        Mockito.doReturn(ITEM_1).when(storeService).getItem(ITEM_1.getId());
        Mockito.doReturn(Lists.newArrayList(ITEM_1, ITEM_2)).when(storeService).getAllItems();
    }

    @Test
    public void testGetItem() throws Exception {
        mockMvc.perform(get("/items/{item-id}", ITEM_1.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ITEM_1.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.itemName", is(ITEM_1.getItemName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", is(ITEM_1.getPrice())));
    }

    @Test
    public void testGetItems() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/items").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", Is.is(ITEM_1.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].itemName", is(ITEM_1.getItemName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].price", is(ITEM_1.getPrice())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].id", Is.is(ITEM_2.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].itemName", is(ITEM_2.getItemName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].price", is(ITEM_2.getPrice())));
    }

    @Test
    public void testPostTaskAssignment() throws Exception {
        Item item = new Item();
        item.setId(4);
        item.setItemName("flower");
        item.setPrice(16);

        String json = objectMapper.writeValueAsString(item);

        mockMvc.perform(post("/items").contentType(MediaType.APPLICATION_JSON)
                .content(json.getBytes()))
                .andExpect(status().isOk());
        verify(storeService).postItem(item);
    }
    //to ask how to send 201
}
