package com.hircitech.dinnerdecision;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ManageActivity extends Activity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_layout);

        listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));
        setContentView(listView);

    }
    private ArrayList<String> getData(){

       FileIO io = new FileIO();
        try {
            return io.jsonToList(new JSONObject(io.getData(this)));
        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
