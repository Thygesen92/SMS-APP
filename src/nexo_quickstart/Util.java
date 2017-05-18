package nexo_quickstart;

/**
 * Created by thyge on 18-05-2017.
 */
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {
    public Util() {
    }

    public static void configureLogging() {
        String value = System.getenv("QUICKSTART_DEBUG");
        if(value != null) {
            ConsoleHandler handler = new ConsoleHandler();
            handler.setLevel(Level.FINEST);
            Logger logger = Logger.getLogger("com.nexmo");
            logger.setLevel(Level.FINEST);
            logger.addHandler(handler);
        }

    }

    public static String envVar(String key) {
        String value = System.getenv(key);
        if(value == null) {
            throw new IllegalArgumentException("You must provide the " + key + " environment variable!");
        } else {
            return value;
        }
    }
}
