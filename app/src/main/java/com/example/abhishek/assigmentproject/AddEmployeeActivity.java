package com.example.abhishek.assigmentproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class AddEmployeeActivity extends AppCompatActivity {

    EditText name;
    EditText emailid;
    EditText phone;
    EditText unit;
    Button add;
    EmployeeBean employee;
    DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        name=(EditText) findViewById(R.id.name);
        emailid=(EditText) findViewById(R.id.emailId);
        phone=(EditText) findViewById(R.id.phone);
        unit=(EditText) findViewById(R.id.unit);



        dbManager =new DBManager(this);
        add=(Button)findViewById(R.id.employeeadd);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                employee=new EmployeeBean();
                employee.setEmailid(emailid.getText().toString());
                employee.setEmpName(name.getText().toString());
                employee.setPhoneNumber(phone.getText().toString());
                employee.setUnit(unit.getText().toString());
                long rowId= dbManager.saveDataEmployee(employee);
                if(rowId>0){
                    Toast.makeText(getApplicationContext(),"successfully inserted at row " + rowId,Toast.LENGTH_SHORT).show();}
                else {
                    Toast.makeText(getApplicationContext(),"unable to insert " + rowId,Toast.LENGTH_SHORT).show();
                }

                /*ArrayList<ArrayList> resultset=new ArrayList<ArrayList>();

                resultset=DBOpenHelper.dbOpenHelper.getAllEmployees();
                Iterator<ArrayList> iteratorrs = resultset.iterator();
                while (iteratorrs.hasNext()) {
                    Iterator<String> iterator2 = iteratorrs.next().iterator();
                    String str="";
                    while (iterator2.hasNext()) {
                        str=str+","+iterator2.next();
                    }
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                }*/

                ArrayList<EmployeeBean> resultset=new ArrayList<EmployeeBean>();

                resultset=DBOpenHelper.dbOpenHelper.getAllEmployees();
                Iterator<EmployeeBean> iterator = resultset.iterator();
                while (iterator.hasNext()) {

                    EmployeeBean eb=new EmployeeBean();
                    eb=iterator.next();
                    String str=eb.getEmpid()+","+eb.getEmailid()+","+eb.getEmpName()+","+eb.getUnit()+","+eb.getPhoneNumber();
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                }

            }


        });

    }
}
