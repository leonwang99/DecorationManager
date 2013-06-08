package com.coollong.DecorationManager;  
  
  
import java.util.ArrayList;  
import java.util.Random;  
  
import android.content.ContentValues;  
import android.content.Context;  
import android.database.Cursor;  
import android.database.sqlite.SQLiteDatabase;  
import android.database.sqlite.SQLiteOpenHelper;  
  
public class FolderDAO extends SQLiteOpenHelper {  
	
    private final static String AUDIODATABASE_NAME = "student.db";  
    private final static String TABLE = "student";  
    private final static String COLUM_ID = "id";  
    private final static String COLUM_NAME = "name";  
    private final static String COLUM_AGE = "age";  
    private final static int DATABASE_VERSION = 1;  
    private long row;  
    private ArrayList<Students> arrayList;  
  
    public FolderDAO(Context context) {  
        super(context, AUDIODATABASE_NAME, null, DATABASE_VERSION);  
        // TODO Auto-generated constructor stub  
    }  
  
    @Override  
    public void onCreate(SQLiteDatabase db) {  
        // TODO Auto-generated method stub  
        String sql = "CREATE TABLE " + TABLE + " (" + COLUM_ID  
                + " INTEGER primary key autoincrement, " + " " + COLUM_NAME  
                + " text, " + " " + COLUM_AGE + " int)";  
        db.execSQL(sql);  
    }  
  
    @Override  
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  
        // TODO Auto-generated method stub  
        String sql = "DROP TABLE IF EXISTS " + TABLE;  
        db.execSQL(sql);  
    }  
  
    public long insert() {  
        SQLiteDatabase db = getWritableDatabase();  
        ContentValues cv = new ContentValues();  
        Random random = new Random();  
        for(int i=1;i<=100;i++)  
        {  
            cv.put(COLUM_ID, i);  
            cv.put(COLUM_NAME, "name"+String.valueOf(i));  
            cv.put(COLUM_AGE, random.nextInt(100));  
            row = db.insert(TABLE, null, cv);  
        }  
        db.close();  
        return row;  
    }
    
    //查询记录的总数  
    public int getCount() {  
    	SQLiteDatabase db = getWritableDatabase();  
        String sql = "select count(*) from '"+TABLE+"'";  
        Cursor c = db.rawQuery(sql, null);  
        c.moveToFirst();  
        int length = c.getInt(0);  
        c.close();  
        db.close();  
        // System.out.println("length-->"+length);  
        return length;  
     }  
        
    public  ArrayList<Students> getAllItems(int firstResult, int maxResult) {  
    	arrayList=new ArrayList<Students>();  
        SQLiteDatabase db = getWritableDatabase();  
        String sql = "select * from '"+TABLE+"' limit ?,?";  
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(firstResult), String.valueOf(maxResult)});  
        
        if (cursor != null && cursor.getCount() > 0) {  
        	cursor.moveToFirst();  
        }  
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {  
        	Students students=new Students();  
            students.setId(cursor.getInt(0));  
            students.setName(cursor.getString(1));  
            students.setAge(cursor.getInt(2));  
            arrayList.add(students);  
        }  
        cursor.close();  
        db.close();  
        return arrayList;  
    }  
          
    public ArrayList<Students> selectAll() {  
        arrayList=new ArrayList<Students>();  
        SQLiteDatabase db = this.getWritableDatabase();  
        Cursor cursor = db.query(TABLE, null, null, null, null, null, null);  
        if (cursor != null && cursor.getCount() > 0) {  
            cursor.moveToFirst();  
        }  
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {  
            Students students=new Students();  
            students.setId(cursor.getInt(0));  
            students.setName(cursor.getString(1));  
            students.setAge(cursor.getInt(2));  
            arrayList.add(students);  
        }  
        cursor.close();  
        db.close();  
        return arrayList;            
    }  
  
}  