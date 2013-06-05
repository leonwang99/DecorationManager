package com.coollong.DecorationManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class DiaryShareActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//设置自定义titlebar
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.diaryshare_activity); 
	}
}
