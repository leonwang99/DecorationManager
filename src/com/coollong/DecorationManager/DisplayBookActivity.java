package com.coollong.DecorationManager;


	
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class DisplayBookActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //设置自定义titlebar
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.displaybookactivity);  
        			
        //取得GridView对象        
        GridView gridview = (GridView) findViewById(R.id.book_gridview);
        
        
        //生成动态数组，并且转入数据  
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();  
        for(int i=0;i<10;i++)  
        {  
        	HashMap<String, Object> map = new HashMap<String, Object>();  
        	
        	switch(i)
        	{
        	case 0:
        		map.put("ItemImage", R.drawable.bs_grid_cover_1);//添加图像资源的ID  
            	map.put("ItemText", "装修流程");//按序号做ItemText
        		break;
        	case 1:
        		map.put("ItemImage", R.drawable.bs_grid_cover_2);//添加图像资源的ID  
            	map.put("ItemText", "验房宝典");//按序号做ItemText
        		break;
        	case 2:
        		map.put("ItemImage", R.drawable.bs_grid_cover_3);//添加图像资源的ID  
            	map.put("ItemText", "装修公司选择");//按序号做ItemText
        		break;
        	case 3:
        		map.put("ItemImage", R.drawable.bs_grid_cover_4);//添加图像资源的ID  
            	map.put("ItemText", "装修报价");//按序号做ItemText
        		break;
        	case 4:
        		map.put("ItemImage", R.drawable.bs_grid_cover_5);//添加图像资源的ID  
            	map.put("ItemText", "材料选择");//按序号做ItemText
        		break;
        	case 5:
        		map.put("ItemImage", R.drawable.bs_grid_cover_6);//添加图像资源的ID  
            	map.put("ItemText", "硬装流程");//按序号做ItemText
        		break;
        	case 6:
        		map.put("ItemImage", R.drawable.bs_grid_cover_7);//添加图像资源的ID  
            	map.put("ItemText", "软装流程");//按序号做ItemText
        		break;
        	case 7:
        		map.put("ItemImage", R.drawable.bs_grid_cover_8);//添加图像资源的ID  
            	map.put("ItemText", "经验分享1");//按序号做ItemText
        		break;
        	case 8:
        		map.put("ItemImage", R.drawable.bs_grid_cover_9);//添加图像资源的ID  
            	map.put("ItemText", "经验分享2");//按序号做ItemText
        		break;
        	case 9:
        		map.put("ItemImage", R.drawable.bs_grid_cover_10);//添加图像资源的ID  
            	map.put("ItemText", "经验分享3");//按序号做ItemText
        		break;
        	}		
        		
        	
        	lstImageItem.add(map);  
        	
        }  
        
        //生成适配器的ImageItem <====> 动态数组的元素，两者一一对应  
        SimpleAdapter saImageItems = new SimpleAdapter(this, //没什么解释  
                                                  lstImageItem,//数据来源   
                                                  R.layout.gridview_item,//night_item的XML实现  
                                                    
                                                  //动态数组与ImageItem对应的子项          
                                                  new String[] {"ItemImage","ItemText"},   
                                                    
                                                  //ImageItem的XML文件里面的一个ImageView,两个TextView ID  
                                                  new int[] {R.id.ItemImage,R.id.ItemText});  
        //添加并且显示  
        gridview.setAdapter(saImageItems);  

        //添加消息处理  
        gridview.setOnItemClickListener(new OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
        		//Toast.makeText(DisplayBookActivity.this, "你选择了" + (position + 1) + " 号图片", Toast.LENGTH_SHORT).show();
        			
        		int selectBookType = 0;
        			
        		switch(position)
        		{	
        		case 0:
        			selectBookType = 0;
        			break;
        		case 1:
        			selectBookType = 1;
        			break;
        		case 2:
        			selectBookType = 2;
        			break;
        		case 3:
        			selectBookType = 3;
        			break;
        		case 4:
        			selectBookType = 4;
        			break;
        		case 5:
        			selectBookType = 5;
        			break;
        		case 6:
        			selectBookType = 6;
        			break;
        		case 7:
        			selectBookType = 7;
        			break;
        		case 8:
        			selectBookType = 8;
        			break;
        		case 9:
        			selectBookType = 9;
        			break;        			
        		}	
        					
        		Bundle bundle=new Bundle();
        			
        		//将要传递的值放入到新new的Bundle对象中
        		bundle.putInt("Select_Book_Type",selectBookType);			
        		Intent intent=new Intent();
        		
        		//将Bundle对象放入到Intent中
        		intent.putExtras(bundle);
        				
        		intent.setClass(DisplayBookActivity.this, BookListActivity.class);	             						
                startActivity(intent);	
        					
            }				
        });
        
    }
    
    
   
  
}