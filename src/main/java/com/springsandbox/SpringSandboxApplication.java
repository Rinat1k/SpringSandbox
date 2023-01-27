package com.springsandbox;

import com.springsandbox.keepers.PetKeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSandboxApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        var petKeeper1 = context.getBean("petKeeper", PetKeeper.class);
        petKeeper1.setSurName("Messi");

        var petKeeper2 = context.getBean("petKeeper", PetKeeper.class);
        petKeeper2.setSurName("Ronaldo");

        context.close();
    }

}
