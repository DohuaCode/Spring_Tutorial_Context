package org.dohuacode.spring.configuration.Jcode2;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:app.properties")

public class Config {
    @Bean
    @Scope("singleton")
public Pet catBean(){
    return new Cat();
}
@Bean
public  PersonJconfig personBean(){
        return new PersonJconfig(catBean());
}
}
