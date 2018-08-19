package com.wzy.config;

import com.wzy.jar.LoadJar;
import com.wzy.util.log.BoxLog;
import com.wzy.util.log.JavaBoxLog;

/**
 * 系统配置
 */
public class Config {

    // 配置日志管理
    public static JavaBoxLog log = new BoxLog();

    // 配置服务
    public static BoxConfig config = new BoxConfig();

    // 配置Jar
    public static LoadJar loadJar = new LoadJar();

    // 初始化配置信息
    public static void initConfig(){
        config.setPort(8000);
        config.setServerMainPath("http://localhost:8762");
        config.setGetApiList("/butt/getApiList");
        config.setGetMouderList("/butt/getMoudularList");
        config.setGetProjectList("/butt/getProjectList");
        config.setJarDownServerUrl("http://localhost:8762/downJar?downUrl=");
        try {
            loadJar.initHttp();
            loadJar.initJar();
        } catch (Exception e) {
            log.error(e);
        }
    }
}