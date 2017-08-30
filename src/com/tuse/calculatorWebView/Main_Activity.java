package com.tuse.calculatorWebView;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main_Activity extends Activity {
    /** Called when the activity is first created. */
	
	Button b1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        b1=(Button)findViewById(R.id.button1);
        
        b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
				NetworkInfo nInfo = cm.getActiveNetworkInfo();
				
				if(nInfo != null && nInfo.isConnected()){
					
					Intent i = new Intent(getApplicationContext(), AppWebViewActivity.class);
					Toast.makeText(getApplicationContext(), "Internet is Available & Type is: "+nInfo.getTypeName(), Toast.LENGTH_SHORT).show();
					startActivity(i);
					finish();
					
				}
				else {
					Toast.makeText(getApplicationContext(), "Internet is not available", Toast.LENGTH_SHORT).show();
					Intent j = new Intent(getApplicationContext(), Calculator_SqliteActivity.class);
					
					startActivity(j);
					finish();
					
				}
				
				
			}
		});
    }
}