class ExamActivity implements Runnable {
    private String activityName;
    private int delaySeconds;
    private int priority;

    public ExamActivity(String name, int delay, int priority) {
        this.activityName = name;
        this.delaySeconds = delay;
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        current.setPriority(priority);

        try {
            System.out.println("[WAIT] " + activityName + " is scheduled. Current State: " + current.getState());
            Thread.sleep(delaySeconds * 1000);

            System.out.println("[START] " + activityName + " has begun. Priority: " + current.getPriority() + 
                               " | State: " + current.getState());

            Thread.sleep(2000); 

            System.out.println("[FINISH] " + activityName + " completed.");
        } catch (InterruptedException e) {
            System.out.println(activityName + " was interrupted.");
        }
    }
}

public class ExamHallManagement {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Exam Hall Management System Initialized ---\n");
        Thread entry = new Thread(new ExamActivity("Student Entry", 0, 5), "EntryThread");
        Thread papers = new Thread(new ExamActivity("Paper Distribution", 5, 10), "PaperThread");
        Thread attendance = new Thread(new ExamActivity("Attendance Marking", 10, 8), "AttendanceThread");
        Thread collection = new Thread(new ExamActivity("Sheet Collection", 15, 7), "CollectionThread");

        System.out.println("Initial State of Paper Distribution: " + papers.getState());
        entry.start();
        papers.start();
        attendance.start();
        collection.start();
        Thread.sleep(6000); 
        System.out.println("\n[SYSTEM CHECK] Paper Distribution Thread State: " + papers.getState());
        entry.join();
        papers.join();
        attendance.join();
        collection.join();

        System.out.println("\n--- Exam Session Concluded. All threads TERMINATED. ---");
    }