package com.ntrlab.ntrlabtest.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ObjectFetcher {
    private static final String TAG = "CharacterFetcher";

    public String getJSONString(String url) throws IOException {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        URL urlRes = new URL(url);

        try {
            urlConnection = (HttpURLConnection) urlRes.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            resultJson = buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultJson;
    }

    public Entity fetchEntity(String url) {
        Entity entity = new Entity();
        try {
            String jsonString = getJSONString(url);
            JSONObject jsonBody = new JSONObject(jsonString);
            parseItem(entity, jsonBody);
        } catch (IOException ex) {
            Log.e(TAG , "Ошибка загрузки данных", ex);
        } catch (JSONException jex) {
            Log.e(TAG , "Empty JSON", jex);
        }

        return entity;
    }

    private void parseItem(Entity entity, JSONObject object)
            throws IOException, JSONException {


        entity.setObjects(parseArrayItems(object, "object"));
//        item.setUrl(object.getString("url"));
    }

    private List<NTRObject> parseArrayItems(JSONObject object, String str)
            throws IOException, JSONException {
        List<NTRObject> list = new ArrayList<>();
        JSONObject jObject = object.getJSONObject("objects");
        JSONArray jsonArray = jObject.getJSONArray(str);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            list.add(new NTRObject(obj.getString("name"),
                    obj.getString("title"),
                    obj.getString("object_id")));
        }
        return list;
    }
}
