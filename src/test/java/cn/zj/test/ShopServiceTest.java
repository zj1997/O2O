package cn.zj.test;

import cn.zj.o2o.dao.ShopDao;
import cn.zj.o2o.dto.ShopExecution;
import cn.zj.o2o.entities.Area;
import cn.zj.o2o.entities.Shop;
import cn.zj.o2o.entities.ShopCategory;
import cn.zj.o2o.service.AreaService;
import cn.zj.o2o.service.ShopCategoryService;
import cn.zj.o2o.service.ShopService;
import cn.zj.o2o.serviceImpl.ShopServiceImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;



public class ShopServiceTest extends BaseTest{

	@Autowired
	private ShopService shopService;

	@Autowired
	private ShopDao dao;


	@Autowired
    private ShopCategoryService cService;

    @Autowired
    private AreaService aservice;

	@Test
    @Ignore
	public void testAddShop() throws Exception {

		Shop shop = new Shop();
		//shop.setOwnerId(1L);
		Area area = new Area();
		area.setAreaId(1);
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(1L);
		shop.setShopName("mytest1");
		shop.setShopDesc("mytest1");
		shop.setShopAddr("testaddr1");
		shop.setPhone("13810524526");
		shop.setShopImg("test1");
		shop.setLongitude(1D);
		shop.setLatitude(1D);
		shop.setCreateTime(new Date());
		shop.setUpdateTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("审核中");
		shop.setArea(area);
		shop.setShopCategory(sc);


		ShopExecution se = shopService.addShop(shop,null);

		System.out.print(se);


		//assertEquals("mytest1", se.getShop().getShopName());
	}


//	@Test
//	public void testGetByEmployeeId() throws Exception {
//		long employeeId = 1;
//		ShopExecution shopExecution = shopService.getByEmployeeId(employeeId);
//		List<Shop> shopList = shopExecution.getShopList();
//		for (Shop shop : shopList) {
//			System.out.println(shop);
//		}
//	}
//
//	@Ignore
//	@Test
//	public void testGetByShopId() throws Exception {
//		long shopId = 1;
//		Shop shop = shopService.getByShopId(shopId);
//		System.out.println(shop);
//	}

    @Test
	public void test(){


        Shop shop = dao.queryShopById(1L);
        System.out.print(shop);

    }



}
