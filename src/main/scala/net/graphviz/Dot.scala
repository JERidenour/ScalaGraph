package viz.lyrics

import scala.collection.mutable.ArrayBuffer

class Dot {

    private var _graphParam = "[overlap=false " + 
        "outputorder=edgesfirst " +
        "size=24 bgcolor=gray];"
    private var _edgeParam = "[weight=2, penwidth=5];"
    private var _nodeParam = "[fontsize=32 width=5 " + 
        "shape=ellipse style=filled fillcolor=white];"

    var nodeBuffer = new ArrayBuffer[Node]
    var edgeBuffer = new ArrayBuffer[Edge]
    
    def graphParam = _graphParam
    def nodeParam = _nodeParam
    def edgeParam = _edgeParam
    
    def graphParam_= (in:String):Unit = _graphParam = in
    def edgeParam_= (in:String):Unit = _edgeParam = in
    def nodeParam_= (in:String):Unit = _nodeParam = in

    override def toString: String = {

        var s = "graph g { " +
            "graph" + _graphParam +
            "edge" + _edgeParam +
            "node" + _nodeParam 

        s += this.nodeBuffer.mkString
        s += this.edgeBuffer.distinct.mkString
        s += "}"
        s
    }
}

object Dot {

    def apply(gs: String, es: String, ns: String)={

        var d = new Dot()
        d.graphParam = gs
        d.edgeParam = es
        d.nodeParam = ns
        d
    }
}
