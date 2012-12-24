package draw;

import java.util.List;

/** A SquareRoot takes squareroot.
 *  @author Andrea Wu
 */
class SquareRoot extends Combination {

    /** Variable RESULT. */
    private double result;

    /** Constructor for SquareRoot, with OPERANDS. */
    SquareRoot(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of SquareRoot with
     * OPERANDS as instance variables. */
    public SquareRoot create(List<Expr> operands) {
        return new SquareRoot(operands);
    }

    /** Returns the SquareRoot of an operand, using MACHINE. */
    public Value execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 1) {
            if (_operands.get(0).isNumeral()) {
                double a = _operands.get(0).execute(machine).doubleValue();
                if (a >= 0.0) {
                    result = Math.sqrt(a);
                    return new Number(result);
                } else {
                    throw new MyException("Error: variable"
                            + "isn't a Numeral");
                }
            } else if (_operands.get(0).isSymbol()) {
                Symbol a = (Symbol) _operands.get(0);
                Value v = a.execute(machine);
                if (v.isNumber()) {
                    result = Math.sqrt(v.doubleValue());
                    if (result >= 0.0) {
                        return new Number(result);
                    } else {
                        throw new MyException("Error: variable"
                                + "isn't a Numeral");
                    }
                } else {
                    throw new MyException("Error: variable"
                            + "isn't a Numeral");
                }
            } else {
                throw new MyException("Error: operands"
                        + "not numeral or symbol");
            }
        } else {
            throw new MyException("Error: incorrect args squareroot");
        }
    }

}
