package com.ys.client4qq.job;

import com.ys.client4qq.demo.FlowOrderDemo;
import com.ys.client4qq.utils.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/4/2 21:44
 * @Version: 1.0
 */
public class QueryQQThreadJob implements Callable<List<Map<String, Object>>> {
    private List<String> qqs;

    Logger logger = LoggerFactory.getLogger(QueryQQThreadJob.class);

    public QueryQQThreadJob(List<String> qqs) {
        this.qqs = qqs;
    }

    @Override
    public List<Map<String, Object>> call() throws Exception {
        if(CollectionUtils.isEmpty(qqs)){
            return null;
        }
        logger.debug("线程："+Thread.currentThread().getName() + "   开始");
        logger.debug("开始时间：" + new Date());
        FlowOrderDemo f = new FlowOrderDemo();
        List<Map<String, Object>> resultList = f.callApi(qqs,"https://api.66mz8.com/api/qq.level.php");
        return resultList;
    }

}
