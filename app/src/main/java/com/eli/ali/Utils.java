package com.eli.ali;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

    private static AssetManager mAssetManager;

    public static Bitmap getBitmap(Context context, String path) {
        if (mAssetManager == null) {
            mAssetManager = context.getAssets();
        }
        InputStream inputStream = null;
        try {
            inputStream = mAssetManager.open(path);
        } catch (IOException e) {
        }
        if (inputStream != null) {
            return BitmapFactory.decodeStream(inputStream);
        }

        return null;
    }
}
