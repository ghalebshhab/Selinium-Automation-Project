package com.todo.Utils;

import java.util.Properties;

public class configUtils {
private static Properties props;
static configUtils  confutils;
private configUtils(){
    props=propertiesUtils.LoadProp("src/test/java/com/todo/config/production.properties");
}
public static configUtils getInstance(){
    if (confutils==null)
        confutils=new configUtils();
    return confutils;
}
public String getUrl(){
   return props.getProperty("baseUrl");
}
    public String getEmail(){
        return props.getProperty("email");
    }
    public String getPass(){
        return props.getProperty("password");
    }
}
