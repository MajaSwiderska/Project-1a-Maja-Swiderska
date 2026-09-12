package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.Logger

object height:
  private val logger = Logger(getClass)

  def apply(s: Shape): Int =
    logger.debug(s"height input: $s")
    s match
      case Rectangle(_, _) => 1
      case Ellipse(_, _)   => 1
      case Location(_, _, shape) => 1 + apply(shape)
      case Group(shapes*)  =>
        if shapes.isEmpty then 1
        else 1 + shapes.map(apply).max
end height