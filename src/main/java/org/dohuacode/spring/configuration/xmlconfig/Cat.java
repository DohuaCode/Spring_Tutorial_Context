package org.dohuacode.spring.configuration.xmlconfig;

public class Cat implements Pet {
    public  Cat(){
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

