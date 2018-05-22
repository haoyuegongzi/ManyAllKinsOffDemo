package bonc.demopractice_allkinsoff.textview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import bonc.demopractice_allkinsoff.R;

public class EditTextActivity extends AppCompatActivity {
    TextView tvTest;
    EditText etTextWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        etTextWatcher = (EditText) findViewById(R.id.etTextWatcher);
        tvTest = (TextView) findViewById(R.id.tvTextWatcher);
        etTextWatcher.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {
               tvTest.setText(s.toString().trim()+"");
           }
        });
    }
}
