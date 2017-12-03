package zhangshengqin.bwie.com.a12.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import zhangshengqin.bwie.com.a12.R;
import zhangshengqin.bwie.com.a12.adapter.MyAdApter;
import zhangshengqin.bwie.com.a12.bean.MyGson;

/**
 * Created by 额头发 on 2017/12/1.
 */

public class JingxuanFragment extends Fragment{
    @BindView(R.id.recycler)

    XRecyclerView recycler;

    Unbinder unbinder;



    private MyGson myGson;



    public JingxuanFragment(MyGson myGson) {

        this.myGson = myGson;

    }



    @Nullable

    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.ites, null);

        unbinder = ButterKnife.bind(this, view);

        //配置recyclerview

        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        recycler.setAdapter(new MyAdApter(getActivity(), myGson));

        return view;

    }



    @Override

    public void onDestroyView() {

        super.onDestroyView();

        unbinder.unbind();

    }
}
