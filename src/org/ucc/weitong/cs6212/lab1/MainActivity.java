package org.ucc.weitong.cs6212.lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity {
	TextView textView;
	String data = "Hello Intent Service";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        Log.d("MainActivity", "@ onCreate method");
		
		textView = (TextView) findViewById(R.id.text_view);
		
		textView.setText("\nData sent to service -->" + data);
		
		Intent serviceIntent = new Intent(this, MyIntentService.class);
		
		ResultReceiver resultReceiver = new MyResultReceiver(new Handler());
		
		serviceIntent.putExtra("callbackResultReceiver", resultReceiver);
		
		serviceIntent.putExtra("data", data);
		
		startService(serviceIntent);
	}
	
	public class MyResultReceiver extends ResultReceiver {
		public MyResultReceiver(Handler handler) {
			super(handler);
		}
		protected void onReceiveResult (int resultCode, Bundle resultData){
			super.onReceiveResult (resultCode, resultData);
			
			textView.append("\nData receiverd from service -->"
					+ resultData.getString("data"));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.menu_detail_view) {
			Intent i = new Intent (this, SecondActivity.class);
			i.putExtra("message", "Hello From MainActivity");
			
			Bundle extras = new Bundle();
			extras.putString("bundle","Data using Bundle!");
			
			i.putExtras(extras);
			startActivity(i);
		}
		return super.onOptionsItemSelected(item);
	    
    }
}
