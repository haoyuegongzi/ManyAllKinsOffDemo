package bonc.demopractice_allkinsoff.seekbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.SeekBar;
import android.widget.TextView;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    @BindView(R.id.SeekBar1)
    SeekBar mSeekBar1;
    @BindView(R.id.tvSeekBar1)
    TextView mTvSeekBar1;
    @BindView(R.id.SeekBar2)
    SeekBar mSeekBar2;
    @BindView(R.id.tvSeekBar2)
    TextView mTvSeekBar2;
    @BindView(R.id.acSeekBar)
    AppCompatSeekBar mAcSeekBar;
    @BindView(R.id.tvCompatBar)
    TextView mTvCompatBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        ButterKnife.bind(this);
        dealSeekBar();
    }

    public void dealSeekBar() {
        mSeekBar1.setProgress(10);
        mSeekBar2.setProgress(10);
        mSeekBar1.setOnSeekBarChangeListener(this);
        mSeekBar2.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()) {
            case R.id.SeekBar1:
                mTvSeekBar1.setText(getResources().getString(R.string.textString) + mSeekBar1.getProgress());
                break;
            case R.id.SeekBar2:
                mTvSeekBar2.setText(getResources().getString(R.string.textString) + mSeekBar2.getProgress());
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
