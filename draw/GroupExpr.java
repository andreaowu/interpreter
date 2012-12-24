package draw;

import java.util.List;
import java.util.ArrayList;

/** A Expr for Group class.
 *  @author Andrea Wu
 */
class GroupExpr extends Combination {

    /** Constructor for Group that takes OPERANDS, returns instance of Group. */
    GroupExpr(List<Expr> operands) {
        super(operands);
    }

    /** Returns a new instance of GroupExpr with OPERANDS. */
    public GroupExpr create(List<Expr> operands) throws MyException {
        return new GroupExpr(operands);
    }

    /** Returns the drawn group of pictures, using MACHINE. */
    Group execute(Interpreter machine) throws MyException {
        if (_operands != null) {
            ArrayList<Picture> pics = new ArrayList<Picture>();
            for (int i = 0; i < _operands.size(); i += 1) {
                if (_operands.get(i).execute(machine).isPicture()) {
                    Picture p = (Picture) _operands.get(i).execute(machine);
                    pics.add(p);
                } else {
                    throw new MyException("Error: cannot draw group");
                }
            }
            return new Group(pics);
        } else {
            throw new MyException("Error: incorrect args group");
        }
    }

}
