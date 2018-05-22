package bonc.demopractice_allkinsoff.charts;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.application.BaseActivity;
import bonc.demopractice_allkinsoff.utils.MyMarkerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SingleLineActivity extends BaseActivity implements SeekBar.OnSeekBarChangeListener,
        OnChartGestureListener, OnChartValueSelectedListener {
    @BindView(R.id.lcSingleLine)LineChart mLcSingleLine;
    @BindView(R.id.sbBarCount)SeekBar mSbBarCount;
    @BindView(R.id.tvBarCount)TextView mTvBarCount;
    @BindView(R.id.sbBarMax)SeekBar mSbBarMax;
    @BindView(R.id.tvBarMax)TextView mTvBarMax;
    @BindView(R.id.tvClassName)TextView mTvClassName;

    private YAxis leftAxis;
    private XAxis mXAxis;
    private ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_line);
        ButterKnife.bind(this);
        setAttribute();
    }

    private void setAttribute() {
        /**设置监听**/
        mSbBarCount.setOnSeekBarChangeListener(this);
        mSbBarMax.setOnSeekBarChangeListener(this);
        mLcSingleLine.setOnChartGestureListener(this);
        mLcSingleLine.setOnChartValueSelectedListener(this);

        /**给Charts设置各种属性**/
//      mLcSingleLine.setBackgroundColor(Color.rgb(127,255,212));
        mLcSingleLine.getDescription().setText("练习Demo");//设置该属性时，不显示且系统自带的消失
        mLcSingleLine.getDescription().setTextSize(12f);
        mLcSingleLine.getDescription().setTextColor(Color.rgb(255, 0, 0));
//      mLcSingleLine.getDescription().setPosition(300f,800f);//这里单位是px，用的时候建议用dp，做好适配。
        mLcSingleLine.setNoDataText("数据处理异常");
        mLcSingleLine.setNoDataTextColor(Color.rgb(0, 255, 0));
//      mLcSingleLine.setDrawGridBackground(true);
//      mLcSingleLine.setGridBackgroundColor(Color.rgb(0,0,255));
//      mLcSingleLine.setDrawBorders(true);

        leftAxis = mLcSingleLine.getAxisLeft();
        int max = mSbBarMax.getProgress();
        leftAxis.setAxisMaximum(70);
        leftAxis.setAxisMinimum(0f);
        setData(45, 50);

        MyMarkerView mmView = new MyMarkerView(this, R.layout.custom_marker_view);
        mmView.setChartView(mLcSingleLine); // For bounds control
        mLcSingleLine.setMarker(mmView); // Set the marker to the chart

        mXAxis = mLcSingleLine.getXAxis();
        mXAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        leftAxis.enableGridDashedLine(10f, 5f, 0f);//坐标平面内设置网格格式
        leftAxis.setDrawZeroLine(true);
        leftAxis.setDrawLimitLinesBehindData(true);
        mLcSingleLine.getAxisRight().setEnabled(false);//设置是否在图标右边显示Y坐标轴
        mLcSingleLine.animateXY(3000, 3000);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        mTvBarCount.setText(mSbBarCount.getProgress() + "");
        mTvBarMax.setText(mSbBarMax.getProgress() + "");
        setData(mSbBarCount.getProgress(), mSbBarMax.getProgress());

        leftAxis.setAxisMaximum(mSbBarMax.getProgress() + 20);
        TextView tvClassName = (TextView) findViewById(R.id.tvClassName);
        String sClassName = getClass().getName();
        for (ILineDataSet iSet : dataSets) {
            LineDataSet set = (LineDataSet) iSet;
            set.setDrawValues(!set.isDrawValuesEnabled());
            tvClassName.setText(sClassName + "/***/" + !set.isDrawValuesEnabled());
        }
        mLcSingleLine.invalidate();
    }

    //给折线造数据，chart1
    private void setData(int count, float range) {
        ArrayList<Entry> values = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range) + 20;
            values.add(new Entry(i, val));
        }
        LineDataSet set1;

        if (mLcSingleLine.getData() != null && mLcSingleLine.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mLcSingleLine.getData().getDataSetByIndex(0);
            set1.setValues(values);
            mLcSingleLine.getData().notifyDataChanged();
            mLcSingleLine.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(values, "Demo1");
            // set the line to be drawn like this "- - - - - -"
            set1.enableDashedLine(10f, 5f, 0f);
            set1.enableDashedHighlightLine(10f, 5f, 0f);
            set1.setColor(Color.BLACK);
            set1.setCircleColor(Color.BLACK);

            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(15f);
            set1.setDrawFilled(true);
            //需要setDrawFilled属性为true
            if (Utils.getSDKInt() >= 18) {//SDK>18，填充色渐变，否则设置为绿色。
                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_red);
                set1.setFillDrawable(drawable);
            } else {
                set1.setFillColor(Color.GREEN);
            }
            dataSets.add(set1); // add the datasets
            // create a data object with the datasets
            LineData data = new LineData(dataSets);
            mLcSingleLine.setData(data);
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

    }

    @Override
    public void onNothingSelected() {

    }
}
