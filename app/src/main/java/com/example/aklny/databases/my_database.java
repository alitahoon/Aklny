package com.example.aklny.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.aklny.objects.meals;

public class my_database extends SQLiteOpenHelper {
    public static final String DB_Name="Aklny_database";
    public static final int DB_Verion=1;
    public static final String meal_tb_name="meal";
    public static final String meal_cln_name="name";
    public static final String meal_cln_rate="rate";
    public static final String meal_cln_details="details";
    public static final String meal_cln_id="id";
    public static final String meal_cln_image="image";

    public my_database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_Name, null, DB_Verion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(String.format("CREATE TABEL%s INT ID PRIMERY KEY AUTOINCRMENT ,%s TEXT,%s INT,%s INT,%s TEXT", meal_tb_name, meal_cln_details, meal_cln_rate, meal_cln_image, meal_cln_name));

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(String.format("DROP Tabel%s if exist", meal_tb_name));
        onCreate(sqLiteDatabase);
    }
    public boolean insertNewMeal(meals meal){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();

        db.insert(meal_tb_name,null,)
    }
}
