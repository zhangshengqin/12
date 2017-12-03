package zhangshengqin.bwie.com.zhouyi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zhangshengqin.bwie.com.zhouyi.adapter.MainAdapter;
import zhangshengqin.bwie.com.zhouyi.app.Api;
import zhangshengqin.bwie.com.zhouyi.bean.DataBean;
import zhangshengqin.bwie.com.zhouyi.gen.DataBeanDao;
import zhangshengqin.bwie.com.zhouyi.presenter.MyPresenter;
import zhangshengqin.bwie.com.zhouyi.utils.DBUtils;
import zhangshengqin.bwie.com.zhouyi.view.MyViewInfo;

public class MainActivity extends AppCompatActivity implements MyViewInfo {

    @BindView(R.id.rlv)
    RecyclerView rlv;
    private DataBeanDao dao;
    private List<DataBean> dates;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = DBUtils.getInstance(this).getDao();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MyPresenter myPresenter = new MyPresenter(this);
        rlv.setLayoutManager(new LinearLayoutManager(this));

        //从数据库里取数据
        dates = dao.loadAll();
        adapter = new MainAdapter(dates, this);
        rlv.setAdapter(adapter);
        if (dates == null || dates.size() == 0){
            myPresenter.getSuccess(Api.PATH);
        }

    }

    @Override
    public void showSuccess(List<DataBean> list) {
        if (list != null){
            for (DataBean bean : list){
                dao.insert(bean);
            }
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void failError(String msg) {

    }
}
