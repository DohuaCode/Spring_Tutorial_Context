package org.dohuacode.spring.configuration.Jcode;

import org.springframework.stereotype.Component;

@Component("catBean") //or defaultname will be cat
public class Cat implements Pet {
    public Cat(){
        System.out.println("created CAT");
    }
    @Override
    public void sound(){
        System.out.println("MEOW");
    }

        public void init(){
            System.out.println("INIT METHOD");
        }
    public void destroy(){
        System.out.println("DESTROY METHOD");
    }
}

