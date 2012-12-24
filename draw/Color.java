package draw;

/** A Color changes the color.
 *  @author Andrea Wu
 */
class Color extends Picture {

    /** Variable red. */
    private double _red;
    /** Variable green. */
    private double _green;
    /** Variable blue. */
    private double _blue;

    /** Constructor for Color with RED, GREEN, and BLUE. */
    Color(double red, double green, double blue) {
        this._red = red;
        this._green = green;
        this._blue = blue;
    }
}
