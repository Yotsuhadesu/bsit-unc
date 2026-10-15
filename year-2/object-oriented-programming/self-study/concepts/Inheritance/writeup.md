# OOP Concept: Inheritance

## What is Inheritance?
Inheritance is an OOP concept where classes has a relationship called `Is-A`. It is where a subclass, or a child class, gets or inherits the fields, constructors, and methods inside a parent class.

## How do I implement it?
By using the keywords;
1. `extends`- allows you to make a class a subclass of another class

        parent class
        class ChessPiece {  // parent class

        }
        // subclass
        class Knight extends Chesspiece { 

        }
2. `super` - used in the subclasses and refers to the immediate parent class, its fields, constructors, and methods.

        // parent class
        class ChessPiece {
            // field
            String color;
            // constructor
            ChessPiece(String color) {
                this.color = color;
            }
            void move() {
                System.out.println("Unknown piece.");
            }
        }
        // subclass
        class Knight extends Chesspiece {
            Knight(String color) {
                super(color);   // refers to the parent class's constructor
            }
            @Override
            void move() {
                System.out.println("The knight moves in an L-shaped path.)
                super.move();   // refers to the parent class's move() method
            }
            void setColor(String color) {
                super.color = color;    // super.color refers to the color field of the parent class
            }
        }

## Method Overriding
Method overriding happens when the subclasses has a method that has the exact method signature to an existing method from the parent class.

        // parent class
        class ChessPiece {
            //method
            void move() {
                System.out.println("The piece has moved.");
            }
        }
        // subclass
        class Knight extends ChessPiece {
            @Override
            void move() {
                System.out.println("The knight moved in an L-shaped path.");
            }
        }

## Notes
- If the subclass doesn't have a constructor, Java would try to insert `super();`. However, the parent class must have a no-arg constructor to avoid compile-error.
- You can make multiple subclasses from a single parent class, this is called `Hierarchical Inheritance`. Each subclass contains separate elements of the parent class.
- In Java 25, the `super(...)`, which refers to the parent class's contstructor, need not to be the first line of code of the subclass's constructor, which wasn't the case before. However, you aren't allowed to access the elements of the subclass before `super(...)` is called, as the parent's elements weren't fully constructed yet.

## Why implement it?
- The parent class's fields, constructors, and methods can be used and modified by the subclasses.
- Easier debugging, especially for larger programs that contains plenty of classes.
- Shorten the length of each subclass.