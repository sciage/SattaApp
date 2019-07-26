package in.co.sattamaster.ui.Homepage;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import in.co.sattamaster.R;
import in.co.sattamaster.ui.PlayMatka.PlayMatkaActivity;

public class LocationGridAdapter extends BaseAdapter{
    public static class Item{
        public String text;
        public String time;
    }

    private List<Item> mItems = new ArrayList<Item>();
    private Context mContext;
    public LocationGridAdapter(Context context) {


        LocationGridAdapter.Item object = new LocationGridAdapter.Item();
        object.text = "Faridabad";
        object.time = "06:30 pm";
        mItems.add(object);
        notifyDataSetChanged();


        LocationGridAdapter.Item object02 = new LocationGridAdapter.Item();
        object02.text = "Disawar";
        object02.time = "05:30 am";

        mItems.add(object02);
        notifyDataSetChanged();


        LocationGridAdapter.Item object03 = new LocationGridAdapter.Item();
        object03.text = "Gaziabad";
        object03.time = "08:00 pm";

        mItems.add(object03);
        notifyDataSetChanged();


        LocationGridAdapter.Item object04 = new LocationGridAdapter.Item();
        object04.text = "Gali";
        object04.time = "11:00 pm";

        mItems.add(object04);
        notifyDataSetChanged();


        LocationGridAdapter.Item object05 = new LocationGridAdapter.Item();
        object05.text = "Rewari";
        object05.time = "10:00 am";


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

        TextView location_id = (TextView) convertView.findViewById(R.id.location_id);
        TextView location_time = (TextView) convertView.findViewById(R.id.location_time);
        TextView last_time = (TextView) convertView.findViewById(R.id.last_time);
        TextView new_time = (TextView) convertView.findViewById(R.id.new_time);
        ConstraintLayout location_back = (ConstraintLayout) convertView.findViewById(R.id.location_back);

        location_id.setText(mItems.get(position).text);
        location_time.setText(mItems.get(position).time);


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
