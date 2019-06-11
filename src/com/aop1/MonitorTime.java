package com.aop1;

import java.util.Date;

public class MonitorTime {

    private String className;
    private String methodName;
    private Date logTime;
    private Long comsumeTime;

    public MonitorTime(String className, String methodName, Date logTime, Long comsumeTime) {
        this.className = className;
        this.methodName = methodName;
        this.logTime = logTime;
        this.comsumeTime = comsumeTime;
    }

    public MonitorTime(){}

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public Long getComsumeTime() {
        return comsumeTime;
    }

    public void setComsumeTime(Long comsumeTime) {
        this.comsumeTime = comsumeTime;
    }
}
