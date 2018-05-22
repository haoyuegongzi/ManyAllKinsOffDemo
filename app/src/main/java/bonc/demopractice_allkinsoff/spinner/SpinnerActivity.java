package bonc.demopractice_allkinsoff.spinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SpinnerActivity extends AppCompatActivity {

    @BindView(R.id.tvSpinner)
    TextView mTvSpinner;
    @BindView(R.id.sSpinner)
    Spinner mSSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ButterKnife.bind(this);
        List<String> mAreaList = SiChuanArea.getInstance().mAreaList();
//        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this, mAreaList);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mAreaList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSSpinner.setAdapter(spinnerAdapter);
        mSSpinner.setDropDownVerticalOffset(80);
        mSSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String Selected = mSSpinner.getItemAtPosition(i).toString();
                Toast.makeText(SpinnerActivity.this, Selected, Toast.LENGTH_LONG).show();
                mTvSpinner.setText(Selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
