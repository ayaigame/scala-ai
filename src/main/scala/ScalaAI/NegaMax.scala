package ScalaAI

import scala.collection.mutable.ArrayBuffer


object NegaMax {

  def negamax(node: Node, depth: Double, color: Double):Double = {
    //if depth is 0 or node is terminal (no children), then return color times node data
    if(depth == 0 || node.children.length == 0) {
      //println("ChildVal of depth: " + (depth) + " is " + (color*node.data))
      return color * node.data
    }
    var bestvalue:Double = Double.NegativeInfinity
    var childNodes:ArrayBuffer[Node] = node.children
    for (child <- childNodes) {
    	var childval:Double = -negamax(child, depth-1, color)
    	//println("Bestval is " + bestvalue)
    	bestvalue = math.max(bestvalue, childval)
    }
    
    return bestvalue
  }
  
  def run(root: Node):Double = {
    println("Running Negamax")
    var nega: Double = negamax(root, 5, 1)
    println("The NegaMax value is: " + nega)
    return nega
  }
}
