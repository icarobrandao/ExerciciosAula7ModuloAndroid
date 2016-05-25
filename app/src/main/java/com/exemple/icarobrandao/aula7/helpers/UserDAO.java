package com.exemple.icarobrandao.aula7.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.exemple.icarobrandao.aula7.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by icarobrandao on 21/05/16.
 */
public class UserDAO {
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String TABLE_NAME = "users";

    private DbHelper dbHelper;

    public UserDAO(Context context) {
        dbHelper= new DbHelper(context);
    }

    public void add(User user) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getNome());
        values.put(COLUMN_EMAIL, user.getEmail());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        user.setId(db.insert(TABLE_NAME, null, values));
        db.close();
    }

    public void update(User user){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getNome());
        values.put(COLUMN_EMAIL, user.getEmail());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.update(TABLE_NAME, values, "_id=?", new String[]{user.getId().toString()});
        db.close();
    }

    public void remove(User user){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TABLE_NAME, "_id=?", new String[] {user.getId().toString()});
        db.close();
    }

    public List<User> getAll(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, "_id ASC");
                List<User> results = new ArrayList<>();
        try{
            while(c.moveToNext()){
                User user = new User();
                user.setId(c.getLong(c.getColumnIndex(COLUMN_ID)));
                user.setNome(c.getString(c.getColumnIndex(COLUMN_NAME)));
                user.setEmail(c.getString(c.getColumnIndex(COLUMN_EMAIL)));
                results.add(user);
            }
        }finally {
            c.close();
        }
        db.close();
        return results;
    }

}
