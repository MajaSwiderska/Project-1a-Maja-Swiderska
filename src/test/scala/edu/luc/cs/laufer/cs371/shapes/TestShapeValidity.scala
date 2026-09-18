package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

import Shape.*

class TestShapeValidity:

  @Test
  def testValidRectangle(): Unit =
    assertDoesNotThrow(() => Shape.rectangle(10, 20))

  @Test
  def testNegativeRectangleWidth(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Shape.rectangle(-1, 10))

  @Test
  def testNegativeRectangleHeight(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Shape.rectangle(10, -1))

  @Test
  def testValidEllipse(): Unit =
    assertDoesNotThrow(() => Shape.ellipse(10, 20))

  @Test
  def testNegativeEllipseWidth(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Shape.ellipse(-1, 10))

  @Test
  def testNegativeEllipseHeight(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Shape.ellipse(10, -1))

  @Test
  def testZeroDimensionsAllowed(): Unit =
    assertDoesNotThrow(() => Shape.rectangle(0, 0))
    assertDoesNotThrow(() => Shape.ellipse(0, 0))

  @Test
  def testDirectConstructorRejectsNegative(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Shape.Rectangle(-1, 20))
    assertThrows(classOf[IllegalArgumentException], () => Shape.Ellipse(-1, 20))

end TestShapeValidity