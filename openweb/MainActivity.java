package com.thaiall.www.openweb;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WebView myWebView = (WebView) findViewById(R.id.webViewForm);
        myWebView.setWebViewClient(new MyWebViewClient());
        myWebView.getSettings().setAllowFileAccess(true);
        myWebView.getSettings().setAppCacheEnabled(false);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setUserAgentString("com.thaiall.www.openweb");
        myWebView.getSettings().setCacheMode( WebSettings.LOAD_NO_CACHE );
        myWebView.loadUrl("http://www.thaiall.com/actress/missgrand2017/"); // PWA (Progressive Web Apps)
    }

    private class MyWebViewClient extends WebViewClient {
        // shouldOverrideUrlLoading(WebView view, WebResourceRequest request) start in API 24
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().equals("www.thaiall.com") ||
            Uri.parse(url).getHost().equals("www.missgrandthailand.com")) {
                return false;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }
    }
}
