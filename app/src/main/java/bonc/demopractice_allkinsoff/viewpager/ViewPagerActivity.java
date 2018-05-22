package bonc.demopractice_allkinsoff.viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

public class ViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.vpSeries)
    ViewPager mVpSeries;

    private LoopPagerAdapetr mPagerAdapetr;
    private List<View> mViews;
    private List<Integer> listPeacture;
    private int currentPosition = 0;
    private int DELAY = 2000;
    private int PERIOD = 1500;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
        addDataToListPeacture();
        setAdapetr();
    }

    private void addDataToListPeacture(){
        mViews = new ArrayList<>();
        listPeacture = new ArrayList<>();

        listPeacture.add(R.drawable.spring06);
        listPeacture.add(R.drawable.spring01);
        listPeacture.add(R.drawable.spring02);
        listPeacture.add(R.drawable.spring03);
        listPeacture.add(R.drawable.spring04);
        listPeacture.add(R.drawable.spring05);
        listPeacture.add(R.drawable.spring06);
        listPeacture.add(R.drawable.spring01);

        for (int i = 0; i < listPeacture.size(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.view_pager, null);
            ImageView image = (ImageView) view.findViewById(R.id.ivViewPagerItem);
            image.setImageResource(listPeacture.get(i));
            mViews.add(view);
        }
        timer = new Timer();
    }

    private void setAdapetr(){
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        ViewGroup.LayoutParams params = mVpSeries.getLayoutParams();

        params.width = (int) (metrics.widthPixels * 0.6);/**设置ViewPager中Item的相对屏幕的宽度*/
        params.height = params.width * 682 / 1024;/**682:图片的高度，1024：图片的宽度*/
//        params.height = metrics.heightPixels;
        mVpSeries.setLayoutParams(params);

        mPagerAdapetr = new LoopPagerAdapetr(mViews);
        mVpSeries.setAdapter(mPagerAdapetr);

        mVpSeries.setOffscreenPageLimit(mViews.size());
        mVpSeries.setPageMargin(60);/**设置ViewPager中相邻Item的间距*/
        /**设置ViewPager起始播放位置,不能为0或者最后一个，否则就会出现起始时的Item的左边是空的，没有形成循环，给人中断的感觉*/
        mVpSeries.setCurrentItem(1);

        timer.schedule(task, DELAY, PERIOD);

        mVpSeries.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                currentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state != ViewPager.SCROLL_STATE_IDLE){
                    return;
                }
                if(currentPosition == 0){/**如果当前加载是第一张*/
                    mVpSeries.setCurrentItem(mPagerAdapetr.getCount() - 2, true);/**则加载倒数第二张*/
                }
                if(currentPosition == mPagerAdapetr.getCount() - 2 ){/**如果当前加载是最后一张*/
                    currentPosition = 0;
                    mVpSeries.setCurrentItem(1, true);/**则设置页面加载第二张*/
                }
            }
        });

        mVpSeries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void onEventMainThread(EventMsg msg){
        mVpSeries.setCurrentItem(msg.position, false);
    }


    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            int currentItem = mVpSeries.getCurrentItem();
            if(currentItem == 0){/**如果当前加载是第一张*/
                EventBus.getDefault().post(new EventMsg((mPagerAdapetr.getCount() - 2) % mViews.size()));
            }else if(currentPosition == mPagerAdapetr.getCount() - 2){/**如果当前加载是最后一张*/
                EventBus.getDefault().post(new EventMsg( 1 % mViews.size()));
            }else {
                EventBus.getDefault().post(new EventMsg((mVpSeries.getCurrentItem() + 1) % mViews.size()));
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        timer.cancel();
        task.cancel();
    }
}
