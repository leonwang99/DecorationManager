package com.coollong.DecorationManager;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListManagerActivity extends Activity{			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
				
		//设置自定义titlebar
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.listmanager_activity);  
        
        
        Button new_folder_button = (Button)findViewById(R.id.new_folder_button);             					
        new_folder_button.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("StillStandingActivity", "Button_start.setOnClickListener!!!!!!!!!!!!!!!!");
				Intent intent=new Intent();

				intent.setClass(ListManagerActivity.this, NewFolderActivity.class);	
				startActivityForResult(intent,0); 
			}
        });
                		
        
        SimpleAdapter adapter=new SimpleAdapter(this, getData(), R.layout.folder_view_item,new String[]{"img","name","allprice","price"},new int[]{R.id.img,R.id.folder_name,R.id.folder_allprice, R.id.folder_price});//对应R中的id 
        	
        ListView listView=(ListView)findViewById(R.id.folder_listView);
        listView.setAdapter(adapter);		
        listView.setOnItemClickListener(new OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        		// TODO Auto-generated method stub     
        		if(view==null)
        		{
        			Log.e("error", "onListItemClick : paramter : v is null");
        		}
        		else
        		{
        		}
        	}	
        });			
	}
	
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (resultCode) { 
			case RESULT_OK:
				Bundle b = data.getExtras();  
				String name = b.getString("name");
				String allPrice = b.getString("allPrice");
				String price = b.getString("price");
				
				Log.d("ListManagerActivity:", "name = " + name);
				Log.d("ListManagerActivity:", "allPrice = " + allPrice);
				Log.d("ListManagerActivity:", "price = " + price);
				
				
		        break;		
			default:	
				break;
		}
	}
	
	private List<Map<String,Object>> getData(){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("img",R.drawable.bs_grid_cover_1);
		map.put("name","建材类");
		map.put("allprice","预算：30000");
		map.put("price","余额：12000");
		list.add(map);

		map=new HashMap<String,Object>();
		map.put("img",R.drawable.bs_grid_cover_1);
		map.put("name","电器类");
		map.put("allprice","预算：50000");
		map.put("price","余额：4000");
		list.add(map);

		map=new HashMap<String,Object>();
		map.put("img",R.drawable.bs_grid_cover_1);
		map.put("name","家具类");
		map.put("allprice","预算：30000");
		map.put("price","余额：5000");
		list.add(map);

		map=new HashMap<String,Object>();
		map.put("img",R.drawable.bs_grid_cover_1);
		map.put("name","五金类");
		map.put("allprice","预算：10000");
		map.put("price","余额：5000");
		list.add(map);

		map=new HashMap<String,Object>();
		map.put("img",R.drawable.bs_grid_cover_1);
		map.put("name","工程类");
		map.put("allprice","预算：30000");
		map.put("price","余额：5000");
		list.add(map);

		map=new HashMap<String,Object>();
		map.put("img",R.drawable.bs_grid_cover_1);
		map.put("name","软装类");
		map.put("allprice","预算：30000");
		map.put("price","余额：5000");
		list.add(map);

		map=new HashMap<String,Object>();
		map.put("img",R.drawable.bs_grid_cover_1);
		map.put("name","其他类");
		map.put("allprice","预算：30000");
		map.put("price","余额：5000");
		list.add(map);
			
		return list;
	}
	
}
