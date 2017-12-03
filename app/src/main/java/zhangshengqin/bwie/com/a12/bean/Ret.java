package zhangshengqin.bwie.com.a12.bean;

import java.util.ArrayList;

/**
 * Created by 额头发 on 2017/12/1.
 */

public class Ret {
    ArrayList<Mybean> list;
    public ArrayList<Mybean> getList() {
        return list;
    }
    public void setList(ArrayList<Mybean> list) {
        this.list = list;
    }
    public Ret(ArrayList<Mybean> list) {
        this.list = list;
    }
}
