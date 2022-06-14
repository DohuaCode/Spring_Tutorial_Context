package org.dohuacode.spring.configuration.xmlconfig;

public class PersonConstructor {
    private Pet pet;
    private  String name;

    public PersonConstructor(Pet pet){
        System.out.println("created PERSON in constructor");
        this.pet = pet;
    }

    public void callPet(){
        System.out.println("hey pet");
        pet.sound();
    }
    public void setName(String name) {
        System.out.println("SET NAME");
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
