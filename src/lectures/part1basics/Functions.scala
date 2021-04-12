package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION
  // Functions need the return type specified, as the compiler isn't able to infer this

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  /*
  1. A greeting function (name, age) => "Hi, my name is $name and I am $age  years old"
  2. Factorial function 1 * 2 * 3 * .. * n
  3. A fibonacci function
     f(1) = 1
     f(2) = 1
     f(n) = f(n - 1) + f(n - 2)
  4. Tests if a number is prime
   */

  def greeting(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old."
  }

  println(greeting("Felix", 18))
  // "Hi, my name is Felix and I am 18 years old."

  def factorial(int: Int): Int = {
    if (int <= 0) 1 else int * factorial(int - 1)
  }

  print(factorial(6)) // 720

  def fibonacci(int: Int): Int = {
    if (int <= 2) 1
    else fibonacci(int - 1) + fibonacci(int - 2)
  }

  println(fibonacci(8)) // 21

  def isPrime(int: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else int % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(int / 2)
  }

  println(isPrime(2))
  println(isPrime(97))
  println(isPrime(98))
}
