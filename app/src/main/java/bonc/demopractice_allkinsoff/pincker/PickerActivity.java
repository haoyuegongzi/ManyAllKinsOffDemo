package bonc.demopractice_allkinsoff.pincker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.application.MessageUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PickerActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener, TimePicker.OnTimeChangedListener {

    @BindView(R.id.dpDatePicker)
    DatePicker mDpDatePicker;
    @BindView(R.id.tpTimePicker)
    TimePicker mTpTimePicker;
    @BindView(R.id.btUpdatePicker)
    Button mBtUpdatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        ButterKnife.bind(this);

        mTpTimePicker.setIs24HourView(true);
        mTpTimePicker.setOnTimeChangedListener(this);

        mDpDatePicker.init(2017, 10, 13, this);

        int Day = mDpDatePicker.getDayOfMonth();
        int Month = mDpDatePicker.getMonth();
        int Year = mDpDatePicker.getYear();

        int Hour = mTpTimePicker.getCurrentHour();
        int Minute = mTpTimePicker.getCurrentMinute();
        int baseLine = mTpTimePicker.getBaseline();

        Log.i("TAG", "onCreate: 日期是：" + Year + "" + Month + "" + Day + "  " + Hour + "" + Minute + "::" + baseLine);
    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        String month = null;
        String day = null;
        if (monthOfYear < 10) {
            month = "0" + monthOfYear;
        }
        if (dayOfMonth < 10) {
            day = "0" + dayOfMonth;
        }

        MessageUtils.showToast(PickerActivity.this, "日期是：" + year + "" + month + "" + dayOfMonth);
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        String hour = null;
        String minutes = null;
        if (hourOfDay < 10) {
            hour = "0" + hourOfDay;
        }
        if (hourOfDay < 10) {
            hour = "0" + hourOfDay;
        }
        MessageUtils.showToast(PickerActivity.this, "时间是：" + hourOfDay + "：" + minute);
    }

    @OnClick(R.id.btUpdatePicker)
    public void onClick() {
        mDpDatePicker.updateDate(2016,3-1,27);
    }

}
