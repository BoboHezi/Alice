package com.eli.ali;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static <T> List loadList(String path, Class<T> tClass, Context context) {
        List result = new ArrayList<>();

        if (mAssetManager == null) {
            mAssetManager = context.getAssets();
        }

        InputStream inputStream = null;
        try {
            inputStream = mAssetManager.open(path);
        } catch (IOException e) {
        }
        if (inputStream != null) {
            String str = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining(System.lineSeparator()));
            Gson gson = new Gson();

            result = Arrays.asList(gson.fromJson(str, (Type) tClass));
        }
        return result;
    }
}
