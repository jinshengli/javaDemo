package designmodel.singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoggerSingleton {

    private FileWriter writer;

    private static final LoggerSingleton instance = new LoggerSingleton();

    private LoggerSingleton(){
        try {
            File file = new File("log.txt");
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LoggerSingleton getInstance(){
        return instance;
    }

    public void log(String message) throws IOException {
            writer.write(message);
    }

}
