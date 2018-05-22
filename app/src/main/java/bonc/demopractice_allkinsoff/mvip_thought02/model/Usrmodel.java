package bonc.demopractice_allkinsoff.mvip_thought02.model;

import bonc.demopractice_allkinsoff.mvip_thought02.Bean.UserBean;

/**
 * Created by chenjie on 2017/5/3.
 * TODO：
 */

public class Usrmodel implements InterfaceUnsrmodel{
    String Name;
    String Psw;
    @Override
    public void httpRequest(String name, String psw) {
        UserBean user = new UserBean(name, psw);
    }

    @Override
    public void parseResult() {

    }
}
