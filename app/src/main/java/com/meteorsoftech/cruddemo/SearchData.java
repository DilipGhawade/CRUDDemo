package com.meteorsoftech.cruddemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchData extends AppCompatActivity {
    EditText editTextsearch;
    TextView textViewmobileno,textViewemailid,textViewaddress;
    MysqlDbHelper mysqlDbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);
        editTextsearch = (EditText)findViewById(R.id.edtsearch);
        textViewmobileno = (TextView)findViewById(R.id.txt_mobileno);
        textViewemailid = (TextView)findViewById(R.id.txt_emailid);
        textViewaddress = (TextView)findViewById(R.id.txt_addresss);
        textViewaddress.setVisibility(View.GONE);
        textViewmobileno.setVisibility(View.GONE);
        textViewemailid.setVisibility(View.GONE);
    }

    public void serchContact(View view)
    {
        search_name = editTextsearch.getText().toString();
        mysqlDbHelper = new MysqlDbHelper(getApplicationContext());
        sqLiteDatabase =  mysqlDbHelper.getReadableDatabase();
        Cursor cursor=mysqlDbHelper.SearchInformation(search_name,sqLiteDatabase);
        if (cursor.moveToFirst())
        {
            String mobiel=cursor.getString(0);
            String email=cursor.getString(1);
            String address=cursor.getString(2);

            textViewmobileno.setText(mobiel);
            textViewemailid.setText(email);
            textViewaddress.setText(address);

            textViewmobileno.setVisibility(View.VISIBLE);
            textViewemailid.setVisibility(View.VISIBLE);
            textViewaddress.setVisibility(View.VISIBLE);
        }
        mysqlDbHelper.close();
    }


    public void deletedata(View view)
    {
        mysqlDbHelper = new MysqlDbHelper(getApplicationContext());
        sqLiteDatabase= mysqlDbHelper.getReadableDatabase();
        mysqlDbHelper.deleteinfromation(search_name,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data Deleted...",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i =  new Intent(SearchData.this,HomeActivity.class);
        startActivity(i);
        finish();
    }
}
