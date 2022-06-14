package org.dohuacode.spring.configuration.annotationCFG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personBean")
public class PersonAutowired {
    @Autowired  // DEPENDENCY WITH FIELD SET
    @Qualifier("rabbitBean") // set bean foe dependency if many classes
    // @Scope("singleton"/"prorotype")
    private Pet pet;
    //@Value("kozlov") //set value HARDCODED
    @Value("${person.name}")
     private  String name;

    // VIA CONSTRUCTOR
      /*
    @Autowired
    public PersonJconfig(@Qualifier(catBean) Pet pet){
        System.out.println("CONSTRUCTOR  PET");
        this.pet = pet;
    }
 */
    //VIA SETTER
  /*
    @Autowired
    @Qualifier(catBean) // sam like field injection
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
