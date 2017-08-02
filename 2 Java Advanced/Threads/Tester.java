public class Tester {
    public static void main(String[] args) throws InterruptedException {
        /* Threads
         * threads are used to give us the illusion of multitasking
         * with threads the computer work at multiple location of the program
         * and each part is executed in turn.
         *
         * with thread our program can work on multiple tasks.
         * that is extremely effective when we have heavy tasks that may take time to complete.
         * examples: loading file, communications with remote server, waiting for response or input
         * thread lets us continue other parts of the program when others are blocked
         * */

        //examples with creating classes which inherit Thread

        //example 1:
        FirstThread t = new FirstThread();
        t.start();//start running

        //example 2:
        new MyThread(); //start is called in constructor


        //example 3:
        //using runnable object as target to run on new thread
        Thread threadRunner = new Thread(new MyRunnable());
        threadRunner.start();


        //example 4:
        //We can create custom threads with abilities to control them
        RemoteControlThread rct = new RemoteControlThread();
        rct.start();

        Thread.sleep(2000);//wait two seconds

        rct.kill(); //stop the thread from here


        /* Inline thread:
         * is cases we want to start new simple thread quickly and easily
         * we are able to use inline thread. which are written in 1 line of code
        */

        //creating and calling thread inline:

        //example 5:
        //Java 7 - using new Runnable object
        new Thread(new Runnable() {
            public void run() {
                System.out.println("On new thread");
            }
        }).start();


        //example 6:
        //Java 8 - using lambda expression
        new Thread(() -> System.out.println("on new thread")).start();
    }
}
