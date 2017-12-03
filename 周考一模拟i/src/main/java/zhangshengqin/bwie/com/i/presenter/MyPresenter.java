package zhangshengqin.bwie.com.i.presenter;

import java.util.List;

import zhangshengqin.bwie.com.i.bean.DataBean;
import zhangshengqin.bwie.com.i.model.MyModel;
import zhangshengqin.bwie.com.i.model.MyModelInfo;
import zhangshengqin.bwie.com.i.model.RequestListener;
import zhangshengqin.bwie.com.i.view.MyViewInfo;

/**
 * Created by 额头发 on 2017/12/2.
 */

public class MyPresenter {
    MyViewInfo myViewInfo;
    MyModelInfo myModelInfo;

    public MyPresenter(MyViewInfo myViewInfo) {
        this.myViewInfo = myViewInfo;
        myModelInfo = new MyModel();
    }
    public void getSuccess(String url){
        myModelInfo.getRequsetListener(url, new RequestListener() {
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
