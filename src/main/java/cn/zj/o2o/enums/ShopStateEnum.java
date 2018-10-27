package cn.zj.o2o.enums;

/**
 * @author zhaojie
 * @date 2018\8\12 0012 - 11:21
 */
//关于店铺状态信息的常量字典
public enum ShopStateEnum{

  CHECK(0,"审核中"),
  OFFLINE(-1,"非法操作"),
  PASS(2,"通过认证"),
  SUCCESS(1,"操作成功"),
  INNER_ERROR(-10001,"操作失败"),
  NNULL_SHOPID(-10002,"无shop的id"),
  NULL_SHOP_INFO(-10003,"店铺信息为空");

  private int state;
  private String stateInfo;

  //枚举类的构造函数在内部对其枚举类型进行初始化
  private ShopStateEnum(int state,String stateInfo){
      this.state=state;
      this.stateInfo=stateInfo;
  }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ShopStateEnum stateOf(int index ){

      for (ShopStateEnum state:values()) {

          if(state.getState() == index){

              return state;

          }

      }
         return null;
  }

}
