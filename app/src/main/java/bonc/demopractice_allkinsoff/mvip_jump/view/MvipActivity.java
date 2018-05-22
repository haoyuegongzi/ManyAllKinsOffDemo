package bonc.demopractice_allkinsoff.mvip_jump.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.mvip_jump.presenter.MainPresenter;

public class MvipActivity extends Activity implements View.OnClickListener, MainViewInterface{
    private EditText id;
    private EditText password;
    private Button saveBtn;
    private Button showId;
    private MainPresenter mainPresenter;

    private void assignViews() {
        id = (EditText) findViewById(R.id.id);
        password = (EditText) findViewById(R.id.password);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        showId = (Button) findViewById(R.id.showId);

        mainPresenter = new MainPresenter(this);
        mainPresenter.setMainViewInterface(this);
        saveBtn.setOnClickListener(this);
        showId.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        assignViews();
    }

    @Override
    public void setId(String id) {
        Toast.makeText(this, "用户账号：" + id, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPassword(String password) {
        Log.i("px password", "" + password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.saveBtn:
                mainPresenter.saveDatas(this, id.getText().toString().trim(), password.getText().toString().trim());
                Toast.makeText(this,"保存成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.showId:
                mainPresenter.loadDatas();
                break;
        }
    }
}
