package cn.zj.o2o.entities;

import java.util.Date;

/**
 * @author zhaojie
 * @date 2018\8\11 0011 - 0:04
 */
//创建用户实体类
public class PersonInfo {

    private Long userId;

    private String personInfoName;

    //用户头像地址
    private String profileImg;

    private String email;

    private String gender;

    private Integer enableStatus;

    //用户的权限  默认 1：顾客  2：店家  3：超级管理员
    private Integer userType;

    private Date createTime;

    private Date updateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPersonInfoName() {
        return personInfoName;
    }

    public void setPersonInfoName(String personInfoName) {
        this.personInfoName = personInfoName;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
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
