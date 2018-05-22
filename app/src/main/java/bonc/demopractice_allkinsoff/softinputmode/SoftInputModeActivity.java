package bonc.demopractice_allkinsoff.softinputmode;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;

import bonc.demopractice_allkinsoff.R;

import static bonc.demopractice_allkinsoff.R.id.btLogin;

/**
 * 本示例的作用：解决app弹出软件的时候，遮挡住了输入框的问题
 */
public class SoftInputModeActivity extends AppCompatActivity {
    private Button btLogin;
    private LinearLayout llLoginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_soft_input_mode);
        btLogin = (Button) findViewById(R.id.btLogin);
        llLoginView = (LinearLayout) findViewById(R.id.llLoginView );
        autoScrollView();
    }

    /**
     * @param root 最外层的View
     * @param scrollToView 不想被遮挡的View,会移动到这个Veiw的可见位置
     */
    private int scrollToPosition = 0;
    private void autoScrollView() {
        llLoginView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        computePosition(llLoginView, btLogin);
//                        Rect rect = new Rect();
//                        //获取root在窗体的可视区域
//                        llLoginView.getWindowVisibleDisplayFrame(rect);
//                        //获取root在窗体的不可视区域高度(被遮挡的高度)
//                        int rootInvisibleHeight = llLoginView.getRootView().getHeight() - rect.bottom;
//                        //若不可视区域高度大于150，则键盘显示
//                        if (rootInvisibleHeight > 150) {
//                            //获取scrollToView在窗体的坐标,location[0]为x坐标，location[1]为y坐标
//                            int[] location = new int[2];
//                            btLogin.getLocationInWindow(location);
//                            //计算root滚动高度，使scrollToView在可见区域的底部
//                            int scrollHeight = (location[1] + btLogin.getHeight()) - rect.bottom;
//                            //注意:scrollHeight是相对移动距离，而scrollToPosition是绝对移动距离
//                            scrollToPosition += scrollHeight;
//                        } else {//否则键盘隐藏
//                            scrollToPosition = 0;
//                        }
//                        llLoginView.scrollTo(0, scrollToPosition);
                    }
                });
    }

    private void computePosition(LinearLayout linearLayoutLoginView, Button buttonLogin){
        Rect rect = new Rect();
        //获取root在窗体的可视区域
        linearLayoutLoginView.getWindowVisibleDisplayFrame(rect);
        //获取root在窗体的不可视区域高度(被遮挡的高度)
        int rootInvisibleHeight = linearLayoutLoginView.getRootView().getHeight() - rect.bottom;
        //若不可视区域高度大于150，则键盘显示
        if (rootInvisibleHeight > 150) {
            //获取scrollToView在窗体的坐标,location[0]为x坐标，location[1]为y坐标
            int[] location = new int[2];
            buttonLogin.getLocationInWindow(location);
            //计算root滚动高度，使scrollToView在可见区域的底部
            int scrollHeight = (location[1] + buttonLogin.getHeight()) - rect.bottom;
            //注意:scrollHeight是相对移动距离，而scrollToPosition是绝对移动距离
            scrollToPosition += scrollHeight;
        } else {//否则键盘隐藏
            scrollToPosition = 0;
        }
        linearLayoutLoginView.scrollTo(0, scrollToPosition);
    }
}
