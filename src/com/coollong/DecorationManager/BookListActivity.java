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
			"(1)װ�����̽���","(2)�Ƚ���ϸ��װ������ͼ","(3)����װ�޾�������","(4)ʷ����ȫװ������","(5)�·�װ������"
			};//book001~book005
						
	final String[] booklist02=new String[]{
			"(1)�·��鷿ע������(��ϸ�����������鷿)","(2)��װ���鷿ע����������Щ","(3)ë����װ�޲���(��ذ� �Ͻ��ղ��ˣ�)","(4)�鷿��������Щ(9���鷿�����÷�)","(5)�鷿ע������(ë�������·�����װ�������ַ��鷿��ȫ)","(6)�շ��鷿�Ĳ��輰ע������",
			"(7)�·��鷿ע�������ȫ"
			};//book006~book0012	
		
	final String[] booklist03=new String[]{
			"(1)���ѡ��װ�޹�˾","(2)ѡ��װ�ι�˾Ӧ��ע��ʲô��","(3)��ôѡ��װ�޹�˾�ؼ�","(4)װ�޹�˾��ѡ��","(5)����ѡ���װ��˾��","(6)���ѡ��װ�޹�˾?�Ӳ���ר�ҵ�ʮ�����ؾ�",
			"(7)���ѡ��װ�޹�˾"
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
            			
            		//��Ҫ���ݵ�ֵ���뵽��new��Bundle������
            		bundle.putInt("Select_Book_Type",selectBookType);	
            		bundle.putInt("Select_Book_Num",arg2);
            					
            		Intent intent=new Intent();
            		
            		//��Bundle������뵽Intent��
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
            			
            		//��Ҫ���ݵ�ֵ���뵽��new��Bundle������
            		bundle.putInt("Select_Book_Type",selectBookType);	
            		bundle.putInt("Select_Book_Num",arg2);
            					
            		Intent intent=new Intent();
            		
            		//��Bundle������뵽Intent��
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
            			
            		//��Ҫ���ݵ�ֵ���뵽��new��Bundle������
            		bundle.putInt("Select_Book_Type",selectBookType);	
            		bundle.putInt("Select_Book_Num",arg2);
            					
            		Intent intent=new Intent();
            		
            		//��Bundle������뵽Intent��
            		intent.putExtras(bundle);	
            				
            				
            		intent.setClass(BookListActivity.this, DisplayBook.class);
            		startActivity(intent);
            				
            	}         
            });           	
        }
         		
        
    }
    
    	
    //listview�����������������С����ɫ��
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