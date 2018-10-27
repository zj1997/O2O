package cn.zj.o2o.serviceImpl;

import cn.zj.o2o.dao.AreaDao;
import cn.zj.o2o.dao.ShopDao;
import cn.zj.o2o.dto.ShopExecution;
import cn.zj.o2o.entities.Area;
import cn.zj.o2o.entities.Shop;
import cn.zj.o2o.enums.ShopStateEnum;
import cn.zj.o2o.exception.ShopException;
import cn.zj.o2o.service.AreaService;
import cn.zj.o2o.service.ShopService;
import cn.zj.o2o.utils.FileUtil;
import cn.zj.o2o.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @author zhaojie
 * @date 2018\8\12 0012 - 11:54
 */

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areadao;


    @Override
    public List<Area> queryArea() {

        List<Area> areas = areadao.queryArea();

        return areas;
    }
}
