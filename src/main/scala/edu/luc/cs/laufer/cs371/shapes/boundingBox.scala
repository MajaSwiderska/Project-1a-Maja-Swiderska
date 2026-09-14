package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*
import com.typesafe.scalalogging.Logger

//this returns the smallest rectangle that contains the shape s
//the result is always a Location that holds a rectangle
object boundingBox:
  private val logger = Logger(getClass)

  def apply(s: Shape): Location =
    logger.debug(s"boundingBox input: $s")
    //look at which kind of shape s is and handle each case
    s match
    //a rectangles bounding box is itself, starting at (0,0)
    case Rectangle(w, h) => Location(0, 0, Rectangle(w, h))
    //An ellipse is centered on its location
    //the bounding box spans from (-w, -h) to (+w, +h), size (2w, 2h)
    case Ellipse(w, h) => Location(-w, -h, Rectangle(2 * w, 2 * h))
    //a location shifts the inner shapes bounding box by (x,y)
    case Location(x, y, shape) =>
      val Location(bx, by, Rectangle(bw, bh)) = apply(shape): @unchecked
      Location(x + bx, y + by, Rectangle(bw, bh))
    //a group bounding box is the union of all it's childrens boxes
    //map(apply) computes each childs box, reduce(union) merges them
    case Group(shapes*) =>
      if shapes.isEmpty then Location(0, 0, Rectangle(0, 0))
      else shapes.map(apply).reduce(union)

  //combine two bounding boxes into one that contains both
  def union(a: Location, b: Location): Location =
    val Location(ax, ay, Rectangle(aw, ah)) = a: @unchecked
    val Location(bx, by, Rectangle(bw, bh)) = b: @unchecked
    val minX = math.min(ax, bx)
    val minY = math.min(ay, by)
    val maxX = math.max(ax + aw, bx + bw)
    val maxY = math.max(ay + ah, by + bh)
    Location(minX, minY, Rectangle(maxX - minX, maxY - minY))
end boundingBox
