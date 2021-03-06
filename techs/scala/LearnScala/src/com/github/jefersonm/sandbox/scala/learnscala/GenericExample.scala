package com.github.jefersonm.sandbox.scala.learnscala

class Reference[T] {

  private var contents: T = _
  def set(value: T) {contents = value}
  def get: T = contents
  
}

object ReferenceTest {
  
  def main(args: Array[String]){
    val integer = new Reference[Int]
    integer set 13
    println("Reference contains the half of " + (integer.get * 2))
    
    val string = new Reference[String]
    string set "Jeff"
    println("Reference contains the value " + string.get)
  }
  
}