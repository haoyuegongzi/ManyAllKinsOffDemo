package bonc.demopractice_allkinsoff.mvip_thought01.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.mvip_jump.LoginSuccessActivity;
import bonc.demopractice_allkinsoff.mvip_thought01.moudle.InterfaceLoginMsg;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MvpOneActivity extends AppCompatActivity implements InterfaceLoginResult {
/********************************************************************************/
    @BindView(R.id.etUserName)EditText mEtUserName;
    @BindView(R.id.etUserPsw)EditText mEtUserPsw;
    @BindView(R.id.btLogin)Button mBtLogin;

    private InterfaceLoginMsg mLoginMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_one);
        ButterKnife.bind(this);
    }

    @Override
    public void loginError(String error) {
        Toast.makeText(MvpOneActivity.this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess(String response) {
        if ("ok".equals(response)) {
            startActivity(new Intent(MvpOneActivity.this, LoginSuccessActivity.class));
        }
    }

    @OnClick(R.id.btLogin)
    public void onViewClicked() {
        String name = mEtUserName.getText().toString();
        String psw = mEtUserPsw.getText().toString();
        if (!name.isEmpty() && !psw.isEmpty()) {
            mLoginMsg.getLoginMsg(name, psw);
        }else{
            Toast.makeText(MvpOneActivity.this, "账号或密码为空", Toast.LENGTH_LONG).show();
        }
    }
}
