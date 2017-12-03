package zhangshengqin.bwie.com.zhouyi.model;

import java.util.List;

import zhangshengqin.bwie.com.zhouyi.bean.DataBean;

/**
 * Created by 额头发 on 2017/12/3.
 */

public interface RequsetListener {
    void OnSuccess(List<DataBean> list);
    void OnError(String r);
}
