package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class collction2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    private ArrayList<Question> arr;
    private int index;
    boolean contRun = true;
    public collction2()
    {


        arr=new ArrayList<>();
        Question q1= new Question("1+40","23","41","14","40",2);
        Question q2= new Question("5+32","27","37","17","73",2);
        Question q3= new Question("4+77","79","81","11","71",2);
        Question q4= new Question("11+10","21","41","12","22",1);
        arr.add(q1);
        arr.add(q2);
        arr.add(q3);
        arr.add(q4);
        Collections.shuffle(arr);

    }
    public void initquestion()
    {
        index=0;
            Collections.shuffle(arr);


    }
    //public ArrayList<Question> morequistion()
    //{
    //}

    public boolean isnotquestion(){
        //הפעולה מחזירה אמת אם השאלה אחרונה
        return (index<arr.size());//if not at the end of the arryList
    }
    public   int getIndex(){
        return  index;
    }

    public Question getNextQuistion()
    {
        Question q=arr.get(index);
        index++;
        return q;
    }
}