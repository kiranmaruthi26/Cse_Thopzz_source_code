package com.example.csethopzz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback extends AppCompatActivity {
    /*EditText roll,name,feed;
    DatabaseReference reference;
    Button send;*/
    WebView mywebview;
    ProgressBar progressBar;


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        /*roll = findViewById(R.id.roll);
        name = findViewById(R.id.name);
        feed = findViewById(R.id.feedback);
        send = findViewById(R.id.send);
        reference = FirebaseDatabase.getInstance().getReference("Feedback");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();

            }
        });*/
       Toolbar toolbar = findViewById(R.id.toolbar);
       toolbar.setTitleTextColor(0xFFFFFFFF);
       setSupportActionBar(toolbar);
       progressBar = findViewById(R.id.progress);
       mywebview = findViewById(R.id.me_web);
       mywebview.setWebViewClient(new feedback.WebViewClient());
       mywebview.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSeQjQ_bKRqrPQx61oZzfGaH1CvX1J53D6FvS0-O__1BU2j7VQ/viewform?usp=sf_link");

       WebSettings webSettings = mywebview.getSettings();
       webSettings.setJavaScriptEnabled(true);
       webSettings.setBuiltInZoomControls(true);
       webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
       webSettings.setSupportZoom(true);
       webSettings.setDisplayZoomControls(false);
       webSettings.setBuiltInZoomControls(true);
       webSettings.setUseWideViewPort(true);
       mywebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
       mywebview.setOverScrollMode(WebView.OVER_SCROLL_IF_CONTENT_SCROLLS);
       webSettings.setJavaScriptEnabled(true);
       webSettings.setAppCacheEnabled(true);
       webSettings.setAllowFileAccess(true);
       webSettings.setDomStorageEnabled(true);
       mywebview.setWebViewClient(new feedback.WebViewClient());

   }

    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }


    @Override
    public void onBackPressed() {
        if(mywebview.canGoBack())
        {
            mywebview.goBack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Intent intent = new Intent(this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
                break;
            case R.id.refresh:
                mywebview.reload();
                Toast.makeText(this, "Page Refreshed", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }




    /*private void addData(){
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