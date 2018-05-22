package bonc.demopractice_allkinsoff.mvip_thought01;

import bonc.demopractice_allkinsoff.mvip_thought01.view.InterfaceLoginResult;

/**
 * Created by chenjie on 2017/5/2.
 * TODO：
 */

public class LoginParsing{
/********************************************/
    private InterfaceLoginResult mLoginResult;
    private String RequestResult;
    public LoginParsing(String result){
        RequestResult = result;
    }

    public void parsingRequestRuslt(){
        InterfaceLoginParsing parsing = new InterfaceLoginParsing() {
            @Override
            public void parsingRequestRuslt() {
                /**
                 * 在这里解析数据
                 * 然后更新UI
                 */
                if("123".equals(RequestResult)){
                    mLoginResult.loginSuccess(RequestResult);
                }
            }
        };
    }
}
