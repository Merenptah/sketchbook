# Java 16 records
What are records for, what are they not for?

They provide
- simple possibility to create pairs or other tuples, that is nice
- immutability
- simple type for configuration classes
- nice `toString`

They do not provide
- a copy possibility, so they are not usable as a base for an immutable type system, but you could implement `with...` yourself
- any possibility to have a static factory method, to control creation of microtypes

In total, I find them nice for configuration and for stuff like tuples. Apart from that, I prefer the flexibility of classes together with lombok.
