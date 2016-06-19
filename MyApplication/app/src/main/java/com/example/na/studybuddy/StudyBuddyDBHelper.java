package com.example.na.studybuddy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

import static com.example.na.studybuddy.StudyBuddyDatabase.*;

/**
 * Created by Naema Ahmed on 4/9/2016.
 */
public class StudyBuddyDBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "StudyBuddy.db";
    private static final String TABLE_USERS = "users";
    public static final String COLUMN_userID = "userID";
    public static final String COLUMN_email = "email";
    public static final String COLUMN_password = "password";

    public StudyBuddyDBHelper(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " +
                TABLE_USERS + "("
                + COLUMN_userID + " INTEGER PRIMARY KEY," + COLUMN_email
                + " TEXT," + COLUMN_password + " INTEGER" + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }
    public void addUSER(StudyBuddyDatabase StudyBuddyDatabase) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_email, StudyBuddyDatabase.get_email());
        values.put(COLUMN_password, StudyBuddyDatabase.get_password());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_USERS, null, values);
        db.close();
    }
    public StudyBuddyDatabase findUser(String email) {
        String query = "Select * FROM " + TABLE_USERS + " WHERE " + COLUMN_email + " =  \"" + email + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        StudyBuddyDatabase User = new StudyBuddyDatabase();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            User.set_userID(cursor.getString(0));
            User.set_email(cursor.getString(1));
            User.set_password(cursor.getString(2));
            cursor.close();
        } else {
            User = null;
        }
        db.close();
        return User;
    }
}
