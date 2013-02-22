package android.oauth;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import resources.RestClient;
import resources.UserMessage;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

public class RetrieveAccessTokenTask extends AsyncTask<Uri, Void, Void> {

	final String TAG = getClass().getName();
	
	@SuppressWarnings("unused")
	private Context	context;
	private OAuthProvider provider;
	private OAuthConsumer consumer;
	private SharedPreferences prefs;
	
	public RetrieveAccessTokenTask(Context context, OAuthConsumer consumer,OAuthProvider provider, SharedPreferences prefs) {
		
		this.context = context;
		this.consumer = consumer;
		this.provider = provider;
		this.prefs=prefs;
	}


	/**
	 * Retrieve the oauth_verifier, and store the oauth and oauth_token_secret 
	 * for future API calls.
	 */
	@Override
	protected Void doInBackground(Uri...params) {
		
		
		final Uri uri = params[0];
		final String oauth_verifier = uri.getQueryParameter(OAuth.OAUTH_VERIFIER);
		
		try {
			
			provider.setOAuth10a(true);
			provider.retrieveAccessToken(consumer, oauth_verifier);
			
			String username = "";
			String response = RestClient.executeHttpGetAuth(OAuthConstants.USER_URL, consumer);

			Gson gson = new Gson();
			UserMessage userMessage = gson.fromJson(response, UserMessage.class);  			
			username=userMessage.getUser().getUsername();
			
			Log.i("HTTP GET ", username);
						
			final Editor edit = prefs.edit();
			//this must be changed if/when multiuser is supported 
			edit.putString("username", username);
			edit.putString("users.json", response);
			edit.putString(OAuth.OAUTH_TOKEN, consumer.getToken());
			edit.putString(OAuth.OAUTH_TOKEN_SECRET, consumer.getTokenSecret());
			edit.commit();
			
			String token = prefs.getString(OAuth.OAUTH_TOKEN, "");
			String secret = prefs.getString(OAuth.OAUTH_TOKEN_SECRET, "");
			
			consumer.setTokenWithSecret(token, secret);
			Log.i(TAG, "OAuth - Access Token Retrieved");
			
		} catch (Exception e) {
			
			Log.e(TAG, "OAuth - Access Token Retrieval Error", e);
		}

		return null;
	}
}