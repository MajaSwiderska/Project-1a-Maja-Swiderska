package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Ellipse(width: Int, height: Int)
  case Group(shapes: Shape*)

object Shape:
  def rectangle(width: Int, height: Int): Shape =
    require(width >= 0, s"width must be >= 0, got $width")
    require(height >= 0, s"height must be >= 0, got $height")
    Rectangle(width, height)

  def ellipse(width: Int, height: Int): Shape =
    require(width >= 0, s"width must be >= 0, got $width")
    require(height >= 0, s"height must be >= 0, got $height")
    Ellipse(width, height)
