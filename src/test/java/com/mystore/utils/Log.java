package com.mystore.utils;

import org.apache.log4j.Logger;

public class Log {

    /*
    * Here a static onject log is defined for logs it accepts class name as a parameter with getName method
    * */
    public static Logger log = Logger.getLogger(Log.class.getName());

    public static void startTestCase(String testCaseName)
    {
        log.info("===================="+testCaseName+" Test Start ====================");
    }

    public static void endTestCase(String testCaseName)
    {
        log.info("===================="+testCaseName+" Test End ====================");
    }

    public static void info(String message)
    {
        log.info(message);
    }
    public static void warn(String message)
    {
        log.warn(message);
    }
    public static void debug(String message)
    {
        log.debug(message);
    }
    public static void error(String message)
    {
        log.error(message);
    }
}
