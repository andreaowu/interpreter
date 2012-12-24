package draw;

import java.util.List;

/** A Expr for Circ class.
 *  @author Andrea Wu
 */
class BlankExpr extends Combination {

    /** Constructor for BlankExpr that takes OPERANDS,
     *  returns instance of BlankExpr. */
    BlankExpr(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of CircExpr with OPERANDS. */
    public BlankExpr create(List<Expr> operands) throws MyException {
        return new BlankExpr(operands);
    }

    /** Returns the drawn circle of the operands, using MACHINE. */
    Blank execute(Interpreter machine) throws MyException {
        return new Blank("hi I am just a placeholder");
    }
}
