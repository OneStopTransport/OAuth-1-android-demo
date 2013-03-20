package android.oauth;

public class OAuthConstants {


	
	public static final String CONSUMER_KEY 	= "YOUR_CONSUMER_KEY";
	public static final String CONSUMER_SECRET 	= "YOUR_CONSUMER_SECRET";
	
	public static final String SCOPE 			= "user";
	
	public static final String REQUEST_URL 		= "https://auth.ost.pt/v1/request_token/";
	public static final String ACCESS_URL 		= "https://auth.ost.pt/v1/access_token/";
	public static final String AUTHORIZE_URL 	= "https://auth.ost.pt/v1/authorize/";
	public static final String USER_URL 		= "https://api.ost.pt/users";
		
	public static final String ENCODING 		= "UTF-8";

	public static final String	OAUTH_CALLBACK_SCHEME	= "x-oauthflow";
	public static final String	OAUTH_CALLBACK_HOST		= "callback";
	public static final String	OAUTH_CALLBACK_URL		= OAUTH_CALLBACK_SCHEME + "://" + OAUTH_CALLBACK_HOST;
}
