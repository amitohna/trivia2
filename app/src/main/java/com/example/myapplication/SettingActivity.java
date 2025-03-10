package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SettingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
private Spinner spinner;
private String[] arrcolor={"red","blue","pink","yellow"};
private Button settingback;



private String choseColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        spinner=findViewById(R.id.Spinner);
        spinner.setOnItemSelectedListener(this);
        settingback = findViewById(R.id.btncolor);
        settingback.setOnClickListener(this);

        ArrayAdapter AA= new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrcolor);
        AA.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(AA);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
choseColor=arrcolor[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent();
        i.putExtra("color",choseColor);
        setResult(RESULT_OK,i);
        finish();
    }
}