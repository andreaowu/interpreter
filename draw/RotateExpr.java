package draw;

import java.util.List;

/** A Expr for rotating.
 *  @author Andrea Wu
 */
class RotateExpr extends Combination {

    /** Constructor for RectExpr that takes OPERANDS,
     * returns instance of RectExpr. */
    RotateExpr(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of RectExpr with OPERANDS. */
    public RotateExpr create(List<Expr> operands) {
        return new RotateExpr(operands);
    }

    /** Returns the drawn rectangle of the operands, using MACHINE. */
    Value execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 2
                && _operands.get(0).execute(machine).isPicture()
                && _operands.get(1).execute(machine).isNumber()) {
            Picture p = (Picture) _operands.get(0).execute(machine);
            double x = _operands.get(1).execute(machine).doubleValue();
            return p.rotate(x);
        } else {
            throw new MyException("Error: rotateexpr args");
        }
    }

}
