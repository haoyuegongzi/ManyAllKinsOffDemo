package bonc.demopractice_allkinsoff.popup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PopupWindowActivity extends AppCompatActivity {


    @BindView(R.id.view)
    View mView;
    @BindView(R.id.tvShowPopupDown)
    TextView mTvShowPopupDown;
    @BindView(R.id.tvShowPopupLeft)
    TextView mTvShowPopupLeft;
    @BindView(R.id.tvShowPopupRight)
    TextView mTvShowPopupRight;
    @BindView(R.id.tvShowPopupUp)
    TextView mTvShowPopupUp;
//    @BindView(R.id.rlParent)
//    RelativeLayout mRlParent;

    private TestPopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        ButterKnife.bind(this);
        mPopupWindow = new TestPopupWindow(this);
    }

    @OnClick({R.id.tvShowPopupDown, R.id.tvShowPopupLeft, R.id.tvShowPopupRight, R.id.tvShowPopupUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvShowPopupDown:
//                if (mPopupWindow.isShowing()) {
//                    mPopupWindow.dismiss();
//                } else {
//                    mPopupWindow.showAsDropDown(mTvShowPopupDown);
//                    mPopupWindow.showAsDropDown(mTvShowPopupDown, 0, -50);
//                    mPopupWindow.showAtLocation(mTvShowPopupDown, Gravity.CENTER_HORIZONTAL, 0, 100);
//                }
                break;
            case R.id.tvShowPopupLeft:
//                if (mPopupWindow.isShowing()) {
//                    mPopupWindow.dismiss();
//                } else {
//                    mPopupWindow.showAtLocation(mTvShowPopupLeft, Gravity.LEFT, 100, 0);
//                }
                break;
            case R.id.tvShowPopupRight:
                if (mPopupWindow.isShowing()) {
                    mPopupWindow.dismiss();
                } else {
                    mPopupWindow.showAtLocation(mTvShowPopupRight, Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK, 0, 80);
                }
                break;
            case R.id.tvShowPopupUp:
//                if (mPopupWindow.isShowing()) {
//                    mPopupWindow.dismiss();
//                } else {
//                    mPopupWindow.showAtLocation(mTvShowPopupUp, Gravity.TOP, 0, 0);
//                }
                break;
        }
    }
}
