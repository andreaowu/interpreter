package draw;

import java.util.List;

/** A Plus adds numbers.
 *  @author Andrea Wu
 */
class Plus extends Combination {

    /** Variable SUM. */
    private double sum;

    /** Constructor for Plus with OPERANDS. */
    Plus(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of Define with OPERANDS as instance variables. */
    public Plus create(List<Expr> operands) {
        return new Plus(operands);
    }

    /** Returns the sum of the two operands, using MACHINE. */
    public Value execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 2) {
            if (_operands.get(0).isNumeral()
                    && _operands.get(1).isNumeral()) {
                double a = _operands.get(0).execute(machine).doubleValue();
                double b = _operands.get(1).execute(machine).doubleValue();
                sum = a + b;
                return new Number(sum);
            } else if (_operands.get(0).isNumeral()
                    && _operands.get(1).isSymbol()) {
                double a = _operands.get(0).execute(machine).doubleValue();
                Symbol b = (Symbol) _operands.get(1);
                Value v = b.execute(machine);
                if (v.isNumber()) {
                    sum = a + v.doubleValue();
                    return new Number(sum);
                } else {
                    throw new MyException("Error: one or"
                            + "more variables isn't a Numeral");
                }
            } else if (_operands.get(0).isSymbol()
                    && _operands.get(1).isNumeral()) {
                double b = _operands.get(1).execute(machine).doubleValue();
                Symbol a = (Symbol) _operands.get(0);
                Value v = a.execute(machine);
                if (v.isNumber()) {
                    sum = b + v.doubleValue();
                    return new Number(sum);
                } else {
                    throw new MyException("Error: one or"
                            + "more variables isn't a Numeral");
                }
            } else if (_operands.get(0).isSymbol()
                    && _operands.get(1).isSymbol()) {
                Symbol a = (Symbol) _operands.get(0);
                Value vA = a.execute(machine);
                Symbol b = (Symbol) _operands.get(1);
                Value vB = b.execute(machine);
                if (vA.isNumber() && vB.isNumber()) {
                    sum = vA.doubleValue() + vB.doubleValue();
                    return new Number(sum);
                } else {
                    throw new MyException("Error: one or"
                            + "more variables isn't a Numeral");
                }
            } else {
                throw new MyException("Error: operands"
                        + "not numeral or symbol");
            }
        } else {
            throw new MyException("Error: incorrect number"
                    + "of operands for summing");
        }
    }

}
