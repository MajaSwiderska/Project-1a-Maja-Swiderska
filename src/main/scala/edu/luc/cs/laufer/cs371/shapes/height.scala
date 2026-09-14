package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.Logger

//height is the number of nodes on the longest path from the root of the shape tree down to a leaf
object height:
  private val logger = Logger(getClass)

  def apply(s: Shape): Int =
    logger.debug(s"height input: $s")
    s match
      //a leaf has height 1
      case Rectangle(_, _) => 1
      case Ellipse(_, _)   => 1
      //a location adds 1 to the inner shapes height
      case Location(_, _, shape) => 1 + apply(shape)
      //a group adds 1 to the tallest childs height
      //if the group is empty, its height is 1
      case Group(shapes*)  =>
        if shapes.isEmpty then 1
        else 1 + shapes.map(apply).max
end height