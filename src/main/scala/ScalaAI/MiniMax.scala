package ScalaAI
import scala.math._

object MiniMax {
  var pInf = Double.PositiveInfinity
  var nInf = Double.NegativeInfinity

  def isTerminal(node: Node): Boolean = {
    if(node.children.length > 0){
      return false
    }
    return true
  }

  def minimax(node: Node, depth: Int, maxing: Boolean): Double = {
   if(depth == 0 || isTerminal(node)) {
     return node.data
   }

  if(maxing) {
    var alpha = nInf
    for(child <- node.children) {
      val value = minimax(child, depth - 1, false)
      alpha = max(value, alpha)
      }
    return alpha
  } else {
    var alpha = pInf
    for(child <- node.children) {
      val value = minimax(child, depth - 1, true)
      alpha = min(value, alpha)
    }
    return alpha
   }
  }

  def run(root: Node):Double = {
    Console.println("Running Minimax")
    val value = minimax(root, 10, true)
    Console.println("Best terminal value is: " + value)
    return value
  }
}
