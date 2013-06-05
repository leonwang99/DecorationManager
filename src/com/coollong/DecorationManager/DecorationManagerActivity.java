package com.coollong.DecorationManager;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class DecorationManagerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        		
        
		Intent intent=new Intent();

		intent.setClass(DecorationManagerActivity.this, TabWidget.class);	             						
        startActivity(intent);	
        	
    }
}