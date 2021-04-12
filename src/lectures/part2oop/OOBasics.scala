package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Stacey", 31)
  println(person.x)
  println(person.greet("Eloise"))
  println(person.greet())

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge())
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
  counter.inc(3).dec.print
}

// constructor
class Person(name: String, val age: Int) {
  // body
  val x = 2

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors - not necessary as we can easily use default parameters, preventing the need for theses
  def this(name: String) = this(name, 0)
  def this() = this(" John Doe")
}

/*
Novel and Writer

Writer: first name, surname, year of birth
  - method full name

Novel: name, year of publish, author: Writer
  - authorAge (at year of publish)
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel
 */

class Writer(firstName: String, surname: String, val birth: Int) {

  def fullName(): String = s"$firstName $surname"
}

class Novel(val name: String, published: Int, author: Writer) {

  def authorAge(): Int = published - author.birth

  def isWrittenBy(author: Writer) = author == this.author

  def copy(newRelease: Int): Novel = new Novel(name, newRelease, author)
}

/*
Counter class
  - receives an int value
  - method current count
  - method to increment/decrement => new Counter
  - overload inc/dec to receive an amount
*/

class Counter(val count: Int = 0) {

  def inc: Counter = {
    println("incrementing")
    new Counter(count + 1)
  } // immutability

  def dec: Counter = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(amount: Int): Counter = {
    if (amount <= 0) this
    else inc.inc(amount - 1)
  }
  def dec(amount: Int): Counter = {
    if (amount <= 0) this
    else dec.dec(amount - 1)
  }

  def print = println(count)
}

// class parameters are NOT FIELDS
