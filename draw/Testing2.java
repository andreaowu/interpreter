package draw;

import org.junit.Test;
import static org.junit.Assert.*;
import ucb.junit.textui;
import java.util.ArrayList;

/** Unit tests for draw package
 * @author Andrea Wu
 */
public class Testing2 {
    /** Run the JUnit tests in the draw package. */
    public static void main(String[] ignored) {
        textui.runClasses(draw.Testing2.class);
    }

    @Test (expected = MyException.class)
    public void filledcircExprFail() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        FilledCircExpr ce = new FilledCircExpr(lstExprs);
        ce.create(lstExprs).execute(i);
    }

    @Test (expected = MyException.class)
    public void rectExprFail() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        RectExpr re = new RectExpr(lstExprs);
        re.create(lstExprs).execute(i);
    }

    @Test (expected = MyException.class)
    public void filledrectExprFail() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        FilledRectExpr re = new FilledRectExpr(lstExprs);
        re.create(lstExprs).execute(i);
    }

    @Test (expected = MyException.class)
    public void lineExprFail() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        LineExpr l = new LineExpr(lstExprs);
        l.create(lstExprs).execute(i);
    }

    @Test (expected = MyException.class)
    public void colorExprFail() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(0.0);
        Numeral b = new Numeral(0.5);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        ColorExpr ce = new ColorExpr(lstExprs);
        ce.create(lstExprs).execute(i);
    }

    @Test (expected = MyException.class)
    public void colorExprFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(2.0);
        Numeral b = new Numeral(3.5);
        Numeral c = new Numeral(4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        ColorExpr ce = new ColorExpr(lstExprs);
        ce.create(lstExprs).execute(i);
    }

    @Test (expected = MyException.class)
    public void linewidthExpr1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        LinewidthExpr l = new LinewidthExpr(lstExprs);
        l.create(lstExprs).execute(i);
    }

    /** Tests Shape Exprs: wrong type of args. */
    @Test (expected = MyException.class)
    public void circExprFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Plus p = new Plus(lstExprs);
        Numeral c = new Numeral(2.0);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs.add(p);
        lstExprs.add(c);
        CircExpr ce = new CircExpr(lstExprs2);
        ce.create(lstExprs).execute(i);
    }

    @Test (expected = MyException.class)
    public void filledcircExprFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Plus p = new Plus(lstExprs);
        Numeral c = new Numeral(2.0);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs.add(p);
        lstExprs.add(c);
        FilledCircExpr ce = new FilledCircExpr(lstExprs2);
        ce.create(lstExprs).execute(i);
    }

    @Test (expected = MyException.class)
    public void rectExprFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Plus p = new Plus(lstExprs);
        Numeral c = new Numeral(2.0);
        Numeral d = new Numeral(3.0);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs.add(p);
        lstExprs.add(c);
        lstExprs.add(d);
        RectExpr re = new RectExpr(lstExprs2);
        re.create(lstExprs).execute(i);
    }

    @Test (expected = MyException.class)
    public void filledrectExprFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Plus p = new Plus(lstExprs);
        Numeral c = new Numeral(2.0);
        Numeral d = new Numeral(3.0);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs.add(p);
        lstExprs.add(c);
        lstExprs.add(d);
        FilledRectExpr re = new FilledRectExpr(lstExprs2);
        re.create(lstExprs).execute(i);
    }

    @Test (expected = MyException.class)
    public void lineExprFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Plus p = new Plus(lstExprs);
        Numeral c = new Numeral(2.0);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs.add(p);
        lstExprs.add(c);
        LineExpr l = new LineExpr(lstExprs2);
        l.create(lstExprs).execute(i);
    }

    @Test (expected = MyException.class)
    public void colorExprFail4() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Plus p = new Plus(lstExprs);
        Numeral c = new Numeral(2.0);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs.add(p);
        lstExprs.add(c);
        ColorExpr ce = new ColorExpr(lstExprs2);
        ce.create(lstExprs).execute(i);
    }

    @Test (expected = MyException.class)
    public void linewidthExpr3() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(-1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        LinewidthExpr l = new LinewidthExpr(lstExprs);
        l.create(lstExprs).execute(i);
    }

    /** Group. */
    @Test
    public void groupExpr1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        CircExpr ce = new CircExpr(lstExprs);
        ArrayList<Expr> lstExprsG = new ArrayList<Expr>();
        lstExprsG.add(ce);
        GroupExpr g = new GroupExpr(lstExprsG);
        assertNotNull(g.execute(i));
    }

    @Test (expected = MyException.class)
    public void groupExpr2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Plus p = new Plus(lstExprs);
        ArrayList<Expr> lstExprsG = new ArrayList<Expr>();
        lstExprsG.add(p);
        GroupExpr g = new GroupExpr(lstExprsG);
        g.execute(i);
    }

    /** Setting getting color. */
    @Test
    public void setColor1() throws MyException {
        Interpreter i = new Interpreter(null);
        double a = 0.0;
        double b = 1.0;
        double c = 0.5;
        i.setColor(a, b, c);
        double[] answer = i.getColor();
        assertEquals(answer[0], a, 0.0);
    }

    @Test
    public void setColor2() throws MyException {
        Interpreter i = new Interpreter(null);
        double a = 0.0;
        double b = 1.0;
        double c = 0.5;
        i.setColor(a, b, c);
        double[] answer = i.getColor();
        assertEquals(answer[1], b, 0.0);
    }

    @Test
    public void setColor3() throws MyException {
        Interpreter i = new Interpreter(null);
        double a = 0.0;
        double b = 1.0;
        double c = 0.5;
        i.setColor(a, b, c);
        double[] answer = i.getColor();
        assertEquals(answer[2], c, 0.0);
    }

    /** Setting and getting Linewidth. */
    @Test
    public void setLw1() throws MyException {
        Interpreter i = new Interpreter(null);
        double a = 4.0;
        i.setLw(a);
        double b = i.getLw();
        assertEquals(b, a, 0.0);
    }

    /** For. */
    @Test
    public void for1() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(a);
        lstExprs.add(b);
        For f = new For(lstExprs);
        assertNull(f.execute(i));
    }

    @Test (expected = MyException.class)
    public void for2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(a);
        For f = new For(lstExprs);
        f.execute(i);
    }

    @Test (expected = MyException.class)
    public void for3() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(s1);
        lstExprs.add(b);
        For f = new For(lstExprs);
        f.execute(i);
    }

    /** DrawExpr. */
    @Test (expected = MyException.class)
    public void drawExpr() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(5.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        DrawExpr d = new DrawExpr(lstExprs);
        d.execute(i);
    }

    @Test (expected = MyException.class)
    public void drawExpr2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(5.0);
        Numeral b = new Numeral(6.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        DrawExpr d = new DrawExpr(lstExprs);
        d.execute(i);
    }

    /** MoveExpr. */
    @Test (expected = MyException.class)
    public void moveExpr() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(5.0);
        Numeral b = new Numeral(6.0);
        Numeral c = new Numeral(7.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        MoveExpr d = new MoveExpr(lstExprs);
        d.execute(i);
    }

    @Test (expected = MyException.class)
    public void moveExpr2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(5.0);
        Numeral b = new Numeral(6.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        MoveExpr d = new MoveExpr(lstExprs);
        d.execute(i);
    }

    /** RotateExpr. */
    @Test (expected = MyException.class)
    public void rotateExpr() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(5.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        RotateExpr d = new RotateExpr(lstExprs);
        d.execute(i);
    }

    @Test (expected = MyException.class)
    public void rotateExpr2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(5.0);
        Numeral b = new Numeral(6.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        RotateExpr d = new RotateExpr(lstExprs);
        d.execute(i);
    }

    /** ScaleExpr. */
    @Test (expected = MyException.class)
    public void scaleExpr() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(5.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        ScaleExpr d = new ScaleExpr(lstExprs);
        d.execute(i);
    }

    @Test (expected = MyException.class)
    public void scaleExpr2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(5.0);
        Numeral b = new Numeral(6.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        ScaleExpr d = new ScaleExpr(lstExprs);
        d.execute(i);
    }
}
