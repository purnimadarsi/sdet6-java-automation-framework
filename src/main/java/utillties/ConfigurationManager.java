package utillties;

import java.io.File;
import java.util.Objects;
import java.util.Properties;

public final class ConfigurationManager {
    private ConfigurationManager(){

    }
    public static Properties FRAMEWORK_PROPERTIES;
    public static Properties ENVIRONMENT_PROPERTIES;
    public static String ENVIRONMENT;
    public  static String BROWSER_NAME;
    public static String IS_HEADLESS;

     static{
         FRAMEWORK_PROPERTIES = FileReaderUtil.getConfigPropertyFileInfo("src/main/resources/framework-config.properties");
         getSystemVariables();
         setTestEnvProperties();

     }
     private static void getSystemVariables(){
         if(Objects.nonNull(System.getProperty("ENVIRONMENT"))){
             ENVIRONMENT = System.getProperty("ENVIRONMENT");
         }else{
             ENVIRONMENT = FRAMEWORK_PROPERTIES.getProperty("ENVIRONMENT");
         }
         if(Objects.nonNull(System.getProperty("BROWSER_NAME"))){
             BROWSER_NAME = System.getProperty("BROWSER_NAME");
         }else{
             BROWSER_NAME = FRAMEWORK_PROPERTIES.getProperty("BROWSER_NAME");
         }
         if(Objects.nonNull(System.getProperty("IS_HEADLESS"))){
             IS_HEADLESS = System.getProperty("IS_HEADLESS");
         }else{
             IS_HEADLESS = FRAMEWORK_PROPERTIES.getProperty("IS_HEADLESS");
         }


     }
     private static void setTestEnvProperties(){
        if(ENVIRONMENT.equalsIgnoreCase("QA")){
            ENVIRONMENT_PROPERTIES = FileReaderUtil.getConfigPropertyFileInfo("src/main/resources/environments/qa.properties");
        } else if (ENVIRONMENT.equalsIgnoreCase("INT")) {
            ENVIRONMENT_PROPERTIES = FileReaderUtil.getConfigPropertyFileInfo("src/main/resources/environments/int.properties");

        } else if (ENVIRONMENT.equalsIgnoreCase("PROD")) {
            ENVIRONMENT_PROPERTIES = FileReaderUtil.getConfigPropertyFileInfo("src/main/resources/environments/prod.properties");

        }else{
            throw new RuntimeException("invalid environment selected");
        }

     }

}
