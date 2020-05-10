package com.ys.client4qq.controller;

import com.ys.client4qq.demo.FlowOrderDemo;
import com.ys.client4qq.job.QueryQQThreadJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
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
    public String action(String qq) {
        List<String> qqs = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            qqs.add("1359611399");
            qqs.add("120848418");
            qqs.add("1521612384");
        }

        int perNum = 20;
        int threadSum = qqs.size() / perNum;

        ExecutorService e = Executors.newFixedThreadPool(20);//默认最多20个线程
        List<Future<String>> futureList = new ArrayList<>();

        int start = 0;
        int end = 1;
        for (int i = 1; i <= threadSum; i++) {
            logger.debug("循环：" + String.valueOf(i));
            end = i * perNum > qqs.size() ? qqs.size() : i * perNum;
            List subList = qqs.subList(start, end);
            Future<String> f1 = e.submit(new QueryQQThreadJob(subList));

            futureList.add(f1);
//            start = perNum * (i+1);
            start = end;

            if (i == threadSum && perNum * threadSum < qqs.size()) {
                Future<String> f2 = e.submit(new QueryQQThreadJob(qqs.subList(threadSum * perNum, qqs.size())));
                futureList.add(f2);
            }
        }
        String result = "";
        try {
            for (Future<String> f : futureList) {
                result += f.get();
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

    /*@RequestMapping("/query")
    public String query(){
        List<String> qqs = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            qqs.add("1359611399");
            qqs.add("120848418");
            qqs.add("1521612384");
        }

        List<String> resultList = new ArrayList<>();

        int perNum = 5;
        int threadSum = qqs.size() / perNum;

        int start = 0;
        int end = 1;
        for (int i = 1; i <= threadSum; i++) {
            end = i * perNum > qqs.size() ? qqs.size() : i * perNum;
            List subList = qqs.subList(start, end);

            QueryThread thread = new QueryThread(subList);
            thread.run();
            resultList.addAll(thread.getResultList());

            start = end;

            if (i == threadSum && perNum * threadSum < qqs.size()) {

            }
        }
        logger.debug(resultList.toString());
        return resultList.toString();
    }*/

    @RequestMapping("query1")
    public String query1() {
        List<String> qqs = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            qqs.add("1359611399");
            qqs.add("120848418");
            qqs.add("1521612384");
        }
        List<String> result = new ArrayList<>();
        //创建线程池 newFixedThreadPool(10) 创建一个定长线程池，可控制线程最大并发数为10(根据需求自行修改)
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);

        int perNum = 5;
        int threadSum = qqs.size() / perNum;

        int start = 0;
        int end = 1;
        for (int i = 1; i <= threadSum; i++) {
            end = i * perNum > qqs.size() ? qqs.size() : i * perNum;

            List subList = qqs.subList(start,end);
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    FlowOrderDemo f = new FlowOrderDemo();
                    List<String> l =  f.callApi(subList,"https://api.66mz8.com/api/qq.level.php");
                    logger.debug("==============================================");
                    logger.debug(l.toString());
                    result.addAll(l);
                }
            });

            start = end;
        }
        return result.toString();
    }

    private static List<String> list = new ArrayList<>();

    @RequestMapping("query2")
    public List query2(){
        List<String> qqs = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            qqs.add("1359611399");
            qqs.add("120848418");
            qqs.add("1521612384");
        }


        List<String> result = new ArrayList<>();
        //创建线程池 newFixedThreadPool(10) 创建一个定长线程池，可控制线程最大并发数为10(根据需求自行修改)
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);

        int perNum = 5;
        int threadSum = qqs.size() / perNum;

        int start = 0;
        int end = 1;
        for (int i = 1; i <= threadSum; i++) {
            end = i * perNum > qqs.size() ? qqs.size() : i * perNum;

            List subList = qqs.subList(start,end);
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    FlowOrderDemo f = new FlowOrderDemo();
                    List<String> l =  f.callApi(subList,"https://api.66mz8.com/api/qq.level.php");
                    logger.debug("==============================================");
                    logger.debug(l.toString());
                    ApiController.addList(l);
                }
            });

            start = end;
        }
        return list;
    }

    public static void addList(List l){
        list.addAll(l);
    }
}
