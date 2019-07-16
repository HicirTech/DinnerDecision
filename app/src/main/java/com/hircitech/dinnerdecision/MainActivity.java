package com.hircitech.dinnerdecision;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchToAddMenu(View view) {
        Intent addMenu = new Intent(this, AddMenuActivity.class);
        startActivity(addMenu);
    }

    public void switchToManageMenu(View view)  {

        Intent addMenu = new Intent(this, ManageActivity.class);
        startActivity(addMenu);
    }

    public void onShowClicked(View view) {
        FileIO io = new FileIO();
        TextView textResult = findViewById(R.id.result_text);
        try {
            JSONObject resultSet = new JSONObject(io.getData(this));
            ArrayList<String> resultList = io.jsonToList(resultSet);
            textResult.setVisibility(View.VISIBLE);
            textResult.setText(resultList.get((int) (Math.random() * resultList.size())));
        } catch (JSONException e) {
            Toast.makeText(this, "No item in you menu yet, go add one", Toast.LENGTH_LONG).show();
        }
    }
}
