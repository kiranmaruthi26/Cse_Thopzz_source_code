package com.example.csethopzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    Handler handler;
    PackageInfo packageInfo;
    TextView ver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ver = findViewById(R.id.version);
        String version_name="";
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(),0);
            version_name= "V "+packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        ver.setText(version_name);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        },5*1000);
    }
}