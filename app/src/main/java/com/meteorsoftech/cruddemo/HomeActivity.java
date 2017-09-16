package com.meteorsoftech.cruddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonadd,buttonview,buttonsearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonadd = (Button)findViewById(R.id.btn_add);
        buttonview = (Button)findViewById(R.id.btn_view);
        buttonsearch = (Button)findViewById(R.id.btn_Searchh);

        buttonview.setOnClickListener(this);
        buttonadd.setOnClickListener(this);
        buttonsearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_add:
                Intent i = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.btn_view:
                Intent i1= new Intent(HomeActivity.this,DataListActivity.class);
                startActivity(i1);
                finish();
                break;

            case R.id.btn_Searchh:
                Intent intent = new Intent(HomeActivity.this,SearchData.class);
                startActivity(intent);
                finish();
                break;
        }

    }
}
