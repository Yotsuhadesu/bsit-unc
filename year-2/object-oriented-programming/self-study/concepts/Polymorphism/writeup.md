# Concept: Polymorphism

## What is Polymorphism?
- Polymorphism is an Object-Oriented Programming principle that literally means "many forms," where a piece of code or method performs different functionalities depending on the parameter or the class it is in.
- Real-world Analogy: An airconditioner with a built in heater that cools the room during summer and warms the room during winter.

## Types of Polymorphism
1. Compile-Time Polymorphism (Method Overloading)
    - same method name but different parameter type, order, and count.

            public static void greet() {
                System.out.print("Hello! Isn't it a nice day?")
            }
            public static void greet(String name) {
                System.out.printf("Hello %s! Isn't it a nice day?", name)
            }
2. Runtime Polymorphism (Method Overriding)
    - methods with the same signature (method name and parameter(s)) between the parent and its subclass(es)

            // parent class method
            public void greet() {
                System.out.print("Hello! Isn't it a nice day?")
            }
            // subclass method
            @Override
            public void greet() {
                System.out.print("Hello! Isn't it a nice evening?")
            }
## Why implement it?
- Adaptable and flexible method: Use the same method or method name to do unique functionalities based on the parameters given instead of creating separate methods that basically does the same thing. 
- Save Resources: Use a method that does different functionalities based on the class it is in. 