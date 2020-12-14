package com.example.csethopzz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SriVasavi extends AppCompatActivity {
    WebView mywebview;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sri_vasavi);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(0xFFFFFFFF);
        progressBar = findViewById(R.id.progress);
        mywebview = findViewById(R.id.vasavi);
        mywebview.setWebViewClient(new WebViewClient());
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setDomStorageEnabled(true);
        mywebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mywebview.setOverScrollMode(WebView.OVER_SCROLL_IF_CONTENT_SCROLLS);
        mywebview.getSettings().setLoadsImagesAutomatically(true);
        mywebview.loadUrl("http://srivasaviengg.ac.in/");


        mywebview.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String s, String s1, String s2, String s3, long l) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(s));
                request.setMimeType(s3);
                String cookies = CookieManager.getInstance().getCookie(s);
                request.addRequestHeader("cookies",cookies);
                request.addRequestHeader("User-Agent",s1);
                request.setDescription("Downloading File...");
                request.setTitle(URLUtil.guessFileName(s, s2, s3));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,URLUtil.guessFileName(s,s2,s3));
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(SriVasavi.this, "Downloading Files", Toast.LENGTH_SHORT).show();

            }
        });


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
            else if(url.startsWith("tel")){
                dail(url);
            }
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }

    public void dail(String url){
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+url));
        startActivity(intent);
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