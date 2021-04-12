package lectures.part1basics

object CBNbsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }
  // expression is evaluated and then that value is passed through and used in every occurrence within the function definition.

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }
  // => delays the evaluation of the expression passed as a parameter until it is used within the function definition.

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(infinite(), 34)
  printFirst(34, infinite())
}
