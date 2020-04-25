package com.ys.springframework.v2;

import com.ys.springframework.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/30 21:03
 * @Version: 1.0
 */
public class YSDispatcherServlet extends HttpServlet {
    private Properties contextProperties = new Properties();

    private List<String> classNames = new ArrayList<String>();

    private Map<String, Object> ioc = new HashMap<String, Object>();

    private Map<String, Method> handlerMapping = new HashMap<String, Method>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatcher(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        String url = req.getRequestURI();
        StringBuffer URL = req.getRequestURL();
        String contextPath = req.getContextPath();

        url = url.replaceAll(contextPath, "");

        if (!handlerMapping.containsKey(url)) {
            resp.getWriter().println("404 Not Found!!!");
            return;
        }

        Map<String, String []> params = req.getParameterMap();

        Method method = handlerMapping.get(url);

        Class<?>[] paramTypes = method.getParameterTypes();
        Object[] paramValues = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> paramType = paramTypes[i];
            if (paramType == HttpServletRequest.class) {
                paramValues[i] = req;
            } else if (paramType == HttpServletResponse.class) {
                paramValues[i] = resp;
            } else {
                Annotation[][] annotations = method.getParameterAnnotations();
                for (int j = 0; j < annotations.length; j++) {
                    for (Annotation anno : annotations[i]){
                        if(anno instanceof YSRequestParam){
                            String paramName = ((YSRequestParam) anno).value();
                            if(!"".equals(paramName.trim())){
                                String value = Arrays.toString(params.get(paramName))
                                        .replaceAll("\\[|\\]","")
                                        .replaceAll("\\s+",",");
                                paramValues[i] = value;
                            }
                        }
                    }
                }
            }
        }

        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());
        method.invoke(ioc.get(beanName), paramValues);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //加载配置文件位置
        try {
            loadConfigLocation(config.getInitParameter("contextConfigLocation"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //扫描相关的类
        scan(contextProperties.getProperty("scanPackage"));

        //初始化IoC容器
        initIoC();

        //完成依赖注入（DI）
        executeDI();

        //初始化映射处理器（HandlerMapping）
        initHandlerMapping();
    }

    private void initHandlerMapping() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> currentClazz = entry.getValue().getClass();
            if (!currentClazz.isAnnotationPresent(YSController.class)) {
                continue;
            }

            String baseUrl = "";
            if (currentClazz.isAnnotationPresent(YSRequestMapping.class)) {
                baseUrl = currentClazz.getAnnotation(YSRequestMapping.class).value();
            }

            for (Method method : currentClazz.getMethods()) {
                if (!method.isAnnotationPresent(YSRequestMapping.class)) {
                    continue;
                }

                String url = (baseUrl + "/" + method.getAnnotation(YSRequestMapping.class).value()).trim().replaceAll("/+", "/");
                handlerMapping.put(url, method);
                System.out.println("Mapped : " + url + "," + method);
            }
        }
    }

    private void executeDI() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            for (Field field : entry.getValue().getClass().getDeclaredFields()) {
                if (!field.isAnnotationPresent(YSAutowire.class)) {
                    continue;
                }

                YSAutowire autowire = field.getAnnotation(YSAutowire.class);
                //用户定义的beanName
                String beanName = autowire.value().trim();
                //没自定义则默认
                if ("".equals(beanName)) {
                    beanName = field.getType().getName();
                }

                //赋值
                field.setAccessible(true);
                try {
                    field.set(entry.getValue(), ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private void initIoC() {
        if (classNames.isEmpty()) {
            return;
        }
        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                //之反转标注了注解的类的控制权
                if (clazz.isAnnotationPresent(YSController.class)) {
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName, clazz.newInstance());
                } else if (clazz.isAnnotationPresent(YSService.class)) {
                    //自定义beanName
                    String beanName = clazz.getAnnotation(YSService.class).value();

                    Object instance = clazz.newInstance();
                    //默认beanName
                    if ("".equals(beanName.trim())) {
                        beanName = toLowerFirstCase(clazz.getSimpleName());
                    }
                    ioc.put(beanName, instance);

                    //将service接口也放入容器中
                    //如果接口有多个实现类则报异常
                    for (Class<?> c : clazz.getInterfaces()) {
                        if (ioc.containsKey(c.getName())) {
                            throw new Exception("Class" + c.getName() + " is already existed");
                        }
                        ioc.put(c.getName(), instance);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private void scan(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.trim().replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());
        if (classPath == null) {
            return;
        }
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                scan(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                classNames.add(scanPackage + "." + file.getName().replaceAll(".class", ""));
            }
        }
    }

    private void loadConfigLocation(String contextConfigLocation) throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        contextProperties.load(is);
    }
}
