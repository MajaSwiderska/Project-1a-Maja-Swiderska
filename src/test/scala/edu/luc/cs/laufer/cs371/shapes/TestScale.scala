package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import TestFixtures.*
import Shape.*

class TestScale:

  @Test
  def testSimpleRectangle(): Unit =
    assertEquals(Rectangle(160, 240), scale(2, simpleRectangle))

  @Test
  def testSimpleEllipse(): Unit =
    assertEquals(Ellipse(100, 60), scale(2, simpleEllipse))

  @Test
  def testSimpleLocation(): Unit =
    assertEquals(Location(140, 60, Rectangle(160, 240)), scale(2, simpleLocation))

  @Test
  def testBasicGroup(): Unit =
    assertEquals(Group(Ellipse(100, 60), Rectangle(40, 80)), scale(2, basicGroup))

  @Test
  def testSimpleGroup(): Unit =
    assertEquals(
      Group(
        Location(400, 200, Ellipse(100, 60)),
        Location(800, 600, Rectangle(200, 100))
      ),
      scale(2, simpleGroup)
    )

  @Test
  def testComplexGroup(): Unit =
    assertEquals(
      Location(100, 200,
        Group(
          Ellipse(40, 80),
          Location(300, 100,
            Group(
              Rectangle(100, 60),
              Rectangle(600, 120),
              Location(200, 400, Ellipse(100, 60))
            )),
          Rectangle(200, 400)
        )),
      scale(2, complexGroup)
    )

end TestScale