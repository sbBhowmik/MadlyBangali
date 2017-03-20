package com.rupik.madlybangali;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.appodeal.ads.Appodeal;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onResume() {
        super.onResume();
        Appodeal.onResume(this, Appodeal.BANNER);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String appKey = "46b93fb93e5ba35aaf564f9603a4e59496e0d9ab0f53d4c5";
        Appodeal.initialize(this, appKey, Appodeal.BANNER | Appodeal.MREC);

        Appodeal.show(this, Appodeal.BANNER_BOTTOM);

        //Appodeal.show(this, Appodeal.MREC);

        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl("http://madlybangali.000webhostapp.com/");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                ProgressBar webViewProgressBar = (ProgressBar) findViewById(R.id.webViewProgressBar);
                webViewProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                ProgressBar webViewProgressBar = (ProgressBar) findViewById(R.id.webViewProgressBar);
                webViewProgressBar.setVisibility(View.VISIBLE);
            }

        });

//        MyWebViewClient webClient = new MyWebViewClient();
//        webClient.loadWebView();

    }

    @Override
    public void onBackPressed() {
        WebView myWebView = (WebView) findViewById(R.id.webView);
        if (myWebView.canGoBack()) {
            myWebView.goBack();
            return;
        }
    }




}
