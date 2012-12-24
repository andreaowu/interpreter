package draw;

import java.util.List;

/** A Minus subtracts numbers.
 *  @author Andrea Wu
 */
class Minus extends Combination {

    /** Variable DIFFERENCE. */
    private double difference;

    /** Constructor for Minus, takes OPERANDS. */
    public Minus(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of Minus with OPERANDS as instance variables. */
    public Minus create(List<Expr> operands) {
        return new Minus(operands);
    }

    /** Returns the difference of the two operands, using MACHINE. */
    public Value execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 2) {
            if (_operands.get(0).isNumeral()
                    && _operands.get(1).isNumeral()) {
                double a = _operands.get(0).execute(machine).doubleValue();
                double b = _operands.get(1).execute(machine).doubleValue();
                difference = a - b;
                return new Number(difference);
            } else if (_operands.get(0).isNumeral()
                    && _operands.get(1).isSymbol()) {
                double a = _operands.get(0).execute(machine).doubleValue();
                Symbol b = (Symbol) _operands.get(1);
                Value v = b.execute(machine);
                if (v.isNumber()) {
                    difference = a - v.doubleValue();
                    return new Number(difference);
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
                    difference = v.doubleValue() - b;
                    return new Number(difference);
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
                    difference = vA.doubleValue() - vB.doubleValue();
                    return new Number(difference);
                } else {
                    throw new MyException("Error: one or"
                            + "more variables isn't a Numeral");
                }
            } else {
                throw new MyException("Error: operands"
                        + "not numeral or symbol");
            }
        } else {
            throw new MyException("Error: incorrect args minus");
        }
    }
}
