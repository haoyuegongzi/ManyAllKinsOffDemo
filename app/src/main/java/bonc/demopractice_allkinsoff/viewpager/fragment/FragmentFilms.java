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

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by chen1 on 2017/8/23.
 */

public class FragmentFilms extends Fragment {
    @BindView(R.id.wvFilms)
    WebView mWvFilms;
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_films, container, false);
        unbinder = ButterKnife.bind(this, view);

        mWvFilms.loadUrl("http://www.iqiyi.com/");
        mWvFilms.setWebViewClient(new WebViewClient(){
            @Override    //shouldOverrideUrlLoading
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWvFilms.loadUrl(url);
                return true;
            }
        });
        Log.i("TAG", "FragmentFilms————》》》onCreateView: ");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
