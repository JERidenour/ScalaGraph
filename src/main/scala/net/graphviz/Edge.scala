package viz.lyrics

class Edge {

    private var _leftName = ""
    private var _rightName = ""
    private var _color = "#FFFFFF"
    private var _tooltip = ""

    def leftName = _leftName
    def rightName = _rightName
    def color = _color
    def tooltip = _tooltip

    def leftName_= (in:String):Unit = _leftName = in
    def rightName_= (in:String):Unit = _rightName = in
    def color_= (in:String):Unit = _color = in
    def tooltip_= (in:String):Unit = _tooltip = in

    override def toString: String = {
        if(this.tooltip==""){ 
            s"""$leftName -- $rightName [color="$color"];"""
        }else{
            s"""$leftName -- $rightName [color="$color" label="$tooltip"];"""
        }
    }

    def canEqual(a: Any) = a.isInstanceOf[Edge]

    override def equals(that: Any): Boolean = that match {
        case that: Edge => that.canEqual(this) && this.hashCode == that.hashCode
        case _ => false
    }

    // set the hash code to the sum, since they are non-directional
    override def hashCode: Int = {
        if ( (this.leftName==null) || (this.rightName==null) || (this.color==null) ) {
            0
        } else {
            this.leftName.hashCode + this.rightName.hashCode + this.color.hashCode
        }
    }
}

object Edge {

    // weed out characters not accpeted by graphviz
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

    def apply(ln: String, rn: String, c: String, tp: String) = {

        var v = new Edge 
        v.leftName = createName(ln)
        v.rightName = createName(rn)
        v.color = c
        v.tooltip = tp
        v
    }
    def apply(ln: String, rn: String, c: String) = {

        var v = new Edge 
        v.leftName = createName(ln)
        v.rightName = createName(rn)
        v.color = c
        v
    }
}
