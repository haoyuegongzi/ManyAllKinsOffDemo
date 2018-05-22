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

public class MainTab02 extends Fragment {

    @BindView(R.id.webView02)
    WebView webView02;
    @BindView(R.id.ly_main_weixin)
    LinearLayout lyMainWeixin;
    Unbinder unbinder;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View messageLayout = inflater.inflate(R.layout.main_tab_02, container, false);
        unbinder = ButterKnife.bind(this, messageLayout);
        return messageLayout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
