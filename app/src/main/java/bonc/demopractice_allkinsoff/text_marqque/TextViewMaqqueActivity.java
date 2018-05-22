package bonc.demopractice_allkinsoff.text_marqque;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TextViewMaqqueActivity extends AppCompatActivity {

    @BindView(R.id.tvMarqque)
    TextView mTvMarqque;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_maqque);
        ButterKnife.bind(this);

        String text = "美国不停地在世界各地搞事，迟早会被自己的罪孽反噬。。。。。。";
        mTvMarqque.setText(text);
    }
}
