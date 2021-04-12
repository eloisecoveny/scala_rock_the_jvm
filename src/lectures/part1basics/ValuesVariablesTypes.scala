package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x = 42
  println(x)

  // VALS ARE IMMUTABLE

  // COMPILER can infer types

  val aString: String  = "hello"
  val anotherString: String = "goodbye"

  val aBoolean: Boolean = false
  val aCharacter: Char = 'a'
  val anInt: Int = x
  // 4 bytes
  val aShort: Short = 4613
  // 2 bytes
  val aLong: Long = 320572845L
  // 8 bytes
  val aFloat: Float = 2.0f
  // decimal values followed by an f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  aVariable = 5 // side effects
}
