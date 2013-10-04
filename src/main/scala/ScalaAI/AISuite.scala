package ScalaAI
import scala.collection.JavaConversions._

object AISuite extends App {
  def testGraph: Node = {
    // From http://en.wikibooks.org/wiki/Artificial_Intelligence/Search/Exhaustive_search/Breadth-first_search

    var root: Node = new Node(0)

    var roomA: Node = new Node(1)
    var roomB: Node = new Node(2)
    var roomC: Node = new Node(3)

    val deskA: Node = new Node(4)
    val deskB:Node = new Node(5)

    roomA.children += deskA
    roomB.children += deskB
    
    root.children += roomA
    root.children += roomB
    root.children += roomC

    return root
  }

  def testTree: Node = {
    // From http://en.wikipedia.org/wiki/File:AB_pruning.svg
    var root: Node = new Node(0)

    // Nodes named n(depth)_(id)
    // Terminal Nodes
    val n4_1: Node = new Node(5)
    val n4_2: Node = new Node(6)

    val n4_3: Node = new Node(7)
    val n4_4: Node = new Node(4)
    val n4_5: Node = new Node(5)

    val n4_6: Node = new Node(3)

    val n4_7: Node = new Node(6)

    val n4_8: Node = new Node(6)
    val n4_9: Node = new Node(9)


    val n4_10: Node = new Node(7)
    
    val n4_11: Node = new Node(5)

    val n4_12: Node = new Node(9)
    val n4_13: Node = new Node(8)

    val n4_14: Node = new Node(6)

    // Depth 3 Nodes
    var n3_1: Node = new Node(0)
    n3_1.children += n4_1
    n3_1.children += n4_2

    var n3_2: Node = new Node(0)
    n3_2.children += n4_3
    n3_2.children += n4_4
    n3_2.children += n4_5

    var n3_3: Node = new Node(0)
    n3_3.children += n4_6
    
    var n3_4: Node = new Node(0)
    n3_4.children += n4_7
    
    var n3_5: Node = new Node(0)
    n3_5.children += n4_8
    n3_5.children += n4_9
    
    var n3_6: Node = new Node(0)
    n3_6.children += n4_10
    
    var n3_7: Node = new Node(0)
    n3_7.children += n4_11
    
    var n3_8: Node = new Node(0)
    n3_8.children += n4_12
    n3_8.children += n4_13

    var n3_9: Node = new Node(0)
    n3_9.children += n4_14

    // Depth 2 nodes

    var n2_1: Node = new Node(0)
    n2_1.children += n3_1
    n2_1.children += n3_2

    var n2_2: Node = new Node(0)
    n2_2.children += n3_3

    var n2_3: Node = new Node(0)
    n2_3.children += n3_4
    n2_3.children += n3_5

    var n2_4: Node = new Node(0)
    n2_4.children += n3_6

    var n2_5: Node = new Node(0)
    n2_5.children += n3_7
    
    var n2_6: Node = new Node(0)
    n2_6.children += n3_8
    n2_6.children += n3_9 

    // Depth 1 nodes
    var n1_1 = new Node(0)
    n1_1.children += n2_1
    n1_1.children += n2_2

    var n1_2 = new Node(0)
    n1_2.children += n2_3
    n1_2.children += n2_4

    var n1_3 = new Node(0)
    n1_3.children += n2_5
    n1_3.children += n2_6

    root.children += n1_1
    root.children += n1_2
    root.children += n1_3

    return root
  }

  Console.println("Running AI Suite")
  Console.println("========\n")

  // Infoless Search Should eventually return "shore" and should print path taken
  FlailWildly.run("beach", "shore")
  Console.println("--------\n")
  BackTracking.run("beach", "shore")
  Console.println("--------\n")

  // Graph search should look for 3, return the found number, and should print the path taken
  BreadthFirst.run(testGraph, 3)
  Console.println("--------\n")
  DepthFirst.run(testGraph, 3)
  Console.println("--------\n")

  // Adversarials should return 6.0
  MiniMax.run(testTree)
  Console.println("--------\n")
  AlphaBeta.run(testTree)
  Console.println("--------\n")
  NegaMax.run(testTree)
  Console.println("--------\n")

}


