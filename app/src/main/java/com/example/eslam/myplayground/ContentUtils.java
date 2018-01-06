package com.example.eslam.myplayground;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by Eslam on 11/11/2017.
 */

public class ContentUtils {
    private static final String QUOTES = "\"";
    private static final String NEW_LINE = "\n";
    private static final String EQUALS = " = ";
    private static final String COMMA = ";";
    private static final String CONTENT_FLAT_LINK = "https://confluence.sp.vodafone.com/download/attachments/99462525/sitesExportFlat.json?version=72&modificationDate=1510067413000&api=v2&download=true";

    public static void printContent() throws Exception {
        String contentJson = "{\n" +
                "\t\"service_access_info_page_title\": \"Datos acceso a Mi Vodafone\",\n" +
                "\t\"service_access_info_page_desclaimer_title\": \"Último acceso\",\n" +
                "\t\"service_access_info_page_desclaimer_body\": \"Accediste por última vez a Mi Vodafone el 13 de septiembre de 2015 desde la App de Mi vodafone.\",\n" +
                "\t\"service_access_info_page_sections_1_title\": \"Usuario\"\n" +
                "}";
        Gson gson = new Gson();
        String json = readUrl(CONTENT_FLAT_LINK);
        Log.i("JSON",json);
        HashMap<String,String> contentMap = gson.fromJson(json, HashMap.class);
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : contentMap.keySet()) {
            key = key.replaceAll(QUOTES,"");
            stringBuilder.append("public static final String ")
                    .append(key.toUpperCase())
                    .append(EQUALS)
                    .append(QUOTES)
                    .append(key)
                    .append(QUOTES)
                    .append(COMMA)
                    .append(NEW_LINE);
        }

        Log.i("Content",stringBuilder.toString());
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
