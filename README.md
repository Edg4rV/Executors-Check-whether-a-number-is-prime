# Executors-Check-whether-a-number-is-prime
Executors  Check whether a number is prime
Write a program that reads integer numbers from the standard input and prints only those of them that are prime, in any order. A prime number is a natural number greater than 1 that cannot be formed by multiplying two smaller natural numbers, for example: 2, 3, 5, 7, 11 and so on.

The main thread must read integer numbers until the end. For each number, it should create a task to check whether the number is prime. If that is true, the number has to be printed in a new line. All tasks must be submitted to an ExecutorService. After executing all tasks, your program should stop correctly, otherwise, you will get a "Time limit exceed" error.

Use the provided template with the main method and the PrintIfPrimeTask class.

 Report a typo
Sample Input 1:

1 2 3 4 5 6 7 8 9 10 11
Sample Output 1:

2
3
5
7
11
