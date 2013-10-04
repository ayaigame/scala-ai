package ScalaAI
import scala.math._

object AlphaBeta {
 def isTerminal(node: Node): Boolean = {
    if(node.children.length > 0){
      return false
    }
    return true
  }

  def minimax(node: Node, depth: Int, a: Double, b: Double, maxing: Boolean): Double = {
    if(depth == 0 || isTerminal(node)) {
       return node.data
    }

    var alpha : Double = a
    var beta : Double = b

    if(maxing) {
      for(child <- node.children) {
        
        alpha = max(alpha, minimax(child, depth - 1, alpha, beta, false))
        
        //ALPHA-BETA PRUNING
        if(beta <= alpha)
          return alpha

      }
      return alpha
    } else {
      for(child <- node.children) {
       
        beta = min(beta, minimax(child, depth - 1, alpha, beta, true))

        //ALPHA-BETA PRUNING
        if(beta <= alpha)
          return beta

      }
      return beta
    }
  }

  def run(root: Node):Double = {
    
    Console.println("Running AlphaBeta")
    val value = minimax(root, 10, Double.NegativeInfinity, Double.PositiveInfinity, true)
    Console.println("Best terminal value is: " + value)
    return value
  }

}
