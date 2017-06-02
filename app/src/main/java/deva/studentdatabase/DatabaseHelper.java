package deva.studentdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/*
 * Created by Devashish Katoriya on 01-06-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Student.db";
    private static final String TABLE_NAME = "student_table";
    private static final String COL1 = "Roll";
    private static final String COL2 = "Name";
    private static final String COL3 = "Marks";

    private SQLiteDatabase database;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( "
                + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL2 + " TEXT,"
                + COL3 + " INTEGER"
                + " ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insert(int Roll,String Name,int Marks)
    {
        database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1,Roll);
        cv.put(COL2,Name);
        cv.put(COL3,Marks);
        long result = database.insert(TABLE_NAME,null,cv);

        /* ALTERNATE WAY
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(" + Roll + ", '" + Name + "' ," + Marks + ")");
        */

        if(result==-1)
            return false;
        else
            return true;
    }

    public int delete(String Name)
    {
        String whereClause = COL2 + "=?";
        String []whereArgs = new String[]{Name};
        database = this.getWritableDatabase();

        int rowsDeleted = database.delete(TABLE_NAME,whereClause,whereArgs);
        return rowsDeleted;
    }

    public int update(int oldRoll,String newName,int newMarks)
    {
        String whereClause = COL1 + "=?";
        String []whereArgs = new String[]{oldRoll+""};
        database = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL1,oldRoll);
        cv.put(COL2,newName);
        cv.put(COL3,newMarks);

        int rowsUpdated = database.update(TABLE_NAME,cv,whereClause,whereArgs);
        return rowsUpdated;
    }
}
