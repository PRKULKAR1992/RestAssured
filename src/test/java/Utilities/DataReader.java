package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Properties;

public class DataReader {
    private Properties properties;
    private static String propertyFilePath= FileSystems.getDefault().getPath("").toAbsolutePath() +"//src//main//java//Config.properties";


    public static Properties ConfigFileReader() throws IOException {
        System.out.println(propertyFilePath);
        BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
        Properties props=new Properties();
        props.load(reader);
        return props;
    }
}
