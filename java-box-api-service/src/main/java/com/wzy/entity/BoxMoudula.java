package com.wzy.entity;

import java.util.Date;

public class BoxMoudula {
    Integer moudularId;
    Integer projectId;
    String moddularName;
    String moddularRoute;
    String jarName;
    String jarUrl;
    String jarVersion;
    Integer isUpdate;
    Date createTime;
    String jarMd5;

    public String getJarMd5() {
        return jarMd5;
    }

    public void setJarMd5(String jarMd5) {
        this.jarMd5 = jarMd5;
    }

    public Integer getMoudularId() {
        return moudularId;
    }

    public void setMoudularId(Integer moudularId) {
        this.moudularId = moudularId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getModdularName() {
        return moddularName;
    }

    public void setModdularName(String moddularName) {
        this.moddularName = moddularName;
    }

    public String getModdularRoute() {
        return moddularRoute;
    }

    public void setModdularRoute(String moddularRoute) {
        this.moddularRoute = moddularRoute;
    }

    public String getJarName() {
        return jarName;
    }

    public void setJarName(String jarName) {
        this.jarName = jarName;
    }

    public String getJarUrl() {
        return jarUrl;
    }

    public void setJarUrl(String jarUrl) {
        this.jarUrl = jarUrl;
    }

    public String getJarVersion() {
        return jarVersion;
    }

    public void setJarVersion(String jarVersion) {
        this.jarVersion = jarVersion;
    }

    public Integer getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Integer isUpdate) {
        this.isUpdate = isUpdate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
