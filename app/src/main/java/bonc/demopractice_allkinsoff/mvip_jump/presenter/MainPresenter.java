package bonc.demopractice_allkinsoff.mvip_jump.presenter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import bonc.demopractice_allkinsoff.mvip_jump.bean.DBHelper;
import bonc.demopractice_allkinsoff.mvip_jump.bean.UserBean;
import bonc.demopractice_allkinsoff.mvip_jump.moudle.MainModel;
import bonc.demopractice_allkinsoff.mvip_jump.moudle.MainModelInterface;
import bonc.demopractice_allkinsoff.mvip_jump.view.MainViewInterface;

/**
 * Created by 10840 on 2015/12/26.
 */
public class MainPresenter {
    private Context context;
    private MainViewInterface mainViewInterface;
    private MainModelInterface mainModelInterface;
    private SQLiteDatabase db;
    private String tableName = "";

    public MainPresenter(Context context){
        this.context = context;
        mainModelInterface  = new MainModel();
        tableName = "user_info";
        db = DBHelper.openOrCreateDatabase(context,"user");
    }

    public void setMainViewInterface(MainViewInterface mainViewInterface) {
        this.mainViewInterface = mainViewInterface;
    }

    public void saveDatas(Context context, String id, String password){
        mainModelInterface.createTable(db, tableName);
        mainModelInterface.saveIdAndPassword(db, tableName, id, password);
    }

    public void loadDatas(){
        UserBean userBean = mainModelInterface.getUserBean(db,tableName);
        mainViewInterface.setId(userBean.getUserId());
        mainViewInterface.setPassword(userBean.getUserPassword());
    }
}
