package draw;

import java.io.PrintWriter;

/** Makes a rectangle.
 * @author Andrea Wu
 */
class Circ extends Picture {

    /** Private variable _x. */
    private double _x;
    /** Private variable _y. */
    private double _y;
    /** Private variable _rad. */
    private double _rad;
    /** Private variable theta1. */
    private double _theta1;
    /** Private variable theta2. */
    private double _theta2;
    /** Private variable num. */
    private final double num = 360;
    /** Private variable linewidth. */
    private double _lw;
    /** Variable rgb. */
    private double[] _rgb;

    /** Constructor for Circ that has to have args:
     * point (X, Y) RAD, RGB, LW.
     * Returns an instance of Circ.
     */
    public Circ(double x, double y, double rad, double[] rgb, double lw) {
        this._x = x;
        this._y = y;
        this._rad = rad;
        this._theta1 = 0;
        this._theta2 = num;
        this._lw = lw;
        double[] rgbrgb = new double[3];
        rgbrgb[0] = rgb[0];
        rgbrgb[1] = rgb[1];
        rgbrgb[2] = rgb[2];
        this._rgb = rgbrgb;
    }

    @Override
    void draw(PrintWriter out) {
        out.println(_rgb[0] + " " + _rgb[1] + " " + _rgb[2] + " setrgbcolor");
        out.println(_lw + " setlinewidth");
        out.println(_x + " " + _y + " " + _rad + " " + _theta1
                + " " + _theta2 + " arc");
        out.println(_x + " " + _y + " stroke");
    }

    @Override
    Picture move(double x, double y) {
        double a = _x + x;
        double b = _y + y;
        return new Circ(a, b, _rad, _rgb, _lw);
    }

    @Override
    Picture rotate(double degree) {
        double a = _x * Math.cos(Math.toRadians(degree))
            - _y * Math.sin(Math.toRadians(degree));
        double b = _x * Math.sin(Math.toRadians(degree))
            + _y * Math.cos(Math.toRadians(degree));
        return new Circ(a, b, _rad, _rgb, _lw);
    }

    @Override
    Picture scale(double factor) {
        double a = _x * factor;
        double b = _y * factor;
        double rad = _rad * factor;
        return new Circ(a, b, rad, _rgb, _lw);
    }
}
