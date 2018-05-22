package bonc.demopractice_allkinsoff.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScrollerActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.tv_02)
    TextView mTv02;
    @BindView(R.id.tv_03)
    TextView mTv03;
    @BindView(R.id.scrollerLayout)
    ScrollerLayout mScrollerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller);
        ButterKnife.bind(this);

        setTitle("坐标体系实战案例");

    }

    @OnClick(R.id.btn)
    public void onClick() {
        Toast.makeText(ScrollerActivity.this, "click button", Toast.LENGTH_SHORT).show();
    }
}
