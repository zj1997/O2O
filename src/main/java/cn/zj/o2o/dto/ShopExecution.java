package cn.zj.o2o.dto;

import cn.zj.o2o.entities.Shop;
import cn.zj.o2o.enums.ShopStateEnum;

import java.util.List;

/**
 * @author zhaojie
 * @date 2018\8\12 0012 - 11:39
 */
//封装shop执行后的结果
public class ShopExecution {

    //结果状态
    private int state;

    //结果标识
    private String stateInfo;

    //店铺数量
    private int count;

    //店铺（针对增删改查）
    private Shop shop;

    private List<Shop> shopList;

    //店铺执行失败后的结果
    public ShopExecution(ShopStateEnum state){

         this.state=state.getState();
         this.stateInfo=state.getStateInfo();
    }

    //执行店铺成功后的结果
    public ShopExecution(ShopStateEnum state, Shop shop){

        this.state=state.getState();
        this.stateInfo=state.getStateInfo();
        this.shop=shop;
    }

    //执行店铺成功后的结果
    public ShopExecution(ShopStateEnum state, List<Shop> shopList){

        this.state=state.getState();
        this.stateInfo=state.getStateInfo();
        this.shopList=shopList;
    }



    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
