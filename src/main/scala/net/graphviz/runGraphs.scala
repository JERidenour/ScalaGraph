package net.graphviz

import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets
import sys.process._

object myMainClass{
    def main(args: Array[String]) {
        
        // create dot object with default graph params
        val dot = new Dot()

        // add nodes
        dot.nodeBuffer += Node.apply("Module 1")
        dot.nodeBuffer += Node.apply("Module 2")

        // add edges
        dot.edgeBuffer += Edge.apply("Module 1", "Module 2")

        // create .dot file and compile
        Files.write(Paths.get("src/main/resources/graph.dot"), 
            dot.toString.getBytes(StandardCharsets.UTF_8))

        "neato src/main/resources/graph.dot -Tpng -osrc/main/resources/graph.png " !

    }
}
