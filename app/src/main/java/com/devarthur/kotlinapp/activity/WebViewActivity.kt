package com.devarthur.kotlinapp.activity

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.devarthur.kotlinapp.R
import com.devarthur.kotlinapp.extensions.setupToolbar

class WebViewActivity : AppCompatActivity() {

    private val URL_SOBRE = "http://www.livroandroid.comm.br/sobre.htm"
    var webview : WebView? = null
    var progress : ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        // Toolbar
        val actionBar = setupToolbar(R.id.toolbar)
        actionBar.setDisplayHomeAsUpEnabled(true)

        //Views
        webview = findViewById<WebView>(R.id.webview)
        progress = findViewById<ProgressBar>(R.id.progress)

        //Looads the page
        setWebViewClient(webview)
    }

    private fun setWebViewClient(webview: WebView?) {

        webview?.webViewClient = object : WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                //Starts the progress bar
                progress?.visibility = View.VISIBLE

            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progress?.visibility = View.INVISIBLE
            }
        }

    }
}
