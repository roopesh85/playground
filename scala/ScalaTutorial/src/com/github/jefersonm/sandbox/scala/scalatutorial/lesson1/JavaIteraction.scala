package com.github.jefersonm.sandbox.scala.scalatutorial.lesson1

//importing only Date and Locale from java.util package
import java.util.{Date, Locale}
import java.text.DateFormat
//Same as import .* in Java, but in scala we use ._ instead
import java.text.DateFormat._

//Object makes it as an singleton class
object JavaIteraction {

	def main(args: Array[String]){
	  val now = new Date()
	  val df = getDateInstance(LONG, Locale.ITALY)
	  //scala sintax, when a method take on argument only, it can be used with an infix sintax,
	  //it's the same as: df.format(now)
	  println(df format now)
	}
  
}