package draw;

import java.util.List;

/** An Expr for Linewidth.
 *  @author Andrea Wu
 */
class LinewidthExpr extends Combination {

    /** Constructor for Linewidth with OPERANDS. */
    LinewidthExpr(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of Linewidth with
     * OPERANDS as instance variables. */
    public LinewidthExpr create(List<Expr> operands) {
        return new LinewidthExpr(operands);
    }

    /** Changes the linewidth, using MACHINE, returns new one. */
    Linewidth execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 1) {
            if (_operands.get(0).isNumeral()) {
                double a = _operands.get(0).execute(machine).doubleValue();
                if (a > 0.0) {
                    machine.setLw(a);
                    return new Linewidth(a);
                } else {
                    throw new MyException("Error: var not +");
                }
            } else if (_operands.get(0).isSymbol()) {
                Symbol b = (Symbol) _operands.get(0);
                Value v = b.execute(machine);
                if (v.isNumber()) {
                    double result = v.doubleValue();
                    if (result > 0.0) {
                        machine.setLw(result);
                        return new Linewidth(result);
                    } else {
                        throw new MyException("Error: var not +");
                    }
                } else {
                    throw new MyException("Error: var not Number");
                }
            } else {
                throw new MyException("Error: operands"
                        + "not numeral or symbol");
            }
        } else {
            throw new MyException("Error: incorrect args linewidthexpr");
        }
    }

}
