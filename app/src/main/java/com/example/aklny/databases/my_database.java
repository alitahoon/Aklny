package com.example.aklny.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.aklny.objects.meals;
import com.example.aklny.objects.user;

import java.util.ArrayList;

public class my_database extends SQLiteOpenHelper {
    public static final String DB_Name = "Aklny_database";
    public static final int DB_Verion = 1;
    public static final String meal_tb_name = "meal";
    public static final String meal_cln_name = "name";
    public static final String meal_cln_rate = "rate";
    public static final String meal_cln_details = "details";
    public static final String meal_cln_id = "id";
    public static final String meal_cln_image = "image";
    public static final String fav_meal_tb_name = "fav_meal";
    public static final String fav_meal_cln_name = "name";
    public static final String fav_meal_cln_rate = "rate";
    public static final String fav_meal_cln_details = "details";
    public static final String fav_meal_cln_id = "id";
    public static final String fav_meal_cln_image = "image";
    public static final String user_tb_name = "user";
    public static final String user_cln_username = "username";
    public static final String user_cln_password = "password";
    public static final String user_cln_location = "location";
    public static final String user_cln_phone = "phone";
    public static final String user_cln_favourites = "favourites";
    public static final String user_cln_image = "image";

    public my_database(@Nullable Context context) {
        super(context, DB_Name, null, DB_Verion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT ,%s TEXT,%s INT,%s INT,%s TEXT)", meal_tb_name, meal_cln_details, meal_cln_rate, meal_cln_image, meal_cln_name));
        sqLiteDatabase.execSQL(String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT ,%s TEXT,%s INT,%s INT,%s TEXT)", fav_meal_tb_name, fav_meal_cln_details, fav_meal_cln_rate, fav_meal_cln_image, fav_meal_cln_name));
        sqLiteDatabase.execSQL(String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY,%s TEXT,%s INT,%s INT,%s TEXT,%s TEXT)", user_tb_name, user_cln_username, user_cln_location, user_cln_image, user_cln_favourites, user_cln_password, user_cln_phone));

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(String.format("DROP Table %s if exist", meal_tb_name));
        sqLiteDatabase.execSQL(String.format("DROP Table %s if exist", fav_meal_tb_name));
        sqLiteDatabase.execSQL(String.format("DROP Table %s if exist", user_tb_name));
        onCreate(sqLiteDatabase);
    }

    //handle insert new Meal
    public boolean insertNewMeal(meals meal) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(meal_cln_name, meal.getName());
        cv.put(meal_cln_image, meal.getImg());
        cv.put(meal_cln_details, meal.getDetails());
        cv.put(meal_cln_rate, meal.getRate());
        long l = db.insert(meal_tb_name, null, cv);
        return l != -1;
    }

    //handle insert new Favourite Meal
    public boolean insertNewFavouroteMeal(meals meal) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(fav_meal_cln_name, meal.getName());
        cv.put(fav_meal_cln_image, meal.getImg());
        cv.put(fav_meal_cln_details, meal.getDetails());
        cv.put(fav_meal_cln_rate, meal.getRate());
        long l = db.insert(fav_meal_tb_name, null, cv);
        return l != -1;
    }

    //handle insert new user
    public boolean insertNewUser(user user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(user_cln_username, user.getUsername());
        cv.put(user_cln_password, user.getPassword());
        cv.put(user_cln_image, user.getImg());
        cv.put(user_cln_location, user.getLocation());
        cv.put(user_cln_phone, user.getPhone());
        cv.put(user_cln_favourites, user.getFavourite());
        long l = db.insert(user_tb_name, null, cv);
        return l != -1;
    }

    //select all meals from database
    public ArrayList<meals> getMeals() throws SQLException {
        ArrayList<meals> m_list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursorMeals = db.rawQuery("SELECT * FROM " + meal_tb_name, null);
        if (cursorMeals.moveToFirst()) {
            do {
                m_list.add(new meals(cursorMeals.getString(4), cursorMeals.getInt(3)
                        , cursorMeals.getString(1), cursorMeals.getInt(2), cursorMeals.getInt(0), "none"));
            } while (cursorMeals.moveToNext());
        }
        cursorMeals.close();
        return m_list;
    }

    //select specifq meals from database
    public ArrayList<meals> getMeals(String regin) throws SQLException {
        ArrayList<meals> m_list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursorMeals = db.rawQuery(String.format("SELECT * FROM %s WHERE %s LIKE %s", meal_tb_name, meal_cln_name, regin), null);
        if (cursorMeals.moveToFirst()) {
            do {
                m_list.add(new meals(cursorMeals.getString(4), cursorMeals.getInt(3)
                        , cursorMeals.getString(1), cursorMeals.getInt(2), cursorMeals.getInt(0), "none"));
            } while (cursorMeals.moveToNext());
        }
        cursorMeals.close();
        return m_list;
    }

    //select specifq meals from database
    public ArrayList<meals> getMealsWithid(int num1, int num2) throws SQLException {
        ArrayList<meals> m_list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursorMeals = db.rawQuery("SELECT * FROM " + meal_tb_name + " WHERE " + meal_cln_id + " BETWEEN " + num1 + " AND " + num2, null);
        if (cursorMeals.moveToFirst()) {
            do {
                m_list.add(new meals(cursorMeals.getString(4), cursorMeals.getInt(3)
                        , cursorMeals.getString(1), cursorMeals.getInt(2), cursorMeals.getInt(0), "none"));
            } while (cursorMeals.moveToNext());
        }
        cursorMeals.close();
        return m_list;
    }

    //select row data with id
    public meals getMealsWithid(int id) throws SQLException {
        meals m = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursorMeals = db.rawQuery("SELECT * FROM " + meal_tb_name + " WHERE " + meal_cln_id + " = " + id, null);
        if (cursorMeals.moveToFirst()) {
            do {
                m = new meals(cursorMeals.getString(4), cursorMeals.getInt(3)
                        , cursorMeals.getString(1), cursorMeals.getInt(2), cursorMeals.getInt(0), "none");
            } while (cursorMeals.moveToNext());
        }
        cursorMeals.close();
        return m;
    }

    //handle insert new Meal
    public boolean insertNewFavMeal(meals meal) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(fav_meal_cln_name, meal.getName());
        cv.put(fav_meal_cln_image, meal.getImg());
        cv.put(fav_meal_cln_details, meal.getDetails());
        cv.put(fav_meal_cln_rate, meal.getRate());
        long l = db.insert(fav_meal_tb_name, null, cv);
        return l != -1;
    }

    //select all meals from database
    public ArrayList<meals> getFavMeals() throws SQLException {
        ArrayList<meals> m_list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursorMeals = db.rawQuery("SELECT * FROM " + fav_meal_tb_name, null);
        if (cursorMeals.moveToFirst()) {
            do {
                m_list.add(new meals(cursorMeals.getString(4), cursorMeals.getInt(3)
                        , cursorMeals.getString(1), cursorMeals.getInt(2), cursorMeals.getInt(0), "none"));
            } while (cursorMeals.moveToNext());
        }
        cursorMeals.close();
        return m_list;
    }
    public meals getFavMealsWithid(int id) throws SQLException {
        meals m = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursorMeals = db.rawQuery("SELECT * FROM " + fav_meal_tb_name + " WHERE " + fav_meal_cln_id + " = " + id, null);
        if (cursorMeals.moveToFirst()) {
            do {
                m = new meals(cursorMeals.getString(4), cursorMeals.getInt(3)
                        , cursorMeals.getString(1), cursorMeals.getInt(2), cursorMeals.getInt(0), "none");
            } while (cursorMeals.moveToNext());
        }
        cursorMeals.close();
        return m;
    }
}


