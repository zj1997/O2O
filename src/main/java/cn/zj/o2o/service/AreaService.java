package cn.zj.o2o.service;

import cn.zj.o2o.dto.ShopExecution;
import cn.zj.o2o.entities.Area;
import cn.zj.o2o.entities.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * @author zhaojie
 * @date 2018\8\12 0012 - 11:53
 */

public interface AreaService {

    List<Area> queryArea();

}
