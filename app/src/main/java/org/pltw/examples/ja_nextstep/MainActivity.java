package org.pltw.examples.ja_nextstep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    private String url = "https://www.juniorachievement.org/web/ja-usa/home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //this is the start of the code that makes the Webview work
        mWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl(url);

        //This code that keeps new Web pages inside the WebView(method obtained from Terence Lui from stackoverflow)
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    // this code allows the user to go to the previous page when back button is pressed (method obtained from user Foamy guy on stackoverflow
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (mWebView.canGoBack()) {

                        mWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //this is the settings navigation tool
        if (id == R.id.action_settings) {
            mWebView.loadUrl("https://www.juniorachievement.org/web/ja-usa/home");
        }
        if(id == R.id.more_settings) {
            mWebView.loadUrl("https://www.juniorachievement.org/web/ja-scpa/stem-summit");
        }
        if(id == R.id.information_settings){
            //loads info page
            Intent intent = new Intent(MainActivity.this, InformationPage.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}