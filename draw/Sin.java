package draw;

import java.util.List;

/** A Sin returns trigonometric sine of an angle.
 *  @author Andrea Wu
 */
class Sin extends Combination {

    /** Variable RESULT. */
    private double result;

    /** Constructor for Sin, with OPERANDS. */
    Sin(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of Sin with OPERANDS as instance variables. */
    public Sin create(List<Expr> operands) throws MyException {
        if (operands.size() == 1) {
            return new Sin(operands);
        } else {
            throw new MyException("Error: Cannot make Sin");
        }
    }

    /** Returns the sin of an operand, using MACHINE. */
    public Value execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 1) {
            if (_operands.get(0).isNumeral()) {
                double a = _operands.get(0).execute(machine).doubleValue();
                result = Math.sin(Math.toRadians(a));
                return new Number(result);
            } else if (_operands.get(0).isSymbol()) {
                Symbol a = (Symbol) _operands.get(0);
                Value v = a.execute(machine);
                if (v.isNumber()) {
                    result = Math.sin(Math.toRadians(v.doubleValue()));
                    return new Number(result);
                } else {
                    throw new MyException("Error: variable"
                            + "isn't a Numeral");
                }
            } else {
                throw new MyException("Error: operands"
                        + "not numeral or symbol");
            }
        } else {
            throw new MyException("Error: incorrect args sine");
        }
    }
}
