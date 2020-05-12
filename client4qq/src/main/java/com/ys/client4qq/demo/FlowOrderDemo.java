package com.ys.client4qq.demo;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 流量订单Demo
 *
 * @ClassName FlowOrderDemo
 * @Description
 * @Date 2019/10/25 15:10
 **/
public class FlowOrderDemo {
    private static Logger logger = LoggerFactory.getLogger(FlowOrderDemo.class);

    public static String orderId = "O20041517015003897227";
    public static String secret = "6dd3030268af04048682433c341386bb";
    public static String proxyHost = "flow.hailiangip.com";
    public static int proxyPort = 14223;

    public static String createPwd(String orderId, String secret) {
        String signTemplate = "orderId={orderId}&secret={secret}&time={time}";
        String passwordTemplate = "orderId={orderId}&sign={sign}&time={time}&pid=27&cid=337";
        long time = System.currentTimeMillis() / 1000;
        String str1 = signTemplate.replace("{orderId}", orderId)
                .replace("{secret}", secret)
                .replace("{time}", String.valueOf(time));
        String sign = org.apache.commons.codec.digest.DigestUtils.md5Hex(str1).toLowerCase();
        return passwordTemplate.replace("{orderId}", orderId)
                .replace("{sign}", sign)
                .replace("{time}", String.valueOf(time));
    }

    public Map<String, Object> httpProxyWithPassRequest(String destUrl, String proxyHost, int proxyPort, String proxyUserName, String proxyPassword) throws IOException {
        HttpHost host = new HttpHost(proxyHost, proxyPort);
        CredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(new AuthScope(host), new UsernamePasswordCredentials(proxyUserName, proxyPassword));

        //DefaultConnectionKeepAliveStrategy 默认实现
        ConnectionKeepAliveStrategy myStrategy = new ConnectionKeepAliveStrategy() {
            @Override
            public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                Args.notNull(response, "HTTP response");
                final HeaderElementIterator it = new BasicHeaderElementIterator(
                        response.headerIterator(HTTP.CONN_KEEP_ALIVE));
                while (it.hasNext()) {
                    final HeaderElement he = it.nextElement();
                    final String param = he.getName();
                    final String value = he.getValue();
                    if (value != null && param.equalsIgnoreCase("timeout")) {
                        try {
                            return Long.parseLong(value) * 1000;
                        } catch (final NumberFormatException ignore) {
                        }
                    }
                }
                return 1;
            }

        };

        CloseableHttpClient client = HttpClients.custom()
                .setDefaultCredentialsProvider(provider).setKeepAliveStrategy(myStrategy).build();


        HttpGet httpGet = new HttpGet(destUrl);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(60000)
                .setSocketTimeout(60000).setProxy(host).build();

        httpGet.setConfig(requestConfig);
        HttpResponse httpResponse = client.execute(httpGet);
        System.out.println("http代理请求状态码: " + httpResponse.getStatusLine());
        logger.debug("当前线程：" + Thread.currentThread().getName());
        String result = EntityUtils.toString(httpResponse.getEntity());
        JSONObject jsonResult = JSONObject.parseObject(result);
        return jsonResult;
    }

    public List<Map<String, Object>> callApi(List<String> qqs, String url) {
        List<Map<String, Object>> result = new ArrayList<>();

        qqs.forEach(qq -> {
            String uri = url + "?qq=" + qq;
            try {
                result.add(httpProxyWithPassRequest(uri, proxyHost, proxyPort, "proxy", createPwd(orderId, secret)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        logger.debug("线程" + Thread.currentThread().getName() + "结束");
        logger.debug("结束时间：" + new Date());
        return result;
    }
}
