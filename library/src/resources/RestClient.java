package resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;

import oauth.signpost.OAuthConsumer;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class RestClient {

	public static String executeHttpGet(String uri) throws Exception {

		BufferedReader in = null;

		try {

			HttpClient httpclient = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			request.setURI(new URI(uri));
			Log.i("Header","here");

			HttpResponse response = httpclient.execute(request);
			Log.i("Header",""+response.getStatusLine());
			
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");

			while ((line = in.readLine()) != null) {

				sb.append(line + NL);
			}

			in.close();
			String page = sb.toString();
			return page;

		} finally {

			if (in != null) {

				try {

					in.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public static String executeHttpGetAuth(String uri, OAuthConsumer consumer) throws Exception {

		BufferedReader in = null;

		try {

			HttpClient httpclient = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			request.setURI(new URI(uri));

			consumer.sign(request);

			HttpResponse response = httpclient.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");

			while ((line = in.readLine()) != null) {

				sb.append(line + NL);
			}

			in.close();
			String page = sb.toString();
//			System.out.println(page);
			return page;
		} finally {

			if (in != null) {

				try {

					in.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public static StatusLine executeHttpPost(String uri, List<NameValuePair> nameValuePairs) throws Exception {

		BufferedReader in = null;

		try {

			HttpClient httpclient = new DefaultHttpClient();
			HttpPost request = new HttpPost();
			request.setURI(new URI(uri));
			request.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse response = httpclient.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			//Log.i("CENAS", response.);
			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");

			while ((line = in.readLine()) != null) {

				sb.append(line + NL);
			}

			in.close();
			//String page = sb.toString();
//			System.out.println(page);
			return response.getStatusLine();
			
		} finally {

			if (in != null) {

				try {

					in.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}		
	}

	public static String executeHttpPostAuth(String uri, List<NameValuePair> nameValuePairs, OAuthConsumer consumer) throws Exception {

		BufferedReader in = null;

		try {

			HttpClient httpclient = new DefaultHttpClient();
			HttpPost request = new HttpPost();
			request.setURI(new URI(uri));
			request.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			consumer.sign(request);

			HttpResponse response = httpclient.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");

			while ((line = in.readLine()) != null) {

				sb.append(line + NL);
			}

			in.close();
			String page = sb.toString();
//			System.out.println(page);
			return page;
		} finally {

			if (in != null) {

				try {

					in.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}		
	}

	public static String executeHttpPut(String uri, List<NameValuePair> nameValuePairs) throws Exception {

		BufferedReader in = null;

		try {

			HttpClient httpclient = new DefaultHttpClient();
			HttpPut request = new HttpPut();
			request.setURI(new URI(uri));
			request.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse response = httpclient.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");

			while ((line = in.readLine()) != null) {

				sb.append(line + NL);
			}

			in.close();
			String page = sb.toString();
//			System.out.println(page);
			return page;
		} finally {

			if (in != null) {

				try {

					in.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}		
	}

	public static String executeHttpPutAuth(String uri, List<NameValuePair> nameValuePairs, OAuthConsumer consumer) throws Exception {

		BufferedReader in = null;

		try {

			HttpClient httpclient = new DefaultHttpClient();
			HttpPut request = new HttpPut();
			request.setURI(new URI(uri));
			request.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			consumer.sign(request);

			HttpResponse response = httpclient.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");

			while ((line = in.readLine()) != null) {

				sb.append(line + NL);
			}

			in.close();
			String page = sb.toString();
			return page;
		} finally {

			if (in != null) {

				try {

					in.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}		
	}
}
