package com.example.sattaapp.ui.Homepage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sattaapp.R;
import com.example.sattaapp.SquareLayout;
import com.example.sattaapp.ui.Contact.ContactUsActivity;
import com.example.sattaapp.ui.History.HistoryActivity;
import com.example.sattaapp.ui.Result.ResultActivity;
import com.example.sattaapp.ui.Withdraw.WithdrawActivity;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends BaseAdapter{
    public static class Item{
        public String text;
        public int resId;
    }

    private List<Item> mItems = new ArrayList<Item>();
    private Context mContext;
    public GridAdapter(Context context) {

        Item object = new Item();
        object.text = "Play Matka";
        mItems.add(object);
        notifyDataSetChanged();


        Item object02 = new Item();
        object02.text = "Contact Us";
        mItems.add(object02);
        notifyDataSetChanged();


        Item object03 = new Item();
        object03.text = "Withdraw Balance";
        mItems.add(object03);
        notifyDataSetChanged();


        Item object04 = new Item();
        object04.text = "History";
        mItems.add(object04);
        notifyDataSetChanged();


        Item object05 = new Item();
        object05.text = "Result chart";
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.mainpage_item, null);
        }

        TextView location_id = (TextView) convertView.findViewById(R.id.location_id);

        SquareLayout box_back = (SquareLayout) convertView.findViewById(R.id.mainPageBack);

        location_id.setText(mItems.get(position).text);

        if (position == 0){
            box_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), LocationPageActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        } else if (position == 1){
            box_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ContactUsActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        } else if (position == 2){
            box_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), WithdrawActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        } else if (position == 3){
            box_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), HistoryActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        } else if (position == 4){
            box_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ResultActivity.class);
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
