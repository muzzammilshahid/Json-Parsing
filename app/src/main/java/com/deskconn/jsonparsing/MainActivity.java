package com.deskconn.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONObject jsonObject = new JSONObject(loadJSONFromAsset());
            System.out.println(jsonObject.getString("firstName"));
            System.out.println(jsonObject.getString("lastName"));
            System.out.println(jsonObject.getString("gender"));
            System.out.println(jsonObject.getInt("age"));
            System.out.println(jsonObject.getJSONObject("address"));
            System.out.println(jsonObject.getJSONArray("phoneNumbers"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream inputStream = getAssets().open("user.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


}