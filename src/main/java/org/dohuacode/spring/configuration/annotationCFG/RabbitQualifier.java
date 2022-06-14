package org.dohuacode.spring.configuration.annotationCFG;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("rabbitBean") //or defaultname will be rabbitqualifier
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

