package com.exemple.icarobrandao.aula7.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by icarobrandao on 21/05/16.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME ="app_db";
    private static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBSQLStrings.CREATE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBSQLStrings.DROP_USER);
        onCreate(db);

    }
}
