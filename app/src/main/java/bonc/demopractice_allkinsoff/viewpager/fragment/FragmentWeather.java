package bonc.demopractice_allkinsoff.viewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by chen1 on 2017/8/23.
 */

public class FragmentWeather extends Fragment {
    @BindView(R.id.wvWeather)
    WebView mWvWeather;
    Unbinder unbinder;
    @BindView(R.id.sRefresh)
    SmartRefreshLayout mSRefresh;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        unbinder = ButterKnife.bind(this, view);
        mWvWeather.loadUrl("http://www.weather.com.cn/");
        mWvWeather.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWvWeather.loadUrl(url);
                return true;
            }
        });
        Log.i("TAG", "FragmentWeather————》》》onCreateView: ");
        setSRefresh();
        return view;
    }

    private void setSRefresh(){
        mSRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mSRefresh.finishRefresh(2000);
                Log.i("TAG", "FragmentWeather————》》》setSRefresh: ");
            }
        });
        mSRefresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mSRefresh.finishRefresh(2000);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
