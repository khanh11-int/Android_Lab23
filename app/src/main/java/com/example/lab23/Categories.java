package com.example.lab23;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.util.ArrayList;

public class Categories {

    String name;
    ArrayList<Furniture> arrayList;
    Bitmap image;

    public Categories(String name, ArrayList<Furniture> arrayList, Bitmap image) {
        this.name = name;
        this.arrayList = arrayList;
        this.image = image;
    }

    public String getName() { return name; }
    public ArrayList<Furniture> getArrayList() { return arrayList; }
    public Bitmap getImage() { return image; }

    public static Bitmap convertStringToBitmapFromAccess(Context context, String filename){
        try {
            InputStream is = context.getAssets().open(filename);
            return BitmapFactory.decodeStream(is);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
