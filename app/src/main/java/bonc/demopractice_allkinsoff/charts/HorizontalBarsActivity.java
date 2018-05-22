package bonc.demopractice_allkinsoff.charts;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.application.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HorizontalBarsActivity extends BaseActivity implements
        SeekBar.OnSeekBarChangeListener, OnChartValueSelectedListener{

    @BindView(R.id.HorizontalBar)HorizontalBarChart mHorizontalBar;
    @BindView(R.id.SeekBarCount)SeekBar mSeekBarCount;
    @BindView(R.id.TvCount)TextView mTvCount;
    @BindView(R.id.SeekBarMax)SeekBar mSeekBarMax;
    @BindView(R.id.TvMax)TextView mTvMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_horizontal_bars);
        ButterKnife.bind(this);
    }

    public void setAttribute(){
        mHorizontalBar.setOnChartValueSelectedListener(this);
        mSeekBarCount.setOnSeekBarChangeListener(this);
        mSeekBarMax.setOnSeekBarChangeListener(this);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
