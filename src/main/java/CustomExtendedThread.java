import org.apache.log4j.Logger;

public class CustomExtendedThread extends Thread {
    private static final Logger logger = Logger.getLogger(CustomExtendedThread.class);
    private final Counter counter;

    public CustomExtendedThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i <= 100; i++) {
            logger.info("Extended " + counter.increment());
        }
    }
}
