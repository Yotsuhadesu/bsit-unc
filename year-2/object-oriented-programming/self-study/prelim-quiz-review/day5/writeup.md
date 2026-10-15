# Day 5 - Pages 220-255
## Contents
1. StringBuilder
2. Method Chaining
3. Wrapper Classes
4. Wrapper Class Utility Methods
5. Autoboxing and Autounboxing
--- 
### StringBuilder
- mutable and manipulates strings in place
- StringBuilder vs String
    - use String when the input is fixed
    - use StringBuilder if the string needs to be modified frequently and doesn't require thread safety
---
### Method Chaining
- using 2 or more methods in a command/process

        String s = "I hate Java";
        s = s.toUpperCase().replace("HATE", "LOVE").concat(" PROGRAMMING");
        System.out.println(s);
        // I LOVE JAVA PROGRAMMING  
---
### Wrapper Classes
- wrapping primitive data types into objects
- Purpose:
    - to use collections that require classes
    - to use several utility methods for primitives

Primitives | Wrapper Classes
--- | ---
byte | Byte
short | Short
int | Integer
long | Long
float | Float
double | Double
char | Character
boolean | Boolean
---
### Wrapper Class Utility Methods
1. `valueOf()` - creates a wrapper object from a primitive
2. `xxxValue()` - convert a wrapper object to a primitive
3. `parseXxx()` - convert a String to a primitive
4. `toString()` - converts a wrapper object to a string
---
### Autoboxing and Autounboxing
- Autoboxing 
        
        Integer i = 10;
        During compilation:
        integer i = Integer.valueOf(10);

- Autounboxing

        Integer i = 10;
        int n = i;
        During compilation:
        int n = i.intValue();
