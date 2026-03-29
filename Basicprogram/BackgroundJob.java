public class BackgroundJob {
    public static void main(String[] args) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Background Job starting on: " + threadName);
            
            try {
                Thread.sleep(3000); 
                System.out.println("Background Job completed successfully on: " + threadName);
            } catch (InterruptedException e) {
                System.out.println("Job was interrupted.");
            }
        };
        Thread backgroundThread = new Thread(task);
        backgroundThread.start();
        System.out.println("Main thread is free to handle other user interactions...");
    }
}