package com.example.lab23;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.io.Serializable;

public class Furniture implements Serializable {

    String name;
    String description;
    Bitmap image;

    public Furniture(String name, String description, Bitmap image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
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
