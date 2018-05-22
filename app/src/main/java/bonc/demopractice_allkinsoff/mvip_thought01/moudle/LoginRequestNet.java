package bonc.demopractice_allkinsoff.mvip_thought01.moudle;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import bonc.demopractice_allkinsoff.mvip_thought01.LoginParsing;
import bonc.demopractice_allkinsoff.mvip_thought01.view.InterfaceLoginResult;

/**
 * Created by chenjie on 2017/5/2.
 * TODO：
 */

public class LoginRequestNet implements InterfaceLoginMsg {
    /******************************************/
    private InterfaceLoginResult mLoginResult;
    private LoginParsing mParsing;
    @Override
    public void getLoginMsg(final String sUserName, final String sUserPsw) {
        //模拟登陆过程
        String Url = "www.baidu.com";
        Log.i(getClass().getName(),"getLoginMsg + 1:");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(sUserName)){
                    mLoginResult.loginError("用户名异常");
                    error = true;
                    return;
                }
                if (TextUtils.isEmpty(sUserPsw)){
                    mLoginResult.loginError("密码异常");
                    error = true;
                    return;
                }
                if (!error){
                    mParsing = new LoginParsing("123");
                    mParsing.parsingRequestRuslt();
                    Log.i(getClass().getName(),"getLoginMsg + 2:" + error);
                }
                Log.i(getClass().getName(),"getLoginMsg + 3:" + error);
            }
        }, 2000);
    }
}