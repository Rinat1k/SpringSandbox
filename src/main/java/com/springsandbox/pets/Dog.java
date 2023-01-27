package com.springsandbox.pets;

import org.springframework.stereotype.Component;
@Component
public class Dog implements Pet {

    @Override
    public void say() {
        System.out.println("Woof-woof!");
    }
}
