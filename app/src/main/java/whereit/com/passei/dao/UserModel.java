package whereit.com.passei.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Map;

import whereit.com.passei.interfaces.SqlDatabase;
import whereit.com.passei.model.User;

/**
 * Created by Desenvolvimento on 01/02/17.
 *
 * Model da Tabela Usuário
 */


public class UserModel extends SQLiteOpenHelper implements SqlDatabase{

    private static final String TABLE = "User";


    public UserModel(Context c){

        super(c,DATABASE,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, user VARCHAR(50), curso VARCHAR(50)) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
    }

    public long insert(User user){

        try {
            SQLiteDatabase db = this.getWritableDatabase();
            onCreate(db);
            ContentValues contentValues = new ContentValues();
            contentValues.put("user", user.getUser());
            contentValues.put("curso", user.getCurso());
            long id = db.insert(TABLE, null, contentValues);
            db.close();
            return id;
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    public User select(String select, String where, String order, String limit){
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            onCreate(db);
            String query = "SELECT " + select + " FROM " + TABLE;

            if(where != null) {
                query += " WHERE " + where + " ";
            }

            if(order != null){
                query += " ORDER BY " + order + " ";
            }

            if(limit != null){
                query += " LIMIT " + limit;
            }

            Cursor c = db.rawQuery(query, null);

            if(c != null){
                c.moveToFirst();
            }

            User user = new User(c.getInt(c.getColumnIndex("id")), c.getString(c.getColumnIndex("user")), c.getString(c.getColumnIndex("curso")));
            return user;

        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public int update(String where, Map<String, String> values){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            onCreate(db);
            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < values.size(); i++) {
                contentValues.put(values.keySet().toArray()[i].toString(), values.get(values.keySet().toArray()[i].toString()));
            }
            return db.update(TABLE, contentValues, where, null);
        }
        catch (Exception e){
            return 0;
        }
    }

}
