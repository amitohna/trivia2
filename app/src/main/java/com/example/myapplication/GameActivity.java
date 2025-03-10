package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btna1,btan2,btna3,btna4,btnquit;
    private TextView tvquistion;
    private TextView tvpoint,tvgameover,tvquistionnumber;
    private Collection collection;
    private Question currentquestion;
    private Fbmodule fbmodule;
    private int points=0;
    private LinearLayout ll;



    private String BackgroundColor = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_game);
        ll=findViewById(R.id.main2);


        tvquistionnumber=findViewById(R.id.tvQuestionNumber);
        collection=new Collection();
        tvquistion=findViewById(R.id.tvQuestion);
        btna1=findViewById(R.id.btna1);
        btan2=findViewById(R.id.btna2);
        btna3=findViewById(R.id.btna3);
        btna4=findViewById(R.id.btna4);
              btnquit=findViewById(R.id.btnquit);
        btna1.setOnClickListener(this);
        btan2.setOnClickListener(this);
        btna3.setOnClickListener(this);
        btna4.setOnClickListener(this);
        btnquit.setOnClickListener(this);
        tvpoint=findViewById(R.id.tvPoints);
        tvgameover=findViewById(R.id.tvGameOver);
        tvgameover.setVisibility(View.INVISIBLE);

        collection.initquestion();
        nextQuistion();

       Intent intent=getIntent();
        String str;
        str = intent.getStringExtra("color");
        if(str!=null)
        {
            setBackgroundColor(str);
        }

    }





    private void nextQuistion() {
        if(collection.isnotquestion()){

            currentquestion=collection.getNextQuistion();
            tvquistion.setText(currentquestion.getQuestion());
            btna1.setText(currentquestion.getA1());
            btan2.setText(currentquestion.getA2());
            btna3.setText(currentquestion.getA3());
            btna4.setText(currentquestion.getA4());

        }
         else {
             tvgameover.setVisibility(View.VISIBLE);
             CustomDialog customDialog =new CustomDialog(this);
             customDialog.show();
        }

    }

    @Override
    public void onClick(View v) {

     if(v==btna1)
     {
         if(currentquestion.getCorrect()==1)
             points++;

     }
        if(v==btan2)
        {
            if(currentquestion.getCorrect()==2)
                points++;
        }
        if(v==btna3)
        {
            if(currentquestion.getCorrect()==3)
                points++;

        }
        if(v==btna4)
        {
            if(currentquestion.getCorrect()==4)
                points++;
        }
        if(v==btnquit)
        {

            CustomDialog customDialog =new CustomDialog(this);
            customDialog.show();
        }

        tvpoint.setText("point is "+points);
        if (collection.isnotquestion()) {
            tvquistionnumber.setText("question number: " + (collection.getIndex()+1));
        }
        nextQuistion();
    }

    public void reset() {
        this.points=0;
        collection.initquestion();

        tvpoint.setText("point "+0);
        tvquistionnumber.setText("question number "+1);
        tvgameover.setVisibility(View.INVISIBLE);
        this.nextQuistion();
    }
    public void setNewColorfromfb(String str) {
        this.BackgroundColor=str;

        setBackgroundColor(str);
    }
    public void setBackgroundColor (String color)
    {
        switch (color)
        {
            case "red":
            {
                ll.setBackgroundColor(Color.RED);
                break;
            }
            case "blue":
            {
                ll.setBackgroundColor(Color.BLUE);
                break;
            }
            case "pink":
            {
                ll.setBackgroundColor(Color.argb(225,225,20,147));
                break;
            }
            case "yellow":
            {
                ll.setBackgroundColor(Color.YELLOW);
                break;
            }

            default:
            {
                ll.setBackgroundColor(Color.WHITE);
                break;
            }

        }
    }
}