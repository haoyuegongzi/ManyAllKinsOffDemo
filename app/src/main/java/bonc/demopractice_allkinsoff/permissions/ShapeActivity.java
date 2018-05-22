package bonc.demopractice_allkinsoff.permissions;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import bonc.demopractice_allkinsoff.R;
import butterknife.ButterKnife;

public class ShapeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//没actionbar
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//取消横屏
        //输入法弹出的时候不顶起布局
        //如果我们不设置"adjust..."的属性，对于没有滚动控件的布局来说，采用的是adjustPan方式，
        // 而对于有滚动控件的布局，则是采用的adjustResize方式。
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN |
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.activity_shape);
        ButterKnife.bind(this);

    }

/**
 * Picasso.with(this).load(url).placeholder(R.drawable.head_default)
 * .into((ImageView) superTextView.getView(SuperTextView.leftImageViewId));
 */

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
