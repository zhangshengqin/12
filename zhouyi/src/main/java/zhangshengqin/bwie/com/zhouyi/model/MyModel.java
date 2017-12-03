package zhangshengqin.bwie.com.zhouyi.model;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhangshengqin.bwie.com.zhouyi.app.ApiService;
import zhangshengqin.bwie.com.zhouyi.bean.Bean;
import zhangshengqin.bwie.com.zhouyi.bean.DataBean;

/**
 * Created by 额头发 on 2017/12/3.
 */

public class MyModel implements MyModelInfo{
    @Override
    public void GetDate(String url, final RequsetListener requsetListener) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();

                ApiService apiService = retrofit.create(ApiService.class);
                //结合rxjava
        Observable<Bean> data = apiService.getData();
        data.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Bean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                requsetListener.OnError(e.getMessage().toString());
                            }

//                            @Override
//                            public void onNext(MyBean songListBean) {
//                                List<MyBean.SongListBean> list = songListBean.getSong_list();
//                                onClientListener.OnSuccess(list);
//                            }

                            @Override
                            public void onNext(Bean bean) {
                                List<DataBean> list = bean.getData();
                                requsetListener.OnSuccess(list);
                            }
                        });
    }
}
