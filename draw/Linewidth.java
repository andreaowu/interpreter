package draw;

/** Makes a Linewidth.
 * @author Andrea Wu
 */
class Linewidth extends Picture {

    /** Variable linewidth. */
    private double _lw;

    /** Constructor for Linewidth that has to have LW.
     * Returns an instance of FilledCirc. */
    public Linewidth(double lw) {
        this._lw = lw;
    }
}
