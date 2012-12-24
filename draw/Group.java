package draw;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/** Makes a group.
 * @author Andrea Wu
 */
class Group extends Picture {

    /** Private variable _PICS. */
    private List<Picture> _pics;

    /** Constructor for Group that has to have args PICS.
     * Returns an instance of Group.
     */
    public Group(List<Picture> pics) {
        this._pics = pics;
    }

    @Override
    void draw(PrintWriter out) throws MyException {
        int counter = 0;
        if (_pics == null) {
            throw new MyException("Error: Nothing to draw");
        }
        while (_pics.size() != counter) {
            Picture p = _pics.get(counter);
            p.draw(out);
            counter += 1;
        }
    }

    @Override
    Picture move(double x, double y) throws MyException {
        int counter = 0;
        ArrayList<Picture> pics = new ArrayList<Picture>();
        if (_pics == null) {
            throw new MyException("Error: Nothing to move");
        }
        while (_pics.size() != counter) {
            Picture p = _pics.get(counter);
            counter += 1;
            pics.add(p.move(x, y));
        }
        return new Group(pics);
    }

    @Override
    Picture rotate(double degree) throws MyException {
        int counter = 0;
        ArrayList<Picture> pics = new ArrayList<Picture>();
        if (_pics == null) {
            throw new MyException("Error: Nothing to rotate");
        }
        while (_pics.size() > counter) {
            Picture p = _pics.get(counter);
            counter += 1;
            pics.add(p.rotate(degree));
        }
        return new Group(pics);
    }

    @Override
    Picture scale(double factor) throws MyException {
        int counter = 0;
        ArrayList<Picture> pics = new ArrayList<Picture>();
        if (_pics == null) {
            throw new MyException("Error: Nothing to scale");
        }
        while (_pics.size() != counter) {
            Picture p = _pics.get(counter);
            counter += 1;
            pics.add(p.scale(factor));
        }
        return new Group(pics);
    }
}
