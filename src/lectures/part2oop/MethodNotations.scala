package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {

    def likes(movie: String): Boolean = movie == favouriteMovie
    def +(person: Person): String = s"$name is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favouriteMovie, age)
    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def apply(n: Int): String = s"$name watched $favouriteMovie $n times"
    def learns(subject: String): String = s"$name is learning $subject"
    def learnsScala: String = learns("Scala")
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (only works on methods that have one parameter)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS
  // Akka actors have ! ? methods

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!) // equivalent

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive) // equivalent

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  /*
  1. Overload the + operator
  mary + "the rockstar" => new person "Mary (the rockstar)"

  2. Add an age to the person class with default 0 value
  Add a unary + operator => new person with age + 1
  +mary => mary with the age increment

  3. Add a "learns" method in the person class => "Mary learns Scala"
  Add a learnsScala method, calls the learns method with "Scala" as a parameter.
  Use it in postfix notation.

  4. Overload the apply method
  mary.apply(2) => "Mary watched Inception 2 times"
   */

  println((mary + "the rockstar")())
  // "Hi, my name is Mary (the rockstar) and I like Inception"

  println((+mary).age)
  // 1

  println(mary learnsScala)
  // Mary is learning Scala

  println(mary.apply(2))
  // Mary watched Inception 2 times
}
