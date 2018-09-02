package com.example.abhishek.assigmentproject;

/**
 * Created by ABHISHEK on 9/23/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DBOpenHelper extends SQLiteOpenHelper {
    static DBOpenHelper dbOpenHelper;

    /*create table user(
    id integer auto increment primary key,
    name text,
    email text,
    password text);
     */

    String create_query_asset = "create table " + DBConstants.TABLE_NAME_ASSET + "(" +
            DBConstants.asset_assetId + " integer primary key autoincrement," +
            DBConstants.asset_allocatedTo + " text," +
            DBConstants.asset_assetMake + " text," +
            DBConstants.asset_allocatedTill + " text," +
            DBConstants.asset_yearOfMaking + " text);";

    String create_query_employee = "create table " + DBConstants.TABLE_NAME_EMPLOYEE + "(" +
            DBConstants.employee_empId + " integer primary key autoincrement," +
            DBConstants.employee_empName + " text," +
            DBConstants.employee_emailId + " text," +
            DBConstants.employee_phoneNumber + " text," +
            DBConstants.employee_unit + " text);";




    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        dbOpenHelper=this;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_query_asset);
        db.execSQL(create_query_employee);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists '" +DBConstants.TABLE_NAME_ASSET+"'");
        db.execSQL("drop table if exists '" +DBConstants.TABLE_NAME_EMPLOYEE+"'");
        db.execSQL(create_query_asset);
        db.execSQL(create_query_employee);
    }

    /*public ArrayList<ArrayList> getAllEmployees() {

        ArrayList<ArrayList> resultSet = new ArrayList<ArrayList>();

        //hp = new HashMap();


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+DBConstants.TABLE_NAME_EMPLOYEE, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            ArrayList<String> attributes=new ArrayList<String>();
            attributes.add(Integer.toString(res.getInt(res.getColumnIndex(DBConstants.employee_empId))));
            attributes.add(res.getString(res.getColumnIndex(DBConstants.employee_emailId)));
            attributes.add(res.getString(res.getColumnIndex(DBConstants.employee_empName)));
            attributes.add(res.getString(res.getColumnIndex(DBConstants.employee_unit)));
            attributes.add(res.getString(res.getColumnIndex(DBConstants.employee_phoneNumber)));

            resultSet.add(attributes);
            res.moveToNext();
        }
        return resultSet;
    }*/

    public ArrayList<EmployeeBean> getAllEmployees() {

        ArrayList<EmployeeBean> resultSet = new ArrayList<EmployeeBean>();

        //hp = new HashMap();


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+DBConstants.TABLE_NAME_EMPLOYEE, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            EmployeeBean eb=new EmployeeBean();
            eb.setEmpid(res.getInt(res.getColumnIndex(DBConstants.employee_empId)));
            eb.setEmailid(res.getString(res.getColumnIndex(DBConstants.employee_emailId)));
            eb.setEmpName(res.getString(res.getColumnIndex(DBConstants.employee_empName)));
            eb.setUnit(res.getString(res.getColumnIndex(DBConstants.employee_unit)));
            eb.setPhoneNumber(res.getString(res.getColumnIndex(DBConstants.employee_phoneNumber)));

            resultSet.add(eb);
            res.moveToNext();
        }
        return resultSet;
    }


    public String[] getAllSpinnerContent(){

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "Select "+DBConstants.employee_empId+" from "+DBConstants.TABLE_NAME_EMPLOYEE;
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if(cursor.moveToFirst()){
            do{
                String word = Integer.toString(cursor.getInt(cursor.getColumnIndex(DBConstants.employee_empId)));
                spinnerContent.add(word);
            }while(cursor.moveToNext());
        }
        cursor.close();

        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);

        return allSpinner;
    }

    public ArrayList<AssetBean> getAllAssets() {

        ArrayList<AssetBean> resultSet = new ArrayList<AssetBean>();

        //hp = new HashMap();


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+DBConstants.TABLE_NAME_ASSET, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            AssetBean ab=new AssetBean();
            ab.setAssetid(res.getInt(res.getColumnIndex(DBConstants.asset_assetId)));
            ab.setAssetMake(res.getString(res.getColumnIndex(DBConstants.asset_assetMake)));
            ab.setAllocatedTo(res.getString(res.getColumnIndex(DBConstants.asset_allocatedTo)));
            ab.setAllocatedTill(res.getString(res.getColumnIndex(DBConstants.asset_allocatedTill)));
            ab.setYearOfMaking(res.getString(res.getColumnIndex(DBConstants.asset_yearOfMaking)));

            resultSet.add(ab);
            res.moveToNext();
        }
        return resultSet;
    }

}
