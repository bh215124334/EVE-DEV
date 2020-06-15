package com.bai.lpstore.tools;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileUtil {
    public static String getValue(String key) {
        Properties prop = new Properties();
        //读取属性文件application.properties，配置文件需要在类的路径下
        InputStream in = PropertyFileUtil.class.getResourceAsStream("/application.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
