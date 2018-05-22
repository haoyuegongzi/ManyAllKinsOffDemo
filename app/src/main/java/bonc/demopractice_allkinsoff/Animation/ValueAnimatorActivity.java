package bonc.demopractice_allkinsoff.Animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ValueAnimatorActivity extends AppCompatActivity {

    @BindView(R.id.btValueAnimator)
    Button mBtValueAnimator;
    @BindView(R.id.btStartAnim)
    Button mBtStartAnim;
    @BindView(R.id.tvTestObject)
    TextView mTvTestObject;
    @BindView(R.id.btValueAnimatorCancel)
    Button mBtValueAnimatorCancel;

    private TranslateAnimation mTranslateAnimation;
    private ValueAnimator valueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        ButterKnife.bind(this);
        //int fromXType, float fromXValue, int toXType, float toXValue,
        //int fromYType, float fromYValue, int toYType, float toYValue
        mTranslateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 400f,
                Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 800f);
        mTranslateAnimation.setRepeatCount(1);
        mTranslateAnimation.setDuration(1500);
        mTranslateAnimation.setFillAfter(true);
    }

    private void addAnimatorToTv() {
//        int mar = dip2px(this, 60f);
        valueAnimator = ValueAnimator.ofInt(0, 450);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int trasValue = (int) valueAnimator.getAnimatedValue();
                mTvTestObject.layout(trasValue, trasValue, trasValue + mTvTestObject.getWidth(), trasValue + mTvTestObject.getHeight());
            }
        });
        valueAnimator.setRepeatCount(0);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                Log.i("TAG", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Log.i("TAG", "onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                Log.i("TAG", "onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                Log.i("TAG", "onAnimationRepeat: " + valueAnimator.getRepeatCount());
            }
        });
        valueAnimator.setEvaluator(new MyEvaluator());//作用相当于设置Reverse
//        valueAnimator.setEvaluator(new IntEvaluator());
//        valueAnimator.setStartDelay(1500);
//        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.setInterpolator(new MyTimeInterpolator());//MyTimeInterpolator
        valueAnimator.start();
    }

    @OnClick({R.id.btStartAnim, R.id.tvTestObject, R.id.btValueAnimator, R.id.btValueAnimatorCancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btStartAnim:
                mTvTestObject.startAnimation(mTranslateAnimation);
                break;
            case R.id.tvTestObject:
                valueAnimator.removeAllUpdateListeners();
                valueAnimator.removeAllListeners();
                Toast.makeText(ValueAnimatorActivity.this, "试试那个位置有点击效果", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btValueAnimator:
                addAnimatorToTv();//启动动画
                break;
            case R.id.btValueAnimatorCancel:
                valueAnimator.cancel();
                break;

        }
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int PxToDp(Context context, int pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
