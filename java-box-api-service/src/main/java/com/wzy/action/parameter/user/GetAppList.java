package com.wzy.action.parameter.user;

import com.wzy.util.annotation.check.IsNotLong;
import com.wzy.util.annotation.check.IsNotNull;

public class GetAppList {
    String appName;
    @IsNotLong(message = "pageNo is number")
    @IsNotNull(message = "pageNo is not null")
    Integer pageNo;
    @IsNotLong(message = "pageSize is number")
    @IsNotNull(message = "pageSize is not null")
    Integer pageSize;
    String jsonp;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getJsonp() {
        return jsonp;
    }

    public void setJsonp(String jsonp) {
        this.jsonp = jsonp;
    }
}
