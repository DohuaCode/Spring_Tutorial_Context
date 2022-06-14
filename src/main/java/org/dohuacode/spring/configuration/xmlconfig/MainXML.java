package org.dohuacode.spring.configuration.xmlconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXML {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext contextconstructor = new ClassPathXmlApplicationContext("ConstructorDependency.xml");

        //get pet from bean
        Pet pet = contextconstructor.getBean("pet",Pet.class);
        pet.sound();

        //get person with cat inside, dependency in appcontext
        PersonConstructor personconstructor = contextconstructor.getBean("person", PersonConstructor.class);
        personconstructor.callPet();
        contextconstructor.close();
        System.out.println("-------------------------------");

        ClassPathXmlApplicationContext contextsetter = new ClassPathXmlApplicationContext("SetterDependency.xml");

        //get person with cat inside, dependency in appcontext
        PersonSetter personsetter = contextsetter.getBean("person", PersonSetter.class);
        personsetter.callPet();

        System.out.println(personsetter.getName());

        contextsetter.close();
        System.out.println("-------------------------------");

        ClassPathXmlApplicationContext contextsetterprop = new ClassPathXmlApplicationContext("SetterDependencyProperties.xml");

        //get person with cat inside, dependency in appcontext
        PersonSetter personsetterproperty = contextsetterprop.getBean("person", PersonSetter.class);
        personsetterproperty.callPet();

        System.out.println(personsetterproperty.getName());

        contextsetterprop.close();

    }
}
