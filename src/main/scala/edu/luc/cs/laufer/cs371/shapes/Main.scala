package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object Main:
  def main(args: Array[String]): Unit =
    val simpleLocation = Location(70, 30, Rectangle(80, 120))
    println(boundingBox(simpleLocation))
    println(Rectangle(2, 3) == Rectangle(2, 3))
    println(Rectangle(22, 33) == Rectangle(23, 34))
end Main
