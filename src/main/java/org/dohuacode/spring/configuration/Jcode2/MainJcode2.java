package org.dohuacode.spring.configuration.Jcode2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJcode2 {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext jcodecontext = new AnnotationConfigApplicationContext (Config.class);

        //get pet from bean
        Pet pet = jcodecontext.getBean("catBean", Pet.class);
        pet.sound();
        System.out.println("-------------------------------");

        PersonJconfig personjconfig = jcodecontext.getBean("personBean", PersonJconfig.class);
        personjconfig.callPet();
        System.out.println(personjconfig.getName());
        jcodecontext.close();

    }
}
