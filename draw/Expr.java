package draw;

/** The superclass of all types of Expr. An Expr is denoted by
 *  an S-expression, as indicated in the specifications.
 *  @author Andrea Wu
 */
abstract class Expr {

    /** Execute me, modifying the state in MACHINE as appropriate and
     *  returning the resulting Value. */
    abstract Value execute(Interpreter machine) throws MyException;

    /** Return whether object is a Combination. */
    boolean isCombination() {
        return false;
    }

    /** Return whether object is a Symbol. */
    boolean isSymbol() {
        return false;
    }

    /** Return whether object is a Numeral. */
    boolean isNumeral() {
        return false;
    }
}
