package ScalaAI

import org.junit.Test
import org.junit.Assert._

class AISuiteTest {

  @Test def flailTest(){
    assertEquals("shore", FlailWildly.run("beach", "shore"))
  }

  @Test def backTrackTest(){
    assertEquals("shore", BackTracking.run("beach", "shore"))
  }

  @Test def breadthTest(){
    assertEquals(3, BreadthFirst.run(AISuite.testGraph, 3))
  }

  @Test def depthTest(){
    assertEquals(3, DepthFirst.run(AISuite.testGraph, 3)) 
  }

  // Note, assertEquals for float is:
  // assertEquals(Float expected, Float actual, Float delta)
  @Test def miniMaxTest() {
    assertEquals(6.0, MiniMax.run(AISuite.testTree), .1)
  }
  @Test def alphaBetaTest(){
      assertEquals(6.0, AlphaBeta.run(AISuite.testTree), .1)
    }
  @Test def negaMaxTest(){
      assertEquals(6.0, NegaMax.run(AISuite.testTree), .1)
  }


}
