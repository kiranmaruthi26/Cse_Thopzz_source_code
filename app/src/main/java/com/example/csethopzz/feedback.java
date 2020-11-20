package com.example.csethopzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback extends AppCompatActivity {
    EditText roll,name,feed;
    DatabaseReference reference;
    Button send;


  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        roll = findViewById(R.id.roll);
        name = findViewById(R.id.name);
        feed = findViewById(R.id.feedback);
        send = findViewById(R.id.send);
        reference = FirebaseDatabase.getInstance().getReference("Feedback");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();

            }
        });

    }
    private void addData(){
        String sname = name.getText().toString().trim();
        String sroll = roll.getText().toString().trim();
        String sfeed = feed.getText().toString().trim();

        if(!TextUtils.isEmpty(sname) ||!TextUtils.isEmpty(sroll) || !TextUtils.isEmpty(sfeed) ){
            String i = reference.push().getKey();
            Member member = new Member(sroll,sname,sfeed);
            reference.child(i).setValue(member);
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "The Above Fields Can't be empty", Toast.LENGTH_SHORT).show();
        }
    }*/

}