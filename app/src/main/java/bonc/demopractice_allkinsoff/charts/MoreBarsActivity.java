package bonc.demopractice_allkinsoff.charts;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.application.BaseActivity;
import bonc.demopractice_allkinsoff.utils.MyMarkerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MoreBarsActivity extends BaseActivity implements
        SeekBar.OnSeekBarChangeListener, OnChartValueSelectedListener{
    public @BindView(R.id.BarChart)BarChart mBarChart;
    public @BindView(R.id.SeekBarCount)SeekBar mSeekBarCount;
    public @BindView(R.id.TvCount)TextView mTvCount;
    public @BindView(R.id.SeekBarMax)SeekBar mSeekBarMax;
    public @BindView(R.id.TvMax)TextView mTvMax;

    private XAxis x;
    private YAxis y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_bars);
        ButterKnife.bind(this);
        setChartAttribute();
    }

    private void setChartAttribute(){
        mSeekBarCount.setProgress(6);
        mSeekBarMax.setProgress(10);
        mBarChart.setOnChartValueSelectedListener(this);
        mSeekBarCount.setOnSeekBarChangeListener(this);
        mSeekBarMax.setOnSeekBarChangeListener(this);

        mBarChart.getDescription().setEnabled(false);
        mBarChart.setDrawBarShadow(false);
        mBarChart.setPinchZoom(false);
        mBarChart.setDrawGridBackground(false);
        mBarChart.getAxisRight().setEnabled(false);
        MyMarkerView markerView = new MyMarkerView(this, R.layout.custom_marker_view);
        markerView.setChartView(mBarChart);
        mBarChart.setMarker(markerView);


        Legend legend = mBarChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(true);
        legend.setYOffset(0f);
        legend.setXOffset(10f);
        legend.setYEntrySpace(0f);
        legend.setTextSize(8f);
        legend.setTypeface(mTfRegular);

        x = mBarChart.getXAxis();
        x.setDrawLabels(true);
        x.setGranularity(1f);
        x.setTypeface(mTfRegular);
        x.setPosition(XAxis.XAxisPosition.BOTTOM);
        x.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                //value先转成int，在转成string，否则，返回值带小数点。
                return String.valueOf((int)value);
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });

        y = mBarChart.getAxisLeft();
        y.setTypeface(mTfRegular);
        y.setValueFormatter(new LargeValueFormatter());
        y.setDrawGridLines(false);
        y.setSpaceTop(5f);
        y.setAxisMinimum(0f);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int BarCount = mSeekBarCount.getProgress();
        int start = 2000;//横坐标起点
        int end = start + BarCount;//成为横坐标值
        mTvMax.setText(mSeekBarMax.getProgress() + "");
        mTvCount.setText(start + " - " + end);

        float multiplier = mSeekBarMax.getProgress()* 1000f;
        ArrayList<BarEntry> mBarList1 = new ArrayList<>();
        ArrayList<BarEntry> mBarList2 = new ArrayList<>();
        ArrayList<BarEntry> mBarList3 = new ArrayList<>();
        for(int k = start; k < end; k++){
            mBarList1.add(new BarEntry(i, (float) (Math.random() * multiplier)));
            mBarList2.add(new BarEntry(i, (float) (Math.random() * multiplier)));
            mBarList3.add(new BarEntry(i, (float) (Math.random() * multiplier)));
        }
        BarDataSet bar1 = null;
        BarDataSet bar2 = null;
        BarDataSet bar3 = null;
        if(mBarChart.getData() != null && mBarChart.getData().getDataSetCount() > 0){
            bar1 = (BarDataSet) mBarChart.getData().getDataSetByIndex(0);
            bar1.setValues(mBarList1);
            bar2 = (BarDataSet) mBarChart.getData().getDataSetByIndex(1);
            bar2.setValues(mBarList2);
            bar3 = (BarDataSet) mBarChart.getData().getDataSetByIndex(2);
            bar3.setValues(mBarList3);
            mBarChart.getData().notifyDataChanged();
            mBarChart.notifyDataSetChanged();
        }else{
            bar1 = new BarDataSet(mBarList1, "腾龙");
            bar1.setColor(Color.rgb(200, 25, 25));
            bar2 = new BarDataSet(mBarList2, "昆仑");
            bar2.setColor(Color.rgb(25, 200, 25));
            bar3 = new BarDataSet(mBarList3, "深空");
            bar3.setColor(Color.rgb(25, 25, 200));
            BarData mBarData = new BarData(bar1, bar2, bar3);
            mBarData.setValueFormatter(new LargeValueFormatter());
            mBarData.setValueTypeface(mTfRegular);

            mBarChart.setData(mBarData);
        }
        float groupSpace = 0.25f;//控制每一组柱状图间的距离
        float barSpace = 0.05f; //控制每一组柱状图中柱子间的距离
        float barWidth = 0.25f; //控制每一组柱状图中每根柱子的宽度
        mBarChart.getBarData().setBarWidth(barWidth);
        mBarChart.getXAxis().setAxisMinimum(start);
        //按照下面这行代码计算出的X轴的最大值太大，不符合显示的需求。
//        mBarChart.getXAxis().setAxisMaximum(start + mBarChart.getBarData().getGroupWidth(groupSpace, barSpace) * barWidth);
        //下面这行代码计算出的X轴的最大值基本符合符合显示的需求。
//        mBarChart.getXAxis().setAxisMaximum(start + BarCount + 1);
        //这样设置X轴的最大值更直接有效
        x.setAxisMaximum(start + BarCount + 1);
        x.setAvoidFirstLastClipping(true);
        mBarChart.setClipValuesToContent(true);
        mBarChart.groupBars(start, groupSpace, barSpace);
        mBarChart.invalidate();
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
