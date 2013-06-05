package com.coollong.DecorationManager;



import android.app.TabActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;
	
   
public class TabWidget extends TabActivity{
	private TabHost tab ;
	private LayoutInflater layoutInflater ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
			
		setContentView(R.layout.tabwidget);
 							
		//System.out.println("211--------------");
		init();
				
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu, menu);
		return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}

	private void init(){
		tab = getTabHost();
		layoutInflater = LayoutInflater.from(this);
		int count = Constant.ConValue.mTabClassArray.length;
		//System.out.println("2--------------");
		for(int i=0;i<5;i++){
			System.out.println("2--------------");
			TabSpec tabSpec = tab.newTabSpec(Constant.ConValue.mTextviewArray[i]).
			setIndicator(getTabItemView(i)).
			setContent(getTabItemIntent(i));
			tab.addTab(tabSpec);
			
			tab.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
		}
		
	}
	
	private View getTabItemView(int index){
		//载入新的资源
		View view = layoutInflater.inflate(R.layout.tab_item_view, null);
		ImageView imageView = (ImageView)view.findViewById(R.id.imageview);
		System.out.println("11---------"+index);
		if (imageView != null)
		{
			//System.out.println(index);
			imageView.setImageResource(Constant.ConValue.mImageViewArray[index]);
		}
		TextView textView = (TextView) view.findViewById(R.id.textview);		
		textView.setText(Constant.ConValue.mTextviewArray[index]);	
		
		return view;
		
	}
	private Intent getTabItemIntent(int index)
	{
		Intent intent = new Intent(this, Constant.ConValue.mTabClassArray[index]);
		
		return intent;
	}
}
