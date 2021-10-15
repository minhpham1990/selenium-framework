package com.demo.logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class MyLogger {
    private static final Logger log = LogManager.getLogger(MyLogger.class.getName());

    public static void logInfo(String msg){
        log.info(msg);
    }

    public static void logError(String msg){
        log.error(msg);
    }
}
