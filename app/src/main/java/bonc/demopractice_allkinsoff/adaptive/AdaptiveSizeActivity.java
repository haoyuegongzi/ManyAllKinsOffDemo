package bonc.demopractice_allkinsoff.adaptive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AdaptiveSizeActivity extends AppCompatActivity {
    @BindView(R.id.asTextView01)
    AdjustSpaceTextView mAsTextView01;
    @BindView(R.id.asTextView02)
    AdjustSpaceTextView mAsTextView02;
    @BindView(R.id.asTextView03)
    AdjustSpaceTextView mAsTextView03;
    @BindView(R.id.asTextView04)
    AdjustSpaceTextView mAsTextView04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaptive_size);
        ButterKnife.bind(this);

        mAsTextView01.setText("剑九·轮回：八式往复入轮回。");
        mAsTextView02.setText("剑十·天葬：意为“自生而灭是为天葬。”");
        mAsTextView03.setText("剑十一·涅槃：意为“极而复始，不生不灭是为涅槃”。");
        mAsTextView04.setText("剑十二：招式名至今未知，是乃纯粹的剑意，超越人力之招");
    }
}
