package bonc.demopractice_allkinsoff.datatime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import bonc.demopractice_allkinsoff.R;

public class DateTimePickerActivity extends AppCompatActivity {
    /** Called when the activity is first created. */
    private EditText startDateTime;
    private EditText endDateTime;

    private String initStartDateTime = "2013年9月"; // 初始化开始时间
    private String initEndDateTime = "2014年8月"; // 初始化结束时间

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_time_picker);

        // 两个输入框
        startDateTime = (EditText) findViewById(R.id.etDatapicker);
        endDateTime = (EditText) findViewById(R.id.etTimepicker);

        startDateTime.setText(initStartDateTime);
        endDateTime.setText(initEndDateTime);

        startDateTime.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
                        DateTimePickerActivity.this, initEndDateTime);
                dateTimePicKDialog.dateTimePicKDialog(startDateTime);

            }
        });

        endDateTime.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
                        DateTimePickerActivity.this, initEndDateTime);
                dateTimePicKDialog.dateTimePicKDialog(endDateTime);
            }
        });

        findViewById(R.id.tvMonthDay).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePicker picker = new DatePicker(DateTimePickerActivity.this, DatePicker.YEAR_MONTH);
                picker.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                picker.setWidth((int) (picker.getScreenWidthPixels() * 0.6));
                picker.setRangeStart(2016, 10, 14);
                picker.setRangeEnd(2020, 11, 11);
                picker.setSelectedItem(2017, 9);
                picker.setOnDatePickListener(new DatePicker.OnYearMonthPickListener() {
                    @Override
                    public void onDatePicked(String year, String month) {
                        Toast.makeText(DateTimePickerActivity.this,
                                year + "-" + month, Toast.LENGTH_LONG).show();
                    }
                });
                picker.show();
            }
        });
    }
}
