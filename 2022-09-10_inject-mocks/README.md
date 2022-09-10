# Mockito's @InjectMocks considered harmful
I never use `@InjectMocks`, ever. For general testing hygiene reasons, your tests grow just more 
obscure. Tests should be clear, instead, showing what dependencies your class/component under 
test is using.

But yesterday a colleague showed me that `@InjectMocks` is not only unnecessary convenience, no, 
it is straightforward dangerous. The tests in this module show the different outcomes of using 
this annotation depending on the defined constructors. Simply don't use it, it's not worth the 
hassle. Somehow a lot of developers still prioritize writing speed before reading speed. 

Common answer to this "revelation": "You have to use it correctly." The answer of who Alan 
Cooper would call "Apologists".

Even better would be to not use mocks at all. Well.