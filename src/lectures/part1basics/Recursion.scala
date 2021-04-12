package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if(n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }

  println(factorial(10))

  def anotherFactorial(n: Int): BigInt = {
    def factHelper(x: BigInt, accumulator: BigInt): BigInt = {
      if (x < 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression
    }
    factHelper(n, 1)
  }
  /*
  anotherFactorial(10) = factHelper(10, 1)
  = factHelper(9, 10 * 1)
  = factHelper(8, 9 * 10 * 1)
  = factHelper(7, 8 * 9 * 10 * 1)
  = factHelper(6, 7 * 8 * 9 * 10 * 1)
  = ...
  = factHelper(2, 3 * 4 * ... * 10 * 1)
  = factHelper(1, 1 * 2 * 2 * 3 * 4 * ... * 10)
  = 1 * 2 * 2 * 3 * 4 * ... * 10
   */

  println(anotherFactorial(5000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION.

  /*
  1. Concatenate a string n times using tail rec
  2. isPrime function tail recursive
  3. Fibonacci function, tail recursive
   */

  @tailrec
  def concatenate(string: String, n: Int, accumulator: String = ""): String = {
    if (n <= 0) accumulator else concatenate(string, n - 1, accumulator + string)
  }

  println(concatenate("hello", 5)) // "hellohellohellohellohello"

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }
    isPrimeTailRec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if(i >= n) last
      else fiboTailRec(i + 1, last + nextToLast, last)
    }
    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)
  }

  println(fibonacci(8))
}
