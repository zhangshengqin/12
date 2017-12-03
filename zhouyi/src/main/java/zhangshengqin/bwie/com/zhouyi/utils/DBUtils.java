package zhangshengqin.bwie.com.zhouyi.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import zhangshengqin.bwie.com.zhouyi.gen.DaoMaster;
import zhangshengqin.bwie.com.zhouyi.gen.DaoSession;
import zhangshengqin.bwie.com.zhouyi.gen.DataBeanDao;



public class DBUtils {
    private static volatile DBUtils instance;
    private final DataBeanDao dao;

    private DBUtils(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context,"user",null);

        SQLiteDatabase db = helper.getWritableDatabase();

        DaoMaster daoMaster = new DaoMaster(db);

        DaoSession daoSession = daoMaster.newSession();

        dao = daoSession.getDataBeanDao();

    }

    public static DBUtils getInstance(Context context){
        if(null==instance){
            synchronized (DBUtils.class){

                if(instance==null){

                    instance=new DBUtils(context);
                }
            }
        }

        return instance;
    }

    public DataBeanDao getDao(){
        return dao;
    }
}
