package edu.luc.cs.laufer.cs371.shapes

import Shape.* 
import com.typesafe.scalalogging.Logger

object scale:
    private val logger = Logger(getClass)

    def apply(factor: Int, s: Shape): Shape =
        logger.debug(s"scale input: $s")
        s match
            case Rectangle(w, h) => Rectangle(w * factor, h * factor)
            case Ellipse(w, h)   => Ellipse(w * factor, h * factor)
            case Location(x, y, shape) => Location(x * factor, y * factor, apply(factor, shape))
            case Group(shapes*) => Group(shapes.map(apply(factor, _))*)
end scale