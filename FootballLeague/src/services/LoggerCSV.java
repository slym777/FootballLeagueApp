package services;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.*;

public class LoggerCSV {
    private LoggerCSV(){}

    private static Formatter CSVFormatter = new Formatter() {
        @Override
        public String format(LogRecord logRecord) {
            String level = logRecord.getLevel().toString();
            Date moment = Calendar.getInstance().getTime();
            String action = logRecord.getMessage();
            String name = logRecord.getLoggerName();

            return level + "," + action + "," + moment.toString() + "," + name + "\n";
        }
    };

    public static Logger getInstance() {
        Logger logger = Logger.getLogger("Premier FootbalLeague");

        try {
            FileHandler handler = new FileHandler("C:\\Users\\sl1m\\Desktop\\FootballLeagueApp\\FootballLeague\\src\\filesCSV\\logger.csv", true);
            handler.setFormatter(LoggerCSV.CSVFormatter);
            logger.addHandler(handler);
            logger.setUseParentHandlers(false);
            logger.setLevel(Level.ALL);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + e.getCause() + "\n" + e.getLocalizedMessage());
        }
        return logger;
    }
}