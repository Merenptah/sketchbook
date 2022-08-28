# Domain Streams
**Domain streams** are a concept I learned some time ago in [Mastering Object-Oriented Programming in
Java](https://app.pluralsight.com/library/courses/object-oriented-programming-java). The idea is simple: Instead of writing something like
```java
List.of(painter1, painter2).stream().filter(p -> p.canPaintMurals())...
```

you overwrite the stream to replace the filter with
```java
.whoAreAbleToPaintMurals()
```

The problem is the verbosity of Java's streams. If we want these pipelines to look more domain-specific, we first need a default implementation of `Stream` to forward.

The same is much easier in Kotlin, as we neither need to work with Streams, thus do not need a forwarding stream. Instead we can simply write extension functions for the lists.
