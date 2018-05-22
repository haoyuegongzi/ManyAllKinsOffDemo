package bonc.demopractice_allkinsoff.application;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by chen1 on 2017/9/20.
 */

public class MessageUtils {

    //Toast吐司通知在Toast.LENGTH_SHORT的基础上进行延长
    public static void showToast(Context mcontext, String str) {
        final Toast toast = Toast.makeText(mcontext, str, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 100);
        new Thread(new Runnable() {
            int tempSecond = 0;
            @Override
            public void run() {
                while (tempSecond < 2) {
                    toast.show();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tempSecond++;
                }
                toast.cancel();
            }
        }).start();
    }
}
