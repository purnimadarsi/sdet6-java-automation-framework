package utillties;

import java.io.*;
import java.util.Properties;

public final class FileReaderUtil {
    private FileReaderUtil() {

    }

    public static Properties getConfigPropertyFileInfo(String filePath) {



    Properties properties = new Properties();
    FileReader fileReader;
    try{
        fileReader = new FileReader(filePath);

    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
        BufferedReader reader = new BufferedReader(fileReader);
     try{
          properties.load(reader);
     } catch (IOException e) {
         throw new RuntimeException(e);
     }

        return properties;

}
}
