package com.ys.pattern.decorator.logger;

import org.slf4j.Logger;

/**
 * Created by Tom.
 */
public class Test {
//    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    private static final Logger logger = JsonAndTimeLoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        logger.error("系统错误");


//        try {
//            InputStream in = new FileInputStream("");
//
//            BufferedInputStream bis = new BufferedInputStream(in);
//
//            bis.read();
//            bis.close();
//
//            BufferedReader br = new BufferedReader(new FileReader(""));
//            br.readLine();
//
//            BufferedReader bs = new BufferedReader(new StringReader(""));
//            bs.readLine();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
