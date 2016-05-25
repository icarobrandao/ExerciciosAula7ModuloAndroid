package com.exemple.icarobrandao.aula7.helpers;

/**
 * Created by icarobrandao on 21/05/16.
 */
public class DBSQLStrings {

    public static final String CREATE_USER =
            "CREATE TABLE users (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "email TEXT)";

    public static final  String DROP_USER = "DROP TABLE IF EXISTS users";

}
