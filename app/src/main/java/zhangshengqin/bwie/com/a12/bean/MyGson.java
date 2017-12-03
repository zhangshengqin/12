package zhangshengqin.bwie.com.a12.bean;

/**
 * Created by 额头发 on 2017/12/1.
 */

public class MyGson {
    private Ret ret;



    @Override

    public String toString() {

        return "MyGson{" +

                "ret=" + ret +

                '}';

    }



    public Ret getRet() {

        return ret;

    }



    public void setRet(Ret ret) {

        this.ret = ret;

    }



    public MyGson(Ret ret) {

        this.ret = ret;

    }
}
