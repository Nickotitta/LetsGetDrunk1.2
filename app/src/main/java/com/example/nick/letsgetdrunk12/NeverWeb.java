package com.example.nick.letsgetdrunk12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class NeverWeb extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_never_web);
        String myUrl="file:///android_asset/Never/never.html";
        WebView view =(WebView) this.findViewById(R.id.neverWebView);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(myUrl);
    }
}
