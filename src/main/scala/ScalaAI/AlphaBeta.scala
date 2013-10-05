package ScalaAI
import scala.math._

object AlphaBeta {

  var branchesPruned : Int = 0 
  
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
        if(beta <= alpha) {
          Console.println("Branch pruned for max:\nalpha:"+alpha+"\nbeta:"+beta+"\ndepth:"+depth+"\n");
          branchesPruned +=1;
          return alpha
        }

      }
      return alpha
    } else {
      for(child <- node.children) {

        beta = min(beta, minimax(child, depth - 1, alpha, beta, true))

        //ALPHA-BETA PRUNING
        if(beta <= alpha) {
          Console.println("Branch pruned for min:\nalpha:"+alpha+"\nbeta:"+beta+"\ndepth:"+depth+"\n");
          branchesPruned +=1;
          return beta
        }

      }
      return beta
    }
  }

  def run(root: Node):Double = {
    
    Console.println("Running AlphaBeta\n")
    val value = minimax(root, 10, Double.NegativeInfinity, Double.PositiveInfinity, true)

    Console.println("Branches pruned: "+branchesPruned);
    Console.println("Best terminal value is: " + value)
    return value
  }

}
