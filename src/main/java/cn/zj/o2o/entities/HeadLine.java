package cn.zj.o2o.entities;

import java.util.Date;

/**
 * @author zhaojie
 * @date 2018\8\11 0011 - 11:37
 */

//头条
public class HeadLine {

    private Integer lineId;
    private String lineName;
    private String linelink;
    private String lineImg;
    private Integer priority;
    //头条可用状态 0不可用  1可用
    private Integer enableStatus;
    private Date createTime;
    private Date updateTime;

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLinelink() {
        return linelink;
    }

    public void setLinelink(String linelink) {
        this.linelink = linelink;
    }

    public String getLineImg() {
        return lineImg;
    }

    public void setLineImg(String lineImg) {
        this.lineImg = lineImg;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
