package draw;

import java.util.List;

/** A Define does :=.
 *  @author Andrea Wu
 */
class Define extends Combination {

    /** Constructor for Define with OPERANDS. */
    Define(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of Define with OPERANDS as instance variables. */
    public Define create(List<Expr> operands) {
        return new Define(operands);
    }

    /** Returns the sum of the two operands, using MACHINE. */
    public Value execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() == 2
                && _operands.get(0).isSymbol()) {
            Value n = _operands.get(1).execute(machine);
            Value p = _operands.get(1).execute(machine);
            Expr s = _operands.get(1);
            if (n.isNumber() || p.isPicture() || s.isSymbol()) {
                Symbol a = (Symbol) _operands.get(0);
                machine.put(a.getString(), _operands.get(1).execute(machine));
                return _operands.get(1).execute(machine);
            }
        } else {
            throw new MyException("Error: incorrect args define");
        }
        return null;
    }
}
