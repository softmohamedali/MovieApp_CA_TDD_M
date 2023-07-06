//package com.example.presentation.details.components
//
//import android.content.Context
//import android.graphics.Bitmap
//import android.graphics.BitmapFactory
//import android.view.View
//import android.webkit.WebChromeClient
//import android.widget.FrameLayout
//
//class WevClint(var context: Context) : WebChromeClient() {
//    private lateinit var mCustomView: View
//    private lateinit var mCustomViewCallback:WebChromeClient.CustomViewCallback
//    private lateinit var mFullscreenContainer: FrameLayout
//    private  var mOriginalOrientation:Int=0
//    private  var mOriginalSystemUiVisibility:Int=0
//
//    override fun getDefaultVideoPoster():Bitmap
//    {
//        if (mCustomView == null) {
//            return null;
//        }
//        return BitmapFactory.decodeResource(context.getResources(), 2130837573);
//    }
//
//
//    onHideCustomView()
//    {
//        ((FrameLayout)getWindow().getDecorView()).removeView(this.mCustomView);
//        this.mCustomView = null;
//        getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
//        setRequestedOrientation(this.mOriginalOrientation);
//        this.mCustomViewCallback.onCustomViewHidden();
//        this.mCustomViewCallback = null;
//    }
//}
//
//class MyChrome extends WebChromeClient {
//
//
//
//    MyChrome() {}
//
//    public Bitmap
//
//    public void
//
//    public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
//    {
//        if (this.mCustomView != null)
//        {
//            onHideCustomView();
//            return;
//        }
//        this.mCustomView = paramView;
//        this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
//        this.mOriginalOrientation = getRequestedOrientation();
//        this.mCustomViewCallback = paramCustomViewCallback;
//        ((FrameLayout)getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
//        getWindow().getDecorView().setSystemUiVisibility(3846 | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//    }
//}
//
//@Override
//protected void onSaveInstanceState(Bundle outState) {
//    super.onSaveInstanceState(outState);
//    mWebView.saveState(outState);
//}
//
//@Override
//protected void onRestoreInstanceState(Bundle savedInstanceState) {
//    super.onRestoreInstanceState(savedInstanceState);
//    mWebView.restoreState(savedInstanceState);
//}
//}