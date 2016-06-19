package com.example.na.studybuddy;

/**
 * Created by na on 4/9/2016.
 */
public class StudyBuddyDatabase {
    private String _userID;
    private String _email;
    private String _password;

    public StudyBuddyDatabase() {

    }

    public StudyBuddyDatabase(String UserID, String email , String password) {
        this._userID = UserID;
        this._email = email;
        this._password = password;
    }

    public  StudyBuddyDatabase(String UserID, String email) {
        this._userID = _userID;
        this._email = email;
    }

    public void set_userID(String UserID) {
        this._userID = _userID;
    }

    public String get_userID() {
        return this._userID;
    }

    public void set_email(String email) {
        this._email = email;
    }

    public String get_email() {
        return this._email;
    }

    public void set_password(String password) {
        this._password = password;
    }

    public String get_password() {
        return this._password;
    }
}


