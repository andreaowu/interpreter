package draw;

import java.util.List;

/** A Multiply multiplies numbers.
 *  @author Andrea Wu
 */
class Multiply extends Combination {

    /** Variable PRODUCT. */
    private double product;

    /** Constructor for Multiply, takes OPERANDS. */
    Multiply(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of Multiply with
     * OPERANDS as instance variables. */
    public Multiply create(List<Expr> operands) {
        return new Multiply(operands);
    }

    /** Returns the product of the two operands, using MACHINE. */
    public Value execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 2) {
            if (_operands.get(0).isNumeral()
                    && _operands.get(1).isNumeral()) {
                double a = _operands.get(0).execute(machine).doubleValue();
                double b = _operands.get(1).execute(machine).doubleValue();
                product = a * b;
                return new Number(product);
            } else if (_operands.get(0).isNumeral()
                    && _operands.get(1).isSymbol()) {
                double a = _operands.get(0).execute(machine).doubleValue();
                Symbol b = (Symbol) _operands.get(1);
                Value v = b.execute(machine);
                if (v.isNumber()) {
                    product = a * v.doubleValue();
                    return new Number(product);
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
                    product = b * v.doubleValue();
                    return new Number(product);
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
                    product = vA.doubleValue() * vB.doubleValue();
                    return new Number(product);
                } else {
                    throw new MyException("Error: one or"
                            + "more variables isn't a Numeral");
                }
            } else {
                throw new MyException("Error: operands"
                        + "not numeral or symbol");
            }
        } else {
            throw new MyException("Error: incorrect args multiply");
        }
    }

}
