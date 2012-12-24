package draw;

import java.util.List;

/** A Expr for Circ class.
 *  @author Andrea Wu
 */
class CircExpr extends Combination {

    /** Constructor for CircExpr that takes OPERANDS,
     *  returns instance of CircExpr. */
    CircExpr(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of CircExpr with OPERANDS. */
    public CircExpr create(List<Expr> operands) throws MyException {
        return new CircExpr(operands);
    }

    /** Returns the drawn circle of the operands, using MACHINE. */
    Circ execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 3) {
            double x = -1.0;
            double y = -1.0;
            boolean radian = true;
            double rad = 0.0;
            if (_operands.get(0).isNumeral()) {
                x = _operands.get(0).execute(machine).doubleValue();
            } else if (_operands.get(0).isSymbol()) {
                Symbol a = (Symbol) _operands.get(0);
                Value vA = a.execute(machine);
                if (vA.isNumber()) {
                    x = vA.doubleValue();
                } else {
                    throw new MyException("Error: var not Number");
                }
            }
            if (_operands.get(1).isNumeral()) {
                y = _operands.get(1).execute(machine).doubleValue();
            } else if (_operands.get(1).isSymbol()) {
                Symbol b = (Symbol) _operands.get(1);
                Value vB = b.execute(machine);
                if (vB.isNumber()) {
                    y = vB.doubleValue();
                } else {
                    throw new MyException("Error: var not Number");
                }
            }
            if (_operands.get(2).isNumeral()) {
                radian = false;
                rad = _operands.get(2).execute(machine).doubleValue();
            } else if (_operands.get(2).isSymbol()) {
                Symbol c = (Symbol) _operands.get(2);
                Value vC = c.execute(machine);
                if (vC.isNumber()) {
                    radian = false;
                    rad = vC.doubleValue();
                } else {
                    throw new MyException("Error: var not Number");
                }
            }
            if (x == -1.0 || y == -1.0 || radian) {
                throw new MyException("Error: one or more"
                        + "variables isn't Numeral or Symbol");
            }
            return new Circ(x, y, rad,
                    machine.getColor(), machine.getLw());
        } else {
            throw new MyException("Error: incorrect args circexpr");
        }
    }

}
