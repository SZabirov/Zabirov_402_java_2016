package ru.itis.inform.store;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import ru.itis.inform.store.services.StoreServiceImpl;

@Configuration
@ComponentScan(basePackages ={ "ru.itis.inform.store" }, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
public class TestStoreContext {

    @Bean
    public StoreServiceImpl storeService(){
        return Mockito.mock(StoreServiceImpl.class);
    }

}
