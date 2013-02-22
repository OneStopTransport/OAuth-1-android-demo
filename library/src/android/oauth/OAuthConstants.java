package android.oauth;

public class OAuthConstants {


	
//	public static final String CONSUMER_KEY 	= "YOUR_CONSUMER_KEY";
//	public static final String CONSUMER_SECRET 	= "YOUR_CONSUMER_SECRET";
	
	public static final String SCOPE 			= "user";

//	public static final String CONSUMER_KEY 	= "e964a8b3abb308a9c46ce635d58186";
//	public static final String CONSUMER_SECRET 	= "a05b308bb94beede812e6e58a26aac";
//	
//	
//	public static final String REQUEST_URL 		= "https://auth.evida.pt/v1/request_token/";
//	public static final String ACCESS_URL 		= "https://auth.evida.pt/v1/access_token/";
//	public static final String AUTHORIZE_URL 	= "https://auth.evida.pt/v1/authorize/";
//	public static final String USER_URL 		= "https://api.evida.pt/users";
//	
	
	public static final String REQUEST_URL 		= "https://auth.ost.pt/v1/request_token/";
	public static final String ACCESS_URL 		= "https://auth.ost.pt/v1/access_token/";
	public static final String AUTHORIZE_URL 	= "https://auth.ost.pt/v1/authorize/";
	public static final String USER_URL 		= "https://api.ost.pt/users";
	
	public static final String CONSUMER_KEY 	= "95a073a85535b7dd03c25fc6801c79";
	public static final String CONSUMER_SECRET 	= "addba2f7f81e947f74e3f84acecf35";
		
	public static final String ENCODING 		= "UTF-8";

	public static final String	OAUTH_CALLBACK_SCHEME	= "x-oauthflow";
	public static final String	OAUTH_CALLBACK_HOST		= "callback";
	public static final String	OAUTH_CALLBACK_URL		= OAUTH_CALLBACK_SCHEME + "://" + OAUTH_CALLBACK_HOST;
}
