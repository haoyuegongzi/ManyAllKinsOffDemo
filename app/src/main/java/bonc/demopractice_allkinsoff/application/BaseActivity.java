package bonc.demopractice_allkinsoff.application;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

//import com.bumptech.glide.Glide;

import com.bumptech.glide.Glide;

import bonc.demopractice_allkinsoff.R;

public class BaseActivity extends AppCompatActivity {
    public Typeface mTfRegular;
    public Typeface mTfLight;
    public Typeface mBold;
    public Typeface mBoldItalic;
    public Typeface mExtraBold;
    public Typeface mExtraBoldItalic;
    public Typeface mItalic;
    public Typeface mLightItalic;
    public Typeface mSemilbold;
    public Typeface mSemilboldItalic;

    protected String[] mMonths = new String[] {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"
    };

    protected String[] mParties = new String[] {
            "Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
            "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
            "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
            "Party Y", "Party Z"
    };

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          this.getSupportActionBar().hide();

//        getTypeface();
    }

    private void getTypeface() {
        mTfRegular = Typeface.createFromAsset(this.getResources().getAssets(), "OpenSans-Regular.ttf");
        mTfLight = Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf");
        mBold = Typeface.createFromAsset(getAssets(), "OpenSans-Bold.ttf");
        mBoldItalic = Typeface.createFromAsset(getAssets(), "OpenSans-BoldItalic.ttf");
        mExtraBold = Typeface.createFromAsset(getAssets(), "OpenSans-ExtraBold.ttf");
        mExtraBoldItalic = Typeface.createFromAsset(getAssets(), "OpenSans-ExtraBoldItalic.ttf");
        mItalic = Typeface.createFromAsset(getAssets(), "OpenSans-Italic.ttf");
        mLightItalic = Typeface.createFromAsset(getAssets(), "OpenSans-LightItalic.ttf");
        mSemilbold = Typeface.createFromAsset(getAssets(), "OpenSans-Semibold.ttf");
        mSemilboldItalic = Typeface.createFromAsset(getAssets(), "OpenSans-SemiboldItalic.ttf");
    }

    protected float getRandom(float range, float startsfrom) {
        return (float) (Math.random() * range) + startsfrom;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
    }

    public void loadGlide(Context mContext, String Url, ImageView view){
        Glide.with(mContext).load(Url).into(view);
    }
}
