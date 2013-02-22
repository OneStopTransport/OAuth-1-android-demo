package demo.project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.oauth.OAuthConstants;
import android.oauth.PrepareRequestTokenActivity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView loggedUser;
	private SharedPreferences prefs;
	ConnectivityManager manager;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		loggedUser = (TextView) findViewById(R.id.logged_user);

		
		//Making sure developers have followed the instructions
		if(OAuthConstants.CONSUMER_KEY.compareTo("YOUR_CONSUMER_KEY")==0||OAuthConstants.CONSUMER_SECRET.compareTo("YOUR_CONSUMER_SECRET")==0){
			Toast.makeText(this, "Não foram configuradas as variáveis OAuth",Toast.LENGTH_SHORT).show();
			MainActivity.this.finish();
		}
		
		
		prefs = PreferenceManager .getDefaultSharedPreferences(MainActivity.this);
		
		//checking for connection
		checkConnection();
		
		//Getting the OAuth flow started
		startActivity(new Intent(MainActivity.this, PrepareRequestTokenActivity.class));
		String username = prefs.getString("username", "");
		Log.w("PREFS", "USERNAME: " + username);

		loggedUser.setText(username);

	}
	
	@Override
	public void onResume(){
	    super.onResume();
	    
		//Checking connection on resume
	    checkConnection();
	    
		String username = prefs.getString("username", "");
		Log.w("PREFS", "USERNAME: " + username);
		loggedUser.setText(username);
		
	}

	
	private void checkConnection() {
		Boolean is3g = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
		Boolean isWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();

		if (!is3g && !isWifi) {

			AlertDialog.Builder connectionAlert = new AlertDialog.Builder(this);

			connectionAlert
					.setMessage("Pretende activar a ligação?")
					.setTitle("Esta aplicação necessita de ligação à internet")
					.setCancelable(false)
					.setPositiveButton("Ok",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {

									MainActivity.this.startActivity(new Intent(Settings.ACTION_SETTINGS));

									// this has to be changed if/when multiuser
									// is supported
									String username = prefs.getString("username", "");
									Log.w("PREFS", "USERNAME: " + username);

									loggedUser.setText(username);

								}
							})
					.setNegativeButton("Sair",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									MainActivity.this.finish();

								}
							});

			connectionAlert.show();

		}		
	}

	public void onResponseButtonClicked(View v) {

		AlertDialog.Builder userAlert = new AlertDialog.Builder(this);

		String usersResponse = prefs.getString("users.json", "");

		userAlert.setMessage(usersResponse)
				.setTitle("Complete /api/users.json response:")
				.setCancelable(false)
				.setNegativeButton("Dismiss",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

		userAlert.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	// Orientation handling.
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

	}
}
