package bonc.demopractice_allkinsoff.mvip_thought02.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.mvip_thought02.presenter.UserMsgPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MvpTwoActivity extends AppCompatActivity implements UserMsg{

    @BindView(R.id.etUserName)EditText mEtUserName;
    @BindView(R.id.etUserPsw)EditText mEtUserPsw;
    @BindView(R.id.btLogin)Button mBtLogin;

    private UserMsgPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_two);
        ButterKnife.bind(this);

        mPresenter = new UserMsgPresenter(this);
    }

    @OnClick(R.id.btLogin)
    public void onViewClicked() {
        Log.i(getClass().getName(), "onViewClicked");
        Log.i(getClass().getName(), mPresenter.loginRequest(getUserName(),getUserPsw()) + "");
        Log.i(getClass().getName(), getUserName() + "/************/" + getUserPsw() + "");
        if( !mPresenter.loginRequest(getUserName(),getUserPsw())){
            startActivity(new Intent(MvpTwoActivity.this, LoginSureActivity.class));
        }
    }

    @Override
    public String getUserName() {
        return mEtUserName.getText().toString() == null ? "" : mEtUserName.getText().toString();
    }

    @Override
    public String getUserPsw() {
        return mEtUserPsw.getText().toString() == null ? "" : mEtUserPsw.getText().toString();
    }
}
