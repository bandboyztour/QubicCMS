package com.qubiccms.logger;

import com.sun.javafx.binding.StringFormatter;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;

public class FileLogger implements Logger {
    private FileWriter logWriter;

    public FileLogger () {
        Date date = new Date(System.currentTimeMillis());
        String now = DateFormat.getDateTimeInstance().format(date);
        File logFile = new File(
                now.replaceAll(":", "_") + ".txt"
        );
        try {
            if (!logFile.exists()) {
                    if (!logFile.createNewFile()) {
                        System.exit(0);
                    }
            }
            logWriter = new FileWriter(logFile);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(0);
        }
    }

    public void log(Level level, String msg) {
        Date date = new Date(System.currentTimeMillis());
        String now = DateFormat.getDateTimeInstance().format(date);
        String formatted = StringFormatter.format("%s %s - %s\n", now, level.getName(), msg).getValue();
        try {
            logWriter.write(formatted);
            logWriter.flush();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
