package com.github.jefersonm.sandbox.scala.scalatutorial.lesson3

//Scala classes are very similary to Java classes, but here in scala we can have parameters
//and when creating an instance of class ScalaClasses will be like it: new ScalaClasses(1.5, 2.3)
class ScalaClasses(real: Double, imaginary: Double) {

	//These methods give access to two classes parameters
	def re() = real
	def im() = imaginary

}

class MethodWithoutArgument(real: Double, imaginary: Double) {

	//These methods give access to two classes parameters
	//Better implementation here, without parenthesis
	def re = real
	def im = imaginary

	//to override something in scala we should put the word override before method declaration
	override def toString() = 
	  "" + re + (if (im < 0) "" else "+") + im + "i"
	
}

object ScalaClassTest {

	def main(args: Array[String]) {
		def s = new ScalaClasses(1.2, 3.5)
		println("re value: " + s.re())
		
		def m = new MethodWithoutArgument(1.2, 3.5)
		println("re value: " + s.re)
	}

}