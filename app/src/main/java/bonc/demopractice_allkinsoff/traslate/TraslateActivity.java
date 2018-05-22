package bonc.demopractice_allkinsoff.traslate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TraslateActivity extends AppCompatActivity {
    private TrasApplication trasApp;


    @BindView(R.id.etName)
    EditText mEtName;
    @BindView(R.id.etCity)
    EditText mEtCity;
    @BindView(R.id.btStart)
    Button mBtStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traslate);
        trasApp = (TrasApplication) getApplication();
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btStart)
    public void onClick() {
        if(!TextUtils.isEmpty(mEtName.getText().toString().trim()) &&
           !TextUtils.isEmpty(mEtCity.getText().toString().trim())){
            trasApp.setName(mEtName.getText().toString());
            trasApp.setCity(mEtCity.getText().toString());
            startActivity(new Intent(TraslateActivity.this, AnotherActivity.class));
        }
    }
}
