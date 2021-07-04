import com.qubiccms.logger.Logger;

import java.util.logging.Level;

public class FileLogger {
    static Logger LOGGER = new com.qubiccms.logger.FileLogger();
    public static void main(String[] args) {
//        Logger logger = new com.qubiccms.logger.FileLogger();
        LOGGER.log(Level.FINEST, "Message");
        LOGGER.log(Level.INFO, "Message");
        LOGGER.log(Level.SEVERE, "Message");
        LOGGER.log(Level.CONFIG, "Message");
        LOGGER.log(Level.FINE, "Message");
        LOGGER.log(Level.FINER, "Message");
        LOGGER.log(Level.OFF, "Message");
        LOGGER.log(Level.FINER, "Message");
    }
}
