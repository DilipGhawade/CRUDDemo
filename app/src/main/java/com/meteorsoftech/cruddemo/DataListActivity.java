package com.meteorsoftech.cruddemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DataListActivity extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    MysqlDbHelper mysqlDbHelper;
    Cursor cursor;
    ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        listView = (ListView)findViewById(R.id.list_item);
        listAdapter = new ListAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listAdapter);
        mysqlDbHelper = new MysqlDbHelper(getApplicationContext());
        sqLiteDatabase = mysqlDbHelper.getReadableDatabase();
        cursor= mysqlDbHelper.getinformation(sqLiteDatabase);

        if (cursor.moveToFirst())
        {
            do {
                String name,mob,email,addresss;
                name=cursor.getString(0);
                mob= cursor.getString(1);
                email=cursor.getString(2);
                addresss=cursor.getString(3);
                Dataprovider dataprovider= new Dataprovider(name,mob,email,addresss);
                listAdapter.add(dataprovider);

            }while (cursor.moveToNext());
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(DataListActivity.this,HomeActivity.class);
        startActivity(i);
        finish();
    }
}
