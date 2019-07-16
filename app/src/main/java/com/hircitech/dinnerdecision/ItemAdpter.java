package com.hircitech.dinnerdecision;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ItemAdpter extends ArrayAdapter<String> {
    private Context mContext;
    private int mResource;

    public ItemAdpter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);

        this.mResource=resource;
        this.mContext=context;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        //return super.getView(position, convertView, parent);
//        LayoutInflater inflater = LayoutInflater.from(mContext);
//
//        convertView = inflater.inflate(mResource,parent,false);
//
//
//    }
}
