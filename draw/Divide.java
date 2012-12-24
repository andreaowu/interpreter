package draw;

import java.util.List;

/** A Divide divides numbers.
 *  @author Andrea Wu
 */
class Divide extends Combination {

    /** Variable QUOTIENT. */
    private double quotient;

    /** Constructor for Divide, takes OPERANDS. */
    public Divide(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of Divide with OPERANDS as instance variables. */
    public Divide create(List<Expr> operands) {
        return new Divide(operands);
    }

    /** Returns the quotient of the two operands, using MACHINE. */
    public Value execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 2) {
            boolean aTF = true;
            double a = 0.0;
            boolean bTF = true;
            double b = 0.0;
            if (_operands.get(0).isNumeral()
                    && _operands.get(1).isNumeral()) {
                a = _operands.get(0).execute(machine).doubleValue();
                b = _operands.get(1).execute(machine).doubleValue();
                aTF = false;
                bTF = false;
            } else if (_operands.get(0).isNumeral()
                    && _operands.get(1).isSymbol()) {
                a = _operands.get(0).execute(machine).doubleValue();
                aTF = false;
                Symbol bSym = (Symbol) _operands.get(1);
                Value v = bSym.execute(machine);
                if (v.isNumber()) {
                    bTF = false;
                    b = v.doubleValue();
                } else {
                    throw new MyException("Error: var not Number");
                }
            } else if (_operands.get(0).isSymbol()
                    && _operands.get(1).isNumeral()) {
                b = _operands.get(1).execute(machine).doubleValue();
                bTF = false;
                Symbol cSym = (Symbol) _operands.get(0);
                Value v = cSym.execute(machine);
                if (v.isNumber()) {
                    aTF = false;
                    a = v.doubleValue();
                } else {
                    throw new MyException("Error: var not Number");
                }
            } else if (_operands.get(0).isSymbol()
                    && _operands.get(1).isSymbol()) {
                Symbol dSym = (Symbol) _operands.get(0);
                Value vA = dSym.execute(machine);
                Symbol eSym = (Symbol) _operands.get(1);
                Value vB = eSym.execute(machine);
                if (vA.isNumber() && vB.isNumber()) {
                    a = vA.doubleValue();
                    b = vB.doubleValue();
                    aTF = false;
                    bTF = false;
                } else {
                    throw new MyException("Error: vars not Number");
                }
            }
            if (aTF || bTF || b == 0.0) {
                throw new MyException("Error: not Numeral/Number");
            }
            quotient = a / b;
            return new Number(quotient);
        } else {
            throw new MyException("Error: incorrect args divide");
        }
    }

}
