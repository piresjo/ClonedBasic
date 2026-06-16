# Nystrom - Scanning

## What Tokens Are

The goal of scanning is to take raw source code and break them down to usable chunks. 
These usable chunks are known as tokens.

The scanning process can just be a very long and sophisticated `switch` statement.

## A Basic Interpreter

For this part of the book, Java is being used as the interpreter. This will support both 
reading from a file and REPL.

## Error Handling

Before doing any other implementations, it would be a good idea to have some error handling in case
the user has any syntax errors in the scanning part

## Lexemes and Tokens

At least in this book, lexemes and tokens are used interchangeably.

Recall this example from earlier.

```python
average = (min + max) / 2
```

These would be the lexemes/tokens (represented as a Python list for readability):

```python
['average', '=', '(', 'min', '+', 'max', ')', '/', '2']
```

### Token Types

You'll need to define all the tokens that make up your language. This entails:

- Literals
- Reserved Keywords
- Symbols 
  - These can be multi-character
  - Eg. `+`, `[`, `,`

### Literal Values

Depending on how you define your literals, you'll need to handle them properly

### Location Information

For our tokens, it would be good to know at least what line the token is in. This will be useful when we create our tree.

## Regular Languages And RegEx

The scanning process described here is reminiscent of regular expressions. We take a series of characters
and determine what token it matches. For sake of clarity and understanding, this book won't use regex

The rules that determine how a particular language groups characters into lexemes is its lexical grammar.

Languages that can be represented by regexes are known as regular languages

## Devising The Scanner

For our purposes, a big scanner class should suffice (maybe splitting some of the util methods into its own class)

## Reserved Words And Identifiers

Reserved words are identifiers used by the language specifically. To handle these, a map should suffice.

## Implicit Semicolons

Most languages now don't need a semicolon at the end of the line. This could be done in a variety of ways:

- Treat the newline character as the semicolon
  - This could lead to issues with multi-line lines of code
  - Python bypasses this by having the `\` character represent that the line is part of a multi-line block.
- Check newlines. Check the next line. If that line is part of the previous, ignore the implicit semicolon. If not, include it.