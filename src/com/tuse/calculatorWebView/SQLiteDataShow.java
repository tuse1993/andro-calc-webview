package com.tuse.calculatorWebView;

import java.nio.Buffer;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class SQLiteDataShow extends Activity {
	DatabaseHelper myDB;
	TextView textView1;
	Button bBack,bHClear;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_4);
        
        myDB = new DatabaseHelper(this);
        textView1=(TextView)findViewById(R.id.textView1);
        
        Cursor resCursor = myDB.getAllData();
        if(resCursor.getCount() == 0){
			Toast.makeText(getApplicationContext(), "Database is Empty", Toast.LENGTH_SHORT).show();
        }
        
        StringBuffer stringBuffer = new StringBuffer();
        while(resCursor.moveToNext()){
        	stringBuffer.append("  "+resCursor.getString(0)+"          "+resCursor.getString(1)+"           "+resCursor.getString(2)+"\n");
        }
        textView1.setText(stringBuffer.toString());
        
        
        
        bBack=(Button)findViewById(R.id.bBack);
        bBack.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Calculator_SqliteActivity.class);
				startActivity(i);
			}
		});
        
        bHClear=(Button)findViewById(R.id.bHClear);
        bHClear.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				boolean isDeletedRows =myDB.deleteData();
				if(isDeletedRows == true){
					Toast.makeText(getApplicationContext(), "History Cleared", Toast.LENGTH_SHORT).show();
				}
				else {
					Toast.makeText(getApplicationContext(), "History not Cleared", Toast.LENGTH_SHORT).show();
				}
				textView1.setText("");
			}
		});
        
	}
}
