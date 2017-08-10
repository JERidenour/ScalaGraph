package viz.lyrics

class Node {

    private var _name = ""
    private var _label = ""

    def name = _name
    def label = _label

    def name_= (in:String):Unit = _name = in
    def label_= (in:String):Unit = _label = in

    override def toString: String = {
        s"""$name [label = "$label"];"""
    }

    def canEqual(a: Any) = a.isInstanceOf[Node]

    override def equals(that: Any): Boolean = that match {
            case that: Node => that.canEqual(this) && this.hashCode == that.hashCode
            case _ => false
    }

    override def hashCode: Int = {
        (if (this.name == null) 0 else this.name.hashCode)
    }
}

object Node {

    // weed out characters not accepted by graphviz
    def createName(input: String) = {
       input 
            .replace(" ", "_")
            .replace(".", "")
            .replace("""(""", "")
            .replace(""")""", "")
            .replace("&", "and")
            .replace("-", "")
            .replace(""""""", "")
            .replace("""'""", "")
            .replace("""[""", "")
            .replace("""]""", "")
            .replace("$", "S")
            .replace("2", "two")
            .replace("50", "fifty")
            .replace("7", "seven")
            .replace("69", "sixtynine")
            .replace("1", "one")

    }

    def createLabel(input: String) = {
       input 
            .replace(""""""", "")
            .replace("""'""", "")

    }

    def apply(input: String) = {

        var n = new Node 
        n.label = createLabel(input) 
        n.name = createName(input)
        n
    }
}
