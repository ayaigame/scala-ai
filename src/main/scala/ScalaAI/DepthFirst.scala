package ScalaAI

object DepthFirst {
  def searchNode(node: Node, goal: Int):Int = {
    if(node.data == goal) {
      Console.println("\nFound it!")
      return node.data
    }

    Console.println("Checking " + node.data)


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
