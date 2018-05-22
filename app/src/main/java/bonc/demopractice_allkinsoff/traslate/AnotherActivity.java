package bonc.demopractice_allkinsoff.traslate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnotherActivity extends AppCompatActivity {
    private TrasApplication trasAppGet;

    private String name;
    private String city;

    @BindView(R.id.tvGetData)
    TextView mTvGetData;
    @BindView(R.id.btGetData)
    Button mBtGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        ButterKnife.bind(this);
        trasAppGet = (TrasApplication) getApplication();
    }

    @OnClick(R.id.btGetData)
    public void onClick() {
        name = trasAppGet.getName();
        city = trasAppGet.getCity();
        mTvGetData.setText("获取到的数据是： name ===" + name + "————>>> city ===" + city);
    }
}
