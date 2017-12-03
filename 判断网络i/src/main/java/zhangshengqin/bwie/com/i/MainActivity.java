package zhangshengqin.bwie.com.i;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(isOnline()){

        }else {
            //弹出提示对话框
            showDialog();
        }

    }
    public boolean isOnline() {

        //得到一个连接管理者
        ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        //得到联网信息
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        //判断设备是否联网
        return (networkInfo != null && networkInfo.isConnected());
    }
    private void showDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("是否联网");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //跳转网络设置界面
                startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));


            }
        });
        builder.create().show();
    }

}
