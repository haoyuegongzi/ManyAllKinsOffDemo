package bonc.demopractice_allkinsoff.objectAnimator;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ObjectAnimatorActivity extends AppCompatActivity {

    @BindView(R.id.btValueAnimator)
    Button mBtValueAnimator;
    @BindView(R.id.btValueAnimatorCancel)
    Button mBtValueAnimatorCancel;
    @BindView(R.id.flAnimator)
    MyPointView mFlAnimator;


    ObjectAnimator mObjectAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btValueAnimator, R.id.btValueAnimatorCancel, R.id.btObjectAnimator,
              R.id.btObjectAnimatorScale, R.id.btObjectAnimatorRotation, R.id.btObjectAnimatorTranslation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btValueAnimator:
                mFlAnimator.getAnimator();
                break;
            case R.id.btValueAnimatorCancel:
                mFlAnimator.valueAnimator.cancel();
                break;
            case R.id.btObjectAnimator:
                chengedView("alpha",1f, 0.25f, 1f);
                break;
            case R.id.btObjectAnimatorScale:
                chengedView("scaleY",0.75f, 0.15f, 1.25f);
                break;
            case R.id.btObjectAnimatorRotation:
                chengedView("rotation",0f, 45f, 180f);
                break;
            case R.id.btObjectAnimatorTranslation:
                chengedView("translationX",100f, 45f, 160f);
                break;
        }
    }

    private void chengedView(String propertyName, float... values) {
        mObjectAnimator = ObjectAnimator.ofFloat(mFlAnimator, propertyName, values);
        mObjectAnimator.setDuration(3500);
        mObjectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mObjectAnimator.setInterpolator(new LinearOutSlowInInterpolator());
        mObjectAnimator.start();

        ObjectAnimator animator = ObjectAnimator.ofInt(mFlAnimator, "BackgroundColor",
                0xffff00ff, 0xffffff00, 0xffff00ff);
        animator.setDuration(3500);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
    }
}
