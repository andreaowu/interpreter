package draw;

import java.util.List;

/** An Expr for Color.
 *  @author Andrea Wu
 */
class ColorExpr extends Combination {

    /** Constructor for Color with OPERANDS. */
    ColorExpr(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of color with
     * OPERANDS as instance variables. */
    public ColorExpr create(List<Expr> operands) {
        return new ColorExpr(operands);
    }

    /** Changes the color, using MACHINE, returns new one. */
    Color execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 3) {
            double x = -1.0;
            double y = -1.0;
            double z = -1.0;
            if (_operands.get(0).isNumeral()) {
                x = _operands.get(0).execute(machine).doubleValue();
            } else if (_operands.get(0).isSymbol()) {
                Symbol a = (Symbol) _operands.get(0);
                Value vA = a.execute(machine);
                if (vA.isNumber()) {
                    x = vA.doubleValue();
                }
            }
            if (_operands.get(1).isNumeral()) {
                y = _operands.get(1).execute(machine).doubleValue();
            } else if (_operands.get(1).isSymbol()) {
                Symbol b = (Symbol) _operands.get(1);
                Value vB = b.execute(machine);
                if (vB.isNumber()) {
                    y = vB.doubleValue();
                }
            }
            if (_operands.get(2).isNumeral()) {
                z = _operands.get(2).execute(machine).doubleValue();
            } else if (_operands.get(2).isSymbol()) {
                Symbol c = (Symbol) _operands.get(2);
                Value vC = c.execute(machine);
                if (vC.isNumber()) {
                    z = vC.doubleValue();
                }
            }
            if (x < 0.0 || x > 1.0 || y < 0.0 || y > 1.0
                    || z < 0.0 || y > 1.0) {
                throw new MyException("Error: one or more"
                        + "variables isn't Numeral or Symbol");
            }
            machine.setColor(x, y, z);
            return new Color(x, y, z);
        } else {
            throw new MyException("Error: incorrect args colorexpr");
        }
    }

}
