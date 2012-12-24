package draw;

import java.util.List;

/**  A Cosine returns trigonometric cosine of an angle.
 *  @author Andrea Wu
 */
class Cosine extends Combination {

    /** Variable RESULT. */
    private double result;

    /** Constructor for Cosine, takes OPERANDS. */
    Cosine(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of Cosine with OPERANDS as instance variables. */
    public Cosine create(List<Expr> operands) {
        return new Cosine(operands);
    }

    /** Returns the cosine of an operand, using MACHINE. */
    public Value execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 1) {
            if (_operands.get(0).isNumeral()) {
                double a = _operands.get(0).execute(machine).doubleValue();
                result = Math.cos(Math.toRadians(a));
                return new Number(result);
            } else if (_operands.get(0).isSymbol()) {
                Symbol a = (Symbol) _operands.get(0);
                Value v = a.execute(machine);
                if (v.isNumber()) {
                    result = Math.cos(Math.toRadians(v.doubleValue()));
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
            throw new MyException("Error: incorrect args cosine");
        }
    }
}
