package com.ys.pattern.decorator.logger;

import org.slf4j.Logger;


/**
 * Created by Tom.
 */
public class JsonAndTimeLoggerFactory {

    public static AddTimeLogger getLogger(Class clazz){
        Logger logger = JsonLoggerFactory.getLogger(clazz);
        return new AddTimeLogger(logger);
    }
}
