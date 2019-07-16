package com.hircitech.dinnerdecision;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AddMenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);
    }

    public void addAction(View view) throws JSONException {
        EditText userInputView = findViewById(R.id.add_menu_inputText);
        String userInput = userInputView.getText().toString();
        FileIO io = new FileIO();
        String fileInput = io.getData(this);
        ArrayList<String> itemList;


        if (fileInput.length()!=0) {
            JSONObject dataLoaded = new JSONObject(fileInput);
            itemList=io.jsonToList(dataLoaded);
        } else {
            itemList = new ArrayList<>();
        }

        System.out.println(itemList);
        if (!userInput.equals("")&&!itemList.contains(userInput)) {
            itemList.add(userInput);
            Toast.makeText(this,"Data added",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"repeated or empty String",Toast.LENGTH_SHORT).show();
        }
        JSONObject objectToSave = io.toJSON(itemList);
        io.saveData(this, objectToSave.toString());
    }
}
