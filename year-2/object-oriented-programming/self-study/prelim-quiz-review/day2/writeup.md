# Day 2 pages 42-102
## Sections
1. Java Program Basic Structure
2. Java Identifiers, Keywords, and Datatypes
3. Java Literals
4. Java Variables
5. Java Memory Addresses and the `final` keyword
---
### Java Program Basic Structure
- It can have multiple classes but one public class at most, with the same name as the source file.
- Pascal-Case Naming Convention 
    - used for naming classes in Java
    - the first letter of every word is in uppercase
    - ex. JavaProgram
- One-Class-per-File Convention - one class per source file for readability
- Java Comments
    1. Single-Line Comments

            // This is a single-line comment
    2. Multiline Comments

            /*
                This is a
                multiline comment
            */
    3. Javadoc Comments

            /**
            * @title: Javadoc Comment
            * @description: Show a javadoc comment
            * @author: Elano, Jethro B.
            */
- Package - an encapsulation mechanism that bundles related classes and interfaces into a single module for resolving naming conflicts, modularity, and security
    - Stucture: `package domaintype.organization.module.submodule;`
            
            package com.unc.oop.activities;
- the  `main()` method
    - used by JVM to know where to start in executing the program
    - Structure: `modifiers void main(String[] parameters)`
    - Common Structure: 
    
            public static void main(String[] args)
        - `public` - accessible outside the class
        - `static` - can be used without an object
        - `void` - doesn't return anything
        - `String[] args` - array of Strings
    - Other valid variations:

            static public void main(String[] args)
            public static synchronize strictfp void main(String[] args)
            public static final void main(String[] args)
            public static void main(String... args)
    
    - Quiz

            Tell if valid or invalid main() methods.
            1. public static void main(String args){ }
            2. public syncronized final strictfp void
            main(String[] args){ }
            3. public static void main(String… args){ }
            4. public static int main(String[] args){ }
            5. public static syncronized final strictfp void
            main(String… args){ }
            6. public static void main(String… args){ }
            7. public void main(String args[]){ }
            8. static public void main(String[] args){ }
            9. public static syncronized void main(String[] a){ }
            10. static public final main(String []june){ }
        - Answers
        
                1. invalid, the parameter isn't an array of Strings
                2. invalid, no `static` keyword and wrong spelling of `synchronized` keyword
                3. valid, parameter as var-args
                4. invalid, the main method isn't expected to return anything
                5. invalid, wrong spelling of `synchronized` keyword
                6. valid, parameter as var-args
                7. invalid, no `static` keyword
                8. valid, this is accepted by JVM
                9. invalid, wrong spelling of `synchronized` keyword
                10. invalid, no returntype
---
### Java Identifiers, Keywords, and Datatypes
- Identifiers 
    - names in Java (classes, variables, objects, etc.)
    - Rules:
        - accepts a-z and A-Z characters, digits, `_`, and `$`
        - doesn't start in digit
        - case-sensitive 
        - doesn't accept keywords
- Keywords - words that serve specific purposes in Java, such as keywords for;
    1. Datatypes - `int`, `boolean`, and etc.
    2. Exception Handling - `try`, `catch`, and etc.
    3. Flow Control - `for`, `while`, and etc.
    4. Objects - `new`, `this`, and etc.
    5. Classes - `synchronized`, `strictfp`, and etc.
    6. the `void` return type
    7. Unused (`const`and `goto`)
    8. Reserved Literals - `null`, `true`, and `false`
    9. Modifiers - `public`, `static`, and etc.
    10. `enum` keyword
- Datatypes
    - Integer Values:
        
        | Data Type | Bit size | Value Range | Default Value |
        | --- | --- | --- | --- | 
        | `byte` | 8 | -2^7 - 2^7-1 | 0 | 
        | `short` | 16 | -2^15 - 2^15-1 | 0 | 
        | `int` | 32 | -2^31 - 2^31-1 | 0 |
        | `long` | 64 | -2^63 - 2^63-1 | `0L` |
    - Floating-Point Values:

        | Data Type | Bit size | Default Value |
        | --- | --- | --- |
        | `float` | 32-bit IEEE 754 | `0.0F` | 
        | `double` | 64-bit IEEE 754|  0.0 | 
    - Boolean Values: `boolean` - `false` is the default value
    - Character Values: `char` - a 16-bit Unicode character
---
### Java Literals
- constant values that are assigned for datatypes
1. Integral Literals 
    - assigning `int`, `byte`, `short`, and `long`
    1. Decimal 
        - any digits are accepted
            
                int x = 10;
    2. Octal 
        - prefix with `0`
        - 0-7 are the only accepted digits

                int x = 010;
    3. Hexadecimal 
        - prefix with `0x` or `0X`
        - Allowed: `a`-`f` or `A`-`F` and digits from `0`-`9`
                
                int x = 0x010;
2. Floating-point Literals
    - assigning `float` and `double`
    - default value is treated as `double`
    - accepts decimal, octal, and hexadecimal (same as integral types) 
    1. `float`
        - suffix with `f`/`F`

                float f = 123.456f;

    2. `double`
        - accepts suffix with `d`/`D`

                double d = 123.456;
                double d = 123.456d;
                double d = 123.456D;
3. Boolean Literals
    - `false` is the default value
    - only accepts `true` or `false`
4. Character Literals
    - the single character needs to be enclosed in single quotes

            char c = 'C';

    - accepts integral literals that corresponds to characters in Unicode

            char c = 65;
    - accepts Unicode representation of a character
    - integral literals accepts characters that are represented by digits 

            int i = 'A';

    | Escape Characters | Meaning |
    | --- | --- | 
    | `\t` | tab |
    | `\b` | backspace |
    | `\n` | newline |
    | `\'` | singe quote |
    | `\"` | quotation mark |
    | `\r` | carriage return |
    | `\\` | backslash |
5. String Literals
    - needs to be enclosed in quotation marks

            String s = "This is a string literal.";
6. Binary Literals
    - accepts `0`s and `1`s and uses `0b`/`0B` as a prefix

- The `_` 
    - used for separating digits for readability of the source code 
    - compiler removes it at compilation

            int x = 123_456;
---
### Java Variables
- Variable - an identifier for container
    - Structure: 
        - Creating a variable: 
                
                [optional modifier] [datatype] [variable name];  
        - Creating and initializing a variable

                [optional modifier] [datatype] [variable name] = [value];   // one variable
                [optional modifier] [datatype] [variable name] = [value], [variable name] = [value];   // two or more variable
- Initialization - act of assigning the first value to a variable
- Dynamic Initialization - the variable is assigned with a value at runtime
- Types:
    1. Based on value represented
        - Primitive variable - represents the value itself
        - Reference variable - refers/points to the location of the value
    2. Based on position and behavior
        1. BLock variable - variable inside a method
        2. Instance variable - variable inside a class and shared with methods
        3. Static variable - variable inside a class but is not accessible to non-static methods
---
### Java Memory Addresses and the `final` keyword
- Java Memory Areas
    - Method Area - static variables and other class-level data
    - Heap Area - instance variables
    - Stack Memory - runtime methods and local variables
    - PC Register - store instructions to execute next
    - Native Method stack - native method inocations
- `final` keyword - used to effectively create a constant variable

        final static double pi = 3.14;