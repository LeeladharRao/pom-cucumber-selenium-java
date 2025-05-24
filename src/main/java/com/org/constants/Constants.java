package com.org.constants;

import com.org.helpers.PropertiesHelper;

public class Constants {

    public static final String HEADLESS = PropertiesHelper.getValue("HEADLESS");
    public static final String TARGET = PropertiesHelper.getValue("TARGET");
    public static final String BROWSER = PropertiesHelper.getValue("BROWSER");
    public static final String REMOTE_URL = PropertiesHelper.getValue("REMOTE_URL");
    public static final String REMOTE_PORT = PropertiesHelper.getValue("REMOTE_PORT");
    public static final String YES = "YES";
    public static final String DELETE_TEMP_FOLDER = "DELETE_TEMP_FOLDER";

    public static final int WAIT_SLEEP_STEP = Integer.parseInt(PropertiesHelper.getValue("WAIT_SLEEP_STEP"));
    public static final int WAIT_PAGE_LOADED = Integer.parseInt(PropertiesHelper.getValue("WAIT_PAGE_LOADED"));
    public static final int WAIT_EXPLICIT = Integer.parseInt(PropertiesHelper.getValue("WAIT_EXPLICIT"));

    public static int count_totalTCs = 0;
    public static int count_passedTCs = 0;
    public static int count_skippedTCs = 0;
    public static int count_failedTCs = 0;

    public static final String FULL_NAME = "Full Name";
    public static final String EMAIL = "Email";
    public static final String CURRENT_ADDRESS = "Current Address";
    public static final String PERMANENT_ADDRESS = "Permanent Address";


    private Constants() {
    }

}
