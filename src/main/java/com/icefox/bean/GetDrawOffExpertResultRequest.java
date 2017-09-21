package com.icefox.bean;


import java.io.Serializable;

/**
 * 获取抽取专家请求对象
 */
public class GetDrawOffExpertResultRequest implements Serializable {
    /**
     * 评审小组ID
     */
    private String workGroupId;

    public String getWorkGroupId() {
        return workGroupId;
    }

    public void setWorkGroupId(String workGroupId) {
        this.workGroupId = workGroupId;
    }
}
