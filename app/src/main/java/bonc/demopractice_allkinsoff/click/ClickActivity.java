package bonc.demopractice_allkinsoff.click;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClickActivity extends AppCompatActivity implements View.OnTouchListener{

    @BindView(R.id.tvSimpleClick)
    TextView mTvSimpleClick;
    @BindView(R.id.tvSimpleResult)
    TextView mTvSimpleResult;
    @BindView(R.id.tvDoubleClick)
    TextView mTvDoubleClick;
    @BindView(R.id.tvDoubleResult)
    TextView mTvDoubleResult;
    @BindView(R.id.tvLongClick)
    TextView mTvLongClick;
    @BindView(R.id.tvLongResult)
    TextView mTvLongResult;
    @BindView(R.id.tvHtml)
    TextView mTvHtml;


    private long TIME_DOWN = 0;
    private long TIME_MOVE = 0;
    private long TIME_UP = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        ButterKnife.bind(this);
        setTvHtml();
    }

    public void setTvHtml(){
        String text = "我的URL：http://www.sina.com";
        text += "\n 我的E-mail：chen126jie@163.com";
        mTvHtml.setText(text);
        mTvHtml.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @OnClick({R.id.tvSimpleClick, R.id.tvDoubleClick, R.id.tvLongClick})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSimpleClick:

                break;
            case R.id.tvDoubleClick:

                break;
            case R.id.tvLongClick:
                if(TIME_UP - TIME_DOWN > 1000){
                    Toast.makeText(this, "长按了tvLongClick按钮", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            TIME_DOWN = System.currentTimeMillis();
        }
        if(event.getAction() == MotionEvent.ACTION_UP){
            TIME_UP = System.currentTimeMillis();
        }
        return false;
    }
}
