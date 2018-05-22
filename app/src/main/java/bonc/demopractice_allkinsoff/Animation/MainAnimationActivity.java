package bonc.demopractice_allkinsoff.Animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.animaote_xml.AnimateXMLActivity;
import bonc.demopractice_allkinsoff.layout_change.LayoutChangeActivity;
import bonc.demopractice_allkinsoff.objectAnimator.ObjectAnimatorActivity;
import bonc.demopractice_allkinsoff.property.AnimatorSetActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btScale)
    Button mBtScale;
    @BindView(R.id.btInterpolator)
    Button mBtInterpolator;
    @BindView(R.id.btValueAnimator)
    Button mBtValueAnimator;
    @BindView(R.id.btSeniorAnimator)
    Button mBtSeniorAnimator;
    @BindView(R.id.btObjectAnimator)
    Button mBtObjectAnimator;
    @BindView(R.id.btPropertyValues)
    Button mBtPropertyValues;
    @BindView(R.id.btAnimatorSet)
    Button mBtAnimatorSet;
    @BindView(R.id.btAnimateXML)
    Button mBtAnimateXML;
    @BindView(R.id.activity_main)
    LinearLayout mActivityMain;
    @BindView(R.id.btLayoutChange)
    Button mBtLayoutChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main_animation);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btScale, R.id.btInterpolator, R.id.btValueAnimator, R.id.btSeniorAnimator,
            R.id.btObjectAnimator, R.id.btPropertyValues, R.id.btAnimatorSet, R.id.btAnimateXML,
            R.id.btLayoutChange})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btScale:
                startActivity(new Intent(this, AnimationActivity.class));
                break;
            case R.id.btInterpolator:
                startActivity(new Intent(this, InterpolatorActivity.class));
                break;
            case R.id.btValueAnimator:
                startActivity(new Intent(this, ValueAnimatorActivity.class));
                break;
            case R.id.btSeniorAnimator:
                startActivity(new Intent(this, SeniorAnimatorActivity.class));
                break;
            case R.id.btObjectAnimator:
                startActivity(new Intent(this, ObjectAnimatorActivity.class));
                break;
            case R.id.btPropertyValues:
                startActivity(new Intent(this, AnimatorSetActivity.class));
                break;
            case R.id.btAnimatorSet:
                startActivity(new Intent(this, AnimateXMLActivity.class));
                break;
            case R.id.btAnimateXML:
                startActivity(new Intent(this, AnimateXMLActivity.class));
                break;
            case R.id.btLayoutChange:
                startActivity(new Intent(this, LayoutChangeActivity.class));
                break;
        }
    }
}
