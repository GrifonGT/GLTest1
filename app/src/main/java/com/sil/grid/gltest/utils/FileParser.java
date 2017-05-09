package com.sil.grid.gltest.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by Marik on 08.05.2017.
 */

public class FileParser {
    public static String loadJsonFromFile(Context context) {
        String json;
        try {
            InputStream is = context.getAssets().open("transition.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

    public static Map<String, Map<String, String>> jsonToMap(String json) {
        Type type = new TypeToken<Map<String, Map<String, String>>>() {}.getType();
        return new Gson().fromJson(json, type);
    }
}
