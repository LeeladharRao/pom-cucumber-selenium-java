package com.org.utils;

import org.apache.logging.log4j.Logger;

public class LogManager {
    private static final Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(LogManager.class);

    // Info Logging
    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void info(Object message) {
        LOGGER.info(message);
    }

    public static void info(String message, Throwable throwable) {
        LOGGER.info(message);
    }

    // Error Logging
    public static void error(String message) {
        LOGGER.error(message);
    }

    public static void error(String message, Throwable throwable) {
        LOGGER.error(message);
    }

    public static void error(Object message) {
        LOGGER.error(message);
    }

    public static void error(Object message, Throwable throwable) {
        LOGGER.error(message);
    }

}
