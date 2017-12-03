package zhangshengqin.bwie.com.i.view;

import java.util.List;

import zhangshengqin.bwie.com.i.bean.DataBean;

/**
 * Created by 额头发 on 2017/12/2.
 */

public interface MyViewInfo {
    void showSuccess(List<DataBean> list);
    void failError(String msg);
}
