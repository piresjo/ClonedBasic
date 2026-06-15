# Basic Overview Of How QBasic Operates

## Typing

QBasic uses static typing

```
DIM a AS STRING
DIM b AS INTEGER
DIM c AS LONG
DIM d AS SINGLE
DIM e AS DOUBLE
```

## Automatic Memory Management

Given everything I've read about QBasic, there is automatic memory management.

For this project, it might be worth going all the way and handle full garbage collection.

## Data Types

### Booleans

I would assume that QBasic would have it, although I need to find documentation.

That said, QB64 definitely has it:

```
CLS
 booltrue = true
 boolfalse = false
 
 print booltrue
 print boolfalse
```

Regardless, for this project, there will be booleans.

### Numbers

There are a few subcategories of numbers

``` 
INTEGER 	A 16-bit signed integer variable.
LONG 	A 32-bit signed integer variable.
SINGLE 	A single-precision floating-point variable.
DOUBLE 	A double-precision floating-point variable.
```

### Strings

These exist and are represented between double quotes.

``` 
DIM a AS STRING
```

### Nil

It doesn't seem like Nil is a thing (which it seems odd)

## Expressions

### Arithmetic

Basic arithmetic is supported:

``` 
 CLS
 
 'Set a-d to initial values
 a = 10
 b = 6
 c = 3.1415
 d = 3.333333
 
 e = a + b
 PRINT a; "+"; b; "="; e
 
 f = c * d
 PRINT c; "x"; d; "="; f
 
 g = b - c
 PRINT b; "-"; c; "="; g
 
 h = b / d
 PRINT b; "/"; d; "="; h
 
 i = INT(d)
 PRINT "Remove the decimal from "; d; "="; i
```

### Comparison and Equality

`=` is used for equality. `<=` `>=` `>` `<` are used for comparison.

### Logical Operators

`AND` `OR` and `NOT` are used for that. However, it seems like `&&`, `||`, and `!` are supported.

Here are the logical operators

``` 
NOT 	Logical complement
AND 	Conjunction
OR 	Disjunction (inclusive "or")
XOR 	Exclusive "or"
EQV 	Equivalence
IMP 	Implication
```

### Precedence and Grouping

Standard order of operations are followed, with parentheses taking precedence.


## Variables

You can set variables using `DIM`. However, it looks like you can declare variables Python style

## Control Flow

QBasic supports `IF`, `ELSE`, `ELSEIF`. A block that uses these three is as follow:

``` 
CLS
DIM a AS INTEGER

a = 6

IF a > 5 && a <= 10 THEN 
    PRINT "BETWEEN" 
ELSEIF a > 0 && a <= 5 THEN 
    PRINT "BELOW 5" 
ELSE 
    PRINT "GREATER THAN 10"
ENDIF
```

For loops are supported:

``` 
num = INT(RND * 20) + 1

 FOR count = 1 TO 5
  INPUT "Pick a number between 1 and 20: ", answer
  IF answer = num THEN PRINT "You win after";count;"guesses!": END
 NEXT
 PRINT "You lose"
```

The for loop specifically is:

``` 
 FOR count = 1 TO 5
  INPUT "Pick a number between 1 and 20: ", answer
  IF answer = num THEN PRINT "You win after";count;"guesses!": END
 NEXT
```

While loops can be written two ways. The first is a while loop; the second is more of a do...while loop.

The while loop is written as such

``` 
 WHILE <condition is true>
   [do this]
   ..
   [and this]
 WEND
```

The do...while loop is written as such

``` 
 DO
   [this]
   ..
   [and this]
 LOOP WHILE <condition is true> / LOOP UNTIL <condition is true>
```

Switch casing is also supported. Here's an example of that:

``` 
CLS
PRINT "WELCOME"
PRINT "I HAVE AN ANSWER FOR ANY OF YOUR QUESTIONS"
10 INPUT "WRITE YOUR QUESTION AND I'LL GIVE YOU AN ANSWER ", question$
RANDOMIZE TIMER
PRINT
answer = INT(RND * 4 + 1)
SELECT CASE answer
    CASE 1
        PRINT "PLEASE REPHRASE YOUR QUESTION."
    CASE 2
        PRINT "YOUR QUESTION IS MEANINGLESS."
    CASE 3
        PRINT "DO YOU THINK I CAN ANSWER THIS?"
    CASE 4
        PRINT "THIS QUESTION LOOKS FUNNY."
END SELECT
PRINT
PRINT "ENTER ANOTHER QUESTION", K$
GOTO 10
```

## Functions

In the world of QBasic, functions are split into procedures (which don't return anything) and
functions (which do return something).

The statements `GOTO` and `GOSUB` also exist.

The GOTO statement is simple; it just moves the execution point to a given Label:

The GOSUB statement transfers control to a given Label, however when a RETURN statement is encountered, execution returns to the line following the GOSUB statement. Any changes made within the GOSUB will be to actual variables used within the 'main' code.

There is error handling in the form of `ON ERROR`

The syntax for procedures (or subprocedures, in this case) is this:

``` 
SUB name (params)
{SHARED variables 'if any}
'{code to execute}
'  ...
'  ...
{STATIC variables 'if any, to be saved for use next time}
END SUB
```

And here is the syntax for functions:

```
FUNCTION name (params) 
  ' Shared variable declarations
  name = result
  ' ...
END FUNCTION

```

## Classes

The closest thing to classes are types. Here is how they're defined:

``` 
TYPE playertype
  name AS STRING
  score AS INTEGER
 END TYPE
```

And here is how they're "instantiated":

``` 
DIM playername AS playertype
playername.name = "Bob"
playername.score = 92
```

As you can see, they behave a lot more like structs in C than classes in C++/Java

### Inheritance

There is no inheritance

## The Standard Library