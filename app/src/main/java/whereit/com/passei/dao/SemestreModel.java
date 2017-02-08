package whereit.com.passei.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import whereit.com.passei.interfaces.SqlDatabase;
import whereit.com.passei.model.Semestre;

/**
 * Created by Desenvolvimento on 07/02/17.
 */

public class SemestreModel extends SQLiteOpenHelper implements SqlDatabase {

    private static final String TABLE = "Semestres";



    public SemestreModel(Context c){

        super(c,DATABASE,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + " (semestre INTEGER PRIMARY KEY, userId INTEGER) ");
        Log.i("onCreate", "Create");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        Log.i("onUpgrade", "Upgrade");
    }

    public long insert(Semestre semestre){
        try{

            SQLiteDatabase db = this.getWritableDatabase();
            this.onCreate(db);
            ContentValues contentValues = new ContentValues();
            contentValues.put("semestre",semestre.getSemestre());
            contentValues.put("userId",semestre.getUserId());
            long sem = db.insert(TABLE,null,contentValues);
            return sem;
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public List<Semestre> select(String select, String where, String order, String limit){
        List<Semestre> semestreList = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            this.onCreate(db);
            String query = "SELECT " + select + "FROM " + TABLE + " ";

            if(where != null){
                query += "WHERE " + where + " ";
            }
            if(order != null){
                query += " ORDER BY " + order + " ";
            }

            if(limit != null){
                query += " LIMIT " + limit;
            }

            Cursor c = db.rawQuery(query,null);

            if(c.moveToFirst()){

                do {
                    Semestre semestre = new Semestre(c.getInt(c.getColumnIndex("semestre")), c.getInt(c.getColumnIndex("userId")));
                    semestreList.add(semestre);
                }
                while (c.moveToNext());
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }

        return semestreList;
    }

}
