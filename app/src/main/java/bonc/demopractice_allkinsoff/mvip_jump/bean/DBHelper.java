package bonc.demopractice_allkinsoff.mvip_jump.bean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;
import java.util.Map;

/**
 * Created by 10840 on 2015/12/26.
 */
public class DBHelper {

    public static SQLiteDatabase openOrCreateDatabase(Context context, String dbName){
        SQLiteDatabase db = context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE,null);
        return db;
    }

    public static void createTable(SQLiteDatabase db, String tableName, List<Map<String,String>> list) {
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                Map<String, String> map = list.get(i);
                str += map.get("DbFieldName") + " ";
                if(i == list.size() -1){
                    str += map.get("DbFieldTyple");
                }else {
                    str += map.get("DbFieldTyple") + ",";
                }
            }
            db.execSQL("CREATE TABLE " + tableName + " (" + str + ")");
    }

    public static void executeSQL(SQLiteDatabase db, String sqlStr){
        db.execSQL(sqlStr);
    }

    public static void insertDatas(SQLiteDatabase db, String tableName, List<Map<String,String>> list){
        ContentValues contentValues = new ContentValues();
        for(int i = 0; i < list.size(); i++){
            Map<String,String> map = list.get(i);
            contentValues.put(map.get("DbFieldName"),map.get("DbFieldNote"));
        }

        db.insert(tableName, null, contentValues);
    }

    public static void deleteDatas(SQLiteDatabase db, String tableName, String whereClause, String[] whereArgs){
        db.delete(tableName, whereClause, whereArgs);
    }

    public static void updateDatas(SQLiteDatabase db, String tableName, List<Map<String,String>> list, String whereClause, String[] whereArgs){
        ContentValues contentValues = new ContentValues();
        for(int i = 0; i < list.size(); i++){
            Map<String,String> map = list.get(i);
            contentValues.put(map.get("DbFieldName"),map.get("DbFieldNote"));
        }
        db.update(tableName, contentValues, whereClause, whereArgs);
    }

    public static Cursor getCursorByQuery(SQLiteDatabase db, String tableName){
        Cursor cursor = db.query(tableName,null,null,null,null,null,null);
        return cursor;
    }

    public static Cursor getCursorByRawQuery(SQLiteDatabase db, String sqlStr, String[] array){
        Cursor cursor = db.rawQuery(sqlStr, array);
        return cursor;
    }
    public static boolean tableIsExist(SQLiteDatabase db, String tableName){
        boolean result = false;
        if(tableName == null){
            return false;
        }
        Cursor cursor = null;
        try {
            String sql = "select count(*) as c from Sqlite_master  where type ='table' and name ='"+tableName.trim()+"' ";
            cursor = db.rawQuery(sql, null);
            if(cursor.moveToNext()){
                int count = cursor.getInt(0);
                if(count>0){
                    result = true;
                }
            }
        } catch (Exception e) {
        }
        return result;
    }

}
