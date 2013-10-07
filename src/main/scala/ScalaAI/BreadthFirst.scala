package ScalaAI

object BreadthFirst {
  def run(root: Node, goal: Int):Int = {
    Console.println("Running BreadthFirst")
    if(root.data == goal) {
      Console.println("Found it at root!")
      return root.data
    }
    else {
      return searchNode(root, goal)
    }
  }

  def searchNode(node: Node, goal: Int):Int = {
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
}
