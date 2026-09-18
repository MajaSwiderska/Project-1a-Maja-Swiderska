package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) */
//shape is an algebraic data type, it represents a tree of shapes.
//There are two kinds of nodes:
// Leaves: rectangle and ellipse
// Containers: Location and Group
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int) //a rectangle with width and height
  case Location(x: Int, y: Int, shape: Shape) //shifts the inner shape by (x, y)
  case Ellipse(width: Int, height: Int) // an ellipse with width and height
  case Group(shapes: Shape*) // a group of zero or more shapes

//These check that dimensions are non negative before creating a shape.
//If width or height is negative, they throw an IllegalArgumentException
object Shape:
  def rectangle(width: Int, height: Int): Shape =
    require(width >= 0, s"width must be >= 0, got $width")
    require(height >= 0, s"height must be >= 0, got $height")
    new Rectangle(width, height)

  def ellipse(width: Int, height: Int): Shape =
    require(width >= 0, s"width must be >= 0, got $width")
    require(height >= 0, s"height must be >= 0, got $height")
    new Ellipse(width, height)
