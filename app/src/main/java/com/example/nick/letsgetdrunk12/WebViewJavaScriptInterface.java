package com.example.nick.letsgetdrunk12;

import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebViewJavaScriptInterface {
    private RingOfFireWeb context;

    public WebViewJavaScriptInterface(RingOfFireWeb context){
        this.context = context;
    }
    @JavascriptInterface
    public void makeToast(String message, boolean lengthLong){
        Toast.makeText(context, message, (lengthLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT)).show();
    }

    @JavascriptInterface
    public void goToSecondActivity(){
        //context.goToSecondActivity();
    }

}
