package cn.zj.o2o.serviceImpl;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.zj.o2o.dao.ShopDao;
import cn.zj.o2o.dto.ShopExecution;
import cn.zj.o2o.entities.Shop;
import cn.zj.o2o.enums.ShopStateEnum;
import cn.zj.o2o.exception.ShopException;
import cn.zj.o2o.service.ShopService;
import cn.zj.o2o.utils.FileUtil;
import cn.zj.o2o.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Date;

/**
 * @author zhaojie
 * @date 2018\8\12 0012 - 11:54
 */

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao dao;



    @Transactional
    @Override
    public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) {

        if(shop ==null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
        }

        try {

            //店铺创建的固定信息
            shop.setUpdateTime(new Date());
            shop.setCreateTime(new Date());
            shop.setEnableStatus(0);

            int effectNum = dao.insertShop(shop);

            if(effectNum <= 0){
                throw new ShopException("店铺创建失败");
            }else{

                try {

                    if(shopImg!=null){

                        addShopImg(shop,shopImg);
                        shop.setAdvice(ShopStateEnum.CHECK.getStateInfo());
                        effectNum = dao.updateShop(shop);

                       if(effectNum <= 0){
                           throw new ShopException("创建图片地址失败");
                       }

                   }

               }catch (Exception e){
                  throw new RuntimeException("addImgErroe:"+e.getMessage());
               }

            }


        }catch (Exception e){

            throw new RuntimeException("insertImgErroe"+e.getMessage());
        }


        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }



    //根据id查询商铺信息
    public Shop queryShopById(Long shopId){

        Shop shop = dao.queryShopById(shopId);

        return shop;
    }



    //修改商铺信息
    @Transactional
    public ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg){

        try {

            //判断图片是否修改
            if(shop == null&&shop.getShopId()==null){
                return new ShopExecution(ShopStateEnum.NNULL_SHOPID);
            }

            if(shopImg!=null){

                Shop ushop = queryShopById(shop.getShopId());


                if(ushop.getShopImg()!=null){

                    FileUtil.deleteFile(ushop.getShopImg());
                }

                addShopImg(shop,shopImg);

            }

            //更新商铺信息
            int effctNum = dao.updateShop(shop);

            if(effctNum <= 0){

                return new ShopExecution(ShopStateEnum.INNER_ERROR);
            }else{

                return new ShopExecution(ShopStateEnum.SUCCESS,dao.queryShopById(shop.getShopId()));
            }


        }catch (Exception e){

            throw new ShopException("修改失败");
        }

    }



    private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {

        String dest = FileUtil.getShopImagePath(shop.getShopId());

        String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
        shop.setShopImg(shopImgAddr);
    }
}
