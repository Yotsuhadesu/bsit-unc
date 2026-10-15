# Day 2 - Pages 103-154

## Concepts
1. Concatenation Operator
2. Pre and Post Decrement/Increment
3. Java Operators
4. Bitwise, Logical, Assignment, Ternary, and other Operators
5. Operator Precedence
6. Type-Casting
7. Display output using System.out
8. Predefined Libraries
9. Classes and Objects
---
### Concatenation Operator
- The `+` operator is the only overloaded operator in Java.
- It concatenates strings and adds digits.

        String archonAge = "Lesser" + "Lord" + "Kusanali" + ":" + 250 + 250;   
        // Lesser Lord Kusanali:250250
        String realArchonAge = 250 + 250 + ":" + "Lesser" + "Lord" + "Kusanali";
        // 500:Lesser Lord Kusanali
- Java reads from left to right. If the first values are strings, the succeeding values gets treated as a string.
---
### Pre and Post Decrement/Increment
1. Pre-Increment 

        int x = 1;
        System.out.println(++x); 
        // prints 2
        // x = 2
2. Pre-Decrement

        int x = 1;
        System.out.println(--x); 
        // prints 0
        // x = 0
3. Post-Increment

        int x = 1;
        System.out.println(x++); 
        // prints 1
        // x = 2
4. Post-Decrement

        int x = 1;
        System.out.println(x--); 
        // prints 1
        // x = 0

Challenge:

    int x = 10;
    System.out.println(x++);
    System.out.println(x);
    System.out.println(++x);

Result:

    10  // print current value of x then add 1
    11  // print current value of x
    12  // add 1 and print the value of x after
---
### Java Operators
- Arithmetic Operators
    - `/`, `*`, `%`, `-`, `+`
    - max(int, datatype a, datatype b)
        - if operating between smaller datatypes (short, byte), int will be the datatype
        - however, if operating between larger datatypes (long, float, double), the datatype will be the highest datatype
    - Arithmetic Exception
        - runtime exception
        - can only be thrown by integral types
        - only `/` and `%` throws this exception, like dividing by 0
- Relational Operators
    - `>`, `<`, `>=`, `<=`
    - compares actual values of primitive types, except boolean
    - cannot compare Strings as they are objects
    - returns boolean
    - cannot be nested
- Equality Operators
    - `!=`, `==`
    - compares memory addresses between objects, such as Strings
    - compares actual values between primitive values
    - returns boolean
- `instanceof` Operator
    - checks if an object is from a certain class
    - Example:

            Scanner scanner = new Scanner(System.in);
            System.out.println(scanner instanceof Scanner); // true
---
### Bitwise, Logical, Assignment, Ternary, and other Operators
- Bitwise Operators
    - `|`, `&`, `^`, `~`
    - can be used for any integral values and boolean (except for `~`)
- Logical Operators
    - `||`, `&&`, `!`
    - can only be used for boolean values or expressions
    - Short-Circuit Behavior 
        - `||` -  skips succeeding conditions if a true condition is met
        - `&&` -  skips succeeding conditions if a false condition is met
- Assignment Operator
    - `=`
    - Types of assignment:
        1. Simple Assignment

                int x = 0;
        2. Chained Assignment

                int a;
                int b=a=2;  // a = 2 and b = 2
                int x = 2, y = 3, z = 4;
        3. Compound Assignment

                int x = 0;
                x += 1; // x = 1
            - `+=`, `-=`, `/=`, `*=`, `%=`
            - `|=`, `&=`, `^=`
            - `>>=`, `<<=`, `>>>=`
- Ternary Operator
    - `?:`
    - Syntax: 
        - `datatype variable = (boolean_expression) ? value1 : value2;`
        - the variable gets assigned with value1 if the boolean expression is true and it will be assigned with value2 if false
- `new` operator
    - creating objects/instance of a class
    - Syntax: `Scanner scanner = new Scanner();`
- `[]` operator
    - creating arrays
    - Syntax: `datatype [] variable = new datatype[length];` or `datatype [] variable;`

            int[] arr = new int[5];
            int[][] matrix = new int[5][5];
---
### Operator Precedence
1. Unary Operators: `~`, `++`, `--`, `!`, type-cast
2. Arithmetic Operators: `/`. `%`, `*`
3. Arithmetic Operators: `+`. `-`
4. Shift Operators: `>>`, `<<`, `>>>`
5. Relational Operators: `>`, `<`, `>=`, `<=`
6. Equality Operators; `==`, `!=`
7. Bitwise Operators: `&`, `|`, `^`
8. Logical Operators: `&&`, `||`
9. Ternary Operator: `?:`
---
### Type Casting
- Converting a datatype to a related datatype
- Types:
    1. Implicit Typecasting
        - Widening
        - Processed by the compiler

                byte b = 1, y = 2;
                int i = b + y;
    2. Explicit Typecasting
        - Narrowing
        - Stated by the programmer

                int i = 1, j = 2;
                byte b = (byte) (i + j);
Implicit  | Datatype | Explicit 
--- | --- | --- 
^ | double | \|
\| | float | \|
\| | long | \|
\| | int | \|
\| | short, char | \|
\| | byte | ⌄
---
### Display output using System.out
1. System.out.print()

        System.out.print("Hello ");
        System.out.print("World!");
        // Hello World!
2. System.out.println()

        System.out.println("Hello");
        System.out.println("World!");
        // Hello 
        // World!
3. System.out.printf()

        String greet = "Hello", receive = "World";
        System.out.printf("%s %s!", greet, receive);
        // Hello World!
---
### Predefined Libraries
- readily available packages and classes for development
- API Description
    - documentation/description of a class/package
    - field summary
    - method summary
    - constructor summary
- Fully Qualified Name use

        java.util.Scanner scanner = new java.util.Scanner(System.in);
- Import them in order to use
    1. Explicit Import
        
            import java.util.Scanner;   // importing the Scanner class
    2. Implicit Import

            import java.util.*; // importing the util package and the classes inside it
        - is discouraged because there might be a name conflict between classes of the same name
    3. Static Import

            import static java.lang.System.out; 
            // out.println() instead of System.out.println()
- `java.lang` and your current package doesn't need to be imported
---
### Classes and Objects
- Classes consists of fields, contructors, or methods
- Can be called using its name if a field/method is static 

        double tiles = Math.ceil(tilesNeeded);
- Create an object to create an instance of a class
- Object is a reference variable

        Scanner scanner = new Scanner(System.in);
        // this creates an instance of the Scanner class called scanner
- Commonly used classes:
    1. Math Class - a class with static fields and methods used for mathematical operations
    2. Random Class - a class for generating random digits
    3. Scanner Class - a class that parses primitive values and strings for input