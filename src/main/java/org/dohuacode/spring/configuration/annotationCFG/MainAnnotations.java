package org.dohuacode.spring.configuration.annotationCFG;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotations {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext contextannotations = new ClassPathXmlApplicationContext("ApplicationContextAnnotations.xml");

        //get pet from bean
        Pet pet = contextannotations.getBean("catBean", Cat.class);
        pet.sound();
        System.out.println("-------------------------------");
        //Person with constructor dependency autowired
        PersonAutowired personAnn = contextannotations.getBean("personBean", PersonAutowired.class);
        personAnn.callPet();
        System.out.println(personAnn.getName());
        contextannotations.close();

    }
}
