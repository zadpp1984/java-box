package com.wzy.server.config;
import com.wzy.server.jar.loader.LoadJarImpl;
import com.wzy.util.log.BoxLog;
import com.wzy.util.log.JavaBoxLog;
import com.wzy.util.properties.PropertiesUtil;

/**
 * 系统配置
 */
public class Config {

    // 配置日志管理
    public final static JavaBoxLog log = new BoxLog();

    // 配置服务
    public final static BoxConfig config = new BoxConfig();

    // 配置Jar
    public final static LoadJarImpl loadJar = new LoadJarImpl();

    // 初始化配置信息
    public static boolean initConfig(){
        if (initEnvConfig())
            return true;
        else if (initPropertiesConfig())
            return true;
        return false;
    }

    // 读取环境变量
    public static boolean initEnvConfig(){
        try {
            String zookeeper_ip= System.getenv("zookeeper_ip");
            String zookeeper_port= System.getenv("zookeeper_port");
            String zookeeper_time_out= System.getenv("zookeeper_time_out");
            String service_api_base_url= System.getenv("service_api_base_url");
            String service_api_get_app_list= System.getenv("service_api_get_app_list");
            String service_api_get_app_api_list= System.getenv("service_api_get_app_api_list");
            String service_api_get_id= System.getenv("service_api_get_id");
            String service_api_get_fliters= System.getenv("service_api_get_fliters");
            String service_apt_down_jar= System.getenv("service_apt_down_jar");
            String server_port= System.getenv("server_port");
            String server_ip= System.getenv("server_ip");
            String server_charset= System.getenv("server_charset");
            config.setServerPort(Integer.valueOf(server_port));
            config.setJarDownServerUrl(service_api_base_url + service_apt_down_jar);
            config.setGetApplist(service_api_base_url + service_api_get_app_list);
            config.setGetAppApiList(service_api_base_url + service_api_get_app_api_list);
            config.setGetAppInfo(service_api_base_url + service_api_get_id);
            config.setGetFliter(service_api_base_url + service_api_get_fliters);
            config.setRegionServerIp(zookeeper_ip);
            config.setRegsionServerPort(Integer.valueOf(zookeeper_port));
            config.setRegsionServerTimeOut(Integer.valueOf(zookeeper_time_out));
            config.setCharSet(server_charset);
            config.setServerIp(server_ip);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // 读取配置文件
    public static boolean initPropertiesConfig(){
        try {
            String zookeeper_ip = PropertiesUtil.getConfigKey("zookeeper_ip");
            String zookeeper_port = PropertiesUtil.getConfigKey("zookeeper_port");
            String zookeeper_time_out = PropertiesUtil.getConfigKey("zookeeper_time_out");
            String service_api_base_url = PropertiesUtil.getConfigKey("service_api_base_url");
            String service_api_get_app_list = PropertiesUtil.getConfigKey("service_api_get_app_list");
            String service_api_get_app_api_list = PropertiesUtil.getConfigKey("service_api_get_app_api_list");
            String service_api_get_id = PropertiesUtil.getConfigKey("service_api_get_id");
            String service_api_get_fliters = PropertiesUtil.getConfigKey("service_api_get_fliters");
            String service_apt_down_jar = PropertiesUtil.getConfigKey("service_apt_down_jar");
            String server_port = PropertiesUtil.getConfigKey("server_port");
            String server_ip = PropertiesUtil.getConfigKey("server_ip");
            String server_charset = PropertiesUtil.getConfigKey("server_charset");
            config.setServerPort(Integer.valueOf(server_port));
            config.setJarDownServerUrl(service_api_base_url + service_apt_down_jar);
            config.setGetApplist(service_api_base_url + service_api_get_app_list);
            config.setGetAppApiList(service_api_base_url + service_api_get_app_api_list);
            config.setGetAppInfo(service_api_base_url + service_api_get_id);
            config.setGetFliter(service_api_base_url + service_api_get_fliters);
            config.setRegionServerIp(zookeeper_ip);
            config.setRegsionServerPort(Integer.valueOf(zookeeper_port));
            config.setRegsionServerTimeOut(Integer.valueOf(zookeeper_time_out));
            config.setCharSet(server_charset);
            config.setServerIp(server_ip);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
