package com.example.abhishek.assigmentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText uname;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit=(Button)findViewById(R.id.login);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uname=(EditText)findViewById(R.id.uname);
                password=(EditText)findViewById(R.id.password);

                if(validate(uname.getText().toString(),password.getText().toString())){
                    Intent n1=new Intent(MainActivity.this,NavigateActivity.class);
                    startActivity(n1);
                }
                else{
                    Toast.makeText(getApplicationContext(),"wrong username and password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    boolean validate(String uname,String password)
    {
        if(uname.equals("abhi")&&password.equals("5555"))
            return true;
        return false;
    }
}
