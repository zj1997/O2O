package cn.zj.o2o.web.shopadmin;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.zj.o2o.dto.ShopExecution;
import cn.zj.o2o.entities.Area;
import cn.zj.o2o.entities.PersonInfo;
import cn.zj.o2o.entities.Shop;
import cn.zj.o2o.entities.ShopCategory;
import cn.zj.o2o.service.AreaService;
import cn.zj.o2o.service.ShopCategoryService;
import cn.zj.o2o.service.ShopService;
import cn.zj.o2o.utils.CodeUtil;
import cn.zj.o2o.utils.HttpServletRequestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.method.annotation.ModelMethodProcessor;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaojie
 * @date 2018\8\12 0012 - 17:48
 */
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {

     @Autowired
     private ShopService shopservice;

    @Autowired
    private ShopCategoryService shopCategoryService;

    @Autowired
    private AreaService areaService;


    @RequestMapping("/ppp")
    public String test(){

        return "shop/shopedit";

    }


     @ResponseBody
     @RequestMapping(value="/registershop",method = RequestMethod.POST)
    public Map<String,Object> registerShop(HttpServletRequest request){

          Map<String,Object>  modelMap = new HashMap<String,Object>();

         //处理验证码
         if(!CodeUtil.checkVerifyCode(request)){

             modelMap.put("success",false);
             modelMap.put("errMsg","验证码输入错误");
             return modelMap;
         }


         //接收参数并转化参数，以及处理图片

         String shopStr = HttpServletRequestUtils.getString(request,"shopStr");


        ObjectMapper mapper = new ObjectMapper();

        Shop shop=null;

        try {

            shop = mapper.readValue(shopStr, Shop.class);

        }catch (Exception e){

            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
            return modelMap;
        }

        //处理图片
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver =
                new CommonsMultipartResolver(request.getSession().getServletContext());

        if(commonsMultipartResolver.isMultipart(request)){

            MultipartHttpServletRequest  multipartHttpServletRequest = (MultipartHttpServletRequest)request;

             shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");

        }else {

            modelMap.put("success",false);
            modelMap.put("errMsg","上传图片不能为空");
            return modelMap;
        }


        //注册店铺 ，返回结果
        if(shop!=null&&shopImg!=null){

            shop.setOwnerId(1L);

            ShopExecution excution = shopservice.addShop(shop, shopImg);


            if(excution.getStateInfo().equals("审核中")){

                modelMap.put("success",true);
                return modelMap;

            }

        }else{

            modelMap.put("success",false);
            modelMap.put("errMsg","注册信息不能为空");
            return modelMap;

        }


        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/getshopinitinfo", method = RequestMethod.GET)
    private Map<String, Object> getShopInitInfo() {

        HashMap<String, Object> modelMap = new HashMap<>();
        List<Area> areas = new ArrayList<Area>();
        List<ShopCategory> shopCategories = new ArrayList<>();

        try {

            shopCategories  = shopCategoryService.queryShopCategory();
            areas = areaService.queryArea();




        } catch (RuntimeException e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        modelMap.put("shopCategoryList", shopCategories);
        modelMap.put("areaList", areas);
        modelMap.put("success", true);
        return modelMap;
     }
    }
