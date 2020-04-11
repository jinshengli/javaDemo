package designmodel.singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private FileWriter writer;

    public Logger() throws IOException {
        File file = new File("log.txt");
        writer = new FileWriter(file, true);
    }

    public void log(String message) throws IOException {
        synchronized (Logger.class){
            writer.write(message);
        }
    }

}
