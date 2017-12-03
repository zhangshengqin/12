package zhangshengqin.bwie.com.zhouyi.view;

import java.util.List;

import zhangshengqin.bwie.com.zhouyi.bean.DataBean;

/**
 * Created by 额头发 on 2017/12/3.
 */

public interface MyViewInfo {
    void showSuccess(List<DataBean> list);
    void failError(String msg);
}
