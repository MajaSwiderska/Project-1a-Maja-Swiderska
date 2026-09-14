package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.Logger

//size counts how many leaf shapes (rectangles and ellipses) are in s
object size:
  private val logger = Logger(getClass)

  def apply(s: Shape): Int =
    logger.debug(s"size input: $s")
    s match
      //a leaf shape counts as 1
      case Rectangle(_, _) => 1
      case Ellipse(_, _)   => 1
      //a location is just a wrapper, count the inner shape
      case Location(_, _, shape) => apply(shape)
      //a groups size is the sum of all childrens sizes
      case Group(shapes*)  => shapes.map(apply).sum
end size