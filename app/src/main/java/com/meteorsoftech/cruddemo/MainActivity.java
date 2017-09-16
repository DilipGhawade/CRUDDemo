package com.meteorsoftech.cruddemo;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    EditText edtname,edtmob,edtemail,edtadd;
    Context context=this;
    MysqlDbHelper mysqlDbHelper;
    SQLiteDatabase sqLiteDatabase;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RegisterView();

    button = (Button)findViewById(R.id.btn_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidation())
                {
                    register();
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Error When Registering",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void RegisterView()
    {
        edtname = (EditText)findViewById(R.id.edt_username);
        edtname.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                Validation.hasText(edtname);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });
        edtmob = (EditText)findViewById(R.id.edt_mobileno);
        edtmob.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                Validation.isMobileNo(edtmob,true);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });
        edtemail = (EditText)findViewById(R.id.edt_emailid);
        edtemail.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                Validation.isEmailId(edtemail,true);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });
        edtadd = (EditText)findViewById(R.id.edt_address);
        edtadd.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                Validation.hasText(edtadd);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

    }


    public void register()
    {
        String name=edtname.getText().toString();
        String mob=edtmob.getText().toString();
        String emaill=edtemail.getText().toString();
        String address=edtadd.getText().toString();
        mysqlDbHelper = new MysqlDbHelper(context);
        sqLiteDatabase=mysqlDbHelper.getWritableDatabase();
        mysqlDbHelper.addInformation(name,mob,emaill,address,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Register Successfully",Toast.LENGTH_LONG).show();
        mysqlDbHelper.close();
    }

    @Override
    public void onBackPressed() {
        Intent i= new Intent(MainActivity.this,HomeActivity.class);
        startActivity(i);
        finish();
        super.onBackPressed();
    }

    private boolean checkValidation()
    {
        boolean ret=true;
        if (!Validation.hasText(edtname))ret=true;
        if (!Validation.isMobileNo(edtmob,true))ret=false;
        if (!Validation.isEmailId(edtemail,true))ret=false;
        if (!Validation.hasText(edtadd))ret=true;
        return ret;
    }
}
