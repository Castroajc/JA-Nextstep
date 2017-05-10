package org.pltw.examples.ja_nextstep;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this is the start of the code that makes the Webview work
        mWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // chromium, enable hardware acceleration
         //   mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        //} else {
            // older android version, disable hardware acceleration
         //   mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        //}
        mWebView.loadUrl("https://www.juniorachievement.org/web/ja-usa/home");
        //start of the code that keeps new Webpages inside the Webview
        this.mWebView.setWebViewClient(new WebViewClient(){
            //the new method just has a WebResourceRequest input box instead of the String url
            //method will work perfectly fine for the webview
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });
    }
}