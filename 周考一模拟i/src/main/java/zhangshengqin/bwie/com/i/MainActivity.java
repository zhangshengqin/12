package zhangshengqin.bwie.com.i;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import zhangshengqin.bwie.com.i.fragment.FiveFragment;
import zhangshengqin.bwie.com.i.fragment.FourFragment;
import zhangshengqin.bwie.com.i.fragment.OneFragment;
import zhangshengqin.bwie.com.i.fragment.ThreeFragment;
import zhangshengqin.bwie.com.i.fragment.TwoFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomTabBar.init(getSupportFragmentManager())
//                .setImgSize(50,50)
//                .setFontSize(8)
//                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.mipmap.ic_launcher, OneFragment.class)
                .addTabItem("想法",R.mipmap.ic_launcher, TwoFragment.class)
                .addTabItem("市场",R.mipmap.ic_launcher, ThreeFragment.class)
                .addTabItem("通知",R.mipmap.ic_launcher, FourFragment.class)
                .addTabItem("更多",R.mipmap.ic_launcher, FiveFragment.class)
                .isShowDivider(false);

    }
}
