# Nested data structures with country-dependent substructures
A common issue is that you have some data structure or domain class which is nested, like an order having related persons having related addresses. And on each level the data (not the behavior) depends on some dimension like the country. How do you model that in Java without creating completely independent class trees per dimension?

## Analysis
What we see in the example is that we can go quite far, letting the common data be defined in the common type via an abstract getter.
The simple approach fails as soon as you want to use a generic type, like a list of order items. If `ItemFr extends Item`, then neither `List<ItemFr> extends List<Item>`, nor the other way round, generic types are _invariant_.

If you still want to prescribe a getter for this generic type, you need to
- cast down when creating the more specific type, as we see in `OrderFr::getItems`
- _know_ as a consumer that `getList` returns even `List<ItemFr>`

So you lose all type-safety and it is hard to use.

But there is a solution: On the abstract basic type we can use [PECS](https://howtodoinjava.com/java/generics/java-generics-what-is-pecs-producer-extends-consumer-super/), and define the getter (which is a producer) using the `extends` rule:
```java
public abstract <T extends Item> List<T> getItems();
```

This now allows us to override the method to be more restrictive, like
```java
@Override
public List<ItemFr> getItems();
```
