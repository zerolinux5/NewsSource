package com.zerolinux5.newssource;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends Activity {
	private static final String LOG_TAG = "ChooserActivity";
	public static final int BUTTONTRUE = 1;
	public static final String LABEL_NUMBER = "";
	public static final String NEW_STRING = "";
	public static final String NEW_URL1 = "http://www.zerolinux5.com/";
	public static final String NEW_URL2 = "http://news.ycombinator.com/";	
	public static final String NEW_URL3 = "http://www.ubuntuvibes.com/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		WebView myWebView = (WebView) findViewById(R.id.webview);
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		myWebView.setWebViewClient(new WebViewClient());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void buttonOne(View v){
		WebView myWebView = (WebView) findViewById(R.id.webview);
		myWebView.loadUrl(NEW_URL1);
	}
	
	public void buttonTwo(View v){
		WebView myWebView = (WebView) findViewById(R.id.webview);
		myWebView.loadUrl(NEW_URL2);
	}
	
	public void buttonThree(View v){
		WebView myWebView = (WebView) findViewById(R.id.webview);
		myWebView.loadUrl(NEW_URL3);
	}
	
	  @Override
	   public void onBackPressed() {
		   WebView myWebView = (WebView) findViewById(R.id.webview);
	       if (myWebView.canGoBack()) {
	           myWebView.goBack();
	       } else {
	       // If it wasn't the Back key or there's no web page history, bubble up to the default
	       // system behavior (probably exit the activity)
	           super.onBackPressed();
	       }
	   }
	  
	  public void menu(View v){
	    	Intent intent = new Intent(MainActivity.this, MenuActivity.class);
	    	startActivityForResult(intent, BUTTONTRUE);  
	  }
	  
	    // Gets the return value.
	    @Override
	    public void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	    	if(requestCode == BUTTONTRUE){
	    			if (resultCode == RESULT_OK) {
	    				Log.d(LOG_TAG, "Chosen: this is " +  data.getStringExtra(NEW_STRING));
	    				if(Integer.parseInt(data.getStringExtra(LABEL_NUMBER)) == 1){	
	    					Button b = (Button) findViewById(R.id.button1);
	    					b.setText(data.getStringExtra(NEW_STRING));
	    				} 
	    				if(Integer.parseInt(data.getStringExtra(LABEL_NUMBER)) == 2){	
	    					Button b = (Button) findViewById(R.id.button2);
	    					b.setText(data.getStringExtra(NEW_STRING));
	    				} 
	    				if(Integer.parseInt(data.getStringExtra(LABEL_NUMBER)) == 3){	
	    					Button b = (Button) findViewById(R.id.button3);
	    					b.setText(data.getStringExtra(NEW_STRING));
	    				} 
	    			}
	    	}
	    }
}
