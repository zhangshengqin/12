package zhangshengqin.bwie.com.i.utils;

/**
 * Created by 额头发 on 2017/12/2.
 */

public class DanLi {
    private static volatile DanLi instance;

    //私有的无参
    private DanLi(){

    }

    public static DanLi getInstance(){

        if(null==instance){
            synchronized (DanLi.class){
                if(instance==null){
                    instance=new DanLi();
                }
            }

        }
        return instance;
    }



}
