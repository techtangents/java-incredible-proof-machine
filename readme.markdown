By the power of the Curry-Howard Isomorphism... presenting:

The Incredible Proof Machine... translated to Java 6
====================================================

Say what?
---------

The Incredible Proof Machine (http://incredible.nomeata.de/) 
is a fantastic way to learn about logical proofs, 
and a lot of fun. It's a great training exercise for programmers. 

The Curry-Howard isomorphism states that proofs in a logic system correspond
to types in a programming language. Translate the theorem into types, then if 
you can inhabit this type, then you've proven the theorem.

This repository translates all of the theorems in the Incredible Proof Machine
into Java 6 methods. Implement the methods to prove the theorem.

Why Java 6?
-----------

It's what I'm most familiar with. I think many programmers scoff at 
Java's verbosity and denounce static typing, but it does have a reasonable
amount of expressive power.

The rules
---------

You are to use a "safe" subset of Java. This means:

- No exceptions
- No nulls
- No equals(...), hashCode(...) or any other method on java.lang.Object
- No var-args
- No arrays
- No inheritance from classes - only interfaces
- No variance annotations
- No missing type parameters (unless inferred)
- No non-final params, classes
- No recursion

But... I don't have lambda expressions
--------------------------------------

interface F<A, B> encodes a lambda expression 
using a single-function interface. 
Use that. 

How does the correspondence work in Java?
-----------------------------------------

The axioms are parameters to the function; the goal is the return type.

Logical conjunction is a Pair (P)
Logical disjuntion is an Either
Logical implication is a Function (F) 

a ∧ b <==> P<A, B>
a ∨ b <==> Either<A, B>
a → b <==> F<A, B>

