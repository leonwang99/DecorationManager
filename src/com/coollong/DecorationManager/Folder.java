package com.coollong.DecorationManager;
	
public class Folder {
    private static int folderid;
    private static String typename;
    private static int all;
    private static int other;
    

    public Folder() {
    }

    public Folder(int Folderid, String Typename, int All, int Other) {
        typename = Typename;
        folderid = Folderid;
        all = All;
        other = Other;
    }
    		
    public static int getId() {
        return folderid;
    }

    public void setId(int id) {
        folderid = id;
    }
    
    public static String getName() {
        return typename;
    }

    public void setName(String name) {
        typename = name;
    }

    public static int getAllPrice() {
        return all;
    }

    public void setAllPrice(int All) {
        all = All;        
    }
    
    public static int getOtherPrice() {
        return other;
    }

    public void setOtherPrice(int All) {
    	other = All;        
    }    	
    
}
