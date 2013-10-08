package ScalaAI

object DepthFirst {
  def searchNode(node: Node, goal: Int):Int = {

    Console.println("Checking " + node.data)
    if(node.data == goal) {
      Console.println("\nFound it!")
      return node.data
    }



    for(child <- node.children) {
      val value = searchNode(child, goal)
      if(value > -1) return value
    }

    return -1
  }

  def run(root: Node, goal: Int):Int = {
    Console.println("Running Depthfirst search")
    return searchNode(root, goal)
  }
}
