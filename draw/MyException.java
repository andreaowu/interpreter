package draw;

/** MyException class.
 * @author Andrea Wu
 */
class MyException extends Exception {

   /** Constructor for MyException that takes MESSAGE. */
    MyException(String message) {
        super(message);
        System.out.println(message);
    }

}
