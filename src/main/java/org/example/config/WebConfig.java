package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//один метод возвращающий объект типа ViewResolver, это такой интерфейс, необходимый для нахождения представления по имени.
//@Configuration сообщает Spring что данный класс является конфигурационным и содержит
// определения и зависимости bean-компонентов.
// Бины (bean) — это объекты, которые управляются Spring'ом.
// Для определения бина используется аннотация @Bean.


@Configuration
@EnableWebMvc  // позволяет импортировать конфигурацию Spring MVC из класса WebMvcConfigurationSupport
@ComponentScan(basePackages = "org.example")
//@ComponentScan сообщает Spring где искать компоненты, которыми он должен управлять, т.е.
// классы, помеченные аннотацией @Component или ее производными, такими как @Controller, @Repository, @Service.
// Эти аннотации автоматически определяют бин класса.
public class WebConfig implements WebMvcConfigurer{

    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}