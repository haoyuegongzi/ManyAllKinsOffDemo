package bonc.demopractice_allkinsoff.charts;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.application.BaseActivity;

public class MoreLinesActivity extends BaseActivity implements SeekBar.OnSeekBarChangeListener,
        OnChartGestureListener, OnChartValueSelectedListener {

    private XAxis xAxis;
    private YAxis leftYAxis;
    private float mYaxisMax = 0f;
    LineChart mMoreLineCharts;
    SeekBar mSbBarCount;
    SeekBar mSbBarMax;
    TextView mTvBarCount;
    TextView mTvBarMax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_lines);
        dealWidget();
    }

    public void dealWidget() {
        mMoreLineCharts = (LineChart) findViewById(R.id.moreLineCharts);
        mSbBarCount = (SeekBar) findViewById(R.id.sbBarCount);
        mSbBarMax = (SeekBar) findViewById(R.id.sbBarMax);
        mTvBarCount = (TextView) findViewById(R.id.tvBarCount);
        mTvBarMax = (TextView) findViewById(R.id.tvBarMax);

        mSbBarMax.setOnSeekBarChangeListener(this);
        mSbBarCount.setOnSeekBarChangeListener(this);
        mMoreLineCharts.setOnChartGestureListener(this);
        mMoreLineCharts.setOnChartValueSelectedListener(this);

        dealLineCharts();

        mMoreLineCharts.invalidate();
    }

    public void dealLineCharts() {
        mMoreLineCharts.setNoDataText("数据处理异常");
        mMoreLineCharts.setNoDataTextColor(Color.RED);
        mMoreLineCharts.setEnabled(true);
        mMoreLineCharts.setTouchEnabled(true);
        mMoreLineCharts.setMaxVisibleValueCount(60);

        mMoreLineCharts.getDescription().setText("多条折线的Demo");
        mMoreLineCharts.getDescription().setTextColor(Color.BLUE);
        mMoreLineCharts.getDescription().setPosition(650f, 100000f);//数据加大，让标签溢出屏幕外
        mMoreLineCharts.getAxisRight().setEnabled(false);

        xAxis = mMoreLineCharts.getXAxis();
        leftYAxis = mMoreLineCharts.getAxisLeft();
        setData(20, 50);

        mMoreLineCharts.animateXY(3000, 3000);

        Legend l = mMoreLineCharts.getLegend();// modify the legend
        l.setForm(Legend.LegendForm.SQUARE);//图例说明前面的样式：线性？方块？圆？
        l.setTextSize(11f);//图例说明的字体大小
        l.setTextColor(Color.DKGRAY);//图例说明的字体颜色
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);//图例说明垂直方向的位置：顶部、中间、底部
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);//图例说明水平方向的位置：左、中、右
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);//图例说明有多个的时候的排列方式：水平并排、竖直排列
        l.setDrawInside(false);
        l.setXEntrySpace(10f);
        l.setYEntrySpace(20f);
        l.setFormToTextSpace(10f);

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(10f);
        xAxis.setTextColor(Color.rgb(127, 0, 0));
        xAxis.setAxisLineWidth(1f);
        xAxis.setAxisLineColor(Color.GRAY);
        xAxis.setDrawLabels(true);
        xAxis.setDrawGridLines(false);
        xAxis.setAvoidFirstLastClipping(true);
        xAxis.setLabelCount(5);//强制控制X轴标签数量
        xAxis.setValueFormatter(new IAxisValueFormatter() {//自定义给X轴设置坐标值
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return data[(int) value % data.length];
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });



        leftYAxis.setAxisMinimum(0f);
        leftYAxis.setDrawLimitLinesBehindData(true);
        leftYAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftYAxis.enableGridDashedLine(15f, 5f, 5f);
        leftYAxis.setDrawZeroLine(true);

        List<ILineDataSet> sets = mMoreLineCharts.getData().getDataSets();
        for (ILineDataSet iSet : sets) {
            LineDataSet set = (LineDataSet) iSet;
            set.setDrawFilled(!set.isDrawFilledEnabled());
        }
    }

    String []data = new String[]{"05.01", "05.02", "05.03", "05.04", "05.05", "05.06",
            "05.07", "05.08", "05.09", "05.10", "05.11", "05.12", "05.13",
            "05.14", "05.15", "05.16", "05.17", "05.18", "05.19", "05.20"};

    private int[] mColors = new int[] {
            Color.rgb(78, 219, 247), Color.rgb(90, 236, 175)
    };

    private void setData(int max, int count) {
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        ArrayList<Entry> values1 = new ArrayList<Entry>();
        for (int i = 0; i < max; i++) {//循环添加数据
            double val1 = (Math.random() * count) + 3;
            values1.add(new Entry(i, (float) val1));
        }
        LineDataSet d1 = new LineDataSet(values1, "办理量 ");
        d1.setLineWidth(2.5f);
        d1.setCircleRadius(4f);
        d1.setColor(mColors[0]);
        d1.setCircleColor(mColors[0]);
        dataSets.add(d1);

        ArrayList<Entry> values2 = new ArrayList<Entry>();
        for (int j = 0; j < max; j++) {//循环添加数据
            double val2 = (Math.random() * count) + 3;
            values2.add(new Entry(j, (float) val2));
        }
        LineDataSet d2 = new LineDataSet(values2, "用户数 ");
        d2.setLineWidth(2.5f);
        d2.setCircleRadius(4f);
        d2.setColor(mColors[1]);
        d2.setCircleColor(mColors[1]);
        dataSets.add(d2);

        LineData data = new LineData(dataSets);
        mMoreLineCharts.setData(data);
        mMoreLineCharts.invalidate();
    }

    private LineDataSet dataSet( int index, List<Entry> mChartLineList){
        LineDataSet dataSet = (LineDataSet) mMoreLineCharts.getData().getDataSetByIndex(index);
        dataSet.setValues(mChartLineList);
        return dataSet;
    }

    public LineDataSet setDatasetAttribute(List<Entry> mChartLineList, int color, String dataName) {
        LineDataSet dataSet = new LineDataSet(mChartLineList, dataName);
        dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSet.setColor(color);
        dataSet.setCircleColor(color);
        dataSet.setFillColor(color);
        dataSet.setLineWidth(2f);
        dataSet.setCircleRadius(3f);
        dataSet.setFillAlpha(65);
        dataSet.setDrawCircleHole(false);
        return dataSet;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        mTvBarMax.setText(mSbBarMax.getProgress() + "");
        mTvBarCount.setText(mSbBarCount.getProgress() + "");
        if(mSbBarMax.getProgress() >= 0 && mSbBarCount.getProgress() >= 0){
            setData(mSbBarMax.getProgress(), mSbBarCount.getProgress());
            mMoreLineCharts.invalidate();
        }else{
            Toast.makeText(this, "SbBar值异常", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartLongPressed(MotionEvent me) {

    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {

    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {

    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        mMoreLineCharts.centerViewToAnimated(e.getX(), e.getY(),
                mMoreLineCharts.getData().getDataSetByIndex(h.getDataSetIndex()).getAxisDependency(), 500);
    }

    @Override
    public void onNothingSelected() {

    }
}
