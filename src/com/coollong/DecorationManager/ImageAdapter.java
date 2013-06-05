package com.coollong.DecorationManager;

 
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

 
public class ImageAdapter extends BaseAdapter
{
    // ����Context
    private Context     mContext;

    // ������������ ��ͼƬԴ
    private Integer[]   mImageIds   =
    {
            R.drawable.main_001,
            R.drawable.main_002,
            R.drawable.main_003,
            R.drawable.main_004,
            R.drawable.main_005,
            R.drawable.main_006,
            R.drawable.main_007,
    };
    	
    public ImageAdapter(Context c)
    {
        mContext = c;
    }

    // ��ȡͼƬ�ĸ���
    public int getCount()
    {
        return mImageIds.length;
    }

    // ��ȡͼƬ�ڿ��е�λ��
    public Object getItem(int position)
    {
        return position;
    }

    // ��ȡͼƬID
    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView imageView;
        if (convertView == null)
        {
            // ��ImageView������Դ
            imageView = new ImageView(mContext);

            // ���ò��� ͼƬ120��120��ʾ
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            			
            // ������ʾ��������
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        else
        {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mImageIds[position]);
        return imageView;
    }
}	
