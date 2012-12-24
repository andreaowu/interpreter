package draw;

import java.io.PrintWriter;

/** The interface describing all kinds of Pictures.
 * @author Andrea Wu
 */
abstract class Picture extends Value {

    @Override
    Picture pictureValue() {
        return this;
    }

    /** Draw me on OUT.  Default implementation does nothing. */
    void draw(PrintWriter out) throws MyException {
    }

    /** Returns new Picture resulting from scaling me by a factor of FACTOR,
     *  which must be > 0.  Default implementation cannot be scaled. */
    Picture scale(double factor) throws MyException {
        throw new MyException("picture cannot be scaled");
    }

    /** Return new Picture resulting from translating me by an amount (X, Y).
     *  Default implementation cannot be translated. */
    Picture move(double x, double y) throws MyException {
        throw new MyException("picture cannot be translated");
    }

    /** Return new Picture resulting from rotating me by D degrees
     *  counterclockwise.  Default implementation cannot be rotated. */
    Picture rotate(double d) throws MyException {
        throw new MyException("picture cannot be rotated");
    }

    @Override
    boolean isPicture() {
        return true;
    }
}
