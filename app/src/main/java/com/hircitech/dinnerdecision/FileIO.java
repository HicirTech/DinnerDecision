package com.hircitech.dinnerdecision;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {

    String fileName = "data.json";

    public void saveData(Context context, String mJsonResponse) {
        try {
            FileWriter file = new FileWriter(context.getFilesDir().getPath() + "/" + fileName);
            file.write(mJsonResponse);
            file.flush();
            file.close();
        } catch (IOException e) {
            Log.e("TAG", "Error in Writing: " + e.getLocalizedMessage());
        }
    }

    public String getData(Context context) {
        try {
            File f = new File(context.getFilesDir().getPath() + "/" + fileName);
            //check whether file exists
            System.out.println(context.getFilesDir().getPath() + "/" + fileName);
            FileInputStream is = new FileInputStream(f);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (IOException e) {
            Log.e("TAG", "Error in Reading: " + e.getLocalizedMessage());
            try {
                FileWriter file = new FileWriter(context.getFilesDir().getPath() + "/" + fileName);
                file.write("");
                file.flush();
                file.close();
                return getData(context);
            } catch (IOException e1) {
                Log.e("TAG", "Error in Reading: " + e1.getLocalizedMessage());
                return null;
            }
        }
    }

    public ArrayList<String> jsonToList(JSONObject dataLoaded) throws JSONException {

        ArrayList<String> resultList = new ArrayList<>();
        String arrayData = dataLoaded.get("itemList").toString().replaceAll("\\[","");
        arrayData=arrayData.replaceAll("]","");
        arrayData=arrayData.replaceAll("\\s+","");
        String[] items = arrayData.split(",");
        for(String s : items){
            resultList.add(s);
        }
        return resultList;
    }

    public JSONObject toJSON(ArrayList<String> itemList) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("itemList", itemList);
            return jsonObject;
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
