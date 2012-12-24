package draw;

import java.util.List;

/** A For does a for loop.
 *  @author Andrea Wu
 */
class For extends Combination {

    /** Constructor for For with OPERANDS. */
    For(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of For with OPERANDS as instance variables. */
    public For create(List<Expr> operands) {
        return new For(operands);
    }

    /** Returns the for of the operands, using MACHINE. */
    public Value execute(Interpreter machine) throws MyException {
        if (_operands != null && _operands.size() >= 3
                && _operands.get(0).isSymbol()
                && _operands.get(1).execute(machine).isNumber()
                && _operands.get(2).execute(machine).isNumber()) {
            Symbol I = (Symbol) _operands.get(0);
            double L = _operands.get(1).execute(machine).doubleValue();
            double U = _operands.get(2).execute(machine).doubleValue();
            machine.put(I.getString(), new Numeral(L).execute(machine));
            if (_operands.size() == 3) {
                if (L > U) {
                    machine.put(I.getString(), new Numeral(L).execute(machine));
                    return null;
                } else {
                    machine.put(I.getString(), new Numeral(U).execute(machine));
                    return null;
                }
            }
            while (L <= U) {
                machine.put(I.getString(), new Numeral(L).execute(machine));
                int counter = 3;
                while (counter < _operands.size()) {
                    _operands.get(counter).execute(machine);
                    counter += 1;
                }
                L += 1;
            }
        } else {
            throw new MyException("Error: incorrect args for");
        }
        return null;
    }
}
