package com.example.sattaapp.ui.Homepage;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.sattaapp.R;
import com.example.sattaapp.ui.Contact.ContactUsActivity;
import com.example.sattaapp.ui.PlayMatka.PlayMatkaActivity;

public class LocationGridAdapter extends BaseAdapter{
    public static class Item{
        public String text;
        public int resId;
    }

    private List<Item> mItems = new ArrayList<Item>();
    private Context mContext;
    public LocationGridAdapter(Context context) {

        for (int i = 0; i < 5; i++) {
            Item object = new Item();
            object.text = "Text "+i;
            mItems.add(object);
        }
        mContext = context;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item, null);
        }

        TextView last_time = (TextView) convertView.findViewById(R.id.last_time);
        TextView new_time = (TextView) convertView.findViewById(R.id.new_time);
        ConstraintLayout location_back = (ConstraintLayout) convertView.findViewById(R.id.location_back);

        location_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), PlayMatkaActivity.class);
                v.getContext().startActivity(intent);
            }
        });


      //  ImageView image = (ImageView) convertView.findViewById(R.id.icon);
      //  TextView text = (TextView) convertView.findViewById(R.id.text);
      //  Item item = (Item) getItem(position);
       // image.setImageResource(item.resId);
        // text.setText(item.text);
        return convertView;
    }
}
