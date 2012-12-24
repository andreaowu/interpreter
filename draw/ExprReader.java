package draw;

import java.io.Reader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;

/** An ExprReader reads expressions from a source given to its constructor,
 *  returning (unexecuted) Exprs as requested.
 *  @author Andrea Wu
 */
class ExprReader {

    /** A new ExprReader that reads from INP, returns instance. */
    ExprReader(Reader inp) {
        _tokens = new StreamTokenizer(inp);
        _tokens.commentChar(';');
        _tokens.ordinaryChars('(', ')');
        _tokens.quoteChar('"');
        _tokens.whitespaceChars(' ', ' ');
        _tokens.wordChars('A', 'Z');
        _tokens.wordChars('a', 'z');
        _tokens.wordChars(':', ':');
        _tokens.wordChars('=', '=');
        _tokens.wordChars('+', '+');
        _tokens.wordChars('*', '*');
        _tokens.wordChars('/', '/');
        _tokens.parseNumbers();
    }

    /** Reads and returns the next command from my input source,
     *  without executing it.  Returns null at end of file.
     */
    Expr read() throws IOException, MyException {
        int i = _tokens.nextToken();
        if (i == -2) {
            return new Numeral(_tokens.nval);
        } else if (i == -3) {
            return new Symbol(_tokens.sval);
        } else if (_tokens.ttype == '-') {
            return new Symbol("-");
        } else if (_tokens.ttype == '(') {
            _tokens.nextToken();
            String op;
            if (_tokens.ttype == '-') {
                op = "-";
            } else {
                op = _tokens.sval;
            }
            ArrayList<Expr> operands = new ArrayList<Expr>();
            while (true) {
                Expr temp = this.read();
                if (temp.isSymbol()) {
                    Symbol s = (Symbol) temp;
                    if (s.getString().equals("Hello I am at the end")) {
                        return Combination.create(op, operands);
                    } else {
                        operands.add(temp);
                    }
                } else {
                    operands.add(temp);
                }
            }
        } else if (_tokens.ttype == ')') {
            Symbol hi = new Symbol("Hello I am at the end");
            return hi;
        } else if (i == -1) {
            return null;
        } else {
            throw new MyException("Error: end of read()");
        }
    }

    /** My input source.  We use a StreamTokenizer because it is
     *  "tuned" to the constituents of an S-expression. */
    private final StreamTokenizer _tokens;
}
