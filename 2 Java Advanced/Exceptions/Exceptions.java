import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Exceptions {
    public static void main(String[] args) {
        /* Exceptions in Java
         *
         * exception, inherits from throwable class. which define a mechanism that reasonable application might want to catch
         *      aside from Exception we have Error (which we won't mention here)
         *
         * Exceptions in Java comes in two ways:
         *      Checked exception & unchecked exception.
         *
         * The checked exception in java indicates that all exception which are checked, must be handled.
         * Unchecked exception does not need to be handled for our code to compile,
         *      but it is good practice to handle them when needed
         *
         * To handle an exception, we have two options: catch the exception or throw it to caller,
         *      usually only one is implemented*/



        /* To call doSomethingDangerous1, we need to handle the exception it might throw, because it is checked exception
         * in this example we're using try catch block, in the try block we write dangerous code
         * in catch block, we write the handling for that specific exception that was thrown*/
        try {
            doSomethingDangerous1();
        } catch (FileNotFoundException e) {
            System.out.println("handling exception here");
        }


        /* finally
         * after working with resources, we should clean up connection to those resources,
         * or dispose of objects which are closeable to free those resources.
         * But sometimes using those resources can throw an exception before the cleanup. that a problem.
         * to deal with this problem, in java we use finally block.
         *
         * finally block is a special code block that always run no matter what, it used to write cleanup code for resources.
         * no matter if exception was thrown, or not. no matter if we handled the exception or not,
         * no matter even if an error was thrown, finally block will run just to let us clean up resources*/

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("some file in storage");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close method is dangerous so we need another try catch here
            try {
                if (fos != null)
                    fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*the finally block is sometimes can be difficult to write because clean can also throw exceptions
        * to make things more comfortable and productive, Java has 'try with resource' block
        * we still taking to account cleanup exceptions, but now we have only one level of try catch blocks + our resource can be scoped to that block*/

        try (FileInputStream fis = new FileInputStream("some file in storage")) {

            //doing logic
            int a = fis.read();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //throwing checked exception, we must either declare exceptions in signature or handle exceptions in methods

    /* example 1: declare throws in signature
     * we are able to throw an exception by letting the caller handle it */
    public static void doSomethingDangerous1() throws FileNotFoundException {
        throw new FileNotFoundException("Bubu file not found");
    }

    /* Example 2: handling exception in method
     * we can throw an exception here (or call dangerous methods)
     * to each checked exception we throw or dangerous method we call,
     * we must declare an appropriate catch block
     *      (i.e. one catch block can catch multiple exception if they inherit from that exception)*/
    public static void doSomethingDangerous2() {
        try {
            int num = new Random().nextInt(2);
            if (num == 0)//50% chance to throw file not found exception
                throw new FileNotFoundException("Bubu file not found");
            else
                doSomethingDangerous1();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //throwing unchecked exception, does not need to be declared at signature or handled in method
    public static void doUncheckException() {
        throw new IndexOutOfBoundsException("Thrown without checking");
    }
}