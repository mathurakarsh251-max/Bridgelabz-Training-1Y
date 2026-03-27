class BankAccount implements Runnable {
    private String accountHolderName;
    private String accountType;
    private int priority;

    public BankAccount(String name, String type, int priority) {
        this.accountHolderName = name;
        this.accountType = type;
        this.priority = priority;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[Check " + i + "] User: " + accountHolderName + 
                               " | Type: " + accountType + 
                               " | Thread Priority: " + Thread.currentThread().getPriority());
            
            try {
                // Simulate checking time (2 seconds)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(accountHolderName + " was interrupted.");
            }
        }
        System.out.println(">>> " + accountHolderName + " has finished all checks.");
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        BankAccount premiumUser = new BankAccount("Alice", "Premium", 10);
        BankAccount regularUser = new BankAccount("Bob", "Regular", 5);
        BankAccount basicUser = new BankAccount("Charlie", "Basic", 1);
        Thread t1 = new Thread(premiumUser);
        Thread t2 = new Thread(regularUser);
        Thread t3 = new Thread(basicUser);
        t1.setPriority(Thread.MAX_PRIORITY); 
        t2.setPriority(Thread.NORM_PRIORITY); 
        t3.setPriority(Thread.MIN_PRIORITY); 
        t1.start();
        t2.start();
        t3.start();
    }
}