package zhangshengqin.bwie.com.zhouyi.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import zhangshengqin.bwie.com.zhouyi.R;
import zhangshengqin.bwie.com.zhouyi.bean.DataBean;

/**
 * Created by 额头发 on 2017/12/3.
 */

public class MainAdapter extends RecyclerView.Adapter{

    private View view;
    private MyViewHolder holder;
    private List<DataBean> list;
    private Context context;
    private MyViewHolder myViewHolder;

    public MainAdapter(List<DataBean> list,Context context){
        this.list = list;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        myViewHolder = (MyViewHolder) holder;
        DataBean dataBean = list.get(position);
        myViewHolder.tv.setText(dataBean.getNews_summary());
        myViewHolder.tv2.setText(dataBean.getNews_title());
        Uri parse = Uri.parse(dataBean.getPic_url());
        myViewHolder.sdv.setImageURI(parse);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv;
        private final TextView tv2;
        private final SimpleDraweeView sdv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            tv2 = itemView.findViewById(R.id.tv2);
            sdv = itemView.findViewById(R.id.sdv);
        }

    }
}
