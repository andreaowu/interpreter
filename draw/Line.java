package draw;

import java.io.PrintWriter;

/** Makes a line segment.
 * @author Andrea Wu
 */
class Line extends Picture {

    /** Private variable _x0. */
    private double _x0;
    /** Private variable _y0. */
    private double _y0;
    /** Private variable _x1. */
    private double _x1;
    /** Private variable _y1. */
    private double _y1;
    /** Current value of line width. */
    private double _lw;
    /** Variable rgb. */
    private double[] _rgb;

    /** Constructor for Line that has to have args:
     * point (X0, Y0) and point (X1, Y1), RGB, LW.
     * Returns an instance of Line.
     */
    public Line(double x0, double y0, double x1, double y1,
            double[] rgb, double lw) {
        this._x0 = x0;
        this._y0 = y0;
        this._x1 = x1;
        this._y1 = y1;
        double[] rgbrgb = new double[3];
        rgbrgb[0] = rgb[0];
        rgbrgb[1] = rgb[1];
        rgbrgb[2] = rgb[2];
        this._rgb = rgbrgb;
        this._lw = lw;
    }

    @Override
    void draw(PrintWriter out) {
        out.println(_rgb[0] + " " + _rgb[1] + " " + _rgb[2] + " setrgbcolor");
        out.println(_lw + " setlinewidth");
        out.println(_x0 + " " + _y0 + " moveto");
        out.println(_x1 + " " + _y1 + " lineto stroke");
    }

    @Override
    Picture move(double x, double y) {
        double a = _x0 + x;
        double b = _y0 + y;
        double c = _x1 + x;
        double d = _y1 + y;
        return new Line(a, b, c, d, _rgb, _lw);
    }

    @Override
    Picture rotate(double degree) {
        double a = _x0 * Math.cos(Math.toRadians(degree))
            - _y0 * Math.sin(Math.toRadians(degree));
        double b = _x0 * Math.sin(Math.toRadians(degree))
            + _y0 * Math.cos(Math.toRadians(degree));
        double c = _x1 * Math.cos(Math.toRadians(degree))
            - _y1 * Math.sin(Math.toRadians(degree));
        double d = _x1 * Math.sin(Math.toRadians(degree))
            + _y1 * Math.cos(Math.toRadians(degree));
        return new Line(a, b, c, d, _rgb, _lw);
    }

    @Override
    Picture scale(double factor) {
        double a = _x0 * factor;
        double b = _y0 * factor;
        double c = _x1 * factor;
        double d = _y1 * factor;
        return new Line(a, b, c, d, _rgb, _lw);
    }
}
