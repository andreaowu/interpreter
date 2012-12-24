package draw;

/** A numeric value in the interpreter.
 * @author Andrea Wu
 */
class Number extends Value {

    /** A Number representing VALUE. */
    Number(double value) {
        _value = value;
    }

    @Override
    double doubleValue() {
        return _value;
    }

    @Override
    boolean isNumber() {
        return true;
    }

    /** The value I represent. */
    private double _value;
}
