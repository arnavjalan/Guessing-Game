# Guessing-Game
Implemented a Number Guessing Game as follows:

1. You think of a 4-digit secret integer between the range of 1000 and 9999 (e.g. 5432).

2. The program takes a guess (e.g. 1234).

3. You tell the program how many digits in the guess match your secret number. A match must have the same digit at the same position. In the example, 5432 and 1234 has only 1 matched digit at position 3, so you tell the program that the number of matching digits is 1.

4. The program performs some updates, and takes another guess (e.g. 5533).

5. You tell the program that the guess has 2 matching digits (5533 and 5432 match in position 1 and 3).

6. The program repeats step 4, until it guesses the correct secrete number, in which case you will tell the program that all 4 digits match.
