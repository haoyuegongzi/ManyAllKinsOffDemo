package bonc.demopractice_allkinsoff.mvip_thought02.Bean;

/**
 * Created by chenjie on 2017/5/3.
 * TODO：
 */

public class UserBean {
    private String sUserName;
    private String sUserPsw;

    public UserBean(String mUserName, String mUserPsw){
        sUserName = mUserName;
        sUserPsw = mUserPsw;
    }

    public String getsUserName(){
        return sUserName;
    }

    public String getsUserPsw(){
        return  sUserPsw;
    }
}
