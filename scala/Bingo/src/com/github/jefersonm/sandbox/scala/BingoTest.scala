package com.github.jefersonm.sandbox.scala
import junit.framework.TestCase
import junit.framework.Assert._
import com.github.jefersonm.sandbox.scala.Bingo._


class BingoTest extends TestCase {

  def testSum() = {
//   assertEquals(1, montaCartela()); 
    val l = montaCartela() 
    println(l.take(1).take(2).take(1))
  }
  
}