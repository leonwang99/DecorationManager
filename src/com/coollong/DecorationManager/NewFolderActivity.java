package com.coollong.DecorationManager;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class NewFolderActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
																					
		//�����Զ���titlebar
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.newfolder_activity);  
        
        Button ok_button = (Button)findViewById(R.id.ok_button);             					
        ok_button.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				NewFolderActivity.this.finish();
			}
        });
        		
        Button cancel_button = (Button)findViewById(R.id.cancel_button);             					
        cancel_button.setOnClickListener(new OnClickListener()
        {	
			public void onClick(View v) {
				// TODO Auto-generated method stub
				NewFolderActivity.this.finish();		
			}
        });
        
        			
					
	}
}
