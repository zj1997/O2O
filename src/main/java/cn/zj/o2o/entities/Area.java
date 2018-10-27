package cn.zj.o2o.entities;

import java.util.Date;

/**
 * @author zhaojie
 * @date 2018\8\10 0010 - 23:43
 */
//区域的实体类
public class Area {

    //区域的ID
    private Integer areaId;

    //区域的名称
    private String areaName;

    //区域的权重
    private Integer priority;

    //区域的创建时间
    private Date createTime;

    //区域的更新时间
    private Date updateTime;


    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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
