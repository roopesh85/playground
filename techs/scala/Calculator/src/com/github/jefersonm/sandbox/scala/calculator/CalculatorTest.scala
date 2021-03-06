package com.github.jefersonm.sandbox.scala.calculator
import com.github.jefersonm.sandbox.scala.calculator.Calculator.calc
import junit.framework.Assert.assertEquals
import junit.framework.TestCase


class CalculatorTest extends TestCase {

  def testSum() = assertEquals(2, calc(1,1,"+"));
  def testSub() = assertEquals(3, calc(4,1,"-"));
  def testMul() = assertEquals(8, calc(4,2,"*"));
  def testDiv() = assertEquals(6, calc(12,2,"/"));
  def testUnsupportedOperation() = assertEquals("This operation isn't supported", calc(12,2,"%"));
  
}