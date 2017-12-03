package zhangshengqin.bwie.com.zhouyi.app;

import retrofit2.http.GET;
import rx.Observable;
import zhangshengqin.bwie.com.zhouyi.bean.Bean;

/**
 * Created by 额头发 on 2017/12/3.
 */

public interface ApiService {
    @GET("AppNews/getNewsList/type/1/p/1")
    Observable<Bean> getData();
}
