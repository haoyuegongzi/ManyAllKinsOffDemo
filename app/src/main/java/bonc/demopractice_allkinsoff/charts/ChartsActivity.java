package bonc.demopractice_allkinsoff.charts;

import android.widget.SeekBar;

import bonc.demopractice_allkinsoff.application.BaseActivity;

public class ChartsActivity extends BaseActivity implements SeekBar.OnSeekBarChangeListener {

//    @BindView(R.id.bcChart) BarChart mBcChart;
//    @BindView(R.id.sbBarCount)SeekBar mSbBarCount;
//    @BindView(R.id.tvBarCount)TextView mTvBarCount;
//    @BindView(R.id.sbBarMax)SeekBar mSbBarMax;
//    @BindView(R.id.tvBarMax)TextView mTvBarMax;
//
//    public ChartsActivity() {
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_charts);
//        init();
//    }
//
//    public void init() {
//        mBcChart.getDescription().setEnabled(true);
//        mBcChart.setMaxVisibleValueCount(60);
//        mBcChart.setPinchZoom(true);
//        mBcChart.setDrawBarShadow(false);
//        mBcChart.setDrawGridBackground(false);
//
//        XAxis xAxis = mBcChart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
//        xAxis.setEnabled(true);
//        xAxis.setDrawAxisLine(true);//绘制X轴线，setEnabled为true的时候生效
//        xAxis.setDrawGridLines(true);//绘制坐标平面图的网格线，setEnabled为true的时候生效
//        xAxis.setDrawLabels(true);//绘制坐标下的标签
//        xAxis.setGranularity(2f);
//        xAxis.setTextColor(0xff001234);
//        xAxis.setTextSize(12f);
//        xAxis.setGridColor(0xddee11aa);
//        xAxis.setGridLineWidth(6f);
//        xAxis.setAxisLineColor(0xaabbccdd);
//        xAxis.setAxisLineWidth(6f);
//        xAxis.enableGridDashedLine(10f, 4f, 6f);
//
//        YAxis yAxis = mBcChart.getAxisLeft();
//        Log.i(getClass().getName(), "Charts的轴坐标");
//
//        mBcChart.invalidate();
//    }
//
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
