package singleton.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private static Logger instance;

    private PrintWriter writer;
    private String fileName;

    private Logger() {
        fileName = "log.txt";
        openFile();
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private void openFile() {
        try {
            writer = new PrintWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.out.println("Could not open log file: " + fileName);
        }
    }

    public void setFileName(String fileName) {
        close();
        this.fileName = fileName;
        openFile();
    }

    public void write(String message) {
        if (writer != null) {
            writer.println(message);
            writer.flush();
        }
    }

    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
