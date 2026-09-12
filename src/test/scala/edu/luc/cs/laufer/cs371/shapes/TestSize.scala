package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import TestFixtures.* 

class TestSize:
    @Test
    def testSimpleRectangle(): Unit = assertEquals(1, size(simpleRectangle))

    @Test
    def testSimpleEllipse(): Unit = assertEquals(1, size(simpleEllipse))

    @Test
    def testSimpleLocation(): Unit = assertEquals(1, size(simpleLocation))

    @Test
    def testBasicGroup(): Unit = assertEquals(2, size(basicGroup))

    @Test
    def testSimpleGroup(): Unit = assertEquals(2, size(simpleGroup))

    @Test
    def testComplexGroup(): Unit = assertEquals(5, size(complexGroup))

end TestSize