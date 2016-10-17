package org.ucc.weitong.cs6212.lab1;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

public class MyIntentService extends IntentService {
	public MyIntentService() {
		super("A version of My Intent Service");
	}

	@Override
	protected void onHandleIntent(Intent intent){
		
		Bundle resultsData = new Bundle ();
		resultsData.putString("data", "Hello from MyIntentService");
		
		
		ResultReceiver resultReceiver = (ResultReceiver) intent
				.getParcelableExtra("callbackResultReceiver");
		
		resultReceiver.send(1234, resultsData);
	}
}



