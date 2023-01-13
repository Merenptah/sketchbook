# Result objects using validations
In the result objects module I have already tried out how to connect validations with `Result` objects.
But there was one severe limitation, it only worked with one validation, you could not have 
several validations returning a result collecting all validation failures.

Here I try a different approach, separating the validation from the `Result`, which looks promising.

One important thing is the differentiation of `Result.orThrow` with or without argument, see the
corresponding JavaDocs.
