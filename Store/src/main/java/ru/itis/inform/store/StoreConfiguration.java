package ru.itis.inform.store;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAspectJAutoProxy
@EnableWebMvc
@ComponentScan("ru.itis.inform.store")
public class StoreConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
//    @Bean
//    public LoggingAspect loggingAspect(){
//        return new LoggingAspect();
//    }
//    @Bean
//    public ItemsDao itemsDaoCsv(){
//        return new ItemsDaoCsvBasedImpl(new File(getProperties().getProperty("filePath")));
//    }
//
//    @Bean
//    public ItemsDao itemsDaoTsv(){
//        return new ItemsDaoTsvBasedImpl(new File(getProperties().getProperty("filePath")));
//    }
//
//    @Bean
//    public ItemsDao itemsDaoFile(){
//        return new ItemsDaoFileBasedImpl(new File(getProperties().getProperty("filePath")));
//    }
//
//    @Bean
//    public StoreService storeService(){
//        return new StoreServiceImpl();
//    }
}
