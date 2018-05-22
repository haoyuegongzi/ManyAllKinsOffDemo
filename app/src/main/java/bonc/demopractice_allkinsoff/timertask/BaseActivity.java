package bonc.demopractice_allkinsoff.timertask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);
    }

    public void printLog(){
        Log.i("TAG", "printLog: 测试继承中的方法执行情况");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "onDestroy: 测试继承中的方法执行情况 :onDestroy");
        printLog();
    }
}
