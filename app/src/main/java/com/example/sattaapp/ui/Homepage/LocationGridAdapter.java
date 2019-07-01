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
import com.example.sattaapp.ui.History.HistoryActivity;
import com.example.sattaapp.ui.PlayMatka.PlayMatkaActivity;
import com.example.sattaapp.ui.Result.ResultActivity;
import com.example.sattaapp.ui.Withdraw.WithdrawActivity;

public class LocationGridAdapter extends BaseAdapter{
    public static class Item{
        public String text;
        public int resId;
    }

    private List<Item> mItems = new ArrayList<Item>();
    private Context mContext;
    public LocationGridAdapter(Context context) {


        LocationGridAdapter.Item object = new LocationGridAdapter.Item();
        object.text = "Faridabad";
        mItems.add(object);
        notifyDataSetChanged();


        LocationGridAdapter.Item object02 = new LocationGridAdapter.Item();
        object02.text = "Disawar";
        mItems.add(object02);
        notifyDataSetChanged();


        LocationGridAdapter.Item object03 = new LocationGridAdapter.Item();
        object03.text = "Gaziabad";
        mItems.add(object03);
        notifyDataSetChanged();


        LocationGridAdapter.Item object04 = new LocationGridAdapter.Item();
        object04.text = "Gali";
        mItems.add(object04);
        notifyDataSetChanged();


        LocationGridAdapter.Item object05 = new LocationGridAdapter.Item();
        object05.text = "Rewari";
        mItems.add(object05);
        notifyDataSetChanged();

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

        if (position == 0){
            location_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), PlayMatkaActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        } else if (position == 1){
            location_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), PlayMatkaActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        } else if (position == 2){
            location_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), PlayMatkaActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        } else if (position == 3){
            location_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), PlayMatkaActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        } else if (position == 4){
            location_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), PlayMatkaActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }

      //  ImageView image = (ImageView) convertView.findViewById(R.id.icon);
      //  TextView text = (TextView) convertView.findViewById(R.id.text);
      //  Item item = (Item) getItem(position);
       // image.setImageResource(item.resId);
        // text.setText(item.text);
        return convertView;
    }
}
