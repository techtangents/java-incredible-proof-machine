The Curry-Howard Isomorphism presents:

The Incredible Proof Machine... translated to Java 6
====================================================

Say what?
---------

The Incredible Proof Machine (http://incredible.nomeata.de/) 
is a fantastic way to learn about logical proofs, 
and a lot of fun. It's a great training exercise for programmers. 

The Curry-Howard isomorphism states that proofs in a logic system correspond
to programs in a programming language. So, if you translate a theorem into types, 
if you can inhabit this type, then you've proven the theorem.

This repository translates most of the theorems in the Incredible Proof Machine
into Java 6 methods. Your task is to implement the methods in order to prove the theorem.

Why Java 6?
-----------

Mostly because it's what I'm most familiar with. 

I also want to show that, despite Java's limitations, it does
have a reasonable static type system, which can be used to prove theorems.

More importantly - even Java's limited type system can prove properties
of your own programs and prevent bugs. 
Every Java programmer should remember this.

But... I don't have lambda expressions
--------------------------------------

    interface F<A, B> 
     
encodes a lambda expression 
using a single-function interface. 
Use that. 

If you want to convert the exercises to Java 8 to use lambdas, feel free. 
I'd love to have a Java 8 branch or fork.

The rules
---------

You are to use a "safe" subset of Java. This means:

- No exceptions
- No nulls
- No equals, hashCode, clone or any other method on java.lang.Object
- No var-args
- No arrays
- No inheritance from classes - only interfaces
- No variance annotations
- No missing type parameters (unless inferred)
- No non-final params, classes, variables
- No recursion
- No casting, instanceof, reflection
- No mocks or proxies
- No for, while, goto, break, continue 
- No side effects

What IDE should I use?
----------------------

The project is set up for IntelliJ, but use whatever you'd like.

How does the correspondence work in Java?
-----------------------------------------

The axioms are parameters to the function; the goal is the return type.

    a ∧ b <==> Pair<A, B>
    a ∨ b <==> Either<A, B>
    a → b <==> F<A, B> (i.e. a function)
    ⊥     <==> java.lang.Void (a type with no values)
    

Where are my blocks?
--------------------

         +-----------------+
     X  -|              ∧  |- X∧Y   ===  Pair.p  
     Y  -|                 |
         +-----------------+


         +-----------------+
    X∧Y -| ∧               |- X     ===  Pair.x  
         |                 |- Y          Pair.y
         +-----------------+


         +---+         +---+
         |   |- X   Y -| → |- X→Y   ===  new F<X, Y>() {...}
         |   |_________|   |
         |                 |
         +-----------------+


         +-----------------+
    X→Y -| →               |- Y     ===  F.apply  
      X -|                 |
         +-----------------+


         +-----------------+
      X -|            .∨   |- X∨Y     ===  Either.<X,Y>x  
         |                 |
         +-----------------+


         +-----------------+
      Y -|            ∨.   |- X∨Y     ===  Either.<X,Y>y  
         |                 |
         +-----------------+


         +---+         +---+
         |   |- X   P -|   |  
    X∨Y -| ∨ +---------+   |- P       === Either.<P>fold
         |   +----------   |
         |   |- Y   P -|   |
         +---+         +---+


         +-----------------+
      ⊥ -|  ⊥              |- P       ===  V.<P>absurd(Void)  
         +-----------------+


         +-----------------+
         |      TND        |- P∨(P→⊥) ===  TND.<P>tnd()
         +-----------------+



What's with the "fold" in Either?
---------------------------------

This is called Church Encoding. 
It's a way of encoding a closed sum type a.k.a. tagged union type.


How do I know my answer's right?
--------------------------------

The theorem has been proven if you've followed The Rules and your code compiles. 

Why can't Java's infer this type?
---------------------------------

Java's type inference isn't real flash. 
You may need to put in explicit type parameters in some places.

Why do some of the axioms throw exceptions?
-------------------------------------------

While the types in these exercises are all expressible in Java, 
some of the values of these types are not. It doesn't matter, however - 
your job is to assume the axioms are true and construct proofs based on them.
So long as you don't use exceptions in your proofs.

Where are sessions 6 and 7?
---------------------------

Sessions 6 and 7 use universal and existential quantifiers (∀ and ∃), 
which correspond to Π and Σ types in a dependently-typed programming
language. 

