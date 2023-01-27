package com.springsandbox.keepers;

import com.springsandbox.pets.Pet;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class PetKeeper {

    @Value("${keeper.surname}")
    private String surName;
    @Value("${keeper.age}")
    private int age;
    private Pet pet;

    public PetKeeper() {

    }

    @Autowired
    public PetKeeper(@Qualifier("dog") Pet pet) {
        this.pet = pet;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void callPet() {
        pet.say();
    }

    @PostConstruct
    public void init() {
        System.out.printf("\nPetkeeper %s initialized\n", this.surName);
    }

    @PreDestroy
    public void destroy() {
        System.out.printf("\nPetkeeper %s destroyed\n", this.surName);
    }

    @Override
    public String toString() {
        return "Surname: " + this.surName + "\nAge: " + this.age + "\nKind of pet: " + pet.getClass().getName();
    }
}
