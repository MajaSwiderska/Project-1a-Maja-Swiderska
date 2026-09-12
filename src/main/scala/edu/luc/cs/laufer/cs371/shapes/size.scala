package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.Logger

object size:
    private val logger = Logger(getClass)

    def apply(s: Shape): Int =
    logger.debug(s"size input: $s")
    s match
        case Rectangle(_, _) => 1
        case Ellipse(_, _)   => 1
        case Location(_, _, shape) => apply(shape)
        case Group(shapes*) => shapes.map(apply).sum
end size