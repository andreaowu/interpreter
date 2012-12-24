package draw;

import java.util.List;

/** A Expr for Rect class.
 *  @author Andrea Wu
 */
class RectExpr extends Combination {

    /** Constructor for RectExpr that takes OPERANDS,
     * returns instance of RectExpr. */
    RectExpr(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of RectExpr with OPERANDS. */
    public RectExpr create(List<Expr> operands) {
        return new RectExpr(operands);
    }

    /** Returns the drawn rectangle of the operands, using MACHINE. */
    Rect execute(Interpreter machine) throws MyException {
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
                Value vA = _operands.get(0).execute(machine);
                if (vA.isNumber()) {
                    xTF = false;
                    x = vA.doubleValue();
                } else {
                    throw new MyException("Error: var not Numeral");
                }
            }
            if (_operands.get(1).isNumeral()) {
                yTF = false;
                y = _operands.get(1).execute(machine).doubleValue();
            } else if (_operands.get(1).isSymbol()) {
                Value vB = _operands.get(1).execute(machine);
                if (vB.isNumber()) {
                    yTF = false;
                    y = vB.doubleValue();
                } else {
                    throw new MyException("Error: var not Numeral");
                }
            }
            if (_operands.get(2).isNumeral()) {
                w = _operands.get(2).execute(machine).doubleValue();
            } else if (_operands.get(2).isSymbol()) {
                Value vC = _operands.get(2).execute(machine);
                if (vC.isNumber()) {
                    w = vC.doubleValue();
                } else {
                    throw new MyException("Error: var not Numeral");
                }
            }
            if (_operands.get(3).isNumeral()) {
                h = _operands.get(3).execute(machine).doubleValue();
            } else if (_operands.get(3).isSymbol()) {
                Value vD = _operands.get(3).execute(machine);
                if (vD.isNumber()) {
                    h = vD.doubleValue();
                } else {
                    throw new MyException("Error: var not Numeral");
                }
            }
            if (xTF || yTF || w < 0.0 || h < 0.0) {
                throw new MyException("Error: not Numeral/Symbol");
            }
            return new Rect(x, y, w, h, machine.getColor(), machine.getLw());
        } else {
            throw new MyException("Error: cannot draw rectangle");
        }
    }

}
