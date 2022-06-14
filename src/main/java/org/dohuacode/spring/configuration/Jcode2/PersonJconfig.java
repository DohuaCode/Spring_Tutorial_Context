package org.dohuacode.spring.configuration.Jcode2;

import org.springframework.beans.factory.annotation.Value;


public class PersonJconfig {

    private Pet pet;
    //@Value("kozlov") //set value HARDCODED
    @Value("${person.name}")
     private  String name;

    // VIA CONSTRUCTOR


    public PersonJconfig( Pet pet){
        System.out.println("CONSTRUCTOR  PET");
        this.pet = pet;
    }

    //VIA SETTER
  /*


    public void setPet(Pet pet) {
        System.out.println("SET PET");
        this.pet = pet;
    }
   */

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
