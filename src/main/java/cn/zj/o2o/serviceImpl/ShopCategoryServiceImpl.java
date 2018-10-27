package cn.zj.o2o.serviceImpl;

import cn.zj.o2o.dao.ShopCategoryDao;
import cn.zj.o2o.entities.ShopCategory;
import cn.zj.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaojie
 * @date 2018\8\12 0012 - 21:47
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryDao dao;


    @Override
    public List<ShopCategory> queryShopCategory() {

        List<ShopCategory> ShopCategories = dao.queryShopCategory();


        return ShopCategories;
    }
}
