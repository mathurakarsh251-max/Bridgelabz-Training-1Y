interface Clock {
    void showTime();
}

interface FitnessTracker {
    void trackSteps();
}
class SmartWatch implements Clock, FitnessTracker {
    @Override
    public void showTime() {
        System.out.println("It is 10:30 AM.");
    }

    @Override
    public void trackSteps() {
        System.out.println("Steps: 5,000");
    }
}