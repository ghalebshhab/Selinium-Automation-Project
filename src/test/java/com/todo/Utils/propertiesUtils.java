package com.todo.Utils;

import javax.management.RuntimeMBeanException;
import java.io.*;
import java.util.Properties;

public class propertiesUtils {

    public static Properties LoadProp(String filePath){
        try{
            File file=new File(filePath);
            InputStream input=new FileInputStream(file);
            Properties props=new Properties();
            props.load(input);
            input.close();
            return props;

        }
        catch(FileNotFoundException e){
            throw new RuntimeException("File not found .");
        }
        catch(IOException e){
            throw new RuntimeException("Error While Loading The Properties .");
        }
    }
}
