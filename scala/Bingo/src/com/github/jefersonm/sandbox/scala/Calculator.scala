package com.github.jefersonm.sandbox.scala

object Calculator {

  def calc(val1:Integer, val2:Integer, arg:Any): Any = arg match {
    case "+" => val1 + val2
    case "-" => val1 - val2
    case "*" => val1 * val2
    case "/" => val1 / val2
    case  _  => "This operation isn't supported"
  }
  
}