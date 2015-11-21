By the power of the Curry-Howard Isomorphism... presenting:

The Incredible Proof Machine... translated to Java 6
====================================================

Say what?
---------

The Incredible Proof Machine (http://incredible.nomeata.de/) 
is a fantastic way to learn about logical proofs, 
and a lot of fun. It's a great training exercise for programmers. 

The Curry-Howard isomorphism states that proofs in a logic system correspond
to types in a programming language. So, if you translate the theorem into types, 
if you can inhabit this type, then you've proven the theorem.

This repository translates all of the theorems in the Incredible Proof Machine
into Java 6 methods. Implement the methods to prove the theorem.

Why Java 6?
-----------

It's what I'm most familiar with. I think many programmers scoff at 
Java's verbosity and denounce static typing, but it does have a reasonable
amount of expressive power and can prove theorems.

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
- No non-final params, classes, variables
- No recursion

But... I don't have lambda expressions
--------------------------------------

    interface F<A, B> 
     
encodes a lambda expression 
using a single-function interface. 
Use that. 

How does the correspondence work in Java?
-----------------------------------------

The axioms are parameters to the function; the goal is the return type.

    a ∧ b <==> Pair<A, B>
    a ∨ b <==> Either<A, B>
    a → b <==> F<A, B>


Where are my blocks?
--------------------

         +-----------------+
     x  -|              ∧  |- x∧y   ===  Pair.p  
     y  -|                 |
         +-----------------+


         +-----------------+
    x∧y -| ∧               |- x     ===  Pair.x  
         |                 |- y          Pair.y
         +-----------------+


         +---+         +---+
         |   |- X   Y -| → |- x→y   ===  new F<X, Y>() {...}
         |   |_________|   |
         |                 |
         |_________________|


         +-----------------+
    x→y -| →               |- y     ===  F.apply  
      x -|                 |
         +-----------------+



What's with the "fold" in Either?
---------------------------------

This is called Church Encoding. 
It's a way of encoding a closed sum type a.k.a. tagged union type.


