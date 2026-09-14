package edu.luc.cs.laufer.cs371.shapes

import Shape.* 
import com.typesafe.scalalogging.Logger

//scale(factor, s) returns a copy of s where every dimension and every position is multiplied by factor
object scale:
    private val logger = Logger(getClass)

    def apply(factor: Int, s: Shape): Shape =
        logger.debug(s"scale input: $s")
        s match
            //multiply the leaf shapes dimensions
            case Rectangle(w, h) => Rectangle(w * factor, h * factor)
            case Ellipse(w, h)   => Ellipse(w * factor, h * factor)
            //scale both the position (x, y) and the inner shape
            case Location(x, y, shape) => Location(x * factor, y * factor, apply(factor, shape))
            //scale every child and then regroup them
            case Group(shapes*) => Group(shapes.map(apply(factor, _))*)
end scale