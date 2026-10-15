# Concept: Composition

## What is Composition?
Composition is an OOP concept a class contains intance(s) of another class(es).

## Why Implement It?
It is implemented for compiling related classes into a single class so that we only have to create a single object to perform specific functionalities across those classes. Furthermore, data will be compiled into a single object for efficiency and organization.

## How It Works?
1. Create 2 or more related classes 
2. Decide which class will be used to compile those related classes
3. Create class objects to that class
4. Initialize the objects in that class or the Main class

        Sample Demo:
        // First Java file
        public class Restaurant {
            private Chef chef = new Chef();
            private Customer customer = new Customer();

             public void serve() {
                customer.order();
                chef.startCooking();
            }
        }
        // Second Java file
        public class Chef {
            public void startCooking() {
                System.out.println("The chef is cooking.");
            }
        }
        // Third Java file
        public class Customer {
            public void order() {
                System.out.println("The customer has an order.")
            }
        }
        // Main Class
        public class Main {
            public static void main(String[] args) {
                Restaurant restaurant = new Restaurant();
                restaurant.serve();
            }
        }
        // Output
        The customer has an order.
        The chef is cooking.