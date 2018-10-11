package com.wzy.server.jar.loader;

import com.wzy.server.config.Config;
import com.wzy.server.http.request.BoxHttpRequest;
import com.wzy.server.http.response.BoxHttpResponse;
import com.wzy.server.jar.api.NetApi;
import com.wzy.server.jar.api.config.BoxApp;
import com.wzy.server.jar.api.config.BoxAppApi;
import com.wzy.server.jar.loader.LoadJar;
import com.wzy.server.jar.loader.config.Jar;

import javax.swing.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadJarImpl implements LoadJar {

    // 存放应用信息
    static Map<Integer, BoxApp> boxAppMap = new HashMap<>();

    // 存放应用关联的api
    static Map<Integer, List<BoxAppApi>> boxAppApiMap = new HashMap<>();

    // 存放api 访问映射路径
    static Map<String,BoxAppApi> httpMap = new HashMap<>();

    /**
     * 运行jar当中的方法
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public boolean runClass(BoxHttpRequest request, BoxHttpResponse response) throws Exception {
        BoxAppApi boxAppApi = httpMap.get(request.uri());
        if (boxAppApi == null) return false;
        Jar jar = BoxUrlClassLoader.getJar(boxAppApi.getJarMd5());
        if (jar == null) return false;
        jar.setObjClass(jar.getClassLoader().loadClass(boxAppApi.getRunClass()));
        Object obj = jar.getObjClass().newInstance();
        Method method = jar.getObjClass().getMethod(boxAppApi.getRunFunction(),BoxHttpRequest.class,BoxHttpResponse.class);
        boolean returnError = false;
        returnError = (boolean) method.invoke(obj, request,response);
        return returnError;
    }

    @Override
    public void initJar() throws Exception {

        // 循环加载jar
        boxAppMap.forEach((k, v) -> {
            Jar jar = new Jar();
            jar.setBaseId(v.getAppId());
            jar.setJarDownUrl(v.getJarUrl());
            jar.setJarMd5(v.getJarMd5());
            try {
                BoxUrlClassLoader.addJar(jar);
            } catch (Exception e) {
                Config.log.error(e);
            }
            boxAppMap.put(v.getAppId(), v);
        });

        // 存放api访问映射路径
        boxAppApiMap.forEach((k,v) ->{
            v.forEach(boxAppApi -> {
                httpMap.put(boxAppApi.getLinkUrl(), boxAppApi);
            });
        });
    }

    /**
     * 获取网络jar
     * @throws Exception
     */
    @Override
    public void initHttp() throws Exception {
        List<BoxApp> boxApps = NetApi.getBoxAppList();
        boxApps.forEach(boxApp -> {
            boxAppMap.put(boxApp.getAppId(), boxApp);
            try {
                List<BoxAppApi> boxAppApis = NetApi.getBoxAppApiList(boxApp.getAppId().toString());
                boxAppApiMap.put(boxApp.getAppId(), boxAppApis);
            } catch (Exception e) {
                Config.log.error(e);
            }
        });
    }

    @Override
    public boolean scanJar()
    {
        return false;
    }
}
