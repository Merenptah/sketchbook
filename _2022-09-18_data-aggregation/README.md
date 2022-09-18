# Data aggregation
A common process in enterprise software is the collection or aggregation of data from external 
sources based on some incomplete incoming data. Like having an ISBN of a book and getting the 
metadata from an external service.

We compare two implementation approaches:
1. Mutable approach
2. Immutable approach
 
## Mutable approach
The only one I have ever seen implemented is the mutable classes approach. There is one (huge)
domain class which is mutable. It is created from the input, but only containing incomplete 
data. This will then be sent to the adapters for the external data collection and the additional 
data is set.

The advantages are:
- This is pretty transparent and keeps maintainability kind of low, as the adapters can 
  implement all the same interface, taking the whole object
- You can easily add new collectors
- Easy to parallelize

The disadvantages are:
- There is no always-valid domain model
- The data collection process and the update are merged together and thus build an action and 
  not a calculation
- Testing is difficult, as you have to mock getting the data from the external service, you need 
  a full domain object
- There is no easy way to see if the same field is set by several data collectors. This is 
  especially important if you use parallel processing (not shown here)
- You break encapsulation, as all collectors always have access to all data
- You cannot make the domain object immutable, opening the door to all kind of issues.

## Immutable approach
In the immutable approach you clearly separate concerns:
- The input object, immutable, is different from the final valid domain object
- You have specific classes/records to contain the collected data, which is different per collector
- There is a specific orchestrator taking all the collected data and creating the domain object

We distinguish two approaches in there, the explicit one, where each collector returns its own 
result object, and the implicit one, where the collectors act on a builder.

### Explicit approach

The advantages are:
- Collecting the data is completely separated from the domain model, simplifying testing and 
  understanding
- Everything is immutable, no need to track changes through the same model
- Reading is easy (yes, devs tend to optimize for writing, sadly)
- The whole update process is a calculation, not an action.
- You have complete control over which data to take from where

The disadvantages are:
- Maintainability is reduced, you cannot simply throw in a new collector, you also have to 
  adjust the update mechanism.
- Harder to parallelize (it is shown how to)

### Implicit approach
The implicit approach is in between the explicit and the mutable approach and looks pretty 
similar to the mutable approach. The mutability here is hedged locally by using a builder for 
the domain object.

The advantages are:
- Everything but the builder is immutable, no need to track changes through the same model
- Reading is ok
- The whole update process is a calculation, not an action.
- We have the same maintainability as the mutable approach
- easier to parallelize

The disadvantages are:
- The collectors know where to put their data to
- Several collectors might set the same data
- You do not have one place where the data is put together
- Testing is in between the mutable and the explicit approach, but nearer to the mutable approach

## In total
If you regularly need to add new collectors, the implicit approach might be the way to go. If 
you don't, I'd prefer the explicit approach, as it makes reading and understanding so much easier.

Both immutable approaches are better than the mutable approach, as it is much clearer when you 
only have input data and when you have the final domain model.

This even holds in the not shown case in which you really start with a domain model, but you 
might want to update it. It will look similar in the immutable approach, you would then
- require immutable update methods in the domain model (copy-on-write)
- in the implicit collector you instead have a function from `DomainData` to `DomainData` (yes, 
  now this looks even more similar to the mutable approach).