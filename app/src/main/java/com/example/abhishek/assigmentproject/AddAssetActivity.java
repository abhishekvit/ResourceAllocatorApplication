package com.example.abhishek.assigmentproject;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class AddAssetActivity extends AppCompatActivity {

    Button add;

    EditText make;
    EditText year;
    Spinner allocateTo;
    EditText allocateTill;
    DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_asset);

        Spinner spinner = (Spinner) findViewById(R.id.allocateTo);
        DBOpenHelper dbOpenHelper = new DBOpenHelper(AddAssetActivity.this,DBConstants.DBNAME,null,DBConstants.DB_VERSION);
        String[] spinnerLists = dbOpenHelper.getAllSpinnerContent();

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(AddAssetActivity.this,android.R.layout.simple_spinner_item, spinnerLists);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                return;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dbManager=new DBManager(this);
        add=(Button) findViewById(R.id.addAsset);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                make=(EditText) findViewById(R.id.make);
                year=(EditText)findViewById(R.id.year);
                allocateTo=(Spinner) findViewById(R.id.allocateTo);
                //allocateTill=(EditText)findViewById(R.id.allocatetill);

                allocateTill=(EditText)findViewById(R.id.allocatetill);
                allocateTill.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatePickerDialog dp=new DatePickerDialog(AddAssetActivity.this,
                                new DatePickerDialog.OnDateSetListener()
                                {
                                    @Override
                                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                        allocateTill.setText(i);
                                    }

                                },2007,02,02);

                        dp.show();


                    }

                });




                Toast.makeText(getApplicationContext(),make.getText().toString()+year.getText().toString()+allocateTo.getSelectedItem().toString()+allocateTill.getText().toString(),Toast.LENGTH_SHORT).show();
                AssetBean ab=new AssetBean();
                ab.setAllocatedTill(allocateTill.getText().toString());
                ab.setAssetMake(make.getText().toString());
                ab.setAllocatedTo(allocateTo.getSelectedItem().toString());
                ab.setYearOfMaking(year.getText().toString());



                long rowId= dbManager.saveDataAsset(ab);
                if(rowId>0){
                    Toast.makeText(getApplicationContext(),"successfully inserted at row " + rowId,Toast.LENGTH_SHORT).show();}
                else {
                    Toast.makeText(getApplicationContext(),"unable to insert " + rowId,Toast.LENGTH_SHORT).show();
                }

                ArrayList<AssetBean> resultset=new ArrayList<AssetBean>();

                resultset=DBOpenHelper.dbOpenHelper.getAllAssets();
                Iterator<AssetBean> iterator = resultset.iterator();
                while (iterator.hasNext()) {

                    AssetBean ab1=new AssetBean();
                    ab1=iterator.next();
                    String str=ab1.getAssetid()+","+ab1.getAssetMake()+","+ab1.getAllocatedTo()+","+ab1.getAllocatedTill()+","+ab1.getYearOfMaking();
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                }


            }
        });
    }


}



