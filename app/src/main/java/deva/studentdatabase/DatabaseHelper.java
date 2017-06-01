package deva.studentdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 * Created by Devashish Katoriya on 01-06-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Student.db";
    private static final String TABLE_NAME = "student_table";
    private static final String COL1 = "Roll";
    private static final String COL2 = "Name";
    private static final String COL3 = "Marks";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        SQLiteDatabase database = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (Roll INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT, Marks INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
