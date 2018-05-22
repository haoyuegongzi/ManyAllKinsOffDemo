package bonc.demopractice_allkinsoff.mvip_thought02.presenter;

import android.util.Log;

import bonc.demopractice_allkinsoff.mvip_thought02.model.InterfaceUnsrmodel;
import bonc.demopractice_allkinsoff.mvip_thought02.model.Usrmodel;
import bonc.demopractice_allkinsoff.mvip_thought02.view.UserMsg;

import static android.R.attr.name;

/**
 * Created by chenjie on 2017/5/3.
 * TODO：
 */

public class UserMsgPresenter {
    private UserMsg mUserMsg;
    private InterfaceUnsrmodel mUnsrmodel;

    public UserMsgPresenter(UserMsg mUserMsg){
        this.mUserMsg = mUserMsg;
        this.mUnsrmodel = new Usrmodel();
    }

    public boolean loginRequest(String Name, String Psw){
        Log.i(getClass().getName(),"loginRequest: " + Name + "//////" + Psw);
        if("1".equals(name) && "2".equals(Psw)){
            mUnsrmodel.httpRequest(Name, Psw);
            return true;
        }else{
            return false;
        }
    }
}
