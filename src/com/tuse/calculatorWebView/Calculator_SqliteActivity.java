package com.tuse.calculatorWebView;



import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Calculator_SqliteActivity extends Activity {
	EditText editText;
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bplus,bminus,bmul,bpoint,bequal,bdiv,bac,bMSave,bMRetreve,bMClear,bMPlus,bMMinus,bHistory,bHistorySqlite;
	DatabaseHelper myDB;
	
    /** Called when the activity is first created. */
    @Override  
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        
        myDB = new DatabaseHelper(this);
        editText=(EditText)findViewById(R.id.editText);
        
        
        //1.........................................
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String x=editText.getText().toString();
				editText.setText(x+"1");		
			}
		});
        
        //2............................................
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String x=editText.getText().toString();
				editText.setText(x+"2");		
			}
		});
        
        //3...........................................
        b3=(Button)findViewById(R.id.b3);
        b3.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String x=editText.getText().toString();
				editText.setText(x+"3");		
			}
		});
        
        //4.............................................
        b4=(Button)findViewById(R.id.b4);
        b4.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String x=editText.getText().toString();
				editText.setText(x+"4");		
			}
		});
        
        //5.............................................
        b5=(Button)findViewById(R.id.b5);
        b5.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String x=editText.getText().toString();
				editText.setText(x+"5");		
			}
		});
        
        //6............................................
        b6=(Button)findViewById(R.id.b6);
        b6.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String x=editText.getText().toString();
				editText.setText(x+"6");		
			}
		});
        
        //7.............................................
        b7=(Button)findViewById(R.id.b7);
        b7.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String x=editText.getText().toString();
				editText.setText(x+"7");		
			}
		});
        
        //8.............................................
        b8=(Button)findViewById(R.id.b8);
        b8.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String x=editText.getText().toString();
				editText.setText(x+"8");		
			}
		});
        
        //9..............................................
        b9=(Button)findViewById(R.id.b9);
        b9.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String x=editText.getText().toString();
				editText.setText(x+"9");		
			}
		});
        
        //0.............................................
        b0=(Button)findViewById(R.id.b0);
        b0.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String x=editText.getText().toString();
				editText.setText(x+"0");		
			}
		});
        
        //+............................................
        bplus=(Button)findViewById(R.id.bplus);
        bplus.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String x=editText.getText().toString();
				
				if(x.equals("")){
					Toast.makeText(getApplicationContext(), "Format Error", Toast.LENGTH_SHORT).show();
				}
				else {
					editText.setText(x+"+");
				}		
			}
		});
        
        //-............................................
        bminus=(Button)findViewById(R.id.bminus);
        bminus.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String x=editText.getText().toString();
				
				if(x.equals("")){
					Toast.makeText(getApplicationContext(), "Format Error", Toast.LENGTH_SHORT).show();
				}
				else {
					editText.setText(x+"-");
				}	
			}
		});
        
        //x............................................
        bmul=(Button)findViewById(R.id.bmul);
        bmul.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String x=editText.getText().toString();
				if(x.equals("")){
					Toast.makeText(getApplicationContext(), "Format Error", Toast.LENGTH_SHORT).show();
				}
				else {
					editText.setText(x+"x");
				}		
			}
		});
        
        //Division.......................................
        bdiv=(Button)findViewById(R.id.bdiv);
        bdiv.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String x=editText.getText().toString();
				if(x.equals("")){
					Toast.makeText(getApplicationContext(), "Format Error", Toast.LENGTH_SHORT).show();
				}
				else {
					editText.setText(x+"/");
				}		
			}
		});
        
        //Point.........................................
        bpoint=(Button)findViewById(R.id.bpoint);
        bpoint.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String x=editText.getText().toString();
				editText.setText(x+".");		
			}
		});
        
        //AC Button......................................
        bac=(Button)findViewById(R.id.bac);
        bac.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//String x=editText.getText().toString();
				editText.setText("");		
			}
		});
        
        //Equal.............................................
        bequal=(Button)findViewById(R.id.bequal);
        bequal.setOnClickListener(new OnClickListener() {	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String fulltext=editText.getText().toString();
				if(fulltext.equals("")){
					Toast.makeText(getApplicationContext(), "Input is Empty", Toast.LENGTH_SHORT).show();
        		}
				else {
					char checkSign='\0';
					int indexNumber=-1;
					int strlength = fulltext.length();
					
					for(int i=0; i < strlength; i++){
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
					
					if(indexNumber == -1 || fulltext.charAt(strlength-1) == fulltext.charAt(indexNumber)){
						
						Toast.makeText(getApplicationContext(), "Format Error", Toast.LENGTH_SHORT).show();
					}
					
					else {
						indexNumber = -1;
						Intent i = new Intent(getApplicationContext(), CalculationActivity.class);
						i.putExtra("Input_String", fulltext);
						startActivityForResult(i, 1);
					}	
				}
				
			}
		}); 
        
        //Memory Save.......................................
        bMSave=(Button)findViewById(R.id.bMSave);
        bMSave.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SharedPreferences sharedPref=getSharedPreferences("MemoryInfo",Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = sharedPref.edit();
				
				editor.putString("Result_Memory", editText.getText().toString());
				editor.commit();
				
				Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
				
			}
		});
        
        //Memory Retreve.....................................
        bMRetreve=(Button)findViewById(R.id.bMRetreve);
        bMRetreve.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SharedPreferences sharedPref=getSharedPreferences("MemoryInfo",Context.MODE_PRIVATE);
				
				String tmpString = sharedPref.getString("Result_Memory", "");
				editText.setText(tmpString);
				
			}
		});
        
        //Memory Clear......................................
        bMClear=(Button)findViewById(R.id.bMClear);
        bMClear.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SharedPreferences sharedPref=getSharedPreferences("MemoryInfo",Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = sharedPref.edit();
				
				editor.putString("Result_Memory", "");
				editor.commit();
				
				editText.setText("");
				Toast.makeText(getApplicationContext(), "Cleared", Toast.LENGTH_SHORT).show();
				
			}
		});
        
        //Memory Plus........................................
        bMPlus=(Button)findViewById(R.id.bMPlus);
        bMPlus.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SharedPreferences sharedPref=getSharedPreferences("MemoryInfo",Context.MODE_PRIVATE);
				
				String tmpString = sharedPref.getString("Result_Memory", "");
				Double tmpDouble = Double.parseDouble(tmpString);
				tmpDouble++;	
				editText.setText(tmpDouble.toString());
				
				SharedPreferences.Editor editor = sharedPref.edit();
				
				editor.putString("Result_Memory", tmpDouble.toString());
				editor.commit();
				
			}
		});
        
        //Memory Minus......................................
        bMMinus=(Button)findViewById(R.id.bMMinus);
        bMMinus.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SharedPreferences sharedPref=getSharedPreferences("MemoryInfo",Context.MODE_PRIVATE);
				
				String tmpString = sharedPref.getString("Result_Memory", "");
				Double tmpDouble = Double.parseDouble(tmpString);
				tmpDouble--;	
				editText.setText(tmpDouble.toString());
				
				SharedPreferences.Editor editor = sharedPref.edit();
				
				editor.putString("Result_Memory", tmpDouble.toString());
				editor.commit();
				
			}
		});
        
        //Internal History.....................................
        bHistory=(Button)findViewById(R.id.bHistoryIntr);
        bHistory.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String tmptext=editText.getText().toString();
				Intent i = new Intent(getApplicationContext(), InternalHistoryActivity.class);
				i.putExtra("tmp_String", tmptext);
				startActivity(i);
			}
		});
        
        //Sqlite History.........................................
        bHistorySqlite=(Button)findViewById(R.id.bHistorySqlite);
        bHistorySqlite.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), SQLiteDataShow.class);
				startActivity(i);
			}
		});
        
    }
    
    @Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	    // Checks the orientation of the screen
	    Bundle value = new Bundle();
	    value.putString("OriChange", editText.getText().toString());
	    Log.d("BC config log", "in onConfigChange");
	    
	    if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) 
	    {
	    	editText.setText(value.get("OriChange").toString());
	    } 
	    else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
	    {
	    	editText.setText(value.get("OriChange").toString());
	    }
	}
    
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                
                editText.setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}