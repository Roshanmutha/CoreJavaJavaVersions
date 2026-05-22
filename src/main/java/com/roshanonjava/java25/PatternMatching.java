package com.roshanonjava.java25;

import com.roshanonjava.java17.Bike;
import com.roshanonjava.java17.Car;
import com.roshanonjava.java17.VehicleSealed;

public class PatternMatching {

    static void main() {
        showVechile(new Car());
        showVechile(new Bike());
    }

    static void showVechile(VehicleSealed vehicle) {
        switch ( vehicle) {
            case Car c -> System.out.println("This is a car");
            case Bike b -> System.out.println("This is a bike");
            default -> System.out.println("Unknown vehicle");
        };
    }


}
