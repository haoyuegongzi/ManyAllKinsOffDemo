package bonc.demopractice_allkinsoff.viewpagerfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bonc.demopractice_allkinsoff.R;

public class FragmentViewPagerActivity extends AppCompatActivity implements
                    View.OnClickListener, View.OnLongClickListener{

    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private TextView tvcontact, tvfriend, tvweixn, tvsetting;
    private ImageView ibcontact,  ibfriend,  ibweixin,ibsetting;
    private LinearLayout llcontact, llfriend,llweixin, llsetting;
    private TextView[] tvList;
    private ImageView[] ibList;
    //注意排列顺序
    private int ibBackPre[] = {R.drawable.tab_weixin_pressed, R.drawable.tab_find_frd_pressed,
                               R.drawable.tab_address_pressed, R.drawable.tab_settings_pressed};
    //注意排列顺序
    private int ibBackNor[] = {R.drawable.tab_weixin_normal, R.drawable.tab_find_frd_normal,
                               R.drawable.tab_address_normal, R.drawable.tab_settings_normal};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_fragmentviewpager);
        initView();
        setOnPageChange();
        setTabBtnolor(0);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        tvcontact = (TextView) findViewById(R.id.tvfcontact);
        tvfriend = (TextView) findViewById(R.id.tvfriend);
        tvweixn = (TextView) findViewById(R.id.tvweixn);
        tvsetting = (TextView) findViewById(R.id.tvsetting);
        //注意排列顺序
        tvList = new TextView[]{tvweixn,tvfriend,tvcontact,tvsetting};

        ibcontact = (ImageView) findViewById(R.id.ibcontact);
        ibfriend = (ImageView) findViewById(R.id.ibfriend);
        ibweixin = (ImageView) findViewById(R.id.ibweixin);
        ibsetting = (ImageView) findViewById(R.id.ibsetting);
        //注意排列顺序
        ibList = new ImageView[]{ibweixin, ibfriend, ibcontact, ibsetting};

        llcontact = (LinearLayout) findViewById(R.id.llcontact);
        llfriend = (LinearLayout) findViewById(R.id.llfriend);
        llweixin = (LinearLayout) findViewById(R.id.llweixin);
        llsetting = (LinearLayout) findViewById(R.id.llsetting);

        llweixin.setOnClickListener(this);
        llfriend.setOnClickListener(this);
        llcontact.setOnClickListener(this);
        llsetting.setOnClickListener(this);

        MainTab01 tab01 = new MainTab01();
        mFragments.add(tab01);
        MainTab02 tab02 = new MainTab02();
        mFragments.add(tab02);
        MainTab03 tab03 = new MainTab03();
        mFragments.add(tab03);
        MainTab04 tab04 = new MainTab04();
        mFragments.add(tab04);
    }

    public void setOnPageChange(){
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mFragments.size();
            }
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }
        };

        mViewPager.setAdapter(mAdapter);
        tvweixn.setTextColor(Color.RED);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                resetTabBtn();
                setTabBtnolor(position);
            }
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }
            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    private void setTabBtnolor(int position) {
        for(int i = 0; i < (tvList.length); i++){
            if( i == position){
                tvList[i].setTextColor(Color.RED);
                ibList[i].setImageResource(ibBackPre[i]);
            } else{
                tvList[i].setTextColor(Color.WHITE);
                ibList[i].setImageResource(ibBackNor[i]);
            }
        }
        mViewPager.setCurrentItem(position);
    }

    protected void resetTabBtn() {
        for(int i = 0; i < tvList.length; i++){
            tvList[i].setTextColor(Color.WHITE);
            ibList[i].setImageResource(ibBackNor[i]);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llweixin:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.llfriend:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.llcontact:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.llsetting:
                mViewPager.setCurrentItem(3);
                break;
            default:
                mViewPager.setCurrentItem(0);
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.llweixin:
                Toast.makeText(FragmentViewPagerActivity.this, "点击了llweixin", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.llfriend:
                Toast.makeText(FragmentViewPagerActivity.this, "点击了llfriend", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.llcontact:
                Toast.makeText(FragmentViewPagerActivity.this, "点击了llcontact", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.llsetting:
                Toast.makeText(FragmentViewPagerActivity.this, "点击了llsetting", Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(FragmentViewPagerActivity.this, "点击了llweixin", Toast.LENGTH_SHORT).show();
                return false;
        }
    }
}
