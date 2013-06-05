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
        
        //�����Զ���titlebar
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.displaybookactivity);  
        			
        //ȡ��GridView����        
        GridView gridview = (GridView) findViewById(R.id.book_gridview);
        
        
        //���ɶ�̬���飬����ת������  
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();  
        for(int i=0;i<10;i++)  
        {  
        	HashMap<String, Object> map = new HashMap<String, Object>();  
        	
        	switch(i)
        	{
        	case 0:
        		map.put("ItemImage", R.drawable.bs_grid_cover_1);//���ͼ����Դ��ID  
            	map.put("ItemText", "װ������");//�������ItemText
        		break;
        	case 1:
        		map.put("ItemImage", R.drawable.bs_grid_cover_2);//���ͼ����Դ��ID  
            	map.put("ItemText", "�鷿����");//�������ItemText
        		break;
        	case 2:
        		map.put("ItemImage", R.drawable.bs_grid_cover_3);//���ͼ����Դ��ID  
            	map.put("ItemText", "װ�޹�˾ѡ��");//�������ItemText
        		break;
        	case 3:
        		map.put("ItemImage", R.drawable.bs_grid_cover_4);//���ͼ����Դ��ID  
            	map.put("ItemText", "װ�ޱ���");//�������ItemText
        		break;
        	case 4:
        		map.put("ItemImage", R.drawable.bs_grid_cover_5);//���ͼ����Դ��ID  
            	map.put("ItemText", "����ѡ��");//�������ItemText
        		break;
        	case 5:
        		map.put("ItemImage", R.drawable.bs_grid_cover_6);//���ͼ����Դ��ID  
            	map.put("ItemText", "Ӳװ����");//�������ItemText
        		break;
        	case 6:
        		map.put("ItemImage", R.drawable.bs_grid_cover_7);//���ͼ����Դ��ID  
            	map.put("ItemText", "��װ����");//�������ItemText
        		break;
        	case 7:
        		map.put("ItemImage", R.drawable.bs_grid_cover_8);//���ͼ����Դ��ID  
            	map.put("ItemText", "�������1");//�������ItemText
        		break;
        	case 8:
        		map.put("ItemImage", R.drawable.bs_grid_cover_9);//���ͼ����Դ��ID  
            	map.put("ItemText", "�������2");//�������ItemText
        		break;
        	case 9:
        		map.put("ItemImage", R.drawable.bs_grid_cover_10);//���ͼ����Դ��ID  
            	map.put("ItemText", "�������3");//�������ItemText
        		break;
        	}		
        		
        	
        	lstImageItem.add(map);  
        	
        }  
        
        //������������ImageItem <====> ��̬�����Ԫ�أ�����һһ��Ӧ  
        SimpleAdapter saImageItems = new SimpleAdapter(this, //ûʲô����  
                                                  lstImageItem,//������Դ   
                                                  R.layout.gridview_item,//night_item��XMLʵ��  
                                                    
                                                  //��̬������ImageItem��Ӧ������          
                                                  new String[] {"ItemImage","ItemText"},   
                                                    
                                                  //ImageItem��XML�ļ������һ��ImageView,����TextView ID  
                                                  new int[] {R.id.ItemImage,R.id.ItemText});  
        //��Ӳ�����ʾ  
        gridview.setAdapter(saImageItems);  

        //�����Ϣ����  
        gridview.setOnItemClickListener(new OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
        		//Toast.makeText(DisplayBookActivity.this, "��ѡ����" + (position + 1) + " ��ͼƬ", Toast.LENGTH_SHORT).show();
        			
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
        			
        		//��Ҫ���ݵ�ֵ���뵽��new��Bundle������
        		bundle.putInt("Select_Book_Type",selectBookType);			
        		Intent intent=new Intent();
        		
        		//��Bundle������뵽Intent��
        		intent.putExtras(bundle);
        				
        		intent.setClass(DisplayBookActivity.this, BookListActivity.class);	             						
                startActivity(intent);	
        					
            }				
        });
        
    }
    
    
   
  
}