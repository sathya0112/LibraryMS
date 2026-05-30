package util;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {

    public static Logger getLogger(String className) {

        Logger logger = Logger.getLogger(className);

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);

        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);

        return logger;
    }
}