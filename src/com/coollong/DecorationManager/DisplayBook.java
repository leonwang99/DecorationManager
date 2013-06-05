package com.coollong.DecorationManager;



import java.io.InputStream;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

public class DisplayBook extends Activity {
	private ProgressDialog progressDialog;
	public static final int UPDATE_BEGIN_UI_REQUEST_CODE = 1001;
	protected Handler splashHandler;
	protected TextView title;
	protected TextView content;
	protected BookContent bookcontent;
	protected int selectBookType = 0;
	protected int selectBookNum = 0;
	
	final int[] booklist01=new int[]{
    		R.raw.book001, R.raw.book002, R.raw.book003, R.raw.book004,R.raw.book005
			};					
	final int[] booklist02=new int[]{
    		R.raw.book006, R.raw.book007, R.raw.book008, R.raw.book009,R.raw.book0010,R.raw.book0011, R.raw.book0012
			};
	final int[] booklist03=new int[]{
    		R.raw.book0013, R.raw.book0014, R.raw.book0015, R.raw.book0016,R.raw.book0017,R.raw.book0018, R.raw.book0019
			};		
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.showbook);        
        
        Intent i=this.getIntent();
        Bundle b=i.getExtras();
        selectBookType = b.getInt("Select_Book_Type", 0);
        selectBookNum = b.getInt("Select_Book_Num", 0);
        
        
        splashHandler = new Handler() {
            public void handleMessage(Message msg) {
              switch (msg.what) {
              case UPDATE_BEGIN_UI_REQUEST_CODE:
            	  title.setText(bookcontent.getName());	
            	  content.setText(bookcontent.getContent());
                  progressDialog.dismiss();	
            	  break;	
            	  			
              default:
                  break;
              }
              super.handleMessage(msg);
            }	
        }; 
        
        title=(TextView)findViewById(R.id.book_title);
        content=(TextView)findViewById(R.id.book_content); 
        		
        myThread mythread = new myThread();
        mythread.run();	        
    }	
    
    
    //add thread
    class myThread implements Runnable {             
    	public void run() {                 
    		//while (!Thread.currentThread().isInterrupted()) {  
    			progressDialog = ProgressDialog.show(DisplayBook.this, "Loading...", "Please wait...", true, false);  
    				
                                                           
    			//Thread.sleep(100); 
				InputStream is = null;
				is = GetResources();		
				bookcontent = BookContentParse.getBookContent(is);	
						
				Message message = new Message();                       
				message.what = UPDATE_BEGIN_UI_REQUEST_CODE;     
				splashHandler.sendMessage(message);                  
    			//}             
    		}        
    	} 
    
    public InputStream GetResources()
    {		
    	InputStream is = null;
		
		if(selectBookType == 0)
		{
			switch(selectBookNum)
			{
			case 0:
				is = getResources().openRawResource(R.raw.book001);
				break;
			case 1:
				is = getResources().openRawResource(R.raw.book002);
				break;
			case 2:
				is = getResources().openRawResource(R.raw.book003);
				break;
			case 3:
				is = getResources().openRawResource(R.raw.book004);
				break;
			case 4:
				is = getResources().openRawResource(R.raw.book005);
				break;
			default:
				is = getResources().openRawResource(R.raw.book001);
				break;
			}
		}
		else if(selectBookType == 1)
		{
			switch(selectBookNum)
			{
			case 0:
				is = getResources().openRawResource(R.raw.book006);
				break;
			case 1:
				is = getResources().openRawResource(R.raw.book007);
				break;
			case 2:
				is = getResources().openRawResource(R.raw.book008);
				break;
			case 3:
				is = getResources().openRawResource(R.raw.book009);
				break;
			case 4:
				is = getResources().openRawResource(R.raw.book0010);
				break;
			case 5:
				is = getResources().openRawResource(R.raw.book0011);
				break;
			case 6:
				is = getResources().openRawResource(R.raw.book0012);
				break;				
			default:
				is = getResources().openRawResource(R.raw.book006);
				break;
			}
		}		
		else if(selectBookType == 2)
		{
			switch(selectBookNum)
			{
			case 0:
				is = getResources().openRawResource(R.raw.book0013);
				break;
			case 1:
				is = getResources().openRawResource(R.raw.book0014);
				break;
			case 2:
				is = getResources().openRawResource(R.raw.book0015);
				break;
			case 3:
				is = getResources().openRawResource(R.raw.book0016);
				break;
			case 4:
				is = getResources().openRawResource(R.raw.book0017);
				break;
			case 5:
				is = getResources().openRawResource(R.raw.book0018);
				break;
			case 6:
				is = getResources().openRawResource(R.raw.book0019);
				break;				
			default:
				is = getResources().openRawResource(R.raw.book0013);
				break;
			}
		}		

			
    	return is;
    }
}