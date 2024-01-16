package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

    /**
     * Read data from file and return string value
     */
    public static String readDataFromFile(File file) {
        StringBuilder sb = new StringBuilder();
        try {
        BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
        }
        br.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return sb.toString();
    }
}
