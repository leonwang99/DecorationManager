package com.coollong.DecorationManager;
	
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
			

public class BookListActivity extends Activity {
	int selectBookType = 0;
	final String[] booklist01=new String[]{
			"(1)装修流程介绍","(2)比较详细的装修流程图","(3)室内装修具体流程","(4)史上最全装修流程","(5)新房装修流程"
			};//book001~book005
						
	final String[] booklist02=new String[]{
			"(1)新房验房注意事项(详细步骤教你如何验房)","(2)精装修验房注意事项有哪些","(3)毛坯房装修步骤(珍藏版 赶紧收藏了！)","(4)验房工具有哪些(9类验房工具用法)","(5)验房注意事项(毛坯房、新房、精装房、二手房验房大全)","(6)收房验房的步骤及注意事项",
			"(7)新房验房注意事项大全"
			};//book006~book0012	
		
	final String[] booklist03=new String[]{
			"(1)如何选择装修公司","(2)选择装饰公司应该注意什么？","(3)怎么选择装修公司秘籍","(4)装修公司的选择","(5)怎样选择家装公司？","(6)如何选择装修公司?从菜鸟到专家的十二个秘诀",
			"(7)如何选择装修公司"
			};//book0013~book0019	
			
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.booklistactivity);
        
        Intent i=this.getIntent();
        Bundle b=i.getExtras();
        selectBookType = b.getInt("Select_Book_Type", 0);
        					
        ListView lv=(ListView)findViewById(R.id.listView1);  
        
        
        if(selectBookType == 0)
        {			
        	//ArrayAdapter<String> adapter=new ArrayAdapter<String>(BookListActivity.this, android.R.layout.simple_list_item_1, booklist01);
        	List<String> arr = new ArrayList();			
        	for(int j=0; j<booklist01.length; j++)
        	{
        	  arr.add(booklist01[j]);
        	}	
        		
        	MyAdapter adapter = new MyAdapter(arr);		
        			
        	lv.setAdapter(adapter);    	
        	lv.setMinimumHeight(30);
            lv.setOnItemClickListener(new OnItemClickListener() 
            {
            	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {                
            		Bundle bundle=new Bundle();
            			
            		//将要传递的值放入到新new的Bundle对象中
            		bundle.putInt("Select_Book_Type",selectBookType);	
            		bundle.putInt("Select_Book_Num",arg2);
            					
            		Intent intent=new Intent();
            		
            		//将Bundle对象放入到Intent中
            		intent.putExtras(bundle);	
            				
            				
            		intent.setClass(BookListActivity.this, DisplayBook.class);
            		startActivity(intent);
            				
            	}         
            });       
        }	
        else if(selectBookType == 1)
        {
        	//ArrayAdapter<String> adapter=new ArrayAdapter<String>(BookListActivity.this, android.R.layout.simple_list_item_1, booklist02);
        	List<String> arr = new ArrayList();			
        	for(int j=0; j<booklist02.length; j++)
        	{
        	  arr.add(booklist02[j]);
        	}	
        		
        	MyAdapter adapter = new MyAdapter(arr);	
        	
        	lv.setAdapter(adapter);        	      
            lv.setOnItemClickListener(new OnItemClickListener() 
            {
            	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {                
            		Bundle bundle=new Bundle();
            			
            		//将要传递的值放入到新new的Bundle对象中
            		bundle.putInt("Select_Book_Type",selectBookType);	
            		bundle.putInt("Select_Book_Num",arg2);
            					
            		Intent intent=new Intent();
            		
            		//将Bundle对象放入到Intent中
            		intent.putExtras(bundle);	
            				
            				
            		intent.setClass(BookListActivity.this, DisplayBook.class);
            		startActivity(intent);
            				
            	}         
            });           	
        }
        else if(selectBookType == 2)
        {
        	//ArrayAdapter<String> adapter=new ArrayAdapter<String>(BookListActivity.this, android.R.layout.simple_list_item_1, booklist03);
        	List<String> arr = new ArrayList();			
        	for(int j=0; j<booklist03.length; j++)
        	{
        	  arr.add(booklist03[j]);
        	}	
        		
        	MyAdapter adapter = new MyAdapter(arr);	
        	
        	lv.setAdapter(adapter);        	      
            lv.setOnItemClickListener(new OnItemClickListener() 
            {
            	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {                
            		Bundle bundle=new Bundle();
            			
            		//将要传递的值放入到新new的Bundle对象中
            		bundle.putInt("Select_Book_Type",selectBookType);	
            		bundle.putInt("Select_Book_Num",arg2);
            					
            		Intent intent=new Intent();
            		
            		//将Bundle对象放入到Intent中
            		intent.putExtras(bundle);	
            				
            				
            		intent.setClass(BookListActivity.this, DisplayBook.class);
            		startActivity(intent);
            				
            	}         
            });           	
        }
         		
        
    }
    
    	
    //listview适配器，调整字体大小、颜色等
    private class MyAdapter extends BaseAdapter{ 
    	List<String> Items;  
        public MyAdapter(List<String> items) {  
            this.Items = items;  
        }  
        public int getCount() {  
            return Items.size();  
        }  
        	
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            TextView mTextView = new TextView(getApplicationContext());
            mTextView.setText(Items.get(position));
            mTextView.setTextSize(20);
            mTextView.setTextColor(Color.BLUE);
            				
            return mTextView;	
        }
        
    }
    
}	