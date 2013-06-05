package com.coollong.DecorationManager;

import java.util.ArrayList;
import java.util.List;




import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class PoupWindowDemoActivity extends Activity {

	private PopupWindow popupWindow;

	private ListView lv_group;

	private View view;

	private View top_title;

	private TextView tvtitle;

	private List<String> groups;
	
	private Button button;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
	}

}