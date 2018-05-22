package bonc.demopractice_allkinsoff.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OtherActivity extends AppCompatActivity {

    @BindView(R.id.ivOther)
    ImageView mIvOther;
    @BindView(R.id.ivRestore)
    ImageView mIvRestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        ButterKnife.bind(this);
        Log.i("TAG", "OtherActivity————>>>onCreate: ");
        if (savedInstanceState != null) {
            mIvOther.setImageDrawable(getDrawable(savedInstanceState.getInt("draw")));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG", "OtherActivity————>>>onStart: ");
        mIvOther.setImageDrawable(getDrawable(R.mipmap.shuchang));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", "OtherActivity————>>>onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG", "OtherActivity————>>>onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG", "OtherActivity————>>>onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG", "OtherActivity————>>>onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "OtherActivity————>>>onDestroy: ");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            mIvRestore.setImageDrawable(getDrawable(savedInstanceState.getInt("draw")));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {//保存
        super.onSaveInstanceState(outState);
        outState.putInt("draw", R.mipmap.shuchang);
    }

    @OnClick(R.id.ivOther)
    public void onClick() {
    }
}
