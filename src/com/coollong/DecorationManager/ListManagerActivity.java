package com.coollong.DecorationManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class ListManagerActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
				
		//�����Զ���titlebar
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.listmanager_activity);  
        		
        
		
	}
}