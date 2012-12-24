package draw;

import java.io.PrintWriter;
import java.util.Hashtable;
import java.io.IOException;

/** An Interpreter maintains all necessary information about the running
 *  program, such as the values of variables and the destination of output.
 *  @author Andrea Wu
 */
class Interpreter {

    /** Makes a hastable for operators and shape exprs. */
    private static Hashtable<String, Expr> h;
    /** Makes a hastable for variables that are yet to be assigned. */
    private static Hashtable<String, Value> hVar;
    /** Private variable _psOut. */
    private PrintWriter _psOut;
    /** Private variable rgb.*/
    private double[] _rgb;
    /** Private variable linewidth. */
    private double _lw;

    /** An Interpreter that prints its Postscript output on
     *  PSOUT. */
    Interpreter(PrintWriter psOut) {
        _psOut = psOut;
        Hashtable<String, Expr> hash = new Hashtable<String, Expr>();
        Hashtable<String, Value> hashVar = new Hashtable<String, Value>();
        double[] rgb = new double[3];
        hash.put("+", new Plus(null));
        hash.put("-", new Minus(null));
        hash.put("*", new Multiply(null));
        hash.put("/", new Divide(null));
        hash.put("sin", new Sin(null));
        hash.put("cos", new Cosine(null));
        hash.put("sqrt", new SquareRoot(null));
        hash.put("rect", new RectExpr(null));
        hash.put("filledrect", new FilledRectExpr(null));
        hash.put("circ", new CircExpr(null));
        hash.put("filledcirc", new FilledCircExpr(null));
        hash.put("line", new LineExpr(null));
        hash.put("group", new GroupExpr(null));
        hash.put("linewidth", new LinewidthExpr(null));
        hash.put("color", new ColorExpr(null));
        hash.put("draw", new DrawExpr(null));
        hash.put("move", new MoveExpr(null));
        hash.put("rotate", new RotateExpr(null));
        hash.put("scale", new ScaleExpr(null));
        hash.put(":=", new Define(null));
        hash.put("for", new For(null));
        this.h = hash;
        this.hVar = hashVar;
        rgb[0] = 0.0;
        rgb[1] = 0.0;
        rgb[2] = 0.0;
        this._rgb = rgb;
        this._lw = 1.0;
    }

    /** A method that gets operator or shapeexpr OPERANDS from the hashtable.
     * Returns Expr from hashtable. */
    Expr getOpOrShape(String operands) {
        return h.get(operands);
    }

    /** A method that gets variable OPERANDS from the hashtable.
     * Returns Expr from hashtable. */
    Value getVar(String operands) {
        return hVar.get(operands);
    }

    /** A method that puts OPERANDS with OPERATOR into the hashtable.
     * Returns void from hashtable. */
    void put(String operator, Value operands) {
        hVar.put(operator, operands);
    }

    /** Method that takes RED, GREEN, BLUE and returns void. */
    void setColor(double red, double green, double blue) {
        _rgb[0] = red;
        _rgb[1] = green;
        _rgb[2] = blue;
    }

    /** Method that returns _rgb. */
    double[] getColor() {
        return _rgb;
    }

    /** Method that sets _lw to LW, returns void. */
    void setLw(double lw) {
        this._lw = lw;
    }

    /** Method that returns _lw. */
    double getLw() {
        return _lw;
    }

    /** Method that returns _psOut. */
    PrintWriter getPW() {
        return _psOut;
    }

    /** Read a drawing program from RDR and execute it.
     *  Returns void.
     */
    void readAndExecute(ExprReader rdr) throws IOException, MyException {
        _psOut.println("%!PS-Adobe-2.0");
        _psOut.println("");
        Expr temp = rdr.read();
        while (temp != null) {
            temp.execute(this);
            temp = rdr.read();
        }
        _psOut.println("");
        _psOut.println("showpage");
    }
}
