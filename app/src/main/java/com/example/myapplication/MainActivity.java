package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
private ActivityResultLauncher<Intent> launcher;
private Fbmodule fbmodule;
private ConstraintLayout ll;
private String BackgroundColor = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll=findViewById(R.id.main);

        fbmodule=new Fbmodule(this);//לקשר בין המאגר מידע למשחק דרך הclass

        launcher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                      if (result.getResultCode()==RESULT_OK) {
                          Intent data = result.getData();
                          String str = data.getStringExtra("color");

                          Toast.makeText(MainActivity.this, "" + str, Toast.LENGTH_SHORT).show();
                          fbmodule.writeBackgroundcolortoFb(str);

                      }

                    }
                }
        );
    }

    public void onStartGame(View view) {
       Intent intent =new Intent(this,GameActivity.class);
        intent.putExtra("color",BackgroundColor);
        startActivity(intent);
    }



    public void onSetting(View view) {
Intent i=new Intent(this, SettingActivity.class);
launcher.launch(i);
    }

    public void onInstraction(View view) {
        Intent intent =new Intent(this,innsructionActivity.class);

        startActivity(intent);
    }

    public void setNewColorfromfb(String str) {
        this.BackgroundColor=str;
       // Toast.makeText(this, ""+BackgroundColor, Toast.LENGTH_SHORT).show();
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