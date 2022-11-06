# Role-based validation

How would you handle validation of a type for which there are
- different concrete usages requiring different validations
- these different usages can be combined?

Let's call these "concrete usages" _roles_.

Using a hierarchy here would quickly explode the number of necessary subclasses, as you would 
need one subclass per combination. With three different roles we already have 8 different 
combinations.

Another possibility is a variant of the bridge pattern, or using a **knowledge level** as 
described in Martin Fowler's "Analysis Patterns": Why not put the validation on the roles 
themselves? That way we can freely combine the roles without having to touch the entity that is 
to be validated. Furthermore, you can easily add new roles, without having to touch anything but 
the new role itself.

I implemented this pattern here using an enum for the roles, you could as well use an interface 
with different implementations. Using an enum makes sure that we have at most one instantiation of 
each role. It works, because we do not need other collaborators in the example.

The big trade-off is that the factory method of the `Address` class does not tell you, which 
fields are actually required. So, we are trading off readability with maintainability.

If, instead, you knew that the roles correspond to a partition of fields, we might also just put 
the fields in the roles themselves. But I have not come across such a use-case, yet.