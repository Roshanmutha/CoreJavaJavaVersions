package com.roshanonjava.java17;

public sealed class VehicleSealed permits Car, Bike {
        private String name;
        private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void start() {
            System.out.println("Vehicle started");
        }
}
