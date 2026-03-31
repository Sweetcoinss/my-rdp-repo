package com.jasser.extractor;

import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    // العميل الخاص بالكمبيوتر لضمان ظهور واجهة سطح المكتب
    private String desktopUserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setUserAgentString(desktopUserAgent); // تفعيل وضع الكمبيوتر

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                
                // إذا وصل المستخدم لصفحة استوديو البث أو صفحة البث المباشر
                if (url.contains("youtube.com/live_dashboard") || url.contains("studio.youtube.com")) {
                    String cookies = CookieManager.getInstance().getCookie(url);
                    // هنا نقوم بطباعة الكوكيز في التوست (ويمكنك إرسالها لسيرفر أو حفظها)
                    android.util.Log.d("COOKIES_EXTRACTOR", "Cookies: " + cookies);
                    Toast.makeText(MainActivity.this, "تم استخراج الكوكيز بنجاح! راجع Logcat", Toast.LENGTH_LONG).show();
                }
            }
        });

        // الدخول مباشرة لصفحة تسجيل الدخول ثم تحويله للبث
        webView.loadUrl("https://accounts.google.com/ServiceLogin?service=youtube");
    }
}
