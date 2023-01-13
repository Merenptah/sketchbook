# Experimenting with Spock

There are two extremes in integration testing: Using JUnit directly with POJOs, 
or using something like Cucumber, to make tests more readable.

Integration tests in Java are usually a mess, if you are handling larger data
sets, like a JSON request and a JSON response of HTTP calls. Stubbing is often
found to be done by reading in JSON files, an absolute no-go, as it makes understanding
and maintaining tests extremely difficult.
Cucumber, on the other hand, allows for beautiful crafting of tests, which are readable
also by business people or POs or solution designers. You can go all out with documenting
all possible features. The huge disadvantage: Devs hate it. In my experience, only about 5%
of the devs touch Cucumber tests, ever. Why? Because it's not code, and it requires quite
some experience with writing good fixtures and glue.

Spock is somewhere in between:
- It has a nice split of given, when, and then, using labels
- It is code
- Data-driven tests look like Cucumber, you can write tables in Groovy
- You can document the specifications on the labels
- Failing assertions are insanely well described, see the example below
- It is not possible to use something like the Feature/Scenario/Rule documentation, but with Title and Narrative we are close

## A failing assertion

A failing assertion documents all elements that are involved in checking that assertion:
```
content.data.name.contains("Maxi")
|       |    |    |
|       |    |    false
|       |    Max Mustermann
|       [address:MÃ¼nchen, name:Max Mustermann]
[data:[address:MÃ¼nchen, name:Max Mustermann]]
```

## Resources
- A nice IntelliJ-based video by Trisha Gee: https://www.youtube.com/watch?v=i5Qu3qYOfsM
- https://www.baeldung.com/groovy-spock
- https://www.baeldung.com/spring-spock-testing