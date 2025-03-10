package com.example.myapplication;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Fbmodule {
    private Context context;

    public Fbmodule(Context context) {
        this.context = context; //הפנייה ל-main acticity
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference reference= database.getReference("color");
       reference.addValueEventListener(
               new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot snapshot) {
                       String str=snapshot.getValue(String.class);
                       if(str !=null)
                       {
                           ((MainActivity)context).setNewColorfromfb(str);
                       }

                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError error) {

                   }
               }
       );

    }

    public void writeBackgroundcolortoFb(String color)
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference reference= database.getReference("color");
        reference.setValue(color);

    }



}
