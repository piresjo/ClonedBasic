# QBasic - Grammar


ToDo - Double Check If You Can Negate A Value
``` 
expression -> literal | unary | binary | grouping;
literal -> INTEGER | STRING | LONG | DOUBLE | SINGLE | "TRUE" | "FALSE";
grouping -> "(" expression ")";
unary -> ( "-", "NOT") expression;
binary -> expression operator expression
operator -> "=" | "<>" | "<" | "<=" | ">" | ">=" | "+" | "-" | "*" | "/";
```