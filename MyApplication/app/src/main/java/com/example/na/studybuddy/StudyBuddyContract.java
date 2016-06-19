package com.example.na.studybuddy;

import android.provider.BaseColumns;
/**
 * Created by Naema Ahmed on 4/9/2016.
 */
public final class StudyBuddyContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public StudyBuddyContract (){}

    /* Inner class that defines the table contents */
    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_USER_ID = "user_id";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_EMAIL = "email";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
                        UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        UserEntry.COLUMN_NAME_USER_ID + " INTEGER," +
                        UserEntry.COLUMN_NAME_PASSWORD + " INTEGER," +
                        UserEntry.COLUMN_NAME_EMAIL + " INTEGER," +
                        " FOREIGN KEY (" + UserEntry.COLUMN_NAME_USER_ID + ") REFERENCES " +
                        UserEntry.TABLE_NAME + "(_ID)," +
                        " FOREIGN KEY (" + UserEntry.COLUMN_NAME_PASSWORD+ ") REFERENCES " +
                        UserEntry.TABLE_NAME + "(_ID)" +
                        " )";

        public static final String SQL_DELETE_TABLE =
                "DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME;
    }

    public static abstract class LiveEntry implements BaseColumns {
        public static final String TABLE_NAME = "livedata";
        public static final String COLUMN_NAME_USER_ID = "user_id";
        public static final String COLUMN_NAME_CLASSCODE = "classcode";
        public static final String COLUMN_NAME_LOCATION = "location";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
                        LiveEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        LiveEntry.COLUMN_NAME_USER_ID + " INTEGER," +
                        LiveEntry.COLUMN_NAME_CLASSCODE + " INTEGER," +
                        LiveEntry.COLUMN_NAME_LOCATION + " INTEGER," +
                        " FOREIGN KEY (" + LiveEntry.COLUMN_NAME_USER_ID + ") REFERENCES " +
                        LiveEntry.TABLE_NAME + "(_ID)," +
                        " FOREIGN KEY (" + LiveEntry.COLUMN_NAME_CLASSCODE+ ") REFERENCES " +
                        LiveEntry.TABLE_NAME + "(_ID)" +
                        " )";

        public static final String SQL_DELETE_TABLE =
                "DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME;
    }
}
