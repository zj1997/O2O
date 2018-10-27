package cn.zj.o2o.dao;

import cn.zj.o2o.entities.Shop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhaojie
 * @date 2018\8\12 0012 - 0:30
 */
public interface ShopDao {


    //根据店铺Id查询店铺
    Shop queryShopById(Long shopId);

    //插入店铺信息
    int insertShop(Shop shop);

    //更新店铺信息
    int updateShop(Shop shop);

    //根据店铺名称删除店铺
    int deleteShopByName(String shopName);

}
