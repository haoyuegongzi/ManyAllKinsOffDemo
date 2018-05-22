package bonc.demopractice_allkinsoff.viewpager.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.application.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoadFragmentActivity extends BaseActivity {

    @BindView(R.id.flFrgment)
    FrameLayout mFlFrgment;
    @BindView(R.id.ivFilms)
    ImageView mIvFilms;
    @BindView(R.id.tvFilms)
    TextView mTvFilms;
    @BindView(R.id.llFilms)
    LinearLayout mLlFilms;
    @BindView(R.id.ivHome)
    ImageView mIvHome;
    @BindView(R.id.tvHome)
    TextView mTvHome;
    @BindView(R.id.llHome)
    LinearLayout mLlHome;
    @BindView(R.id.ivNews)
    ImageView mIvNews;
    @BindView(R.id.tvNews)
    TextView mTvNews;
    @BindView(R.id.llNews)
    LinearLayout mLlNews;
    @BindView(R.id.ivWeather)
    ImageView mIvWeather;
    @BindView(R.id.tvWeather)
    TextView mTvWeather;
    @BindView(R.id.llWeather)
    LinearLayout mLlWeather;
    @BindView(R.id.llNavigation)
    LinearLayout mLlNavigation;

    private FragmentFilms mFilms;
    private FragmentHome mHome;
    private FragmentNews mNews;
    private FragmentWeather mWeather;

    private ImageView[] navigationImage;
    private TextView[] navigationText;

    private int[] navigationCheck;
    private int[] navigationNormal;

    private FragmentManager mManager;
    private FragmentTransaction mTransaction;
    private Bundle savedInstanceStateBundle;
    private String mFilmsTag = "mFilms";
    private String mHomeTag = "mHome";
    private String mNewsTag = "mNews";
    private String mWeatherTag = "mWeather";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_fragment);
        ButterKnife.bind(this);
        savedInstanceStateBundle = savedInstanceState;
        addViewParms();
        currentLoadNavigation();
        loadPostion(0);
        onClick(mLlFilms);
    }

    private void addViewParms(){
        navigationImage = new ImageView[]{mIvFilms, mIvHome, mIvNews, mIvWeather};
        navigationText  = new TextView []{mTvFilms, mTvHome, mTvNews, mTvWeather};

        navigationCheck = new int[]{R.drawable.films_check, R.drawable.home_check,
                                    R.drawable.news_check, R.drawable.weather_check};
        navigationNormal = new int[]{R.drawable.films_normal, R.drawable.home_normal,
                                    R.drawable.news_normal, R.drawable.weather_normal};

        mFilms = new FragmentFilms();
        mHome = new FragmentHome();
        mNews = new  FragmentNews();
        mWeather = new FragmentWeather();
        

    }

    private void currentLoadNavigation(){
        //先将导航条的图标和文字设置为灰色
        for (int i = 0; i < navigationImage.length; i++) {
            navigationImage[i].setImageResource(navigationNormal[i]);
            navigationText[i].setTextColor(Color.parseColor("#8a8a8a"));//灰色
        }
    }

    private void loadPostion(int position){
        navigationImage[position].setImageResource(navigationCheck[position]);
        navigationText[position].setTextColor(Color.parseColor("#ff0000"));//红色
    }

    @OnClick({R.id.llFilms, R.id.llHome, R.id.llNews, R.id.llWeather})
    public void onClick(View view) {
        currentLoadNavigation();
        mManager = getSupportFragmentManager();
        mTransaction = mManager.beginTransaction();
        Fragment mFilmsFragment = mManager.findFragmentByTag(mFilmsTag);
        Fragment mHomeFragment = mManager.findFragmentByTag(mHomeTag);
        Fragment mNewsFragment = mManager.findFragmentByTag(mNewsTag);
        Fragment mWeatherFragment = mManager.findFragmentByTag(mWeatherTag);
        if(mFilmsFragment != null){
            mTransaction.hide(mFilmsFragment);
        }
        if(mHomeFragment != null){
            mTransaction.hide(mHomeFragment);
        }
        if(mNewsFragment != null){
            mTransaction.hide(mNewsFragment);
        }
        if(mWeatherFragment != null){
            mTransaction.hide(mWeatherFragment);
        }
        switch (view.getId()) {
            case R.id.llFilms:
                loadPostion(0);
                if(mFilmsFragment == null){
                    mTransaction.add(R.id.flFrgment, mFilms, mFilmsTag);
                }else {
                    mTransaction.show(mFilmsFragment);
                }
                break;
            case R.id.llHome:
                loadPostion(1);
                if(mHomeFragment == null){
                    mTransaction.add(R.id.flFrgment, mHome, mHomeTag);
                }else {
                    mTransaction.show(mHomeFragment);
                }
                break;
            case R.id.llNews:
                loadPostion(2);
                if(mNewsFragment == null){
                    mTransaction.add(R.id.flFrgment, mNews, mNewsTag);
                }else {
                    mTransaction.show(mNewsFragment);
                }
                break;
            case R.id.llWeather:
                loadPostion(3);
                if(mWeatherFragment == null){
                    mTransaction.add(R.id.flFrgment, mWeather, mWeatherTag);
                }else {
                    mTransaction.show(mWeatherFragment);
                }
                break;
            default:
                loadPostion(0);
                if(mFilmsFragment == null){
                    mTransaction.add(R.id.flFrgment, mFilms, mFilmsTag);
                }else {
                    mTransaction.show(mFilmsFragment);
                }
                break;
        }
        mTransaction.commit();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentLoadNavigation();
        loadPostion(0);
        Fragment mFilmsFragment = mManager.findFragmentByTag(mFilmsTag);
        Fragment mHomeFragment = mManager.findFragmentByTag(mHomeTag);
        Fragment mNewsFragment = mManager.findFragmentByTag(mNewsTag);
        Fragment mWeatherFragment = mManager.findFragmentByTag(mWeatherTag);
        if(mFilmsFragment != null){
//            mTransaction.hide(mFilmsFragment);
            mTransaction.show(mFilmsFragment);
        }
        if(mHomeFragment != null){
            mTransaction.hide(mHomeFragment);
        }
        if(mNewsFragment != null){
            mTransaction.hide(mNewsFragment);
        }
        if(mWeatherFragment != null){
            mTransaction.hide(mWeatherFragment);
        }
        mTransaction.commit();
    }
}
