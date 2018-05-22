package bonc.demopractice_allkinsoff;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import bonc.demopractice_allkinsoff.Animation.MainAnimationActivity;
import bonc.demopractice_allkinsoff.adaptive.AdaptiveSizeActivity;
import bonc.demopractice_allkinsoff.application.BaseActivity;
import bonc.demopractice_allkinsoff.canvas.CanvasActivity;
import bonc.demopractice_allkinsoff.charts.ChartsActivity;
import bonc.demopractice_allkinsoff.charts.HorizontalBarsActivity;
import bonc.demopractice_allkinsoff.charts.MoreBarsActivity;
import bonc.demopractice_allkinsoff.charts.MoreLinesActivity;
import bonc.demopractice_allkinsoff.charts.SingleLineActivity;
import bonc.demopractice_allkinsoff.click.ClickActivity;
import bonc.demopractice_allkinsoff.datatime.DateTimePickerActivity;
import bonc.demopractice_allkinsoff.expandablelistview.ExpandableActivity;
import bonc.demopractice_allkinsoff.image.ImageViewActivity;
import bonc.demopractice_allkinsoff.imageswicher.ImageSwicherActivity;
import bonc.demopractice_allkinsoff.intent.IntentActionActivity;
import bonc.demopractice_allkinsoff.lifecycle.LifeCycleActivity;
import bonc.demopractice_allkinsoff.listrecycler.ListRecyclerActivity;
import bonc.demopractice_allkinsoff.mvip_jump.view.MvipActivity;
import bonc.demopractice_allkinsoff.mvip_thought01.view.MvpOneActivity;
import bonc.demopractice_allkinsoff.mvip_thought02.view.MvpTwoActivity;
import bonc.demopractice_allkinsoff.permissions.ShapeActivity;
import bonc.demopractice_allkinsoff.pincker.PickerActivity;
import bonc.demopractice_allkinsoff.popup.PopupWindowActivity;
import bonc.demopractice_allkinsoff.recycler_recycler.Recycler_RecyclerActivity;
import bonc.demopractice_allkinsoff.rx_java.RxJavaActivity;
import bonc.demopractice_allkinsoff.rxjava_integrate.RxJavaIntegrateActivity;
import bonc.demopractice_allkinsoff.scroll.SCrollActivity;
import bonc.demopractice_allkinsoff.scrollview.VerticalScrollViewActivity;
import bonc.demopractice_allkinsoff.seekbar.SeekBarActivity;
import bonc.demopractice_allkinsoff.softinputmode.SoftInputModeActivity;
import bonc.demopractice_allkinsoff.spinner.SpinnerActivity;
import bonc.demopractice_allkinsoff.text_marqque.TextViewMaqqueActivity;
import bonc.demopractice_allkinsoff.textview.EditTextActivity;
import bonc.demopractice_allkinsoff.timertask.TimerTaskActivity;
import bonc.demopractice_allkinsoff.traslate.TraslateActivity;
import bonc.demopractice_allkinsoff.view.DetecteViewActivity;
import bonc.demopractice_allkinsoff.view.ScrollerActivity;
import bonc.demopractice_allkinsoff.viewpager.ViewPagerActivity;
import bonc.demopractice_allkinsoff.viewpager.fragment.LoadFragmentActivity;
import bonc.demopractice_allkinsoff.viewpagerfragment.FragmentViewPagerActivity;
import bonc.demopractice_allkinsoff.webview.WebViewActivity;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        initSystemBarTint();
        findViewById(R.id.btSeekBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SeekBarActivity.class));
            }
        });
        findViewById(R.id.btExpandable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ExpandableActivity.class));
            }
        });
        findViewById(R.id.btDataTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DateTimePickerActivity.class));
            }
        });
        findViewById(R.id.btChartsLines).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ChartsActivity.class));
            }
        });
        findViewById(R.id.btSingleLineLines).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SingleLineActivity.class));
            }
        });
        findViewById(R.id.btListRecycler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListRecyclerActivity.class));
            }
        });
        findViewById(R.id.btRecycler_Recycler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Recycler_RecyclerActivity.class));
            }
        });
        findViewById(R.id.btMoreLines).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MoreLinesActivity.class));
            }
        });
        findViewById(R.id.btMoreBars).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MoreBarsActivity.class));
            }
        });
        findViewById(R.id.btHorizontalBars).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HorizontalBarsActivity.class));
            }
        });
        findViewById(R.id.btMvpOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MvpOneActivity.class));
            }
        });
        findViewById(R.id.btMvpTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MvpTwoActivity.class));
            }
        });
        findViewById(R.id.btAndroidCanvas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CanvasActivity.class));
            }
        });
        findViewById(R.id.btEditText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EditTextActivity.class));
            }
        });
        findViewById(R.id.btPermissions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ShapeActivity.class));
            }
        });
        findViewById(R.id.btSpinner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SpinnerActivity.class));
            }
        });
        findViewById(R.id.btMainAnimation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainAnimationActivity.class));
            }
        });
        findViewById(R.id.btViewPager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
            }
        });
        findViewById(R.id.btSCroll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SCrollActivity.class));
            }
        });
        findViewById(R.id.btRxJava).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RxJavaActivity.class));
            }
        });

        findViewById(R.id.btSoftInputMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SoftInputModeActivity.class));
            }
        });
        findViewById(R.id.btWebView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WebViewActivity.class));
            }
        });
        findViewById(R.id.btJumpMvp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MvipActivity.class));
            }
        });
        findViewById(R.id.btTimerTask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TimerTaskActivity.class));
            }
        });
        findViewById(R.id.btFragmentViewPager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FragmentViewPagerActivity.class));
            }
        });
        findViewById(R.id.btClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ClickActivity.class));
            }
        });
        findViewById(R.id.btTextViewMaqque).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TextViewMaqqueActivity.class));
            }
        });
        findViewById(R.id.btImageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ImageViewActivity.class));
            }
        });
        findViewById(R.id.btTraslate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TraslateActivity.class));
            }
        });
        findViewById(R.id.btImageSwicher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ImageSwicherActivity.class));
            }
        });
        findViewById(R.id.btVerticalScrollView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, VerticalScrollViewActivity.class));
            }
        });
        findViewById(R.id.btPicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PickerActivity.class));
            }
        });
        findViewById(R.id.btLifeCycle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LifeCycleActivity.class));
            }
        });
        findViewById(R.id.btDetecteView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DetecteViewActivity.class));
            }
        });
        findViewById(R.id.btScroller).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ScrollerActivity.class));
            }
        });
        findViewById(R.id.btLoadFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoadFragmentActivity.class));
            }
        });
        findViewById(R.id.btIntent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, IntentActionActivity.class));
            }
        });
        findViewById(R.id.btAdaptiveSize).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AdaptiveSizeActivity.class));
            }
        });
        findViewById(R.id.btPopupWindow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PopupWindowActivity.class));
            }
        });

        findViewById(R.id.btIntegrate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RxJavaIntegrateActivity.class));
            }
        });


    }


    /** 设置状态栏颜色 */
    protected void initSystemBarTint() {
        Window window = getWindow();
        if (translucentStatusBar()) {
            // 设置状态栏全透明
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
            return;
        }
        // 沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0以上使用原生方法
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(setStatusBarColor());
        }
//        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //4.4-5.0使用三方工具类，有些4.4的手机有问题，这里为演示方便，不使用沉浸式
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            SystemBarTintManager tintManager = new SystemBarTintManager(this);
//            tintManager.setStatusBarTintEnabled(true);
//            tintManager.setStatusBarTintColor(setStatusBarColor());
//        }
    }

    /** 子类可以重写决定是否使用透明状态栏 */
    protected boolean translucentStatusBar() {
        return false;
    }

    /** 子类可以重写改变状态栏颜色 */
    protected int setStatusBarColor() {
        return R.color.yellow;
    }

    int oldParms = 7;

    @Override
    protected void onResume() {
        super.onResume();
        int newParms = oldParms;
        newParms++;
        Log.i("TAG", "onResume: oldParms==" + oldParms + "→→→→ newParms==" + newParms);

    }
}