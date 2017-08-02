public class RemoteControlThread extends Thread {
    private boolean isAlive;

    public RemoteControlThread() {
        this.isAlive = false;
    }

    @Override
    public synchronized void start() {
        isAlive = true;
        super.start();
    }

    @Override
    public void run() {
        super.run();
        try {
            while (isAlive) {
                System.out.println("working forever!");
                sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void kill() {
        if(isAlive){
            System.out.println("Thread died");
            isAlive = false;
        }
    }
}
