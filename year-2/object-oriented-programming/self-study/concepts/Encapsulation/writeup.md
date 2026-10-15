# Concept: Encapsulation

## What is encapsulation?
Encapsulation is the principle of making fields, variables inside a class, directly untouchable to users outside the class by assigning it with the `private` keyword.

## Why implement it?
If fields were `public` instead of `private`, the users of the program will have the ability to directly manipulate the values of the field. 
For example, in a banking program, the field,

            public double balance;
allows the user to execute the code,

            user.balance = 99999;

which would give the user a balance of 99999 out of thin air. This would be disastrous since you can't just dictate how much money you have in real life, at least for me.

## Setters vs. real methods
- Setters - methods that are used for assigning values to fields

            user.setBalance(500);
- 'Real' methods - blocks of code that performs a specific functionality.

            user.deposit(500);
            user.deposit(500);
The generic setter enables the user to dictate how much balance he has, while the 'real' methods allows them to change their balance via programmer intended processes.

## What it protects against?
- Garbage Inputs (valid but bad), such as;
    1. Blank/Null Input Strings
    2. Negative Inputs

## Where it shows up elsewhere?
1. Age processing program using birthdays
2. Number of copies of a book in a library program
3. A program that counts the score of a student on an exam

## Teach it
Encapsulation is a concept in Object Oriented Programming that encourages program designs that doesn't allow users besides the creator to put or change values from a container. Games that has currency or keeps track of scores uses this concept.