package org.ucc.weitong.cs6212.lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		Intent intent = getIntent();
		String message = intent.getStringExtra("message");
	    Bundle bundle = intent.getExtras();
	    String BundleData = bundle.getString("bundle");
	    Toast.makeText(this,
	    		"Received Message: " + message + "\nThe Bundle Message: "
	            + BundleData, Toast.LENGTH_LONG).show();
	}
}
