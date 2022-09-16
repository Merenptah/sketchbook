# Enforcing valid values
When building an expressive domain model that is always valid, you have two aspects to be considered:
1. The entities and value objects have to be created only with valid values.
2. All methods need to be called with valid values.

Let's focus on the second point, as this is something that is rarely done nicely in OO.

What you often see is that methods that require certain input have to check for the validity of the input themselves. Consider for example `Math.sqrt`, which takes `double` or `NaN` and validates first. Mathematically the "function" considered should be defined to map from the non-negative real numbers to the non-negative real numbers, ignoring any extension to complex numbers, so the Java version is hard to figure out and surprises in its behavior.

This way of handling input validation is incredibly common. Which is weird, because you can create types to express the valid value range, thus allowing the method/function to reduce its responsibility.

In the example code here we show how to define a function `sqrt` mapping the positive natural numbers to real numbers (yes, pretty arbitrary, of course we could also have used the non-negative real numbers and restrict what we map to). The function does _not_ need to check the input, as the type `PositiveInteger` guarantees that we only use positive integers as input.

`PositiveInteger` provides two ways of creation:
1. If you don't know if the value is positive or not, use `of`, which returns a `Result` that might also have failed. This is to be used on infrastructure level.
2. Inside your domain, if you know you have a positive value (as your domain contains only valid values), you can use `ofOrThrow`, which throws an _exception_ if you still provide an invalid value (_that's_ what an exception is for, handling _exceptional_ cases).

That's a variant of Valdimir Khorikov's "CanExecute" pattern, in a more consistent form, as I see it.
Khorikov, instead of having two factory methods, proposed to decouple the check from the creation. In a controller one would first call `canExecute` (or `canCreate`) to know if you are allowed to call or create something, and then call or create it, if successful.
This creates a sort of semantic coupling and increased complexity, as the developer needs to know that a method/class conforms to this pattern.
The solution proposed in here instead does not do that. Yes, you might use the "wrong" creation method, but the method tells you exactly what is happening.
- `of` returns a `Result`, so you know it might fail and you are forced to handle it,
- `ofOrThrow` already tells you, that it might throw.
