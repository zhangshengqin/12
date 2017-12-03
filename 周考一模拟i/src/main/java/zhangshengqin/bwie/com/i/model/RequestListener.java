package zhangshengqin.bwie.com.i.model;

import java.util.List;

import zhangshengqin.bwie.com.i.bean.DataBean;

/**
 * Created by 额头发 on 2017/12/2.
 */

public interface RequestListener {
    void OnSuccess(List<DataBean> list);
    void OnError(String r);
}
