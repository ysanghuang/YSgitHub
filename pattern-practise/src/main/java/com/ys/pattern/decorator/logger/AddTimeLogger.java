package com.ys.pattern.decorator.logger;

import org.slf4j.Logger;

import java.util.Date;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/29 19:36
 * @Version: 1.0
 */
public class AddTimeLogger extends LoggerDecorator{
    public AddTimeLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void error(String s) {
        logger.error(s +new Date().toString());
    }
}
