# Result objects
This shows how you can build your own simple `Result` class with a number of methods that allow to use it in a functional way, even though I still added getters.

This variant does not use polymorphism to differentiate between the error and the success case, but instead makes use of static factory methods. 

## Objective
The focus is more on representing the possible errors, structuring them using nested classes within the abstract `Errors` class, thus allowing to have an overview over all possible error cases. Of course we could also just use an enum to do that, without further structuring or using the enum value name to structure the possible errors.

The other objective is to use a unit test in `ErrorsTest` to make sure that the error codes are unique.
