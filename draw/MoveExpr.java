package draw;

import java.util.List;

/** A Expr for moving.
 *  @author Andrea Wu
 */
class MoveExpr extends Combination {

    /** Constructor for RectExpr that takes OPERANDS,
     * returns instance of RectExpr. */
    MoveExpr(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of RectExpr with OPERANDS. */
    public MoveExpr create(List<Expr> operands) {
        return new MoveExpr(operands);
    }

    /** Returns the drawn rectangle of the operands, using MACHINE. */
    Value execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 3
                && _operands.get(0).execute(machine).isPicture()
                && _operands.get(1).execute(machine).isNumber()
                && _operands.get(2).execute(machine).isNumber()) {
            Picture p = (Picture) _operands.get(0).execute(machine);
            double x = _operands.get(1).execute(machine).doubleValue();
            double y = _operands.get(2).execute(machine).doubleValue();
            return p.move(x, y);
        } else {
            throw new MyException("Error: moveexpr args");
        }
    }

}
