package zhangshengqin.bwie.com.i.app;

import retrofit2.http.GET;
import rx.Observable;
import zhangshengqin.bwie.com.i.bean.Bean;

/**
 * Created by 额头发 on 2017/12/2.
 */

public interface ApiService {
    @GET("AppNews/getNewsList/type/1/p/1")
    Observable<Bean> getData();
}
