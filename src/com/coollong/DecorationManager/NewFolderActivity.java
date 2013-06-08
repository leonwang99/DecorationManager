package com.coollong.DecorationManager;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class NewFolderActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
																					
		//�����Զ���titlebar
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.newfolder_activity);  
        
        final EditText name_editText = (EditText)findViewById(R.id.name_editText);
        final EditText allprice_editText = (EditText)findViewById(R.id.allprice_editText);
        final EditText price_editText = (EditText)findViewById(R.id.price_editText);
        	
        
        Button ok_button = (Button)findViewById(R.id.ok_button);             					
        ok_button.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent aintent = new Intent(NewFolderActivity.this, ListManagerActivity.class);
				
				String name = name_editText.toString(); 
				String allPrice = allprice_editText.toString();	
				String price = price_editText.toString();	
				
				aintent.putExtra("name", name);
				aintent.putExtra("allPrice", allPrice);
				aintent.putExtra("price", price);
					
					
				/* �����ݴ����aintent Bundle �Ĺ����� */
				setResult(RESULT_OK, aintent); //������2������(int resultCode, Intent intent)
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
