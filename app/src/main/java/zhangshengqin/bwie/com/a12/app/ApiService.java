package zhangshengqin.bwie.com.a12.app;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import zhangshengqin.bwie.com.a12.bean.MyGson;

/**
 * Created by 额头发 on 2017/12/1.
 */

public interface ApiService {
    @GET
    Observable<MyGson> getDatasss(@Url String url, @QueryMap Map<String, String> map);
}
