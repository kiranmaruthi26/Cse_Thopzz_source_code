package com.example.csethopzz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.webkit.WebChromeClient;

public class LiveSessions extends AppCompatActivity {
    WebView mywebview;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_sessions);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(0xFFFFFFFF);
        setSupportActionBar(toolbar);
        progressBar = findViewById(R.id.progress);
        mywebview = findViewById(R.id.live);
        mywebview.setWebViewClient(new WebViewClient());
        mywebview.loadUrl("https://csealogin2.web.app");

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
        mywebview.setWebViewClient(new LiveSessions.WebViewClient());


        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }

    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(url.startsWith("http"))
            {
                view.loadUrl(url);
            }
            else if(url.startsWith("zoomus:")){
                launchZoomUrl(url);
            }
            else if(url.startsWith("tel")){
                dail(url);
            }
            else {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }

    /*private void launchZoomClient() {
        PackageManager pm = getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage("us.zoom.videomeetings");
        if (intent != null) {
            startActivity(intent);
        }
    }*/

    public void dail(String url){
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+url));
        startActivity(intent);
    }

    private void launchZoomUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("zoomus://"+url));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
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
}

