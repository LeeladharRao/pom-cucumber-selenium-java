package com.org.helpers;

import java.io.File;

public class SystemHelpers {

    public SystemHelpers() {
        super();
    }

    public static String getCurrentDir() {
        return System.getProperty("user.dir") + File.separator;
    }
}
