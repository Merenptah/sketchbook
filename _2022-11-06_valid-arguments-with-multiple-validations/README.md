# Enforcing valid values with multiple validations
We have already seen how you can enforce valid values in `2022-08-20_valid-arguments`.

But that example was limited in the way that you could not enforce mutliple validations.
For maximal flexibility, I extracted the validation container into its own class, otherwise the 
`Result` class would have to do too much.