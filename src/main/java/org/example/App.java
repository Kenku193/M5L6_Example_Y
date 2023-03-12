package org.example;


import org.example.entity.Human;
import org.example.repository.CarRepository;
import org.example.repository.HumanRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");

        var humanRepository = context.getBean(HumanRepository.class);
        var carRepository = context.getBean(CarRepository.class);

        var someHuman1 = humanRepository.findById(1L).orElseThrow();
        var someHuman2 = humanRepository.findById(2L).orElseThrow();

        System.out.println(someHuman1);
        System.out.println(someHuman2);

        System.out.println("-".repeat(50));

        //carRepository.updateOwner(1L, 2L);

        // FIND ALL
         humanRepository.findAll().forEach(System.out::println);

        // FIND BY NAME
         humanRepository.findByName("Anya").forEach(System.out::println);

        // COUNT
         System.out.println(humanRepository.count());

        // UPDATE BALANCE
        // humanRepository.updateBalance(someHuman, BigDecimal.ZERO);


    }
}
