package bonc.demopractice_allkinsoff.property;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PropertyValuesHolderActivity extends AppCompatActivity {

    @BindView(R.id.btStartAnim)
    Button mBtStartAnim;
    @BindView(R.id.flAnimator)
    ObjTextView mFlAnimator;
    @BindView(R.id.btCancelAnim)
    Button mBtCancelAnim;
    @BindView(R.id.btOfObject)
    Button mBtOfObject;

    ObjectAnimator objectAnimator;
    ObjectAnimator objectAnimator01;
    @BindView(R.id.ivKeyframe)
    ImageView mIvKeyframe;

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_values_holder);
        ButterKnife.bind(this);
    }

    private void doPropertyAnimator() {
        PropertyValuesHolder holder = PropertyValuesHolder.ofFloat("Rotation",
                60f, -60f, 50f, -50f, -40f, 40f, 30f, -30f, 20f, -20f, 10f, -10f, 0f);
        PropertyValuesHolder holderColor = PropertyValuesHolder.ofInt("BackgroundColor",
                0xfffffff0, 0xffff00ff, 0xffffff00, 0xffffff0f);
        objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mFlAnimator, holder, holderColor);
//        objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mFlAnimator, holder);
        objectAnimator.setDuration(500);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.start();
    }

    private void doPropertyObjAnimator() {
        PropertyValuesHolder holderText = PropertyValuesHolder.ofObject("CharText",
                new CharEvaluator(), new Character('A'), new Character('Z'));
        PropertyValuesHolder holder = PropertyValuesHolder.ofFloat("Rotation",
                60f, -60f, 50f, -50f, -40f, 40f, 30f, -30f, 20f, -20f, 10f, -10f, 0f);
        PropertyValuesHolder holderColor = PropertyValuesHolder.ofInt("BackgroundColor",
                0xfffffff0, 0xffff00ff, 0xffffff00, 0xffffff0f);
        objectAnimator01 = ObjectAnimator.ofPropertyValuesHolder(mFlAnimator, holderText, holder, holderColor);
        objectAnimator01.setDuration(2000);
        objectAnimator01.setInterpolator(new LinearInterpolator());
        objectAnimator01.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator01.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator01.start();

    }
    Animator animator;
    PropertyValuesHolder frameHolder;
    private void doOfFloatAnim(){
        Keyframe frame0 = Keyframe.ofFloat(0f, 0);
        Keyframe frame1 = Keyframe.ofFloat(0.1f, -20f);
        Keyframe frame2 = Keyframe.ofFloat(0.2f, 20f);
        Keyframe frame3 = Keyframe.ofFloat(0.3f, -20f);
        Keyframe frame4 = Keyframe.ofFloat(0.4f, 20f);
        Keyframe frame5 = Keyframe.ofFloat(0.5f, -20f);
        Keyframe frame6 = Keyframe.ofFloat(0.6f, 20f);
        Keyframe frame7 = Keyframe.ofFloat(0.7f, -20f);
        Keyframe frame8 = Keyframe.ofFloat(0.8f, 20f);
        Keyframe frame9 = Keyframe.ofFloat(0.9f, -20f);
        Keyframe frame10 = Keyframe.ofFloat(1, 0);
        frameHolder = PropertyValuesHolder.ofKeyframe("rotation",  frame0,
                frame1, frame2, frame3, frame4, frame5,
                frame6, frame7, frame8, frame9, frame10);
        frameHolder.setEvaluator(new CharEvaluator());
        animator = ObjectAnimator.ofPropertyValuesHolder(mIvKeyframe, frameHolder);
        animator.setDuration(500);

        animator.setInterpolator(new LinearInterpolator());
        animator.start();
    }

    PropertyValuesHolder frameHolder02;
    ObjectAnimator animator02;
    private void doKeyframeofObject(){
        Keyframe frame0 = Keyframe.ofObject(0f, new Character('A'));
        Keyframe frame1 = Keyframe.ofObject(0.1f, new Character('L'));
        Keyframe frame2 = Keyframe.ofObject(1,new Character('Z'));

        frameHolder02 = PropertyValuesHolder.ofKeyframe("CharText",frame0,frame1,frame2);
        frameHolder02.setEvaluator(new CharEvaluator());
        animator02 = ObjectAnimator.ofPropertyValuesHolder(mFlAnimator, frameHolder);
        animator02.setDuration(3000);
        animator02.start();

    }

    @OnClick({R.id.btStartAnim, R.id.btCancelAnim, R.id.btOfObject, R.id.ivKeyframe, R.id.flAnimator})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btStartAnim:
                doPropertyAnimator();
                break;
            case R.id.btCancelAnim:
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
                if (objectAnimator01 != null) {
                    objectAnimator01.cancel();
                }
                if (animator02 != null) {
                    animator02.cancel();
                }
                break;
            case R.id.btOfObject:
                doPropertyObjAnimator();
                break;
            case R.id.flAnimator://
                doKeyframeofObject();
                break;
            case R.id.ivKeyframe:
                flag = !flag;
                if(flag){
                    doOfFloatAnim();
                }else {
                    if(animator != null){
                        animator.cancel();
                    }
                }
                break;
        }
    }
}
