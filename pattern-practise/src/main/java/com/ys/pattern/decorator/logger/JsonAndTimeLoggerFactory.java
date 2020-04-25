package com.gupaoedu.vip.pattern.decorator.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Tom.
 */
public class JsonAndTimeLoggerFactory {

    public static AddTimeLogger getLogger(Class clazz){
        Logger logger = JsonLoggerFactory.getLogger(clazz);
        return new AddTimeLogger(logger);
    }
}
