package com.techjany.customlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Star Gazer on 1/11/2018.
 */

public class MyAdapter extends ArrayAdapter<String> {

    String[] names;
    Context mContext;

   public MyAdapter(Context context, String[] countryNames){
       super(context, R.layout.listview_item);
       this.names = countryNames;
       this.mContext = context;
   }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

       ViewHolder mViewholder = new ViewHolder();
       if(convertView == null){

           LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = inflater.inflate(R.layout.listview_item, parent,false);
           mViewholder.mNames = convertView.findViewById(R.id.textView);
           convertView.setTag(mViewholder);

       }else {
           mViewholder = (ViewHolder) convertView.getTag();
       }

        mViewholder.mNames.setText(names[position]);
        return convertView;
    }

    static class ViewHolder{
       TextView mNames;
    }
}
