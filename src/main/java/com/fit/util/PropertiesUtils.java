package com.fit.util;

import com.google.common.cache.CacheLoader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @className: PropertiesUtils
 * @description: 读取配置文件工具
 * @author: Aim
 * @date: 2023/3/29
 **/
public class PropertiesUtils {

    private static PropertiesUtils proPool = new PropertiesUtils();
    private Properties prop = new Properties();
    public static Map<String, Object> map = new HashMap<String, Object>();

    static {
        proPool.setBreak("config.properties");
    }

    public final static PropertiesUtils getInstance() {
        return proPool;
    }


    /**
     * 刷新Map中参数
     *
     * @param fileName
     */
    public void setBreak(String fileName) {
        InputStream in = null;
        try {
            in = PropertiesUtils.getProperties(fileName);
            prop.load(in);
            Set<String> keys = prop.stringPropertyNames();
            map.clear();
            for (String key : keys) {
                map.put(key, prop.get(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Properties getProp() {
        return prop;
    }

    /**
     * 获取配置文件流
     *
     * @param fileName 配置文件名
     */
    private static InputStream getProperties(String fileName) {
        return PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName);
    }
}
