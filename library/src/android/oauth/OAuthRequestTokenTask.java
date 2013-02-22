package android.oauth;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

/**
 * An asynchronous task that communicates with Google to 
 * retrieve a request token.
 * (OAuthGetRequestToken)
 * 
 * After receiving the request token from Google, 
 * show a browser to the user to authorize the Request Token.
 * (OAuthAuthorizeToken)
 * 
 */
public class OAuthRequestTokenTask extends AsyncTask<Void, Void, Void> {

	final String TAG = getClass().getName();
	private Context	context;
	private OAuthProvider provider;
	private OAuthConsumer consumer;
	

	/**
	 * 
	 * We pass the OAuth consumer and provider.
	 * 
	 * @param 	context
	 * 			Required to be able to start the intent to launch the browser.
	 * @param 	provider
	 * 			The OAuthProvider object
	 * @param 	consumer
	 * 			The OAuthConsumer object
	 */
	public OAuthRequestTokenTask(Context context,OAuthConsumer consumer,OAuthProvider provider) {
		
		this.context = context;
		this.consumer = consumer;
		this.provider = provider;
		
	}


	/**
	 * 
	 * Retrieve the OAuth Request Token and present a browser to the user to authorize the token.
	 * 
	 */
	protected Void doInBackground(Void... params) {

			try {
		    	Log.i(TAG, "Retrieving request token");
				String url;
				url = provider.retrieveRequestToken(consumer, OAuthConstants.OAUTH_CALLBACK_URL);
				
				Log.i(TAG, ""+provider.getResponseParameters());
				Log.i(TAG, ""+provider.getRequestTokenEndpointUrl());

				Intent intent = new Intent(context,WebViewActivity.class);
				Log.i(TAG, "Popping a browser with the authorize URL : " + url);
				intent.putExtra("url",url);
				context.startActivity(intent);

			
		} catch (Exception e) {
			
			Log.e(TAG, "Error during OAUth retrieve request token", e);
		}

		return null;
	}

}