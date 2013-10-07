package ScalaAI
import java.util.Random

object FlailWildly {
  def run(s1: String, s2: String):String = {
    Console.println("\n\nRunning FlailWildly")

    // a rule is (index, char)
    // so for the word "beach" the rule (0,p) will result in "peach"

    var currentState = s1
    var endState = s2
    var alphabet = List[Char]('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    val source = scala.io.Source.fromFile("src/test/resources/fiveLetterWords.txt")
    val lines = source.mkString
    var words = lines.split("\n")
    var k = 0
    for( k <- 0 until words.length) {
        words(k) = words(k).trim()
    }

    source.close()

    def goal(state: String):Boolean = {
    	if(state == endState){
    		return true
    	}else{
    		return false
    	}	
    }

    def applyRule(rule: (Int, Char), state: String):String = {
    	var tempArray = state.toCharArray()
    	tempArray(rule._1) = rule._2
        var newState = ""
        for(i <- tempArray) {
            newState = newState + i.toString()
        }

        return newState
    }

    def precondition(rule: (Int, Char), state: String):Boolean = {
        var tempState = applyRule(rule, state)
        var foundit = 0
        if(tempState == state){
            return false
        }
        for(i <- words) {
            if(tempState == i){
                return true
            }
        }
        return false
    }

    def generateRules(state: String):List[(Int, Char)] = {
        var possibleRules = List[(Int, Char)]()
        var tempState = state.toCharArray()

        var i = 0
        for(i <- 0 until tempState.length) {
            for(j <- alphabet) {
                var tempRule = (i,j)
                if(precondition(tempRule, state)){
                    possibleRules = possibleRules :+ tempRule
                }  
            }
        }

        return possibleRules
    }

    def describeState(state: String) = {
        Console.println("Current State: " + state)
    }

    def describeRule(rule: (Int, Char)) = {
        Console.println("Change letter in position " + rule._1 + " to " + rule._2)
    }

    var count = 0

    Console.println("Start State: " + currentState)

    while(!goal(currentState)){
        var possibleChoices = generateRules(currentState)
        //describeState(currentState)
        //Console.println("Possible Rules: ")
        for( i <- possibleChoices) {
            //describeRule(i)
        }
        var rand = new Random(System.currentTimeMillis())
        var random_index = rand.nextInt(possibleChoices.length)
        var result = possibleChoices(random_index)
        //Console.println("Rule picked: ")
        //describeRule(result)
        currentState = applyRule(result, currentState)
        //Console.println("\n")
        count = count + 1
    }

    Console.println("Final State: " + currentState)
    Console.println("FlailWildly finished after " + count + " rules where applied\n\n")

    return currentState
  }
}