package org.dohuacode.spring.configuration.Jcode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJcode {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext jcodecontext = new AnnotationConfigApplicationContext (Config.class);

        //get pet from bean
        Pet pet = jcodecontext.getBean("catBean", Cat.class);
        pet.sound();
        System.out.println("-------------------------------");
        //Person with constructor dependency autowired
        PersonJconfig personAnn = jcodecontext.getBean("personBean", PersonJconfig.class);
        personAnn.callPet();
        //System.out.println(personAnn.getName());
        jcodecontext.close();

    }
}
