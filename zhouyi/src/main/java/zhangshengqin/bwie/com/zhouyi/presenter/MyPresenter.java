package zhangshengqin.bwie.com.zhouyi.presenter;

import java.util.List;

import zhangshengqin.bwie.com.zhouyi.bean.DataBean;
import zhangshengqin.bwie.com.zhouyi.model.MyModel;
import zhangshengqin.bwie.com.zhouyi.model.MyModelInfo;
import zhangshengqin.bwie.com.zhouyi.model.RequsetListener;
import zhangshengqin.bwie.com.zhouyi.view.MyViewInfo;

/**
 * Created by 额头发 on 2017/12/3.
 */

public class MyPresenter {
    MyViewInfo myViewInfo;
    MyModelInfo myModelInfo;

    public MyPresenter(MyViewInfo myViewInfo) {
        this.myViewInfo = myViewInfo;
        myModelInfo = new MyModel();
    }
    public void getSuccess(String url){
        myModelInfo.GetDate(url, new RequsetListener() {
            @Override
            public void OnSuccess(List<DataBean> list) {
                myViewInfo.showSuccess(list);
            }

            @Override
            public void OnError(String r) {
                myViewInfo.failError(r);
            }
        });
    }
}
