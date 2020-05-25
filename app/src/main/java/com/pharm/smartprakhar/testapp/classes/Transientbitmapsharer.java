package com.pharm.smartprakhar.testapp.classes;

import android.graphics.Bitmap;

 public class Transientbitmapsharer {
   private static Transientbitmapsharer obj;

    private Transientbitmapsharer() {
    }
   public static Transientbitmapsharer getsharer()
    {
        if(obj==null)
        {
         obj=   new Transientbitmapsharer();
        }
        return obj;

    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    Bitmap bitmap;
}
