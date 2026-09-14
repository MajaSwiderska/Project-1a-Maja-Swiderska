package edu.luc.cs.laufer.cs371.shapes

import Shape.*

//small demo program that prints the bounding box of a sample shape
//it shows how case classes equality works for rectangle
object Main:
  def main(args: Array[String]): Unit =
    //a rectangle at position (70, 30) with size 80x120
    val simpleLocation = Location(70, 30, Rectangle(80, 120))
    //should print Location(70,30,Rectangle(80,120))
    println(boundingBox(simpleLocation))
    //true -> same field values
    println(Rectangle(2, 3) == Rectangle(2, 3))
    //false -> different field values
    println(Rectangle(22, 33) == Rectangle(23, 34))
end Main
