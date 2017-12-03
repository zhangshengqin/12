package zhangshengqin.bwie.com.i.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import zhangshengqin.bwie.com.i.R;
import zhangshengqin.bwie.com.i.adapter.MainAdapter;
import zhangshengqin.bwie.com.i.app.Api;
import zhangshengqin.bwie.com.i.bean.DataBean;
import zhangshengqin.bwie.com.i.gen.DataBeanDao;
import zhangshengqin.bwie.com.i.presenter.MyPresenter;
import zhangshengqin.bwie.com.i.utils.DBUtils;
import zhangshengqin.bwie.com.i.view.MyViewInfo;

public class OneFragment extends Fragment implements MyViewInfo {

    @BindView(R.id.rlv)
    RecyclerView rlv;
    Unbinder unbinder;

    private List<DataBean> datas;
    private DataBeanDao dao;
    private MainAdapter adapter;
    private MyPresenter myPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_one_fragment, container, false);
       dao = DBUtils.getInstance(getActivity()).getDao();
        unbinder = ButterKnife.bind(this, view);
        myPresenter = new MyPresenter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rlv.setLayoutManager(linearLayoutManager);
        //直接从数据库中取数据
         datas = dao.loadAll();
//        Log.d("TT", "showSuccess: "+datas.size()+"33333333333333333333333");
        adapter = new MainAdapter(datas, getActivity());
        rlv.setAdapter(adapter);

        if(datas==null||datas.size()==0){
            //从网络获取
            myPresenter.getSuccess(Api.PATH);
//            Log.d("TT", "showSuccess: "+"22222222222222222222222");
        }


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (!isConnect(getActivity())){
            setNetworkMethod(getActivity());
        }




    }
    public static boolean isConnect(Context context) {
        boolean _isConnect = false;
        ConnectivityManager conManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = conManager.getActiveNetworkInfo();
        if (network != null) {
            _isConnect = conManager.getActiveNetworkInfo().isAvailable();
        }
        return _isConnect;
    }



    /**
     * 打开系统网络设置界面
     * @param context
     */
    public void setNetworkMethod(final Context context) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示信息").setMessage("未发现网络连接,是否进行设置?").setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Intent intent = null;
                //3.0之前和之后API不同，需要判断
                if (android.os.Build.VERSION.SDK_INT > 10) {
                    intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                } else {
                    intent = new Intent();
                    ComponentName component = new ComponentName("com.android.settings", "com.android.settings.WirelessSettings");
                    intent.setComponent(component);
                    intent.setAction("android.intent.action.VIEW");
                }
                context.startActivity(intent);
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        }).show();
    }



    @Override
    public void showSuccess(List<DataBean> list) {
        /*rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlv.setAdapter(new MainAdapter(list,getActivity()));*/

//        Log.d("TT", "showSuccess: "+list.size()+"111111111111111111111111");
        if(list!=null){
            for (DataBean l:list){
                dao.insert(l);
            }
            adapter.notifyDataSetChanged();

        }



    }

    @Override
    public void failError(String msg) {

    }

}
