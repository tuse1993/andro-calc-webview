package com.tuse.calculatorWebView;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "History5.db";
	public static final String TABLE_NAME = "History_Table";
	public static final String Col_1 = "PROBLEM";
	public static final String Col_2 = "RESULT";
	public static final String Col_3 = "TIME";
	


	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);	
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table " + TABLE_NAME + "(PROBLEM TEXT, RESULT TEXT, TIME TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists" + TABLE_NAME);
		onCreate(db);
	}
	
	public boolean insertData(String problem, String result, String time){
		
		
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(Col_1, problem);
		contentValues.put(Col_2, result);
		contentValues.put(Col_3, time);
		
		long operationResult = db.insert(TABLE_NAME, null, contentValues);
		
		db.close();
		
		if(operationResult == -1){
			return false;
		}
		else {
			return true;
		}	
	}
	
	
	public Cursor getAllData(){
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor resCursor = db.rawQuery("select * from "+TABLE_NAME, null);
		return resCursor;
	}
	
	public boolean deleteData(){
		SQLiteDatabase db = this.getWritableDatabase();
		long tmp = db.delete(TABLE_NAME, null, null);
		db.close();

		if(tmp > 0){
			return true;
		}
		else {
			return false;
		}
	}
	
}
