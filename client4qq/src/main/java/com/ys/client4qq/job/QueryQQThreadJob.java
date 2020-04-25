package com.ys.client4qq.job;

import com.ys.client4qq.demo.FlowOrderDemo;
import com.ys.client4qq.utils.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/4/2 21:44
 * @Version: 1.0
 */
public class QueryQQThreadJob implements Callable<String> {
    private List<String> list;

    Logger logger = LoggerFactory.getLogger(QueryQQThreadJob.class);

    public QueryQQThreadJob(List<String> list) {
        this.list = list;
    }

    @Override
    public String call() throws Exception {
        if(CollectionUtils.isEmpty(list)){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (String qq: list) {
            if (StringUtils.isEmpty(qq)){continue;}
            String result = callApi(qq);
            builder.append(result);
        }
        logger.debug("当前线程："+Thread.currentThread().getName());
        return builder.toString();
    }

//    private String callApi(String qq){
//        String url = "https://api.66mz8.com/api/qq.level.php";
//        Map<String, String> param = new HashMap<>();
//        param.put("qq",qq);
//        HttpClientUtil httpUtil = new HttpClientUtil();
//        String result = httpUtil.doGet(url,param);
//        return result;
//    }

    private String callApi(String qq){
        String url = "https://api.66mz8.com/api/qq.level.php?qq="+qq;
        FlowOrderDemo f = new FlowOrderDemo();
        return f.callApi(url);
    }
}
