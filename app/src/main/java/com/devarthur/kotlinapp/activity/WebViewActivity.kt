package com.devarthur.kotlinapp.activity

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.devarthur.kotlinapp.R
import com.devarthur.kotlinapp.extensions.setupToolbar
import kotlinx.android.synthetic.main.activity_web_view.*


import org.jetbrains.anko.alert


class WebViewActivity : AppCompatActivity() {

    private val URL_SOBRE = "https://github.com/Arthur4718"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        // Toolbar
        val actionBar = setupToolbar(R.id.toolbar)
        actionBar.setDisplayHomeAsUpEnabled(true)


        //Looads the page
        setWebViewClient(webview)
        webview.loadUrl(URL_SOBRE)

        //Swipe to refresh
        swipeToRefresh.setOnRefreshListener { webview.reload() }



        //Animation Colors
        swipeToRefresh.setColorSchemeResources(
            R.color.refresh_progress_1,
            R.color.refresh_progress_2,
            R.color.refresh_progress_3
        )


//        AlertDialog.Builder(this)
//            .setTitle("Este é um alerta ")
//            .setMessage("Está é uma mensagem")
//            .setPositiveButton("OK"){
//                dialog, which ->  dialog.dismiss()
//            }.create()
//            .show()

        //The same alert but using anko lib
        alert ("Mensagem de alerta", "Titutlo"){
            positiveButton("ok"){ }
        }.show()
    }

    private fun setWebViewClient(webview: WebView?) {

        webview?.webViewClient = object : WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                //Starts the progress bar
                progress.visibility = View.VISIBLE

            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progress.visibility = View.INVISIBLE
                swipeToRefresh?.isRefreshing = false
            }
        }

    }


}
