package bonc.demopractice_allkinsoff.Animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivScale;
    private Animation mAnimationScale;
    private Animation mAnimationAlpha;
    private Animation mAnimationRotate;
    private Animation mAnimationTranslate;
    private Animation mAnimationSet;

    @BindView(R.id.tvScale)
    TextView mTvScale;
    @BindView(R.id.tvAlpha)
    TextView mTvAlpha;
    @BindView(R.id.tvRotate)
    TextView mTvRotate;
    @BindView(R.id.tvTranslate)
    TextView mTvTranslate;
    @BindView(R.id.tvSet)
    TextView mTvSet;
    @BindView(R.id.ivScale)
    ImageView mIvScale;
    @BindView(R.id.activity_scale)
    LinearLayout mActivityScale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        this.getSupportActionBar().hide();
        ButterKnife.bind(this);
        initController();
    }

    private void initController() {
        ivScale = (ImageView) findViewById(R.id.ivScale);
        mAnimationScale = AnimationUtils.loadAnimation(this, R.anim.scale);//缩放
        mAnimationAlpha = AnimationUtils.loadAnimation(this, R.anim.myalpha);//透明度
        mAnimationRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);//旋转
        mAnimationTranslate = AnimationUtils.loadAnimation(this, R.anim.translate);//移动
        mAnimationSet = AnimationUtils.loadAnimation(this, R.anim.set_animation);//综合

        findViewById(R.id.tvScale).setOnClickListener(this);
        findViewById(R.id.tvAlpha).setOnClickListener(this);
        findViewById(R.id.tvRotate).setOnClickListener(this);
        findViewById(R.id.tvTranslate).setOnClickListener(this);
        findViewById(R.id.tvSet).setOnClickListener(this);
        /**
         *  android:interpolator="@android:anim/accelerate_decelerate_interpolator"
         *  android:interpolator="@android:anim/accelerate_decelerate_interpolator"
         */
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvScale:
                ivScale.startAnimation(mAnimationScale);
                break;
            case R.id.tvAlpha:
                ivScale.startAnimation(mAnimationAlpha);
                break;
            case R.id.tvRotate:
                ivScale.startAnimation(mAnimationRotate);
                break;
            case R.id.tvTranslate:
                ivScale.startAnimation(mAnimationTranslate);
                break;
            case R.id.tvSet:
                ivScale.startAnimation(mAnimationSet);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
}
