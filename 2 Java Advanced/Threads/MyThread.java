public class MyThread extends Thread {

    public MyThread() {
        System.out.println("My thread starts");
        start();//call start (which calls run method)
    }

    //override run method change the thread logic
    @Override
    public void run() {
        super.run();

        System.out.println("automatically starting thread");
    }
}
