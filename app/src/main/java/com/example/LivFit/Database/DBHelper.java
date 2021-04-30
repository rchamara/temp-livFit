package com.example.LivFit.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="LivFit";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String table1=
                "CREATE TABLE "+HealthMaster.Workout.TABLE_NAME+"("+
                        HealthMaster.Workout._ID+" INTEGER PRIMARY KEY,"+
                        HealthMaster.Workout.COLUMN_NAME_WORKOUTNAME+" TEXT,"+
                        HealthMaster.Workout.COLUMN_NAME_CALPMIN+" INTEGER,"+
                        HealthMaster.Workout.COLUMN_NAME_IMAGE+" BLOB)";

        String table2=
                "CREATE TABLE "+HealthMaster.User.TABLE_NAME+"("+
                        HealthMaster.User._ID+"INTEGER PRIMARY KEY,"+
                        HealthMaster.User.COLUMN_NAME_USERNAME+"TEXT,"+
                        HealthMaster.User.COLUMN_NAME_PASSWORD+"TEXT,"+
                        HealthMaster.User.COLUMN_NAME_FNAME+"TEXT,"+
                        HealthMaster.User.COLUMN_NAME_LNAME+"TEXT,"+
                        HealthMaster.User.COLUMN_NAME_EMAIL+"TEXT,"+
                        HealthMaster.User.COLUMN_NAME_AGE+"INTEGER,"+
                        HealthMaster.User.COLUMN_NAME_WEIGHT+"REAL,"+
                        HealthMaster.User.COLUMN_NAME_HEIGHT+"REAL,"+
                        HealthMaster.User.COLUMN_NAME_TARGETWEIGHT+"REAL,"+
                        HealthMaster.User.COLUMN_NAME_GENDER+"TEXT,"+
                        HealthMaster.User.COLUMN_NAME_BMI+"REAL,"+
                        HealthMaster.User.COLUMN_NAME_CALGOAL+"INTEGER,"+
                        HealthMaster.User.COLUMN_NAME_CALCONSUMPTION+"INTEGER"+
                        HealthMaster.User.COLUMN_NAME_CALBURNED+"INTEGER,"+
                        HealthMaster.User.COLUMN_NAME_WATERCOUNT+"INTEGER)";

        String table3=
                "CREATE TABLE "+HealthMaster.Meals.TABLE_NAME+"("+
                        HealthMaster.Meals._ID+"INTEGER PRIMARY KEY,"+
                        HealthMaster.Meals.COLUMN_NAME_MEALNAME+"TEXT,"+
                        HealthMaster.Meals.COLUMN_NAME_CALORIES+"INTEGER)";

        String table4=
                "CREATE TABLE "+HealthMaster.Nutrition.TABLE_NAME+"("+
                        HealthMaster.Nutrition._ID+"INTEGER PRIMARY KEY,"+
                        HealthMaster.Nutrition.COLUMN_NAME_DATE+"TEXT,"+
                        HealthMaster.Nutrition.COLUMN_NAME_TOTCAL+"INTEGER,"+
                        HealthMaster.Nutrition.COLUMN_NAME_PROTEIN+"REAL,"+
                        HealthMaster.Nutrition.COLUMN_NAME_FAT+"REAL,"+
                        HealthMaster.Nutrition.COLUMN_NAME_CARB+"REAL,"+
                        HealthMaster.Nutrition.COLUMN_NAME_CHOLESTAROL+"REAL,"+
                        HealthMaster.Nutrition.COLUMN_NAME_FIBER+"REAL)";

        db.execSQL(table1);
        db.execSQL(table2);
        db.execSQL(table3);
        db.execSQL(table4);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
