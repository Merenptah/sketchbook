# Memento
The **memento pattern** can be used to achieve several different outcomes.
- Getting a snapshot for historical tracking of an entity
- Providing a cleaner separation of access to the internal data, if you do not want to have getters or reflection to access the internal data
- Not having to provide a default constructor for certain mappers or ORMs, which would allow to create invalid entities if abused.

In the example here we take a look at a `Person` without any direct access to its internal data, as this is functionally simply not required. 

But if you still need access to the data to persist it, for example, you could dirty it by adding annotations to the private fields and the ORM creates the class using reflection. Of course, that way you lose any control over consistency of the entity. The `JsonMapper` also requires a default constructor, a complete no-go, as this allows creating a completely broken entity.

With the memento pattern we still have high coupling to unwanted frameworks, but at least we keep the control, as we decouple field names and own the mapping. Furthermore the non-memento interface of the entity stays clean.

The bidirectional coupling of `Person` and `Memento` does not matter here, as this is on purpose.
