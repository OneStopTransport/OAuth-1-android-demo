package android.oauth;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class WebViewActivity extends Activity {
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
	
		WebView webview = (WebView) findViewById(R.id.webview);

		 Log.w("Webview", "WebviewActivity"+getIntent().getExtras().getString("url"));
		 
		 webview.clearCache(true);
		 webview.loadUrl(getIntent().getExtras().getString("url"));
		
		
	}
}
		


