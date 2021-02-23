public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread runnable = new Thread(new CustomRunnableThread(counter));
        CustomExtendedThread extended = new CustomExtendedThread(counter);
        runnable.start();
        extended.start();
    }
}
