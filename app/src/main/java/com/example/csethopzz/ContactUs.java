package com.example.csethopzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity {
    TextView ver;
    PackageInfo packageInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        ver = findViewById(R.id.version);
        String versionname ="";
        try{
            packageInfo = getPackageManager().getPackageInfo(getPackageName(),0);
            versionname= "V "+packageInfo.versionName;
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
        ver.setText(versionname);
    }


    public void callme(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://+919133003443"));
        startActivity(intent);
    }

    public void whatsApp(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://wa.me/+919133003443"));
        startActivity(intent);
    }

    public void feedback(View view) {
        Intent intent = new Intent(this,feedback.class);
        startActivity(intent);
    }
}