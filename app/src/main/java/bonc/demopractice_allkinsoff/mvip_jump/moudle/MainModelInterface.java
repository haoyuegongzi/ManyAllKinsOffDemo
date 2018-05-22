package bonc.demopractice_allkinsoff.mvip_jump.moudle;

import android.database.sqlite.SQLiteDatabase;

import bonc.demopractice_allkinsoff.mvip_jump.bean.UserBean;

/**
 * Created by 10840 on 2015/12/26.
 */
public interface MainModelInterface {
    void createTable(SQLiteDatabase db, String tableName);
    void saveIdAndPassword(SQLiteDatabase db, String tableName, String id, String password);
    UserBean getUserBean(SQLiteDatabase db, String tableName);
}
