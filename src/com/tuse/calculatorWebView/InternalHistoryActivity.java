package com.tuse.calculatorWebView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import android.view.View.OnClickListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InternalHistoryActivity extends Activity {
	TextView textView1;
	Button bBack,bHClear;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_3);
        
        textView1=(TextView)findViewById(R.id.textView1);
        
        //Output The History..................................
        try {
			FileInputStream fileInputStream=openFileInput("History1.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuffer stringBuffer = new StringBuffer();
			String lines;
			
			while((lines=bufferedReader.readLine())!=null){
				stringBuffer.append(lines+"\n");
			}
			
			textView1.setText(stringBuffer.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        //Back Button..........................................
        bBack=(Button)findViewById(R.id.bBack);
        bBack.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Calculator_SqliteActivity.class);
				startActivity(i);
			}
		});
        
        //History Clear Button.....................................
        bHClear=(Button)findViewById(R.id.bHClear);
        bHClear.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String tmpString ="";
				try {
					FileOutputStream fileOutputStream = openFileOutput("History1.txt", MODE_PRIVATE);
					fileOutputStream.write(tmpString.getBytes());
					fileOutputStream.close();
					textView1.setText("");
					Toast.makeText(getApplicationContext(), "Cleared", Toast.LENGTH_SHORT).show();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}

}

