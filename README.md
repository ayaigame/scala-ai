# Scala AI

> A practice repo for us to brush up on Scala/AI

## Scala

Documentation, Install Guide: http://www.scala-lang.org/documentation/

Style Guide: http://docs.scala-lang.org/style/ (tl;dr: no tabs, two space please)

## SBT

> Scala Build Tool

Nowhere near as good as leiningen, but whatever...

Install Guide: http://www.scala-sbt.org/

```
    $ # To compile
    $ sbt compile

    $ # To run
    $ # This will compile, but do sbt compile at first to check
    $ # for anything wrong
    $ sbt run

    $ # To test
    $ sbt test
    $ # Make sure to run this before you submit your pull request 
    $ # as I already set up a unit test for your function.
```

There's an eclipse plugin for it, but I think everyone here probably knows how to use the terminal, right?

http://scala-ide.org/docs/user/gettingstarted.html

https://github.com/typesafehub/sbteclipse

If you add this plugin, do it globally.

## Tasks

### Josh Henry - Flail Wildly

Basically, you're going to take one word "beach" and turn it into the word "shore". You can only change one letter at a time (you do it randomly) and only if the word you're changing to is a valid word. A list of words is in scala/main/resources.

Look at Problem 2 for this:

https://www.cs.drexel.edu/~jpopyack/Courses/AI/Sp11/assignments/HW1/index.html

### Jared Roberts - Backtrack

You should have already done this one before, just try it in Scala. A list of words is in scala/main/resources.

If you need a refresher Problem 2 of this:

https://www.cs.drexel.edu/~jpopyack/Courses/AI/Sp11/assignments/HW2/index.html

### Kurt Wheeler - Breadth First

I gave you a graph where you are looking for the number 3. Do it breadth first. Print out the search path and return the key as it is found. Breadth first should found the answer almost instantly.

http://en.wikipedia.org/wiki/Breadth-first_search
http://en.wikibooks.org/wiki/Artificial_Intelligence/Search/Exhaustive_search/Breadth-first_search
https://www.cs.drexel.edu/~jpopyack/Courses/AI/Sp11/notes/Graphsearch-continued.pdf

### Ryan Lerch - Depth First

I gave you a graph where you are looking for the number 3. Do it depth first. Print out the search path and return the key as it is found. You do not need to iteratively deepen or worry about your depth limit since it's like 3 levels deep

http://en.wikipedia.org/wiki/Depth-first_search
http://en.wikibooks.org/wiki/Artificial_Intelligence/Search/Heuristic_search/Depth-first_search

### Timothy Hahn - Minimax
Already done. Jarrad and Rob are going to be doing variations of minimax, so feel free to copy stuff from mine.

### Rob Mruczek - Alpha Beta
Basically modify my minimax to support alpha beta pruning. Print a message when something is pruned. You don't need to do a heuristic check, just grab the data at the node, and instead of generating rules, go through all the children.

### Jarrad Battaglia - Negamax
Basically turn my minimax into a negamax. "color" is either the number 1 or -1. You may be able to keep my boolean parameters, by using an if statement/negating the statement. You do not have to use alpha beta pruning. The function GenerateMoves is just all the children of a node.

http://en.wikipedia.org/wiki/Negamax

