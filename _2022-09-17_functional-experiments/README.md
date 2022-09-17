# Functional Experiments
This is just a small example of how you can use functional programming. I was in need to take an 
existing list and only update a specific element in that list, without changing the order of the 
elements:
- There is a condition to find the element to update
- The new element depends on the old one

The Java API does not provide such a functionality (as far as I know). But it is easy enough to 
create yourself.