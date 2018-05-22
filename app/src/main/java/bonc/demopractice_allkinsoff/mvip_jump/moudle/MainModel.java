package bonc.demopractice_allkinsoff.mvip_jump.moudle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bonc.demopractice_allkinsoff.mvip_jump.bean.DBHelper;
import bonc.demopractice_allkinsoff.mvip_jump.bean.UserBean;

/**
 * Created by 10840 on 2015/12/26.
 */
public class MainModel implements MainModelInterface {

    @Override
    public void createTable(SQLiteDatabase db, String tableName) {
        if(!DBHelper.tableIsExist(db,tableName)){
            List<Map<String,String>> list = new ArrayList<>();
            Map<String,String> map_1 = new HashMap<>();
            map_1.put("DbFieldName","id");
            map_1.put("DbFieldTyple","VARCHAR");
            list.add(map_1);
            Map<String,String> map_2 = new HashMap<>();
            map_2.put("DbFieldName","password");
            map_2.put("DbFieldTyple","VARCHAR");
            list.add(map_2);
            DBHelper.createTable(db, tableName,list);
        }

        DBHelper.executeSQL(db, "DELETE FROM " + tableName);//��ձ�����
    }

    @Override
    public void saveIdAndPassword(SQLiteDatabase db, String tableName, String id, String password) {
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map_1 = new HashMap<>();
        map_1.put("DbFieldName","id");
        map_1.put("DbFieldNote", id);
        list.add(map_1);
        Map<String,String> map_2 = new HashMap<>();
        map_2.put("DbFieldName","password");
        map_2.put("DbFieldNote",password);
        list.add(map_2);
        DBHelper.insertDatas(db, tableName, list);
    }

    @Override
    public UserBean getUserBean(SQLiteDatabase db, String tableName) {
        UserBean userBean = new UserBean();
        Cursor cursor = DBHelper.getCursorByQuery(db,tableName);
        while (cursor.moveToNext()){
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            Log.i("px Id:", id + "");
            Log.i("px password:", password + "");
            userBean.setUserId(id);
            userBean.setUserPassword(password);
        }
        return userBean;
    }
}
