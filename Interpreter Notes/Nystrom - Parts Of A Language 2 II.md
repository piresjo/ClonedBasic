# Different Aspects Of Languages

## Dynamic Typing

Most contemporary languages use dynamic typing. In other words, you don't need to explicitly state the type of the value.
In fact, a variable can hold values of different types at different times.

### Aside - Static Typing

Languages like Java and C use static typing; the type is explicitly written. This book won't be covering it, however.
I'll have to look into this, however, since QBasic uses it.

## Automatic Memory Management

This allows automated freeing and allocation of memory. In particular, it's good for freeing memory.

There are two forms of automated memory management that are commonly used: reference counting and garbage collection. The flexibility
that garbage collection provides lends it to being more commonly used.

## Data Types

### Booleans

True and False values, usually represented by their own literals.

### Numbers

These can be split into different categories (integers, floating point). This can also be split into unsigned integers,
numbers represented by a varying number of bits (ex. `int8_t` in C).

With more advanced languages, there is a lot of syntax to represent numbers in various ways (eg. in hex, in binary, 
in scientific notation).

The language used in the book I'm taking these notes from (Lox) only has one type: double floating points.

### Strings

Often an array of characters, string literals can be represented in a variety of ways. In Lox (the language created in the book) and QBasic, double
quotes are used.

### Nil

Used to represent things without value.

## Expressions

### Arithmetic

The standard `+`, `-`, `*`, `/`. Languages often have more support (`//` for integer division, `%` for modulo, `^` for exponents, etc.)

You can also have prefix operators, like negating (`-`)

### Comparison and Equality

The standard `==`, `<`, `>`, `>=`, `!=`, `<=` Are usually represented

Some have differing forms of equality (eg. `==` vs `===` in JS). Others differ the symbols (eg. QBasic uses `<>` instead of `!=`)


### Logical Operators

The standard `!`, `&&`, `||` are supported usually.

Sometimes these are represented by their written out equivalents (`NOT`, `AND`, `OR`)

### Precedence and Grouping

Usually PEMDAS is followed, with parentheses taking precedence.

## Statements

Expressions produce values; statements produce effects

### Closures

In some languages, functions are first class. That is, they are values that can be pass around and referenced.

This can lead functions that can take advantage of values declared outside its body.

## Classes

### Object-Oriented Languages

### Classes Or Prototypes

Outside of JS and Swift, bog-standard classes are more commonly used. These entail instances and classes. Classes act as the "blueprint" of an object. Instances are objects formed from the classes.

With JS, however, prototypes started becoming more popular. With Prototypes, there are only objects/instances. Both state and methods are held in objects, and you can append new functionality to a specific object.

### Instantiation And Initialization

### Inheritance

## The Standard Library

