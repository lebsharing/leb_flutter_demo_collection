package com.leb.jet.modules.browser

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.*
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import com.leb.jet.R

class BrowserActivity : FragmentActivity() {

    lateinit var mWebView:WebView;

    companion object {
        const val testUrl = "https://flutter.dev/";
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser);
        mWebView = findViewById(R.id.browser_webview);
        initListener();
        initWebView();
        loadData();
    }

    private fun initListener() {
        findViewById<ImageView>(R.id.browserBackIv).setOnClickListener {
            finish();
        }
    }

    private fun initWebView() {
        mWebView.settings.javaScriptEnabled = true;
        mWebView.settings.useWideViewPort = true;//
        mWebView.settings.loadWithOverviewMode = true;//
        mWebView.settings.setSupportZoom(true);
        mWebView.settings.displayZoomControls = false;
        mWebView.settings.cacheMode = WebSettings.LOAD_DEFAULT;//关闭缓存
        mWebView.settings.allowFileAccess = true;//设置访问文件
        mWebView.settings.loadsImagesAutomatically = true;//支持自动加载图片
        mWebView.settings.defaultTextEncodingName = "utf-8";

        mWebView.webViewClient = BrowserWebViewClient();
        mWebView.webChromeClient = BrowserWebChromeClient();
    }

    private fun loadData() {
        var url: String? = intent.getStringExtra("url");
        if(url == null || url.isEmpty()) {
            url = testUrl;
        }
        Log.i("jet","" + url);
        mWebView.loadUrl(testUrl);
    }


    private  class  BrowserWebChromeClient : WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
        }

        override fun onReceivedTitle(view: WebView?, title: String?) {
            super.onReceivedTitle(view, title)
        }

        override fun onJsAlert(
            view: WebView?,
            url: String?,
            message: String?,
            result: JsResult?
        ): Boolean {
            return super.onJsAlert(view, url, message, result)
        }

        override fun onPermissionRequest(request: PermissionRequest?) {
//            super.onPermissionRequest(request)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && request != null) {
                //直接同意即可     deny是拒绝
                request.grant(request.getResources());
            }
        }
    }
}