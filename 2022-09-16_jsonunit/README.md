# JsonUnit
JsonUnit is great to use it in component tests, where you exercise the REST API you provide. 
Together with WireMock for external services you can test your application from boundary to 
boundary.

A lot of people now compare with JSON files. This has a number of disadvantages:
- Your tests become unreadable, as you always have to switch to the file
- Your tests become unmaitainable, as you have to change all files manually if something changes.
  In code you instead should have some ObjectMother or similar mechanisms.
- Your tests become less expressive, as it is not clear what is relevant for the test and what 
  is not.

Instead what works much better is using JsonPath 
- to configure fakes that are created with default values
- verify the fakes, that they are called with the right values
- verify the response of your API

As the tests here show: You can use JsonUnit together with JsonPath to write really specific 
assertions on your API's response.