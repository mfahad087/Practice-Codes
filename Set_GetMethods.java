// public class Main {
    
// }
class Car {
    // Instance variables
    private String color;  // Private for encapsulation
    private int speed;

    // Set method for color
    public void setColor(String newColor) {
        color = newColor;
    }

    // Set method for speed
    public void setSpeed(int newSpeed) {
        if (newSpeed >= 0) {
            speed = newSpeed;
        } else {
            System.out.println("Invalid speed!");
        }
    }

    // Get method for color
    public String getColor() {
        return color;
    }

    // Get method for speed
    public int getSpeed() {
        return speed;
    }
}

public class Set_GetMethods{
    public static void main(String[] args) {
        // Create a Car object
        Car myCar = new Car();

        // // Set values using set methods
        myCar.setColor("Red");
        myCar.setSpeed(100);

        // Get values using get methods
        System.out.println("Car Color: " + myCar.getColor());
        System.out.println("Car Speed: " + myCar.getSpeed());
    }
}


// Instance Variables

// What are they?

// Instance variables are variables declared inside a class but outside any method.
// They belong to an object (instance) of the class.
// Each object has its own copy of these variables.


// Why use them?
// They store the state (data) of an object.

//---------------------------------------------------------------------



// Set Methods (Setters)

// What are they?
// Set methods (also called setters) are used to assign values to instance variables.
// They are usually public and have a void return type.

// Why use them?
// To control how values are assigned to instance variables (e.g., validation).       
// To follow the principle of encapsulation (hiding the internal details of a class).

//---------------------------------------------------------------------



// Get Methods (Getters)

// What are they?

// Get methods (also called getters) are used to retrieve the values of instance variables.
// They are usually public and have a return type that matches the variable they are accessing.

// Why use them? 
// To allow controlled access to the instance variables.
// To follow the principle of encapsulation