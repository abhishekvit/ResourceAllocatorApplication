package com.example.abhishek.assigmentproject;

/**
 * Created by ABHISHEK on 9/23/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBManager {
    DBOpenHelper dbOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DBManager(Context context){
        dbOpenHelper = new DBOpenHelper(context,DBConstants.DBNAME,null,DBConstants.DB_VERSION);
    }

    private void openDatabase(){

        sqLiteDatabase=dbOpenHelper.getWritableDatabase();
    }

    private void closeDatabase(){

        sqLiteDatabase.close();
    }
    public long saveDataAsset(AssetBean assetBean)
    {
        openDatabase();

        ContentValues values= new ContentValues();
        //values.put(DBConstants.asset_assetId, userBean.getAssetid());
        values.put(DBConstants.asset_allocatedTill, assetBean.getAllocatedTill());
        values.put(DBConstants.asset_allocatedTo, assetBean.getAllocatedTo());
        values.put(DBConstants.asset_assetMake, assetBean.getAssetMake());
        values.put(DBConstants.asset_yearOfMaking, assetBean.getYearOfMaking());

        long rowId= sqLiteDatabase.insert(DBConstants.TABLE_NAME_ASSET, null, values);

        closeDatabase();
        return rowId;
    }

    public long saveDataEmployee(EmployeeBean employeeBean)
    {
        openDatabase();

        ContentValues values= new ContentValues();

        values.put(DBConstants.employee_empName, employeeBean.getEmpName());
        values.put(DBConstants.employee_phoneNumber, employeeBean.getPhoneNumber());
        values.put(DBConstants.employee_emailId, employeeBean.getEmailid());
        values.put(DBConstants.employee_unit, employeeBean.getUnit());

        long rowId= sqLiteDatabase.insert(DBConstants.TABLE_NAME_EMPLOYEE, null, values);

        closeDatabase();
        return rowId;
    }


}

