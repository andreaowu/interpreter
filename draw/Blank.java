package draw;

import java.io.PrintWriter;

/** Makes a blank.
 * @author Andrea Wu
 */
class Blank extends Picture {

    /** Private variable _x. */
    private String _x;

    /** Constructor for Blank that has to have args:
     * S string.
     * Returns an instance of Blank.
     */
    public Blank(String s) {
        this._x = s;
    }

    @Override
    void draw(PrintWriter out) {
    }

    @Override
    Picture move(double x, double y) {
        return new Blank("hi");
    }

    @Override
    Picture rotate(double degree) {
        return new Blank("hi");
    }

    @Override
    Picture scale(double factor) {
        return new Blank("hi");
    }
}
