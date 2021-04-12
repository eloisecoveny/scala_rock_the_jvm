package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // + - * / (bit shift) & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // ALSO WORKS WITH -= *= /= ..... side effects
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  print(if(aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  } // imperative programming

  // NEVER WRITE THIS AGAIN.

  //EVERYTHING in Scala is an expression!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

   // side effects: println(), whiles, reassigning (imperative programming)

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "Hello" else "goodbye"
  } // a code block is an expression. The value of a code block is the value of the last expression

  // 1. difference between "hello world" vs println("hello world")?
  // "hello world" is a value of type string, println("hello world") is a side effect and is of type Unit

  // 2.
  val someValue = {
    2 < 3
  }
  // true

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  // 42
}
