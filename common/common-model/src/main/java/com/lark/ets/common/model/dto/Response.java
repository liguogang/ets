/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.lark.ets.common.model.dto;

import java.io.Serializable;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.lark.ets.common.model.inf.ResponseAttachment;

/**
 * 
 * @author liguogang
 * @version $Id: Result.java, v 0.1 2016年3月19日 下午11:15:23 liguogang Exp $
 */
public class Response<T> implements Serializable {

    /**  */
    private static final long   serialVersionUID = 1L;
    // 串联一次上线文的唯一ID
    private String              traceId;
    // 返回的数据
    private T                   data;
    // transform data,透传数据
    private Map<String, Object> transData;
    // 是否阻断主流程继续往下执行
    private boolean             isInterrupt;
    // 返回结果是否成功
    private boolean             isSuccess;
    // 返回结果的状态码
    private String              code;
    // 返回结果的描述
    private String              desc;

    /***
     * 返回结果的附件
     * 
     * @param attachment
     */
    public final void attachment(final ResponseAttachment attachment) {
        if (null != attachment) {
            this.isInterrupt = attachment.isInterrupt();
            this.isSuccess = attachment.isSuccess();
            this.code = attachment.getCode();
            this.desc = attachment.getDesc();
        }
    }

    /***
     * 从另外一个结果中拷贝附件
     * 
     * @param sourceResult
     */
    public final void copyAttachment(final Response<?> sourceResponse) {
        if (null != sourceResponse) {
            this.isInterrupt = sourceResponse.isInterrupt;
            this.isSuccess = sourceResponse.isSuccess;
            this.code = sourceResponse.code;
            this.desc = sourceResponse.desc;
        }
    }
    
    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> getTransData() {
        return transData;
    }

    public void setTransData(Map<String, Object> transData) {
        this.transData = transData;
    }

    public boolean isInterrupt() {
        return isInterrupt;
    }

    public void setInterrupt(boolean isInterrupt) {
        this.isInterrupt = isInterrupt;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
