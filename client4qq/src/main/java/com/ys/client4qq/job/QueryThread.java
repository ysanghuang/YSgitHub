package com.ys.client4qq.job;

import com.ys.client4qq.controller.ApiController;
import com.ys.client4qq.demo.FlowOrderDemo;
import com.ys.client4qq.utils.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/4/15 16:19
 * @Version: 1.0
 */
public class QueryThread implements Runnable {
    Logger logger = LoggerFactory.getLogger(QueryThread.class);
    private List<String> qqs;
    private List<String> resultList = new ArrayList<>();

    @Autowired
    private ApiController apiController;

    public QueryThread(List<String> qqs) {
        this.qqs = qqs;
    }

    @Override
    public void run() {
        /*for (String qq : qqs) {
            String url = "https://api.66mz8.com/api/qq.level.php?qq="+qq;
            FlowOrderDemo f = new FlowOrderDemo();
            String result = f.callApi(url);
            resultList.add(result);
        }*/
        logger.debug("====当前线程===="+Thread.currentThread().getName());
        String url = "https://api.66mz8.com/api/qq.level.php";
        FlowOrderDemo f = new FlowOrderDemo();
        resultList.addAll(f.callApi(qqs,url));
    }

    public List<String> getResultList() {
        return resultList;
    }
}
