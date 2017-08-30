package com.tuse.calculatorWebView;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.annotation.SuppressLint; 
import android.content.Context;


@SuppressLint("JavascriptInterface")
@SuppressWarnings("unused")
public class AppWebViewActivity extends Activity {
    /** Called when the activity is first created. */
	
	Button b1;
	WebView wb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_5);
        
        //b1=(Button)findViewById(R.id.button1);			
		wb =(WebView)findViewById(R.id.webView1);
		wb.getSettings().setJavaScriptEnabled(true);
		//wb.loadUrl("https://www.aiub.edu");
				
		wb.addJavascriptInterface(new WebAppInterface(this), "Android");
		wb.loadUrl("file:///android_asset/index.html");
			
    }
    
    
    public class WebAppInterface 
	{
		 Context mContext;
		 String data;
		 double myNumber2;
		 double myNumber1;
		 int sign;
		 int signForPoint;
		 
		 WebAppInterface(Context ctx)
		 {
		    this.mContext=ctx;
		    this.myNumber1=0;
		    this.myNumber2=0;
		    this.signForPoint=0;
		 }
		 
		 String opr;

		 @JavascriptInterface
		 public String addNum(String num) 
		 { 
			 if(signForPoint==1){
				 myNumber2= myNumber2+(Double.parseDouble(num)/10);
				 signForPoint=0;
			 }
			 else{
				 if(num.equals(".")){
					 signForPoint=1;
				 }
				 else {
					 myNumber2=Double.parseDouble(num);
				}				
			 }
		 	          
			 return num;
	     } 
		 
		 public String addOperator(String opr) 
		 {
			 if(opr.equals("+")){
				 sign=1;
				 myNumber1=myNumber2;
			 }
			 else if (opr.equals("-")){
				 sign=2;
				 myNumber1=myNumber2;
			 }
			 else if (opr.equals("*")){
				 sign=3;
				 myNumber1=myNumber2;
			 }
			 else if (opr.equals("/")){
				 sign=4;
				 myNumber1=myNumber2;
			 }
			 
			return opr;
	     }
		 		 
		 
		 public String getResult() 
		 {
	         double res = 0;
	         
			 if(sign==1){
				 res=myNumber1+myNumber2;
			 }
			 else if(sign==2){
				 res=myNumber1-myNumber2;
			 }
			 else if(sign==3){
				 res=myNumber1*myNumber2;
			 }
			 else if(sign==4){
				 
					 res=myNumber1/myNumber2;		 
			 }
			 
			sign=0; 
			myNumber1=0;
			myNumber2=0;
			return String.valueOf(res);
	     }
	}
}

