package ScalaAI

object BreadthFirst {
  def searchNode(node: Node, goal: Int):Int = {
    if(node.data == goal) {
      Console.println("\nFound it!")
      return node.data
    }

    Console.println("Checking " + node.data + "'s children:") 
    for(child <- node.children) {
      Console.print(child.data + " ")
      if(child.data == goal) {
        Console.println("\nFound it!")
        return child.data
      }
    }

    Console.println("")

		for(child <- node.children) {
      val value = searchNode(child, goal)
      if(value > -1) return value
    }

    return -1
  }

  def run(root: Node, goal: Int):Int = {
    Console.println("Running BreadthFirst")
    return searchNode(root, goal)
  }
}
