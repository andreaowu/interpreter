package draw;

import java.io.PrintWriter;

/** Makes a rectangle.
 * @author Andrea Wu
 */
class Rect extends Picture {

    /** Private variable _x1. */
    private double _x1;
    /** Private variable _y1. */
    private double _y1;
    /** Private variable _x2. */
    private double _x2;
    /** Private variable _y2. */
    private double _y2;
    /** Private variable _x3. */
    private double _x3;
    /** Private variable _y3. */
    private double _y3;
    /** Private variable _x4. */
    private double _x4;
    /** Private variable _y4. */
    private double _y4;
    /** Private variable _w. */
    private double _w;
    /** Private variable _h.*/
    private double _h;
    /** Current value of line width. */
    private double _lw;
    /** Variable rgb. */
    private double[] _rgb;

    /** Constructor for Rect that has to have args:
     * point (X, Y); width W, height H, RGB, LW.
     * Returns an instance of Rect.
     */
    public Rect(double x, double y, double w, double h,
            double[] rgb, double lw) {
        this._x1 = x;
        this._y1 = y;
        this._x2 = x;
        this._y2 = h + y;
        this._x3 = w + x;
        this._y3 = h + y;
        this._x4 = w + x;
        this._y4 = y;
        this._w = w;
        this._h = h;
        this._lw = lw;
        double[] rgbrgb = new double[3];
        rgbrgb[0] = rgb[0];
        rgbrgb[1] = rgb[1];
        rgbrgb[2] = rgb[2];
        this._rgb = rgbrgb;
    }

    /** Second constructor that takes:
     * (X, Y), W, H, A (cos d), B (sin d), RGB, LW.
     */
    public Rect(double x, double y, double w, double h,
            double a, double b, double[] rgb, double lw) {
        this._x1 = x * a - y * b;
        this._y1 = x * b + y * a;
        this._x2 = x * a - (h + y) * b;
        this._y2 = x * b + (h + y) * a;
        this._x3 = (w + x) * a - (h + y) * b;
        this._y3 = (w + x) * b + (h + y) * a;
        this._x4 = (w + x) * a - y * b;
        this._y4 = (w + x) * b + y * a;
        this._w = w;
        this._h = h;
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
        out.println(_x1 + " " + _y1 + " moveto");
        out.println(_x2 + " " + _y2 + " lineto");
        out.println(_x3 + " " + _y3 + " lineto");
        out.println(_x4 + " " + _y4 + " lineto");
        out.println(_x1 + " " + _y1 + " lineto stroke");
    }

    @Override
    Picture move(double x, double y) {
        double a = _x1 + x;
        double b = _y1 + y;
        return new Rect(a, b, _w, _h, _rgb, _lw);
    }

    @Override
    Picture rotate(double degree) {
        double a = Math.cos(Math.toRadians(degree));
        double b = Math.sin(Math.toRadians(degree));
        return new Rect(_x1, _y1, _w, _h, a, b, _rgb, _lw);
    }

    @Override
    Picture scale(double factor) {
        double a = _x1 * factor;
        double b = _y1 * factor;
        double c = _w * factor;
        double d = _h * factor;
        return new Rect(a, b, c, d, _rgb, _lw);
    }
}
