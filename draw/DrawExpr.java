package draw;

import java.util.List;

/** A Expr for drawing.
 *  @author Andrea Wu
 */
class DrawExpr extends Combination {

    /** Constructor for RectExpr that takes OPERANDS,
     * returns instance of RectExpr. */
    DrawExpr(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of RectExpr with OPERANDS. */
    public DrawExpr create(List<Expr> operands) {
        return new DrawExpr(operands);
    }

    /** Returns the drawn rectangle of the operands, using MACHINE. */
    Value execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 1
                && _operands.get(0).execute(machine).isPicture()) {
            Picture p = (Picture) _operands.get(0).execute(machine);
            p.draw(machine.getPW());
            return null;
        } else {
            throw new MyException("Error: drawexpr args");
        }
    }

}
