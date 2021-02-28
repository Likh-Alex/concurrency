package thread;

import org.apache.log4j.Logger;
import util.Counter;

public class ExtendedThread extends Thread {
    private static final Logger logger = Logger.getLogger(ExtendedThread.class);
    private final Counter counter;

    public ExtendedThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        while (counter.getCount() < 100) {
            logger.info("Extended " + counter.increment());
        }
    }
}
