# Kotlin function chaining

This is an exercise in "From objects to functions" by Uberto Barbini. In "normal" Java and Kotlin you would need to chain functions like that:
```kotlin
fun process(request: Request): Response =
        toResponse(
                toResponseBody(
                        transform(
                                getContent(request)
                        )
                )
        )
```

This inverts the order of the functions, much like it is done in mathematics. But it's harder to read, as you
always start to search for the innermost function.

Kotlin's scope function allow to reverse the order with
```kotlin
fun process(request: Request): Response =
        request.let(::getContent)
                .let(::transform)
                .let(::toResponseBody)
                .let(::toResponse)
```

which now reads more like a pipeline. This still does not read very naturally, so we can define an infix function
`andThen` to allow for

```kotlin
val processFunction =
        ::getContent andThen
        ::transform andThen
        ::toResponseBody andThen
        ::toResponse

processFunction(request)
```