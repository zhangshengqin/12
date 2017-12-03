package zhangshengqin.bwie.com.zhouyi.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 额头发 on 2017/12/3.
 */
@Entity
public class DataBean {
    @Id
    private String news_id;
    private String news_title;
    private String news_summary;
    private String pic_url;
    @Generated(hash = 110510375)
    public DataBean(String news_id, String news_title, String news_summary,
            String pic_url) {
        this.news_id = news_id;
        this.news_title = news_title;
        this.news_summary = news_summary;
        this.pic_url = pic_url;
    }
    @Generated(hash = 908697775)
    public DataBean() {
    }
    public String getNews_id() {
        return this.news_id;
    }
    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }
    public String getNews_title() {
        return this.news_title;
    }
    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }
    public String getNews_summary() {
        return this.news_summary;
    }
    public void setNews_summary(String news_summary) {
        this.news_summary = news_summary;
    }
    public String getPic_url() {
        return this.pic_url;
    }
    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }
}
