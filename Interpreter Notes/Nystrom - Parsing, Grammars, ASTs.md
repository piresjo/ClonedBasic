# Nystrom - Crafting Interpreters - ASTs and Grammars

## Context Free Grammars

Context free grammars are the most sophisticated form of formal grammars.

Formal grammars take a set of atomic pieces it cells it’s “alphabet”. Then there are an infinite (usually) set of strings that follow the rules of the grammar.

Our scanner focuses on lexical grammar. Here, the alphabet is comprised of characters and the strings are tokens. The Parser focuses on syntactic grammar. Here, the tokens are the alphabet and the strings are all possible expressions.

### Rules For Grammar

You can generate strings based off the rules of the grammar. Strings created this way are called derivations. Rules used to produce these strings are called productions

Each production in a context free grammar has a head (its name) and a body (which describes what it generates).

In its purest form, bodies are just symbols, which can be split into two categories:

- Terminals - which are letters from the grammar’s alphabet. For our parser, these would be the tokens. They’re called terminals because they don‘T lead to any other rules being followed
- Nonterminals are named references to another rule in the grammar

### Enhancements To Notation

We can use the | character to add a new production to a rule, like so

```
bread -> "toast"|"biscuits"
```

Here, the bread can either be `toast` or `biscuits`

You can use parentheses for grouping. With the pipe character, this would allow us to select a series of options for a production

```
protein -> ("scrambled" | "fried") "eggs"
```

This means that for a protein, you get two different types of eggs: `scrambled` and `fried`.

We can use * to indicate that a string or construction can be used zero or more times

We can use + to indicate that a string or construction can be used at least once

``` 
meat -> "crispy"+ "bacon" | "sausage"
```

This means that there are two options for meat: `bacon` (by levels of crispiness) and `sausage`

We can use ? to indicate that a string or construction can be used zero or one time

``` 
breakfast -> "cereal" ("with milk")? | bread
```

This means that the breakfast could either be `cereal` (with or without `milk`) or a type of `bread`

With all this, we can create a basic grammar. For example, here is a grammar for creating breakfast

```jsx
breakfast -> protein ("with" breakfast "on the side")? | bread
protein -> "sausage" | ("scrambled" | "fried") "eggs"
bread -> "toast"|"biscuits"
```

### The Grammar For QBasic

See  `QBasic - Grammar.md`

## Implementing Syntax Trees

In our use cases, these grammars are recursive, and can be represented as trees. Therefore, we can create syntax trees based off this.

Since this work is being done in an OOP language, we can leverage those languages’ type systems to cleanly handle this.

### Disoriented Objects

For our implementation, we will be representing the parts of the grammar as classes with fields but no functions. This is similar to how the data layer is separated from the logic layer in functional programming languages. Really, these are used to provide a fixed communication medium between the interpreter and parser.

### Metaprogramming Trees

## Working With Trees

### The Expression Problem

This is where the differences between functional and OOP languages come into play. In an OOP language, you can create new objects (using a DB analogy, rows) easily, but you can’t add new functionality (columns) without rewriting the class.

In comparison, functional languages can add those “columns” a lot more easily. You can utilize pattern matching to create functionality for a wide variety of types.

### Solution - The Visitor Pattern

The visitor pattern allows us to approximate the functional style of programming within an OOP language. It’ll allow us to add new functionality for all our types easily.

### Visitors For Expressions