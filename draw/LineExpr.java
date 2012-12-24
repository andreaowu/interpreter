package draw;

import java.util.List;

/** A Expr for Line class.
 *  @author Andrea Wu
 */
class LineExpr extends Combination {

    /** Constructor for LineExpr that takes OPERANDS,
     * returns instance of RectExpr. */
    LineExpr(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of LineExpr with OPERANDS. */
    public LineExpr create(List<Expr> operands) {
        return new LineExpr(operands);
    }

    /** Returns the drawn line of the operands, using MACHINE. */
    Line execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 4
                && _operands.get(0).execute(machine).isNumber()
                && _operands.get(1).execute(machine).isNumber()
                && _operands.get(2).execute(machine).isNumber()
                && _operands.get(3).execute(machine).isNumber()) {
            double x0 = _operands.get(0).execute(machine).doubleValue();
            double y0 = _operands.get(1).execute(machine).doubleValue();
            double x1 = _operands.get(2).execute(machine).doubleValue();
            double y1 = _operands.get(3).execute(machine).doubleValue();
            return new Line(x0, y0, x1, y1, machine.getColor(),
                    machine.getLw());
        } else {
            throw new MyException("Error: incorrect args lineexpr");
        }
    }
}
