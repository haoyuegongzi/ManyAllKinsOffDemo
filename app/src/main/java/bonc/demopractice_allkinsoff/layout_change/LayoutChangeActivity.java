package bonc.demopractice_allkinsoff.layout_change;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static bonc.demopractice_allkinsoff.R.id.layoutTransitionGroup;

public class LayoutChangeActivity extends AppCompatActivity {

    @BindView(R.id.btAdd)
    Button mBtAdd;
    @BindView(R.id.btRemove)
    Button mBtRemove;
    @BindView(layoutTransitionGroup)
    LinearLayout mLayoutTransitionGroup;

    private LayoutTransition mLayoutTransition;
    private ObjectAnimator mAnimatorIn;
    private ObjectAnimator mAnimatorOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_change);
        ButterKnife.bind(this);
        editLayoutAnimation();

    }

    @OnClick({R.id.btAdd, R.id.btRemove, layoutTransitionGroup})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btAdd:
                addButtonView();
                break;
            case R.id.btRemove:
                removeButtonView();
                break;
            case layoutTransitionGroup:

                break;
        }
    }

    private void addButtonView(){
        Button button = new Button(this);
        button.setAllCaps(false);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(320,100);
        button.setLayoutParams(params);
        mLayoutTransitionGroup.addView(button,0);
        int count = mLayoutTransitionGroup.getChildCount();
        button.setText("Button" + count);
        Log.i("TAG", "addButtonView: count==" + count);
    }

    private void removeButtonView(){
        int count = mLayoutTransitionGroup.getChildCount();
        Log.i("TAG", "removeButtonView: count==" + count);
        if(count > 0){
            mLayoutTransitionGroup.removeViewAt(0);
            count--;
        }
    }

    private void editLayoutAnimation(){
        mLayoutTransition = new LayoutTransition();
        mAnimatorIn = ObjectAnimator.ofFloat(null, "rotationX", 0f, 360f, 0f);
        mAnimatorIn.setDuration(2000);
        mLayoutTransition.setAnimator(LayoutTransition.APPEARING, mAnimatorIn);

        mAnimatorOut = ObjectAnimator.ofFloat(null, "rotation", 0f, 180f, 0f);
        mLayoutTransition.setAnimator(LayoutTransition.DISAPPEARING, mAnimatorOut);

        mLayoutTransitionGroup.setLayoutTransition(mLayoutTransition);

//        mLayoutTransition = new LayoutTransition();
//        //入场动画:view在这个容器中消失时触发的动画
//        ObjectAnimator animIn = ObjectAnimator.ofFloat(null, "rotationY", 0f, 360f,0f);
//        mLayoutTransition.setAnimator(LayoutTransition.APPEARING, animIn);
//
//        //出场动画:view显示时的动画
//        ObjectAnimator animOut = ObjectAnimator.ofFloat(null, "rotation", 0f, 90f, 0f);
//        mLayoutTransition.setAnimator(LayoutTransition.DISAPPEARING, animOut);
//
//        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left", 0, 100, 0);
//        PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top", 1, 1);
//        Animator changeAppearAnimator = ObjectAnimator.ofPropertyValuesHolder(mLayoutTransitionGroup, pvhLeft, pvhTop);
//        mLayoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, changeAppearAnimator);
//
//        mLayoutTransitionGroup.setLayoutTransition(mLayoutTransition);
    }
}
