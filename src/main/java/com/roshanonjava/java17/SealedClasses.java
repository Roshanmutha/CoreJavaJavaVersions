package com.roshanonjava.java17;
/*
 * Sealed classes and interfaces restrict which other classes or interfaces may extend or implement them. This feature provides a more declarative way to control the inheritance hierarchy and can help improve code maintainability and security.
 *
 * A sealed class or interface is declared using the `sealed` modifier, and it must specify which classes or interfaces are permitted to extend or implement it using the `permits` clause.
 *
 * Example:
 * Sealed vs Other Modifiers
Modifier	Meaning
final	No subclasses allowed
sealed	Only specific subclasses allowed
non-sealed	Removes restriction for that subclass
*
* *******Note -  We have sealed interfaces in same way.
 */
public class SealedClasses {

    static void main() {
        VehicleSealed vehicle = new Car();
        System.out.println(vehicle.getClass().getName());
        VehicleSealed vehicle1 = new Bike();
        System.out.println(vehicle1.getClass().getName());

    }

}
