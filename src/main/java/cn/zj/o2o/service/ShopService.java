package cn.zj.o2o.service;

import cn.zj.o2o.dto.ShopExecution;
import cn.zj.o2o.entities.Shop;
import cn.zj.o2o.exception.ShopException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author zhaojie
 * @date 2018\8\12 0012 - 11:53
 */

public interface ShopService {

    //添加店铺
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);


    //修改商铺信息
    ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg);
}
