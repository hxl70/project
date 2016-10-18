package com.hxl.utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by hxl on 2016/10/13.
 */
public class FileUtils {

    public static void createDirectory(String directory) {
        File file = new File(directory);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void createFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            createDirectory(file.getParent());
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
