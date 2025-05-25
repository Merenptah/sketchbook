# The Diamond Kata with Spock

The Diamond Kata goes like that: Write a function that returns for each character A-Z the diamond
that is created out of all letters up to the desired character, as ASCII art.

For A this would just be 'A'. 
For B it would be
```
-A-
B-B
-A-
```
For C it would be
```
--A--
-B-B-
C---C
-B-B-
--A--
```
and so on. 

The solution is from "Spock - Up and Running", https://learning.oreilly.
com/library/view/spock-up-and/9781491923283/ch11.html#idm140647713187504.

The interesting aspect of the kata is, that you do not want to write one test per letter, but
instead find other invariants that let you describe the problem more generically.