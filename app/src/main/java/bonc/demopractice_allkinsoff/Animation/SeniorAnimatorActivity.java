package bonc.demopractice_allkinsoff.Animation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SeniorAnimatorActivity extends AppCompatActivity {

    @BindView(R.id.btValueAnimator)
    Button mBtValueAnimator;
    @BindView(R.id.btValueAnimatorCancel)
    Button mBtValueAnimatorCancel;
    @BindView(R.id.tvTestObject)
    TextView mTvTestObject;

    private ValueAnimator mValueAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_animator);
        ButterKnife.bind(this);
        mValueAnimator = ValueAnimator.ofObject(new MyCharsEvaluator(), new Character('A'), new Character('Z'));


    }

    private void getAnimator(){
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                char value = (char) valueAnimator.getAnimatedValue();
                mTvTestObject.setText("设置新的value值：" + value);
            }
        });
        mValueAnimator.setDuration(2000);
        mValueAnimator.setInterpolator(new AccelerateInterpolator());
        mValueAnimator.start();
    }



    @OnClick({R.id.btValueAnimator, R.id.btValueAnimatorCancel, R.id.tvTestObject})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btValueAnimator:
                getAnimator();
                break;
            case R.id.btValueAnimatorCancel:
                mValueAnimator.cancel();
                break;
            case R.id.tvTestObject:

                break;
        }
    }
}
