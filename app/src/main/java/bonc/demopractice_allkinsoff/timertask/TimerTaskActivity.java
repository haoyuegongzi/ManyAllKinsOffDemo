package bonc.demopractice_allkinsoff.timertask;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class TimerTaskActivity extends BaseActivity {

    @BindView(R.id.tvTimerTask)
    TextView mTvTimerTask;
    @BindView(R.id.btTimerTask)
    Button mBtTimerTask;

    Timer timer;
    @BindView(R.id.btTimerCancel)
    Button mBtTimerCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_task);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        timer = new Timer();
        timer.schedule(task, 500, 1000);
    }

    public void onEventMainThread(EventMsg msg) {
        mTvTimerTask.setText(msg.Message);
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss");
            Log.i("TAG", "run: 该run方法所在的线程： " + Thread.currentThread().getName() + "\n" +
                    "当前的系统时间为：" + simpleDateFormat.format(new Date()));
            EventBus.getDefault().post(new EventMsg("run: 该run方法所在的线程： " + Thread.currentThread().getName() + "\n" +
                    "当前的系统时间为：" + simpleDateFormat.format(new Date())));
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        timer.cancel();
    }

    @OnClick({R.id.btTimerTask, R.id.btTimerCancel})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btTimerTask:
                Log.i("TAG", "onClick: ReStart————TimerTask");
//                timer.notify();
                timer.schedule(task, 500, 1000);
                break;
            case R.id.btTimerCancel:
                Log.i("TAG", "timer进入wait状态");
                try{
//                    timer.wait();
                }catch (Exception e){
                    e.printStackTrace();
                    Log.i("TAG", "timer进入wait状态出现异常：Exception ===" + e);
                }
                break;
        }
    }

//    @Override
//    public void printLog() {
//        Log.i("TAG", "TimerTaskActivity: 测试继承中的方法执行情况 :TimerTaskActivity");
//        super.printLog();
//    }
}
