package ua.dp.parovoziki.loginparser;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class Welcome extends Activity {

	// Declare Variable
	Button logout;
	ProgressDialog pd;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview.xml
		setContentView(R.layout.welcome);

		// Retrieve current user from Parse.com
		final ParseUser currentUser = ParseUser.getCurrentUser();

		// Convert currentUser into String
		String struser = currentUser.getUsername().toString();



		// Locate TextView in welcome.xml
		TextView txtuser = (TextView) findViewById(R.id.txtuser);
		final TextView name = (TextView) findViewById(R.id.textView);
		final TextView idCoin = (TextView) findViewById(R.id.textView2);


		// Set the currentUser String into TextView
		txtuser.setText("You are logged in as " + struser);


			// Locate Button in welcome.xml
			logout=(Button) findViewById(R.id.logout);

			// Logout Button Click Listener
			logout.setOnClickListener(new View.OnClickListener() {
										  public void onClick(View arg0) {
											  // Logout current user
											  ParseUser.logOut();

											  finish();
										  }
									  }

			);
		}
	}