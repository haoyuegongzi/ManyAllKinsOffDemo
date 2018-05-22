package bonc.demopractice_allkinsoff.viewpagerfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainTab04 extends Fragment {

    @BindView(R.id.webView04)
    WebView webView04;
    @BindView(R.id.ly_main_weixin)
    LinearLayout lyMainWeixin;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View newsLayout = inflater.inflate(R.layout.main_tab_04, container,
                false);
        unbinder = ButterKnife.bind(this, newsLayout);
        return newsLayout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
