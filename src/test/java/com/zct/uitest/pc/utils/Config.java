package com.zct.uitest.pc.utils;

import java.io.*;
import java.util.Properties;

public class Config {
    private Properties properties = new Properties();
    public Config(String pathName) {
        File file = new File(pathName);
        try {
            InputStream in = new FileInputStream(file);
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }

}
