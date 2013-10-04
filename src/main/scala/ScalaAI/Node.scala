package ScalaAI
import scala.collection.mutable.ArrayBuffer

class Node(datac: Int) {
  var data: Int = datac
  var children: ArrayBuffer[Node] = ArrayBuffer()
  var searched: Boolean = true
}
