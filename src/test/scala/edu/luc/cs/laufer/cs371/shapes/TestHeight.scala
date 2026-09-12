package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import TestFixtures.* 

class TestHeight:

    @Test
    def testSimpleRectangle(): Unit = assertEquals(1, height(simpleRectangle))

    @Test
    def testSimpleEllipse(): Unit = assertEquals(1, height(simpleEllipse))

    @Test
    def testSimpleLocation(): Unit = assertEquals(2, height(simpleLocation))

    @Test
    def testBasicGroup(): Unit = assertEquals(2, height(basicGroup))

    @Test
    def testSimpleGroup(): Unit = assertEquals(3, height(simpleGroup))

    @Test
    def testComplexGroup(): Unit = assertEquals(6, height(complexGroup))

end TestHeight