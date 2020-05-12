package com.ys.client4qq.controller;

import com.ys.client4qq.demo.FlowOrderDemo;
import com.ys.client4qq.job.QueryQQThreadJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/4/2 13:04
 * @Version: 1.0
 */
@RestController
public class ApiController {

    Logger logger = LoggerFactory.getLogger(ApiController.class);

    @RequestMapping("/queryQQAge")
    public List<Map<String, Object>> action() {
        List<String> qqs = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            qqs.add("1359611399");
            qqs.add("120848418");
            qqs.add("1521612384");
        }

        int perNum = 10;
        int threadSum = qqs.size() / perNum;

        ExecutorService e = Executors.newFixedThreadPool(5);//默认最多20个线程
        List<Future<List<Map<String, Object>>>> futureList = new ArrayList<>();

        int start = 0;
        int end = 1;
        for (int i = 1; i <= threadSum; i++) {
            logger.debug("循环：" + i);
            end = i * perNum > qqs.size() ? qqs.size() : i * perNum;
            List subList = qqs.subList(start, end);
            Future<List<Map<String, Object>>> f1 = e.submit(new QueryQQThreadJob(subList));

            futureList.add(f1);

            start = end;

            if (i == threadSum && perNum * threadSum < qqs.size()) {
                Future<List<Map<String, Object>>> f2 = e.submit(new QueryQQThreadJob(qqs.subList(threadSum * perNum, qqs.size())));
                futureList.add(f2);
            }
        }
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            for (Future<List<Map<String, Object>>> f : futureList) {
                result.addAll(f.get());
            }
        } catch (InterruptedException e1) {
            logger.debug("=================InterruptedException================");
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            logger.debug("=================ExecutionException================");
            e1.printStackTrace();
        }

        return result;


    }


}
