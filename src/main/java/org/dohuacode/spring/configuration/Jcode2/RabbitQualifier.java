package org.dohuacode.spring.configuration.Jcode2;

import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Scope("singleton") //SCOPE
public class RabbitQualifier implements Pet {
    public RabbitQualifier(){
        System.out.println("created RABBIT");
    }
    @Override
    public void sound(){
        System.out.println("SCREAM");
    }
    @PostConstruct //init method
    public void init(){
        System.out.println("INIT METHOD");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("DESTROY METHOD");
    }
}

