package draw;

import java.util.List;

/** A Symbol class.
 *  @author Andrea Wu
 */
class Symbol extends Expr {

    /** Private variable _operator. */
    private String _operator;
    /** Private variable _operands. */
    private List<Expr> _operands;

    /** Constructor for Symbol that takes OPERATOR,
     * returns instance of Symbol. */
    Symbol(String operator) {
        this._operator = operator;
    }

    /** Returns a new Symbol with OPERANDS. */
    Symbol create(List<Expr> operands) throws MyException {
        this._operands = operands;
        return this;
    }

    /** Returns the _operator string. */
    String getString() {
        return _operator;
    }

    /** Returns the value of the operator, using MACHINE. */
    Value execute(Interpreter machine) throws MyException {
        if (machine.getOpOrShape(_operator) != null) {
            Combination a = (Combination) machine.getOpOrShape(_operator);
            return a.create(_operands).execute(machine);
        } else if (machine.getVar(_operator) != null) {
            return machine.getVar(_operator);
        } else {
            throw new MyException("Error: cannot find symbol " + _operator);
        }
    }

    @Override
    boolean isSymbol() {
        return true;
    }
}
