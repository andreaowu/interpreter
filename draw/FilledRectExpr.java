package draw;

import java.util.List;

/** A Expr for FilledRect class.
 *  @author Andrea Wu
 */
class FilledRectExpr extends Combination {

    /** Constructor for FilledRectExpr that takes OPERANDS,
     * returns instance of FilledRectExpr. */
    FilledRectExpr(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of FilledRectExpr with OPERANDS. */
    public FilledRectExpr create(List<Expr> operands) {
        return new FilledRectExpr(operands);
    }

    /** Returns the drawn rectangle filled in, using MACHINE. */
    FilledRect execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 4) {
            boolean xTF = true;
            double x = -1.0;
            boolean yTF = true;
            double y = -1.0;
            double w = -1.0;
            double h = -1.0;
            if (_operands.get(0).isNumeral()) {
                xTF = false;
                x = _operands.get(0).execute(machine).doubleValue();
            } else if (_operands.get(0).isSymbol()) {
                Symbol a = (Symbol) _operands.get(0);
                Value vA = a.execute(machine);
                if (vA.isNumber()) {
                    xTF = false;
                    x = vA.doubleValue();
                }
            }
            if (_operands.get(1).isNumeral()) {
                yTF = false;
                y = _operands.get(1).execute(machine).doubleValue();
            } else if (_operands.get(1).isSymbol()) {
                Symbol b = (Symbol) _operands.get(1);
                Value vB = b.execute(machine);
                if (vB.isNumber()) {
                    yTF = false;
                    y = vB.doubleValue();
                }
            }
            if (_operands.get(2).isNumeral()) {
                w = _operands.get(2).execute(machine).doubleValue();
            } else if (_operands.get(2).isSymbol()) {
                Symbol c = (Symbol) _operands.get(2);
                Value vC = c.execute(machine);
                if (vC.isNumber()) {
                    w = vC.doubleValue();
                }
            }
            if (_operands.get(3).isNumeral()) {
                h = _operands.get(3).execute(machine).doubleValue();
            } else if (_operands.get(3).isSymbol()) {
                Symbol d = (Symbol) _operands.get(3);
                Value vD = d.execute(machine);
                if (vD.isNumber()) {
                    h = vD.doubleValue();
                }
            }
            if (xTF || yTF || w < 0.0 || h < 0.0) {
                throw new MyException("Error: one or more"
                        + "variables isn't Numeral or Symbol");
            }
            return new FilledRect(x, y, w, h,
                    machine.getColor(), machine.getLw());
        } else {
            throw new MyException("Error: incorrect args rect");
        }
    }
}
