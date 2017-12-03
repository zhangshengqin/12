package zhangshengqin.bwie.com.a12.presenter;

import java.util.Map;

import zhangshengqin.bwie.com.a12.bean.MyGson;
import zhangshengqin.bwie.com.a12.model.MyModel;
import zhangshengqin.bwie.com.a12.view.Iview;

/**
 * Created by 额头发 on 2017/12/1.
 */

public class MyPresenter implements MyModel.Onfinish{
    private final Iview iview;
    private final MyModel myModel;

    public MyPresenter(Iview iview) {
        this.iview = iview;
        this.myModel = new MyModel();
        myModel.setOnFinish(this);
    }

    public void setData(String url, Map<String, String> map) {
        myModel.getData(url, map);
    }

    @Override
    public void onFinish(MyGson list) {
        iview.getDatas(list);
    }
}
