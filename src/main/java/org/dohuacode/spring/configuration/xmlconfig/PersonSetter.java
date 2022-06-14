package org.dohuacode.spring.configuration.xmlconfig;

public class PersonSetter {
    private Pet pet;
    private  String name;

    public void setPet(Pet pet) {
        System.out.println("SET PET");
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
