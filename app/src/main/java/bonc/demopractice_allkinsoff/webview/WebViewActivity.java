package bonc.demopractice_allkinsoff.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.wvTest)
    WebView mWvTest;
    @BindView(R.id.pbBar)
    ProgressBar mPbBar;
    @BindView(R.id.tvWeb)
    TextView mTvWeb;

    private String url = "http://www.ifeng.com/";
//    private String downUrl = "http://www.baidu.com";
    private String downNam = "百度客户端";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        this.getSupportActionBar().hide();
        ButterKnife.bind(this);
        WebViewUtils.getInstance().setParms(this, downNam);
        WebViewUtils.getInstance().setWebView(mWvTest, url, mTvWeb, mPbBar);
    }

    @OnClick(R.id.button)
    public void onClick() {
        Toast.makeText(getApplicationContext(), "系好安全带!", Toast.LENGTH_SHORT).show();
    }
}
