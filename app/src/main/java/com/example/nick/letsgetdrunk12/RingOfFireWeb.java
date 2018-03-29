package com.example.nick.letsgetdrunk12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class RingOfFireWeb extends AppCompatActivity {

    private WebViewJavaScriptInterface webViewJavaScriptInterface;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring_of_fire_web);
    }
}
