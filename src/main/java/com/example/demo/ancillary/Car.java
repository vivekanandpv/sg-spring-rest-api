package com.example.demo.ancillary;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"light", "fast & foo"})
public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Car is driving...");
    }
}
