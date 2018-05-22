package bonc.demopractice_allkinsoff.scroll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SCrollActivity extends AppCompatActivity {

    @BindView(R.id.tvScroll)
    TextView mTvScroll;
    @BindView(R.id.btScroll)
    Button mBtScroll;
    @BindView(R.id.btScrollTo)
    Button mBtScrollTo;
    @BindView(R.id.btScrollReset)
    Button mBtScrollReset;

    int tvX, tvY;
    @BindView(R.id.rlParent)
    RelativeLayout mRlParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        ButterKnife.bind(this);
        tvX = mTvScroll.getScrollX();
        tvY = mTvScroll.getScrollY();

    }

    @OnClick({R.id.btScroll, R.id.btScrollTo, R.id.btScrollReset})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btScroll:
                mTvScroll.scrollBy(100, 100);
                break;
            case R.id.btScrollTo:
                mTvScroll.scrollTo(100,60);
                break;
            case R.id.btScrollReset:
                mTvScroll.setGravity(-100);//R.id.rlParent
                break;
        }
    }
}
