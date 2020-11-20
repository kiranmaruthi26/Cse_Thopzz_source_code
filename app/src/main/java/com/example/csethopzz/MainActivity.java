package com.example.csethopzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // tx = findViewById(R.id.repot);

       /* tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,feedback.class);
                startActivity(intent);
            }
        });*/
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }
    public void me_web(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void lms(View view) {
        Intent intent = new Intent(this, SriVasavi_LMS.class);
        startActivity(intent);
    }

    public void vasavi(View view) {
        Intent intent = new Intent(this,SriVasavi.class);
        startActivity(intent);
    }

    public void live_session(View view) {
        Intent intent = new Intent(this,LiveSessions.class);
        startActivity(intent);
    }

    public void results(View view) {
        Intent intent = new Intent(this,Results.class);
        startActivity(intent);
    }
    /*public void Report(View view) {
        Intent intent = new Intent(this,feedback.class);
        startActivity(intent);
    }*/
}