package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(w, h) => Location(0, 0, Rectangle(w, h))
    case Ellipse(w, h) => Location(0, 0, Rectangle(w, h))
    case Location(x, y, shape) =>
      val Location(bx, by, Rectangle(bw, bh)) = apply(shape): @unchecked
      Location(x + bx, y + by, Rectangle(bw, bh))
    case Group(shapes*) =>
      if shapes.isEmpty then Location(0, 0, Rectangle(0, 0))
      else shapes.map(apply).reduce(union)

  def union(a: Location, b: Location): Location =
    val Location(ax, ay, Rectangle(aw, ah)) = a: @unchecked
    val Location(bx, by, Rectangle(bw, bh)) = b: @unchecked
    val minX = math.min(ax, bx)
    val minY = math.min(ay, by)
    val maxX = math.max(ax + aw, bx + bw)
    val maxY = math.max(ay + ah, by + bh)
    Location(minX, minY, Rectangle(maxX - minX, maxY - minY))


end boundingBox
