package bonc.demopractice_allkinsoff.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import bonc.demopractice_allkinsoff.R;

/**
 * Created by chen1 on 2017/9/6.
 */

public class WebViewUtils {
    public static WebViewUtils sWebViewUtils;
    private ProgressBar mPbBar;
    private Context mContext;
    private WebView mWebView;
    private TextView mTextView;
//    private String downUrl;
    private String downName;

    public synchronized static WebViewUtils getInstance(){
        if(sWebViewUtils == null){
            sWebViewUtils = new WebViewUtils();
        }
        return sWebViewUtils;
    }

    public void setParms(Context mContext, String downName){
        this.mContext = mContext;
        this.downName = downName;
    }

    public void setWebView(WebView webView, String Url, TextView mTvWeb, ProgressBar mProgressBar){
        mPbBar = mProgressBar;
        mTextView = mTvWeb;
        mWebView = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setClickable(false);
        webView.setHorizontalScrollBarEnabled(false);//水平不显示
        webView.setVerticalScrollBarEnabled(false); //垂直不显示
        webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return true;
            }
        });
        webView.setWebChromeClient(webChromeClient);
        webView.setWebViewClient(webViewClient);
//        webView.addJavascriptInterface(new JavaScriptInterface(mContext), "JavaScriptInterface");
        webView.loadUrl(Url);
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition,
                                        String mimetype, long contentLength) {
                Thread mThread = downLoad(url);
                mThread.start();
            }
        });
    }

    WebChromeClient webChromeClient = new WebChromeClient(){
        @Override
        public void onProgressChanged(WebView view, int progress) {
            super.onProgressChanged(view, progress);
            if(mPbBar!=null) {
                mPbBar.setVisibility(View.VISIBLE);
                mPbBar.setProgress(progress);
                mPbBar.postInvalidate();
            }
            if (progress == 100){
                webViewClient.onPageFinished(view,view.getUrl());
                mPbBar.setVisibility(View.GONE);
            }
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            mTextView.setText(title);
        }
    };

    WebViewClient webViewClient = new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {
//            mWebView.addJavascriptInterface(new JavaScriptInterface(mContext), "JavaScriptInterface");
            if(mPbBar!=null){
                mPbBar.setVisibility(View.GONE);
            }
            super.onPageFinished(view, url);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            view.loadUrl("file:///android_assets/error_handle.html");
        }
    };

    public Thread downLoad(final String downUrl){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    URL url = new URL(downUrl);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    InputStream in = conn.getInputStream();
                    File downloadFile;
                    File sdFile;
                    FileOutputStream out = null;
                    if(Environment.getExternalStorageState().equals(Environment.MEDIA_UNMOUNTED)){
                        downloadFile = Environment.getExternalStorageDirectory();
                        sdFile = new File(downloadFile, downName);
                        out = new FileOutputStream(sdFile);
                    }
                    byte[] buffer = new byte[1024 * 4];//设置4K的缓存
                    int len = 0;
                    while((len = in.read(buffer)) != -1){
                        if(out != null)
                            out.write(buffer, 0, len);
                    }
                    if(out != null) {
                        out.close();
                    }
                    if(in != null){
                        in.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        return thread;
    }

    /***********************************************************************************************************/
    public void initWebSettings(WebView view) {
        WebSettings settings = view.getSettings();
        //支持获取手势焦点
        view.requestFocusFromTouch();
        //支持JS
        settings.setJavaScriptEnabled(true);
        //支持插件
        settings.setPluginState(WebSettings.PluginState.ON);
        //设置适应屏幕
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        //支持缩放
        settings.setSupportZoom(false);
        //隐藏原生的缩放控件
        settings.setDisplayZoomControls(false);
        //支持内容重新布局
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.supportMultipleWindows();
        settings.setSupportMultipleWindows(true);
        //设置缓存模式
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(view.getContext().getCacheDir().getAbsolutePath());
        //设置可访问文件
        settings.setAllowFileAccess(true);
        //当webview调用requestFocus时为webview设置节点
        settings.setNeedInitialFocus(true);
        //支持自动加载图片
        if (Build.VERSION.SDK_INT >= 19) {
            settings.setLoadsImagesAutomatically(true);
        } else {
            settings.setLoadsImagesAutomatically(false);
        }
        settings.setNeedInitialFocus(true);
        //设置编码格式
        settings.setDefaultTextEncodingName("UTF-8");
    }

    public void initWebViewClient(WebView view, final ProgressBar mProgressbar) {
        view.setWebViewClient(new WebViewClient() {
            //页面开始加载时
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mProgressbar.setVisibility(View.VISIBLE);
            }
            //页面完成加载时
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mProgressbar.setVisibility(View.GONE);
            }
            //是否在WebView内加载新页面
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return true;
            }
            //网络错误时回调的方法
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                /**
                 * 在这里写网络错误时的逻辑,比如显示一个错误页面
                 * 这里我偷个懒不写了
                 * */
            }
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
            }
        });
    }

    public void initWebChromeClient(final Context mContext, WebView view) {
        view.setWebChromeClient(new WebChromeClient() {
            Bitmap mDefaultVideoPoster;//默认的视频展示图
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
//                setToolbarTitle(title);
            }

            @Override
            public Bitmap getDefaultVideoPoster() {
                if (mDefaultVideoPoster == null) {
                    mDefaultVideoPoster = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.logo);
                    return mDefaultVideoPoster;
                }
                return super.getDefaultVideoPoster();
            }
        });
    }
}