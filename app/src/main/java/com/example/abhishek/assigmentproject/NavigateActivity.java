package com.example.abhishek.assigmentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NavigateActivity extends AppCompatActivity {

    Intent n1;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);

        b1=(Button) findViewById(R.id.addEmployee);
        b2=(Button)findViewById(R.id.ViewEmployee);
        b3=(Button)findViewById(R.id.addAsset);
        b4=(Button)findViewById(R.id.viewAsset);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1=new Intent(NavigateActivity.this,AddEmployeeActivity.class);
                startActivity(n1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1=new Intent(NavigateActivity.this,EmployeeViewActivity.class);
                startActivity(n1);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1=new Intent(NavigateActivity.this,AddAssetActivity.class);
                startActivity(n1);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1=new Intent(NavigateActivity.this,ViewAssetActivity.class);
                startActivity(n1);
            }
        });
    }
}
