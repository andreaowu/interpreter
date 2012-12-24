package draw;

import org.junit.Test;
import static org.junit.Assert.*;
import ucb.junit.textui;
import java.util.ArrayList;

/** Unit tests for draw package
 * @author Andrea Wu
 */

public class Testing {
    /** Run the JUnit tests in the draw package. */
    public static void main(String[] ignored) {
        textui.runClasses(draw.Testing.class);
    }

    @Test
    public void num1() {
        Number n = new Number(3.0);
        assertEquals(3.0, n.doubleValue(), 0.0);
    }

    /** Tests create for plus, minus, multiply, divide,
     * sine, cosine, sqrt for numerals.
     */
    @Test
    public void plusCreate() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Plus p = new Plus(lstExprs);
        assertEquals(3.0, p.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void minusCreate() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Minus m = new Minus(lstExprs);
        assertEquals(-1.0, m.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void multiplyCreate() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Multiply m = new Multiply(lstExprs);
        assertEquals(2.0, m.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void divideCreate() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Divide d = new Divide(lstExprs);
        assertEquals(0.5, d.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void cosineCreate() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Cosine c = new Cosine(lstExprs);
        assertEquals(0.0, c.create(lstExprs).execute(i).doubleValue(),
                10 * 10e-17);
    }

    @Test
    public void sinCreate() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Sin s = new Sin(lstExprs);
        assertEquals(1.0, s.create(lstExprs).execute(i).doubleValue(),
                10 * 10e-17);
    }

    @Test
    public void sqrtCreate() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        SquareRoot s = new SquareRoot(lstExprs);
        assertEquals(2.0, s.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    /** Tests create for plus, minus, multiply, divide,
     * sine, cosine, sqrt for symbols.
     */
    @Test
    public void plusCreate2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Number y = new Number(2.0);
        i.put("dog", y);
        Symbol s1 = new Symbol("cat");
        Symbol s2 = new Symbol("dog");
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(s2);
        Plus p = new Plus(lstExprs);
        assertEquals(3.0, p.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void minusCreate2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Number y = new Number(2.0);
        i.put("dog", y);
        Symbol s1 = new Symbol("cat");
        Symbol s2 = new Symbol("dog");
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(s2);
        Minus m = new Minus(lstExprs);
        assertEquals(-1.0, m.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void multiplyCreate2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Number y = new Number(2.0);
        i.put("dog", y);
        Symbol s1 = new Symbol("cat");
        Symbol s2 = new Symbol("dog");
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(s2);
        Multiply m = new Multiply(lstExprs);
        assertEquals(2.0, m.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void divideCreate2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Number y = new Number(2.0);
        i.put("dog", y);
        Symbol s1 = new Symbol("cat");
        Symbol s2 = new Symbol("dog");
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(s2);
        Divide d = new Divide(lstExprs);
        assertEquals(0.5, d.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void cosineCreate2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(90.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        Cosine c = new Cosine(lstExprs);
        assertEquals(0.0, c.create(lstExprs).execute(i).doubleValue(),
                10 * 10e-17);
    }

    @Test
    public void sinCreate2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(90.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        Sin s = new Sin(lstExprs);
        assertEquals(1.0, s.create(lstExprs).execute(i).doubleValue(),
                10 * 10e-17);
    }

    @Test
    public void sqrtCreate2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(4.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        SquareRoot s = new SquareRoot(lstExprs);
        assertEquals(2.0, s.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    /** Tests create for plus, minus, multiply, divide,
     * sine, cosine, sqrt for 1 numeral, 1 symbol.
     */
    @Test
    public void plusCreate3() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral y = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(y);
        Plus p = new Plus(lstExprs);
        assertEquals(3.0, p.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void minusCreate3() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral y = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(y);
        Minus m = new Minus(lstExprs);
        assertEquals(-1.0, m.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void multiplyCreate3() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral y = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(y);
        Multiply m = new Multiply(lstExprs);
        assertEquals(2.0, m.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void divideCreate3() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral y = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(y);
        Divide d = new Divide(lstExprs);
        assertEquals(0.5, d.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    /** Tests create for plus, minus, multiply, divide,
     * sine, cosine, sqrt for 1 symbol, 1 numeral.
     */
    @Test
    public void plusCreate4() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral y = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(y);
        lstExprs.add(s1);
        Plus p = new Plus(lstExprs);
        assertEquals(3.0, p.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void minusCreate4() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral y = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(y);
        lstExprs.add(s1);
        Minus m = new Minus(lstExprs);
        assertEquals(1.0, m.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void multiplyCreate4() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral y = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(y);
        lstExprs.add(s1);
        Multiply m = new Multiply(lstExprs);
        assertEquals(2.0, m.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void divideCreate4() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral y = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(y);
        lstExprs.add(s1);
        Divide d = new Divide(lstExprs);
        assertEquals(2.0, d.create(lstExprs).execute(i).doubleValue(), 0.0);
    }


    /** Tests execute for plus, minus, multiply, divide,
     * sine, cosine, sqrt.
     */
    @Test
    public void plusExecute() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Plus p = new Plus(lstExprs);
        assertEquals(3.0, p.execute(i).doubleValue(), 0.0);
    }

    @Test
    public void minusExecute() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Minus m = new Minus(lstExprs);
        assertEquals(-1.0, m.execute(i).doubleValue(), 0.0);
    }

    @Test
    public void multiplyExecute() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Multiply m = new Multiply(lstExprs);
        assertEquals(2.0, m.execute(i).doubleValue(), 0.0);
    }

    @Test
    public void divide1Execute() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Divide d = new Divide(lstExprs);
        assertEquals(0.5, d.execute(i).doubleValue(), 0.0);
    }

    @Test (expected = MyException.class)
    public void divide2Execute() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(0.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Divide d = new Divide(lstExprs);
        d.execute(i);
    }

    @Test
    public void cosineExecute() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Cosine c = new Cosine(lstExprs);
        assertEquals(0.0, c.execute(i).doubleValue(), 10 * 10e-17);
    }

    @Test
    public void sinExecute() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Sin s = new Sin(lstExprs);
        assertEquals(1.0, s.execute(i).doubleValue(), 10 * 10e-17);
    }

    @Test
    public void sqrt1Execute() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        SquareRoot s = new SquareRoot(lstExprs);
        assertEquals(2.0, s.execute(i).doubleValue(), 10 * 10e-17);
    }

    /** Tests create for too few args for:
     * plus, minus, multiply, divide,
     * sine, cosine, sqrt.
     */
    @Test (expected = MyException.class)
    public void sqrt2Execute() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(-4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        SquareRoot s = new SquareRoot(lstExprs);
        s.execute(i);
    }

    @Test (expected = MyException.class)
    public void plusExecuteFail1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Plus p = new Plus(lstExprs);
        p.execute(i);
    }

    @Test (expected = MyException.class)
    public void minusExecuteFail1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Minus m = new Minus(lstExprs);
        m.execute(i);
    }

    @Test (expected = MyException.class)
    public void multiplyExecuteFail1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Multiply m = new Multiply(lstExprs);
        m.execute(i);
    }

    @Test (expected = MyException.class)
    public void divide1ExecuteFail1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Divide d = new Divide(lstExprs);
        d.execute(i);
    }

    @Test (expected = MyException.class)
    public void divide2ExecuteFail1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Divide d = new Divide(lstExprs);
        d.execute(i);
    }

    @Test (expected = MyException.class)
    public void cosineExecuteFail1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90);
        Numeral b = new Numeral(0.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Cosine c = new Cosine(lstExprs);
        c.execute(i);
    }

    @Test (expected = MyException.class)
    public void sinExecuteFail1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90);
        Numeral b = new Numeral(0.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Sin s = new Sin(lstExprs);
        s.execute(i);
    }

    @Test (expected = MyException.class)
    public void sqrt1ExecuteFail1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(4.0);
        Numeral b = new Numeral(9.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        SquareRoot s = new SquareRoot(lstExprs);
        s.execute(i);
    }

    @Test (expected = MyException.class)
    public void sqrt2ExecuteFail1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(4.0);
        Numeral b = new Numeral(9.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        SquareRoot s = new SquareRoot(lstExprs);
        s.execute(i);
    }

    @Test (expected = MyException.class)
    public void plusExecuteFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        Plus p = new Plus(lstExprs);
        p.execute(i);
    }

    @Test (expected = MyException.class)
    public void minusExecuteFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        Minus m = new Minus(lstExprs);
        m.execute(i);
    }

    @Test (expected = MyException.class)
    public void multiplyExecuteFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        Multiply m = new Multiply(lstExprs);
        m.execute(i);
    }

    @Test (expected = MyException.class)
    public void divide1ExecuteFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        Divide d = new Divide(lstExprs);
        d.execute(i);
    }

    @Test (expected = MyException.class)
    public void divide2ExecuteFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        Divide d = new Divide(lstExprs);
        d.execute(i);
    }

    @Test (expected = MyException.class)
    public void cosineExecuteFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        Cosine c = new Cosine(lstExprs);
        c.execute(i);
    }

    @Test (expected = MyException.class)
    public void sinExecuteFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        Sin s = new Sin(lstExprs);
        s.execute(i);
    }

    @Test (expected = MyException.class)
    public void sqrt1ExecuteFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        SquareRoot s = new SquareRoot(lstExprs);
        s.execute(i);
    }

    @Test (expected = MyException.class)
    public void sqrt2ExecuteFail2() throws MyException {
        Interpreter i = new Interpreter(null);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        SquareRoot s = new SquareRoot(lstExprs);
        s.execute(i);
    }

    /** Tests create for too few args for:
     * plus, minus, multiply, divide,
     * sine, cosine, sqrt.
     */
    @Test (expected = MyException.class)
    public void plusExecuteFail3() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Plus p = new Plus(lstExprs);
        p.execute(i);
    }

    @Test (expected = MyException.class)
    public void minusExecuteFail3() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Minus m = new Minus(lstExprs);
        m.execute(i);
    }

    @Test (expected = MyException.class)
    public void multiplyExecuteFail3() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Multiply m = new Multiply(lstExprs);
        m.execute(i);
    }

    @Test (expected = MyException.class)
    public void divide1ExecuteFail3() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Divide d = new Divide(lstExprs);
        d.execute(i);
    }

    @Test (expected = MyException.class)
    public void divide2ExecuteFail3() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Divide d = new Divide(lstExprs);
        d.execute(i);
    }

    @Test (expected = MyException.class)
    public void cosineExecuteFail3() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90);
        Numeral b = new Numeral(0.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Cosine c = new Cosine(lstExprs);
        c.execute(i);
    }

    @Test (expected = MyException.class)
    public void sinExecuteFail3() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90);
        Numeral b = new Numeral(0.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        Sin s = new Sin(lstExprs);
        s.execute(i);
    }

    @Test (expected = MyException.class)
    public void sqrt1ExecuteFail3() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(4.0);
        Numeral b = new Numeral(9.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        SquareRoot s = new SquareRoot(lstExprs);
        s.execute(i);
    }

    @Test (expected = MyException.class)
    public void sqrt2ExecuteFail3() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(-4.0);
        Numeral b = new Numeral(4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        SquareRoot s = new SquareRoot(lstExprs);
        s.execute(i);
    }

    /** Tests create for wrong args for:
     * plus, minus, multiply, divide,
     * sine, cosine, sqrt.
     */
    @Test (expected = MyException.class)
    public void plusExecuteFail4() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Minus m1 = new Minus(lstExprs1);
        Numeral c = new Numeral(3.0);
        Numeral d = new Numeral(4.0);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(c);
        lstExprs2.add(d);
        Minus m2 = new Minus(lstExprs2);
        ArrayList<Expr> lstExprs3 = new ArrayList<Expr>();
        lstExprs3.add(m1);
        lstExprs3.add(m2);
        Plus p = new Plus(lstExprs3);
        p.execute(i);
    }

    @Test (expected = MyException.class)
    public void minusExecuteFail4() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Plus p1 = new Plus(lstExprs1);
        Numeral c = new Numeral(3.0);
        Numeral d = new Numeral(4.0);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(c);
        lstExprs2.add(d);
        Plus p2 = new Plus(lstExprs2);
        ArrayList<Expr> lstExprs3 = new ArrayList<Expr>();
        lstExprs3.add(p1);
        lstExprs3.add(p2);
        Minus m = new Minus(lstExprs3);
        m.execute(i);
    }

    @Test (expected = MyException.class)
    public void multiplyExecuteFail4() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Minus m1 = new Minus(lstExprs1);
        Numeral c = new Numeral(3.0);
        Numeral d = new Numeral(4.0);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(c);
        lstExprs2.add(d);
        Minus m2 = new Minus(lstExprs2);
        ArrayList<Expr> lstExprs3 = new ArrayList<Expr>();
        lstExprs3.add(m1);
        lstExprs3.add(m2);
        Multiply m = new Multiply(lstExprs3);
        m.execute(i);
    }

    @Test (expected = MyException.class)
    public void divide1ExecuteFail4() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Minus m1 = new Minus(lstExprs1);
        Numeral c = new Numeral(3.0);
        Numeral e = new Numeral(4.0);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(c);
        lstExprs2.add(e);
        Minus m2 = new Minus(lstExprs2);
        ArrayList<Expr> lstExprs3 = new ArrayList<Expr>();
        lstExprs3.add(m1);
        lstExprs3.add(m2);
        Divide d = new Divide(lstExprs3);
        d.execute(i);
    }

    @Test (expected = MyException.class)
    public void cosineExecuteFail4() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Minus m1 = new Minus(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(m1);
        Cosine c = new Cosine(lstExprs2);
        c.execute(i);
    }

    @Test (expected = MyException.class)
    public void sinExecuteFail4() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Minus m1 = new Minus(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(m1);
        Sin s = new Sin(lstExprs2);
        s.execute(i);
    }

    @Test (expected = MyException.class)
    public void sqrt1ExecuteFail4() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Minus m1 = new Minus(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(m1);
        SquareRoot s = new SquareRoot(lstExprs2);
        s.execute(i);
    }

    /** Testing interpreter; indirectly tests
     * machine.getOpOrShape. */
    @Test
    public void interpreterPlus1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s = new Symbol("+");
        assertEquals(3.0, s.create(lstExprs1).execute(i).doubleValue(), 0.0);
    }

    @Test (expected = MyException.class)
    public void interpreterPlus2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s = new Symbol("+ +");
        assertEquals(3.0, s.create(lstExprs1).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void interpreterMinus1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s = new Symbol("-");
        assertEquals(-1.0, s.create(lstExprs1).execute(i).doubleValue(), 0.0);
    }

    @Test (expected = MyException.class)
    public void interpreterMinus2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s = new Symbol("- - hi");
        assertEquals(-1.0, s.create(lstExprs1).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void interpreterMultiply1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s = new Symbol("*");
        assertEquals(2.0, s.create(lstExprs1).execute(i).doubleValue(), 0.0);
    }

    @Test (expected = MyException.class)
    public void interpreterMultiply2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s = new Symbol("* * hi");
        assertEquals(2.0, s.create(lstExprs1).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void interpreterDivide1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s = new Symbol("/");
        assertEquals(0.5, s.create(lstExprs1).execute(i).doubleValue(), 0.0);
    }

    @Test (expected = MyException.class)
    public void interpreterDivide2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s = new Symbol("/ / hi");
        assertEquals(0.5, s.create(lstExprs1).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void interpreterSin1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        Symbol s = new Symbol("sin");
        assertEquals(1.0, s.create(lstExprs1).execute(i).doubleValue(),
                10 * 10e-17);
    }

    @Test (expected = MyException.class)
    public void interpreterSin2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        Symbol s = new Symbol("sin sin");
        assertEquals(1.0, s.create(lstExprs1).execute(i).doubleValue(),
                10 * 10e-17);
    }

    @Test
    public void interpreterCosine1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        Symbol s = new Symbol("cos");
        assertEquals(0.0, s.create(lstExprs1).execute(i).doubleValue(),
                10 * 10e-17);
    }

    @Test (expected = MyException.class)
    public void interpreterCosine2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        Symbol s = new Symbol("cos cos");
        assertEquals(0.0, s.create(lstExprs1).execute(i).doubleValue(),
                10 * 10e-17);
    }

    @Test
    public void interpreterSqrt1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(9.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        Symbol s = new Symbol("sqrt");
        assertEquals(3.0, s.create(lstExprs1).execute(i).doubleValue(), 0.0);
    }

    @Test (expected = MyException.class)
    public void interpreterSqrt2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(9.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        Symbol s = new Symbol("sqrt sqrt");
        assertEquals(3.0, s.create(lstExprs1).execute(i).doubleValue(), 0.0);
    }

    @Test (expected = MyException.class)
    public void interpreterFail() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(9.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        Symbol s = new Symbol("sqrt sqrt sqrt");
        assertEquals(3.0, s.create(lstExprs1).execute(i).doubleValue(), 0.0);
    }

    /** Testing define's create and execute methods.
     * Indirectly tests getVar, put.  */
    @Test
    public void defineCreateExecute1() throws MyException {
        Interpreter i = new Interpreter(null);
        Symbol s = new Symbol("cat");
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s);
        lstExprs.add(a);
        Define d = new Define(lstExprs);
        assertEquals(1.0, d.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    /** Indirectly tests remove. */
    @Test
    public void defineCreateExecute2() throws MyException {
        Interpreter i = new Interpreter(null);
        Symbol s1 = new Symbol("cat");
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(s1);
        lstExprs1.add(a);
        Define d1 = new Define(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        Symbol s2 = new Symbol("cat");
        Numeral b = new Numeral(5.0);
        Define d2 = new Define(lstExprs2);
        lstExprs2.add(s2);
        lstExprs2.add(b);
        assertEquals(5.0, d2.create(lstExprs2).execute(i).doubleValue(), 0.0);
    }

    /** Tests define to execute Plus, Minus, Divide,
     * Multiply, Divide, Cosine, Sine, SquareRoot. */
    @Test
    public void definePlus1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s2 = new Symbol("cat");
        Plus p = new Plus(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(s2);
        lstExprs2.add(p);
        Define d = new Define(lstExprs2);
        assertEquals(3.0, d.create(lstExprs2).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void definePlus2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s1 = new Symbol("cat");
        Plus p = new Plus(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(s1);
        lstExprs2.add(p);
        Define d = new Define(lstExprs2);
        ArrayList<Expr> lstExprs3 = new ArrayList<Expr>();
        Symbol s2 = new Symbol("cat");
        Numeral c = new Numeral(5.0);
        lstExprs3.add(s2);
        lstExprs3.add(c);
        Define d2 = new Define(lstExprs3);
        assertEquals(5.0, d.create(lstExprs3).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void defineMinus1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s2 = new Symbol("cat");
        Minus m = new Minus(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(s2);
        lstExprs2.add(m);
        Define d = new Define(lstExprs2);
        assertEquals(-1.0, d.create(lstExprs2).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void defineMinus2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s1 = new Symbol("cat");
        Minus m = new Minus(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(s1);
        lstExprs2.add(m);
        Define d = new Define(lstExprs2);
        ArrayList<Expr> lstExprs3 = new ArrayList<Expr>();
        Symbol s2 = new Symbol("cat");
        Numeral c = new Numeral(5.0);
        lstExprs3.add(s2);
        lstExprs3.add(c);
        Define d2 = new Define(lstExprs3);
        assertEquals(5.0, d.create(lstExprs3).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void defineMultiply1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s2 = new Symbol("cat");
        Multiply m = new Multiply(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(s2);
        lstExprs2.add(m);
        Define d = new Define(lstExprs2);
        assertEquals(2.0, d.create(lstExprs2).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void defineMultiply2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s1 = new Symbol("cat");
        Multiply m = new Multiply(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(s1);
        lstExprs2.add(m);
        Define d = new Define(lstExprs2);
        ArrayList<Expr> lstExprs3 = new ArrayList<Expr>();
        Symbol s2 = new Symbol("cat");
        Numeral c = new Numeral(5.0);
        lstExprs3.add(s2);
        lstExprs3.add(c);
        Define d2 = new Define(lstExprs3);
        assertEquals(5.0, d.create(lstExprs3).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void defineDivide1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Symbol s2 = new Symbol("cat");
        Divide d = new Divide(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(s2);
        lstExprs2.add(d);
        Define de = new Define(lstExprs2);
        assertEquals(0.5, de.create(lstExprs2).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void defineDivide2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Divide d = new Divide(lstExprs1);
        Symbol s1 = new Symbol("cat");
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(s1);
        lstExprs2.add(d);
        Define de = new Define(lstExprs2);
        ArrayList<Expr> lstExprs3 = new ArrayList<Expr>();
        Symbol s2 = new Symbol("cat");
        Numeral c = new Numeral(5.0);
        lstExprs3.add(s2);
        lstExprs3.add(c);
        Define d2 = new Define(lstExprs3);
        assertEquals(5.0, d2.create(lstExprs3).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void defineCosine1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        Symbol s2 = new Symbol("cat");
        Cosine c = new Cosine(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(s2);
        lstExprs2.add(c);
        Define d = new Define(lstExprs2);
        assertEquals(0.0, d.create(lstExprs2).execute(i).doubleValue(),
                10 * 10e-17);
    }

    @Test
    public void defineCosine2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        Symbol s1 = new Symbol("cat");
        Cosine c = new Cosine(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(s1);
        lstExprs2.add(c);
        Define d = new Define(lstExprs2);
        ArrayList<Expr> lstExprs3 = new ArrayList<Expr>();
        Symbol s2 = new Symbol("cat");
        Numeral f = new Numeral(5.0);
        lstExprs3.add(s2);
        lstExprs3.add(f);
        Define d2 = new Define(lstExprs3);
        assertEquals(5.0, d.create(lstExprs3).execute(i).doubleValue(),
                10 * 10e-17);
    }

    @Test
    public void defineSin1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        Symbol s2 = new Symbol("cat");
        Sin c = new Sin(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(s2);
        lstExprs2.add(c);
        Define d = new Define(lstExprs2);
        assertEquals(1.0, d.create(lstExprs2).execute(i).doubleValue(),
                10 * 10e-17);
    }

    @Test
    public void defineSin2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        Symbol s1 = new Symbol("cat");
        Sin c = new Sin(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(s1);
        lstExprs2.add(c);
        Define d = new Define(lstExprs2);
        ArrayList<Expr> lstExprs3 = new ArrayList<Expr>();
        Symbol s2 = new Symbol("cat");
        Numeral f = new Numeral(5.0);
        lstExprs3.add(s2);
        lstExprs3.add(f);
        Define d2 = new Define(lstExprs3);
        assertEquals(5.0, d.create(lstExprs3).execute(i).doubleValue(),
                10 * 10e-17);
    }

    @Test
    public void defineSquareRoot1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(4.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        Symbol s2 = new Symbol("cat");
        SquareRoot s = new SquareRoot(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(s2);
        lstExprs2.add(s);
        Define d = new Define(lstExprs2);
        assertEquals(2.0, d.create(lstExprs2).execute(i).doubleValue(), 0.0);
    }

    @Test
    public void defineSquareRoot2() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(4.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        Symbol s1 = new Symbol("cat");
        SquareRoot s = new SquareRoot(lstExprs1);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(s1);
        lstExprs2.add(s);
        Define d = new Define(lstExprs2);
        ArrayList<Expr> lstExprs3 = new ArrayList<Expr>();
        Symbol s2 = new Symbol("cat");
        Numeral c = new Numeral(5.0);
        lstExprs3.add(s2);
        lstExprs3.add(c);
        Define d2 = new Define(lstExprs3);
        assertEquals(5.0, d.create(lstExprs3).execute(i).doubleValue(), 0.0);
    }

    /** Second argument type for define is symbol. */
    @Test
    public void defineSymbol() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(4.0);
        i.put("cat", x);
        Number y = new Number(9.0);
        i.put("dog", y);
        Numeral a = new Numeral(4.0);
        ArrayList<Expr> listSymbol1 = new ArrayList<Expr>();
        Symbol s1 = new Symbol("cat");
        listSymbol1.add(a);
        s1.create(listSymbol1).execute(i);
        Define ds1 = new Define(listSymbol1);
        Numeral b = new Numeral(9.0);
        ArrayList<Expr> listSymbol2 = new ArrayList<Expr>();
        Symbol s2 = new Symbol("dog");
        listSymbol2.add(b);
        s2.create(listSymbol2).execute(i);
        Define ds2 = new Define(listSymbol2);
        ArrayList<Expr> listDefine = new ArrayList<Expr>();
        listDefine.add(s1);
        listDefine.add(s2);
        Define d = new Define(listDefine);
        assertEquals(9.0, d.create(listDefine).execute(i).doubleValue(), 0.0);
    }

    /** Wrong first argument type for define. */
    @Test (expected = MyException.class)
    public void defineFail1() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs1 = new ArrayList<Expr>();
        lstExprs1.add(a);
        lstExprs1.add(b);
        Plus p = new Plus(lstExprs1);
        Numeral c = new Numeral(1.0);
        ArrayList<Expr> lstExprs2 = new ArrayList<Expr>();
        lstExprs2.add(p);
        lstExprs2.add(c);
        Define d = new Define(lstExprs2);
        d.create(lstExprs2).execute(i);
    }

    /** Too many arguments for define. */
    @Test (expected = MyException.class)
    public void defineFail3() throws MyException {
        Interpreter i = new Interpreter(null);
        Symbol s = new Symbol("cat");
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s);
        lstExprs.add(a);
        lstExprs.add(b);
        Define d = new Define(lstExprs);
        assertEquals(1.0, d.create(lstExprs).execute(i).doubleValue(), 0.0);
    }

    /** Testing Combinations. */
    @Test
    public void plusCombination() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        assertEquals(3.0, Combination.create("+", lstExprs).
                execute(i).doubleValue(), 0.0);
    }

    @Test
    public void minusCombination() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        assertEquals(-1.0, Combination.create("-", lstExprs).
                execute(i).doubleValue(), 0.0);
    }

    @Test
    public void multiplyCombination() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        assertEquals(2.0, Combination.create("*", lstExprs).
                execute(i).doubleValue(), 0.0);
    }

    @Test
    public void divide1Combination() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        assertEquals(0.5, Combination.create("/", lstExprs).
                execute(i).doubleValue(), 0.0);
    }

    @Test (expected = MyException.class)
    public void divide2Combination() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(0.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        Combination.create("/", lstExprs).execute(i);
    }

    @Test
    public void cosineCombination() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        assertEquals(0.0, Combination.create("cos", lstExprs).
                execute(i).doubleValue(), 10 * 10e-17);
    }

    @Test
    public void sinCombination() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(90);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        assertEquals(1.0, Combination.create("sin", lstExprs).
                execute(i).doubleValue(), 10 * 10e-17);
    }

    @Test
    public void sqrt1Combination() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        assertEquals(2.0, Combination.create("sqrt", lstExprs).
                execute(i).doubleValue(), 0.0);
    }

    @Test (expected = MyException.class)
    public void failCombination() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        assertEquals(1.0, Combination.create("cat", lstExprs).
                execute(i).doubleValue(), 0.0);
    }

    /** Tests Shape Exprs: correct numeral inputs. */
    @Test
    public void circExpr() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        CircExpr ce = new CircExpr(lstExprs);
        assertNotNull(ce.create(lstExprs).execute(i));
    }

    @Test
    public void filledcircExpr() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        FilledCircExpr ce = new FilledCircExpr(lstExprs);
        assertNotNull(ce.create(lstExprs).execute(i));
    }

    @Test
    public void rectExpr() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        Numeral d = new Numeral(4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        lstExprs.add(d);
        RectExpr re = new RectExpr(lstExprs);
        assertNotNull(re.create(lstExprs).execute(i));
    }

    @Test
    public void filledrectExpr() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        Numeral d = new Numeral(4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        lstExprs.add(d);
        FilledRectExpr re = new FilledRectExpr(lstExprs);
        assertNotNull(re.create(lstExprs).execute(i));
    }

    @Test
    public void lineExpr() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        Numeral d = new Numeral(4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        lstExprs.add(d);
        LineExpr l = new LineExpr(lstExprs);
        assertNotNull(l.create(lstExprs).execute(i));
    }

    @Test
    public void linewidthExpr() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        LinewidthExpr l = new LinewidthExpr(lstExprs);
        assertNotNull(l.create(lstExprs).execute(i));
    }

    @Test
    public void colorExpr() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(0.0);
        Numeral b = new Numeral(0.5);
        Numeral c = new Numeral(0.75);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        ColorExpr ce = new ColorExpr(lstExprs);
        assertNotNull(ce.create(lstExprs).execute(i));
    }

    /** Tests Shape Exprs: symbol as first input. */
    @Test
    public void circExpr2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(b);
        lstExprs.add(c);
        CircExpr ce = new CircExpr(lstExprs);
        assertNotNull(ce.create(lstExprs).execute(i));
    }

    @Test
    public void filledcircExpr2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(b);
        lstExprs.add(c);
        FilledCircExpr ce = new FilledCircExpr(lstExprs);
        assertNotNull(ce.create(lstExprs).execute(i));
    }

    @Test
    public void rectExpr2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        Numeral d = new Numeral(4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(b);
        lstExprs.add(c);
        lstExprs.add(d);
        RectExpr re = new RectExpr(lstExprs);
        assertNotNull(re.create(lstExprs).execute(i));
    }

    @Test
    public void filledrectExpr2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        Numeral d = new Numeral(4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(b);
        lstExprs.add(c);
        lstExprs.add(d);
        FilledRectExpr re = new FilledRectExpr(lstExprs);
        assertNotNull(re.create(lstExprs).execute(i));
    }

    @Test
    public void lineExpr2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral b = new Numeral(2.0);
        Numeral c = new Numeral(3.0);
        Numeral d = new Numeral(4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(b);
        lstExprs.add(c);
        lstExprs.add(d);
        LineExpr l = new LineExpr(lstExprs);
        assertNotNull(l.create(lstExprs).execute(i));
    }

    @Test
    public void linewidthExpr2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        LinewidthExpr l = new LinewidthExpr(lstExprs);
        assertNotNull(l.create(lstExprs).execute(i));
    }

    @Test
    public void colorExpr2() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol s1 = new Symbol("cat");
        Numeral b = new Numeral(0.5);
        Numeral c = new Numeral(0.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(s1);
        lstExprs.add(b);
        lstExprs.add(c);
        ColorExpr ce = new ColorExpr(lstExprs);
        assertNotNull(ce.create(lstExprs).execute(i));
    }

    /** Tests Shape Exprs: correct 2 symbol inputs. */
    @Test
    public void circExpr3() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol a = new Symbol("cat");
        Number y = new Number(2.0);
        i.put("dog", y);
        Symbol b = new Symbol("dog");
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        CircExpr ce = new CircExpr(lstExprs);
        assertNotNull(ce.create(lstExprs).execute(i));
    }

    @Test
    public void filledcircExpr3() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol a = new Symbol("cat");
        Number y = new Number(2.0);
        i.put("dog", y);
        Symbol b = new Symbol("dog");
        Numeral c = new Numeral(3.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        FilledCircExpr ce = new FilledCircExpr(lstExprs);
        assertNotNull(ce.create(lstExprs).execute(i));
    }

    @Test
    public void rectExpr3() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol a = new Symbol("cat");
        Number y = new Number(2.0);
        i.put("dog", y);
        Symbol b = new Symbol("dog");
        Numeral c = new Numeral(3.0);
        Numeral d = new Numeral(4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        lstExprs.add(d);
        RectExpr re = new RectExpr(lstExprs);
        assertNotNull(re.create(lstExprs).execute(i));
    }

    @Test
    public void filledrectExpr3() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol a = new Symbol("cat");
        Number y = new Number(2.0);
        i.put("dog", y);
        Symbol b = new Symbol("dog");
        Numeral c = new Numeral(3.0);
        Numeral d = new Numeral(4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        lstExprs.add(d);
        FilledRectExpr re = new FilledRectExpr(lstExprs);
        assertNotNull(re.create(lstExprs).execute(i));
    }

    @Test
    public void lineExpr3() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol a = new Symbol("cat");
        Number y = new Number(2.0);
        i.put("dog", y);
        Symbol b = new Symbol("dog");
        Numeral c = new Numeral(3.0);
        Numeral d = new Numeral(4.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        lstExprs.add(d);
        LineExpr l = new LineExpr(lstExprs);
        assertNotNull(l.create(lstExprs).execute(i));
    }

    @Test
    public void colorExpr3() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol a = new Symbol("cat");
        Number y = new Number(0.0);
        i.put("dog", y);
        Symbol b = new Symbol("dog");
        Numeral c = new Numeral(0.5);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        ColorExpr ce = new ColorExpr(lstExprs);
        assertNotNull(ce.create(lstExprs).execute(i));
    }

    /** Tests Shape Exprs: all symbol inputs. */
    @Test
    public void circExpr4() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol a = new Symbol("cat");
        Number y = new Number(2.0);
        i.put("dog", y);
        Symbol b = new Symbol("dog");
        Number z = new Number(3.0);
        i.put("bird", y);
        Symbol c = new Symbol("bird");
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        CircExpr ce = new CircExpr(lstExprs);
        assertNotNull(ce.create(lstExprs).execute(i));
    }

    @Test
    public void filledcircExpr4() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol a = new Symbol("cat");
        Number y = new Number(2.0);
        i.put("dog", y);
        Symbol b = new Symbol("dog");
        Number z = new Number(3.0);
        i.put("bird", y);
        Symbol c = new Symbol("bird");
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        FilledCircExpr ce = new FilledCircExpr(lstExprs);
        assertNotNull(ce.create(lstExprs).execute(i));
    }

    @Test
    public void rectExpr4() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol a = new Symbol("cat");
        Number y = new Number(2.0);
        i.put("dog", y);
        Symbol b = new Symbol("dog");
        Number z = new Number(3.0);
        i.put("bird", y);
        Symbol c = new Symbol("bird");
        Number asdf = new Number(4.0);
        i.put("cow", asdf);
        Symbol d = new Symbol("cow");
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        lstExprs.add(d);
        RectExpr re = new RectExpr(lstExprs);
        assertNotNull(re.create(lstExprs).execute(i));
    }

    @Test
    public void filledrectExpr4() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol a = new Symbol("cat");
        Number y = new Number(2.0);
        i.put("dog", y);
        Symbol b = new Symbol("dog");
        Number z = new Number(3.0);
        i.put("bird", y);
        Symbol c = new Symbol("bird");
        Number asdf = new Number(4.0);
        i.put("cow", asdf);
        Symbol d = new Symbol("cow");
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        lstExprs.add(d);
        FilledRectExpr re = new FilledRectExpr(lstExprs);
        assertNotNull(re.create(lstExprs).execute(i));
    }

    @Test
    public void lineExpr4() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol a = new Symbol("cat");
        Number y = new Number(2.0);
        i.put("dog", y);
        Symbol b = new Symbol("dog");
        Number z = new Number(3.0);
        i.put("bird", y);
        Symbol c = new Symbol("bird");
        Number asdf = new Number(4.0);
        i.put("cow", asdf);
        Symbol d = new Symbol("cow");
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        lstExprs.add(d);
        LineExpr l = new LineExpr(lstExprs);
        assertNotNull(l.create(lstExprs).execute(i));
    }

    @Test
    public void colorExpr4() throws MyException {
        Interpreter i = new Interpreter(null);
        Number x = new Number(1.0);
        i.put("cat", x);
        Symbol a = new Symbol("cat");
        Number y = new Number(0.0);
        i.put("dog", y);
        Symbol b = new Symbol("dog");
        Number z = new Number(0.5);
        i.put("bird", y);
        Symbol c = new Symbol("bird");
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        lstExprs.add(c);
        ColorExpr ce = new ColorExpr(lstExprs);
        assertNotNull(ce.create(lstExprs).execute(i));
    }

    /** Tests Shape Exprs: too many args. */
    @Test (expected = MyException.class)
    public void circExprFail() throws MyException {
        Interpreter i = new Interpreter(null);
        Numeral a = new Numeral(1.0);
        Numeral b = new Numeral(2.0);
        ArrayList<Expr> lstExprs = new ArrayList<Expr>();
        lstExprs.add(a);
        lstExprs.add(b);
        CircExpr ce = new CircExpr(lstExprs);
        ce.create(lstExprs).execute(i);
    }
}
