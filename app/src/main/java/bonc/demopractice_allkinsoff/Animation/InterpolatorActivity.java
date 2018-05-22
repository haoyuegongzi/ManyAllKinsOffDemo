package bonc.demopractice_allkinsoff.Animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import bonc.demopractice_allkinsoff.R;

public class InterpolatorActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivScale;

    private ScaleAnimation mScaleAnimation;
    private AlphaAnimation mAlphaAnimation;
    private RotateAnimation mRotateAnimation;
    private TranslateAnimation mTranslate;
    private AnimationSet mAnimationSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);
        init();
        getAnimation();
    }

    public void init() {
        ivScale = (ImageView) findViewById(R.id.ivScale);
        findViewById(R.id.btOvershootInter).setOnClickListener(this);
        findViewById(R.id.btLinearInterpolat).setOnClickListener(this);
        findViewById(R.id.btDecelInter).setOnClickListener(this);
        findViewById(R.id.btCycleInter).setOnClickListener(this);
        findViewById(R.id.btBounceInter).setOnClickListener(this);
    }

    private void getAnimation() {
        //float fromX, float toX, float fromY, float toY, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue
        mScaleAnimation = new ScaleAnimation(0f, 1.4f, 0f, 1.4f, 0, 0f, 1, 1f);
        mScaleAnimation.setDuration(1500);
        mScaleAnimation.setFillBefore(true);
        mScaleAnimation.setRepeatCount(1);
        mScaleAnimation.setRepeatMode(Animation.REVERSE);
        mScaleAnimation.setInterpolator(new BounceInterpolator());

        //float fromAlpha, float toAlpha
        mAlphaAnimation = new AlphaAnimation(0.8f, 0.2f);
        mAlphaAnimation.setDuration(1500);
        mAlphaAnimation.setRepeatCount(1);
        mAlphaAnimation.setRepeatMode(Animation.REVERSE);
        mAlphaAnimation.setFillBefore(true);

        //float fromDegrees, float toDegrees, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue
        mRotateAnimation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateAnimation.setDuration(1500);
        mRotateAnimation.setFillBefore(false);
        mRotateAnimation.setRepeatCount(1);
        mRotateAnimation.setRepeatMode(Animation.REVERSE);

        //int fromXType, float fromXValue, int toXType, float toXValue,
        //int fromYType, float fromYValue, int toYType, float toYValue
        mTranslate = new TranslateAnimation(Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 50f, Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 50f);
        mTranslate.setFillBefore(true);
        mTranslate.setRepeatCount(1);
        mTranslate.setDuration(1500);
        mTranslate.setRepeatMode(Animation.REVERSE);

        mAnimationSet = new AnimationSet(true);
        mAnimationSet.addAnimation(mScaleAnimation);
        mAnimationSet.addAnimation(mAlphaAnimation);
        mAnimationSet.addAnimation(mRotateAnimation);
        mAnimationSet.addAnimation(mTranslate);
        mAnimationSet.setDuration(1500);
        mAnimationSet.setRepeatMode(Animation.REVERSE);
        mAnimationSet.setRepeatCount(2);
        mAnimationSet.setFillBefore(true);
        mAnimationSet.setInterpolator(new DecelerateInterpolator());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btOvershootInter:
                ivScale.startAnimation(mScaleAnimation);
                break;
            case R.id.btLinearInterpolat:
                ivScale.startAnimation(mAlphaAnimation);
                break;
            case R.id.btDecelInter:
                ivScale.startAnimation(mRotateAnimation);
                break;
            case R.id.btCycleInter:
                ivScale.startAnimation(mTranslate);
                break;
            case R.id.btBounceInter:
                ivScale.startAnimation(mAnimationSet);
                break;
            default:
                break;
        }
    }
}
