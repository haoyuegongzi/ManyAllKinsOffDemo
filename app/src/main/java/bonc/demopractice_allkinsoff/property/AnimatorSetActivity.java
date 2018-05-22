package bonc.demopractice_allkinsoff.property;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorSetActivity extends AppCompatActivity {
    AnimatorSet animatorSet;


    @BindView(R.id.btAnimatorSetStart)
    Button mBtAnimatorSetStart;
    @BindView(R.id.btAnimatorSetCancel)
    Button mBtAnimatorSetCancel;
    @BindView(R.id.tvAnimator01)
    TextView mTvAnimator01;
    @BindView(R.id.tvAnimator02)
    TextView mTvAnimator02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);
        ButterKnife.bind(this);
    }

    private void objAnimatorSequentially(){
        ObjectAnimator backGround01 = ObjectAnimator.ofInt(mTvAnimator01, "BackgroundColor", 0xffff0000, 0xff00ff00, 0xff0000ff);
        backGround01.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator backGround02 = ObjectAnimator.ofInt(mTvAnimator02, "BackgroundColor", 0xff0000ff, 0xffff0000, 0xff00ff00);
        backGround02.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator translationY01 = ObjectAnimator.ofFloat(mTvAnimator01, "translationY", 150, 280, 500,0);
        translationY01.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator translationY02 = ObjectAnimator.ofFloat(mTvAnimator02, "translationY", 200, 320, 550,0);
        translationY02.setRepeatCount(ValueAnimator.INFINITE);
        animatorSet = new AnimatorSet();
//        animatorSet.playSequentially(translationY02, backGround01, translationY01, backGround02);
        animatorSet.playTogether(translationY02, backGround02, backGround01, translationY01);
        animatorSet.setDuration(2000);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.start();
    }

    @OnClick({R.id.btAnimatorSetStart, R.id.btAnimatorSetCancel, R.id.tvAnimator01, R.id.tvAnimator02})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btAnimatorSetStart:
                objAnimatorSequentially();
                break;
            case R.id.btAnimatorSetCancel:
                if(animatorSet != null){
                    animatorSet.cancel();
                }
                break;
            case R.id.tvAnimator01:
                objAnimatorBuilder();
                break;
            case R.id.tvAnimator02:
                if(mAnimatorset != null){
                    mAnimatorset.cancel();
                }
                break;
        }
    }

    AnimatorSet mAnimatorset;
    private void objAnimatorBuilder(){
        ObjectAnimator backGround01 = ObjectAnimator.ofInt(mTvAnimator01, "BackgroundColor", 0xffff0000, 0xff00ff00, 0xff0000ff);
        backGround01.setRepeatCount(1);
        ObjectAnimator backGround02 = ObjectAnimator.ofInt(mTvAnimator02, "BackgroundColor", 0xff0000ff, 0xffff0000, 0xff00ff00);
        backGround02.setRepeatCount(1);
        ObjectAnimator translationY01 = ObjectAnimator.ofFloat(mTvAnimator01, "translationY", 150, 280, 500,0);
        translationY01.setRepeatCount(1);
        ObjectAnimator translationY02 = ObjectAnimator.ofFloat(mTvAnimator02, "translationY", 200, 320, 550,0);
        translationY02.setRepeatCount(1);//ValueAnimator.INFINITE

        mAnimatorset = new AnimatorSet();
//        AnimatorSet.Builder mBuilder0 = mAnimatorset.play(backGround01).with(translationY01).after(backGround02).before(translationY02);
        AnimatorSet.Builder mBuilder1 = mAnimatorset.play(backGround01);
        mBuilder1.with(translationY01);
        mBuilder1.after(backGround02);//after括号里面的动画先执行。
        mBuilder1.before(translationY02);
//        mBuilder1.with(translationY01).after(backGround02).before(translationY02);//等价于前面3行
        mAnimatorset.setDuration(3000);
        mAnimatorset.setTarget(mTvAnimator02);
        mAnimatorset.start();
//        mAnimatorset.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//
//            }
//        });
    }
}
