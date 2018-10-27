package cn.zj.o2o.entities;

import java.util.Date;

/**
 * @author zhaojie
 * @date 2018\8\11 0011 - 0:40
 */

//微信账号
public class WeChatAuth {

    private Long WeChatAutmId;
    private String openID;
    private Date createTime;
    private PersonInfo person;

    public PersonInfo getPerson() {
        return person;
    }

    public void setPerson(PersonInfo person) {
        this.person = person;
    }

    public Long getWeChatAutmId() {
        return WeChatAutmId;
    }

    public void setWeChatAutmId(Long weChatAutmId) {
        WeChatAutmId = weChatAutmId;
    }

    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
