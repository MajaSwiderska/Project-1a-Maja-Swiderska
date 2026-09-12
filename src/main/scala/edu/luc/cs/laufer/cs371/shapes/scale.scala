package edu.luc.cs.laufer.cs371.shaoes

import Shape.* 

object scale:
    def apply(factor: Int, s: Shape): Shape = s match
        case Rectangle(w, h) => Rectangle(w * factor, h * factor)
        case Ellipse(w, h)   => Ellipse(w * factor, h * factor)
        case Location(x, y, shape) => Location(x * factor, y * factor, apply(factor, shape))
        case Group(shapes*) => Group(shapes.map(apply(factor, _))*)
end scale