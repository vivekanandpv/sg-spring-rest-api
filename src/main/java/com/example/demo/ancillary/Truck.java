package com.example.demo.ancillary;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("heavy")
public class Truck implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Truck is driving...");
    }
}
