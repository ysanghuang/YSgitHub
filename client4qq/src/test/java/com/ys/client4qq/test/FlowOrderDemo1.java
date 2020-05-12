package com.ys.client4qq.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/5/12 14:36
 * @Version: 1.0
 */

public class FlowOrderDemo1 {
    public static String orderId = "O20041517015003897227";
    public static String secret = "6dd3030268af04048682433c341386bb";
    public static String proxyHost = "flow.hailiangip.com";
    public static int proxyPort = 14223;

    public static String createPwd(String orderId, String secret) {
        String signTemplate = "orderId={orderId}&secret={secret}&time={time}";
        String passwordTemplate = "orderId={orderId}&sign={sign}&time={time}&pid=-1&cid=-1&sip=0&nd=0";
        long time = System.currentTimeMillis() / 1000;
        String str1 = signTemplate.replace("{orderId}", orderId)
                .replace("{secret}", secret)
                .replace("{time}", String.valueOf(time));
        String sign = org.apache.commons.codec.digest.DigestUtils.md5Hex(str1).toLowerCase();
        return passwordTemplate.replace("{orderId}", orderId)
                .replace("{sign}", sign)
                .replace("{time}", String.valueOf(time));
    }

    public static Map<String, Object> httpProxyWithPassRequest(String destUrl, String proxyHost, int proxyPort, String proxyUserName, String proxyPassword) throws IOException {
        HttpHost host = new HttpHost(proxyHost, proxyPort);
        CredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(new AuthScope(host), new UsernamePasswordCredentials(proxyUserName, proxyPassword));

        CloseableHttpClient client = HttpClients.custom()
                .setDefaultCredentialsProvider(provider).build();

        HttpGet httpGet = new HttpGet(destUrl);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(6000)
                .setSocketTimeout(6000).setProxy(host).build();

        httpGet.setConfig(requestConfig);
        HttpResponse httpResponse = client.execute(httpGet);
        System.out.println("http代理请求状态码: " + httpResponse.getStatusLine());
//        System.out.println("http代理请求响应内容: " + EntityUtils.toString(httpResponse.getEntity()));
        String result = EntityUtils.toString(httpResponse.getEntity());
        JSONObject jsonResult = JSONObject.parseObject(result);
        return jsonResult;
    }

    public static String destUrl = "https://api.66mz8.com/api/qq.level.php?qq=";
    public static void main(String[] args) {
        List<String> qqs = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            qqs.add("1359611399");
            qqs.add("120848418");
            qqs.add("1521612384");
        }
        List<Map<String, Object>> resultList = new ArrayList<>();
        Long startTime = new Date().getTime();
        qqs.forEach(qq ->{
            try {
                Map<String, Object> m = httpProxyWithPassRequest(destUrl+qq, proxyHost , proxyPort, "proxy", createPwd(orderId, secret));
                resultList.add(m);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Long endTime = new Date().getTime();
        System.out.println("耗时："+(endTime-startTime)/1000+"s");
        System.out.println(resultList);
    }
}
