# Test Data Builders
In tests I often need to build nested objects, say to build request objects or domain objects. 
Especially domain objects can be difficult as you cannot easily just set the data that is 
required for the tests, if your domain model is trying to be "always valid", thus requiring 
valid values.

If you additionally use a framework like Cucumber, where you need to create these nested objects 
in a readable way, you can already discard the typical `Object Mother` pattern. But the 
`Builder` pattern works pretty well.

There are several "tricks" you can apply to make these builders as helpful and readable as possible:
- You can define default values, so that you can concentrate on the values that are relevant in 
  your test.
- Whenever you have a collection, you can decide if `null` should be the default, or an empty 
  collection, or some initial value. I usually use `null`, to be able to test if `null` is 
  handled correctly, if this value is optional.
- When defining collections, using varargs makes the builder most usable. Keep the creation of 
  lists or sets in your builder.
- Depending on the desired usage, you can of course also add items to collections one by one.
- Only ever pass builders, when you want to create nested objects. Otherwise, your builder calls 
  will contain too much clutter. Furthermore, this allows to later adjust that object.
- I like to be able to use Strings as input if `LocalDate` or `BigDecimal` needs to be created. 
  That works perfect with Cucumber, and takes away a lot of the overhead in writing.
- Feel free to add any semantic sugar you can think of, like providing static factory methods 
  for the builders: `aPerson()` instead of `new PersonBuilder()`.

Yes, this is all quite a bit of work. Sadly, Lombok does not give you enough control to achieve 
the same result. What is missing?
- You cannot define default values, you would have to add an `Object Mother` to do that, which 
  is not flexible at all.
- You cannot let Lombok use Builders for nested objects.

On the other hand, you usually have to do this only once.