package bonc.demopractice_allkinsoff.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LifeCycleActivity extends AppCompatActivity {

    @BindView(R.id.tvLifeCycler)
    TextView mTvLifeCycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        ButterKnife.bind(this);
        Log.i("TAG", "LifeCycleActivity————>>>onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG", "LifeCycleActivity————>>>onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", "LifeCycleActivity————>>>onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG", "LifeCycleActivity————>>>onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG", "LifeCycleActivity————>>>onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG", "LifeCycleActivity————>>>onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "LifeCycleActivity————>>>onDestroy: ");
    }

    @OnClick(R.id.tvLifeCycler)
    public void onClick() {
        startActivity(new Intent(LifeCycleActivity.this, OtherActivity.class));
    }
}
