package cn.zj.o2o.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhaojie
 * @date 2018\8\12 0012 - 17:49
 */
public class HttpServletRequestUtils {

    public static int getInt(HttpServletRequest request ,String key){
        return Integer.valueOf(request.getParameter(key));
    }

    public static double getDouble(HttpServletRequest request ,String key){
        return Double.valueOf(request.getParameter(key));
    }

    public static Long getLong(HttpServletRequest request ,String key){
        return Long.valueOf(request.getParameter(key));
    }

    public static boolean getBoolean(HttpServletRequest request ,String key){
        return Boolean.valueOf(request.getParameter(key));
    }

    public static String getString(HttpServletRequest request ,String key){

        String result =null;

        if(key!=null){
            result = request.getParameter(key);
        }

        if(key==""){
            result=null;
        }
            return result;
    }

}
