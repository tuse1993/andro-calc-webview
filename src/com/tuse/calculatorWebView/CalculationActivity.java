package com.tuse.calculatorWebView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import com.tuse.calculatorSqlite.DatabaseHelper;
//import com.tuse.calculatorSqlite.R;
//import com.tuse.calculatorSqlite.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Toast;

public class CalculationActivity extends Activity{
	/** Called when the activity is first created. */
	DatabaseHelper myDB;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_2);
        
        myDB = new DatabaseHelper(this);
        
        
        Bundle bundle=getIntent().getExtras();
        if(bundle==null){
        	return;
        }
        String fulltext=bundle.getString("Input_String");
        
        char checkSign='\0';
		int indexNumber=-1;
		
		for(int i=0;i < fulltext.length();i++){
			checkSign=fulltext.charAt(i);
			if(checkSign == '+'){
				indexNumber=i;
				break;
			}
			else if(checkSign == '-'){
				indexNumber=i;
				break;
			}
			else if(checkSign == 'x'){
				indexNumber=i;
				break;
			}
			else if(checkSign == '/'){
				indexNumber=i;
				break;
			}
			else {
				continue;
			}
		}
		
		
		if(indexNumber == -1){
			
			Toast.makeText(getApplicationContext(), "Format Error", Toast.LENGTH_SHORT).show();
		}
		else {
			

		
		String firstHalf,secondHalf;
		Double frst,scnd;
		firstHalf=fulltext.substring(0, indexNumber);
		secondHalf=fulltext.substring(indexNumber+1, fulltext.length());
		
		frst=Double.parseDouble(firstHalf);
		scnd=Double.parseDouble(secondHalf);
		
		
		String returnText=null;
		
		
		
		if(checkSign == '+'){
			Double total=frst+scnd;
			String xyz=Double.toString(total);
			returnText=xyz;
			
			//editText.setText(xyz);	
		}
		else if(checkSign == '-'){
			Double total=frst-scnd;
			String xyz=Double.toString(total);
			returnText=xyz;
			//editText.setText(xyz);
		}
		else if(checkSign == 'x'){
			Double total=frst*scnd;
			String xyz=Double.toString(total);
			returnText=xyz;
			//editText.setText(xyz);
		}
		else if(checkSign == '/'){		
			if(frst==0){
				if(scnd==0){
					returnText="1";
					//editText.setText("1");
				}
				else {
					returnText="0";
					//editText.setText("Error");
				}
			}
			else if(scnd==0){
				if(frst==0){
					returnText="1";
					//editText.setText("1");
				}
				else {
					returnText="Error";
					//editText.setText("Error");
				}
			}
			else{
				Double total=frst/scnd;
				String xyz=Double.toString(total);					
				returnText=xyz;
				//editText.setText(xyz);
			}
		}
				
		
		
		//Saving in Internal Memory................................
		//SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		//String currentDateandTime = sdf.format(new Date());
		String tme = DateFormat.getTimeFormat(getApplicationContext()).format(new Date());
		
		String tmpString ="\n"+fulltext+"="+returnText+"       "+tme;
		try {
			FileOutputStream fileOutputStream = openFileOutput("History1.txt", MODE_APPEND);
			fileOutputStream.write(tmpString.getBytes());
			fileOutputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Saving in SQLite Database...............................
		
				boolean isInserted = myDB.insertData(fulltext, returnText, tme);
				
				if (isInserted == true) {
					Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
				}
				else {
					Toast.makeText(getApplicationContext(), "Data Insertion Failed", Toast.LENGTH_SHORT).show();
				}
		
		
		Intent returnIntent = new Intent();
        returnIntent.putExtra("result", returnText);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
		}
    }

}
