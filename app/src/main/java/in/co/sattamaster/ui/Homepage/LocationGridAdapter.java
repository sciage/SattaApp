package in.co.sattamaster.ui.Homepage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

import in.co.sattamaster.R;
import in.co.sattamaster.ui.Homepage.LocationPojo;
import in.co.sattamaster.ui.PlayMatka.PlayMatkaActivity;
import in.co.sattamaster.ui.base.Constants;

public class LocationGridAdapter extends BaseAdapter {
    private List<LocationPojo> dataSet = new ArrayList<>();
    private Context mContext;
    String USER_NAME;
    String MODERATOR_NAME;
    String MODERATOR_MOBILE;
    String WALLET_BALANCE;

    public LocationGridAdapter(Context context) {
        mContext = context;
    }

    public void addAll(List<LocationPojo> moveResults) {
        for (LocationPojo result : moveResults) {
            add(result);
            notifyDataSetChanged();
        }


    }

    public void AddActivityData(String USER_NAME, String MODERATOR_NAME, String MODERATOR_MOBILE, String WALLET_BALANCE){
        this.USER_NAME = USER_NAME;
        this.MODERATOR_NAME = MODERATOR_NAME;
        this.MODERATOR_MOBILE = MODERATOR_MOBILE;
        this.WALLET_BALANCE = WALLET_BALANCE;
    }

    public void clear() {
        dataSet.clear();
        notifyDataSetChanged();
    }


    public void add(LocationPojo r) {
        dataSet.add(r);

    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.squareitem,
                    null);
        }

        TextView location_name = (TextView) convertView.findViewById(R.id.location_id);
        TextView location_time = (TextView) convertView.findViewById(R.id.location_time);
        TextView last_time = (TextView) convertView.findViewById(R.id.last_time);
        TextView new_time = (TextView) convertView.findViewById(R.id.new_time);
        ConstraintLayout location_back = (ConstraintLayout) convertView.findViewById(R.id.location_back);

        location_name.setText(dataSet.get(position).getName());
        location_time.setText(dataSet.get(position).getNumberRevealTime());
        if (dataSet.get(position).getNumberLast() != null){
            last_time.setText(dataSet.get(position).getNumberLast());
        } else {
            last_time.setText("XX");

        }

        if (dataSet.get(position).getNumberCurrent() != null){
            new_time.setText(dataSet.get(position).getNumberCurrent());
        } else {
            new_time.setText("XX");

        }


        location_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayMatkaActivity.class);
                intent.putExtra(Constants.USER_NAME, USER_NAME);
                intent.putExtra(Constants.MODERATOR_NAME, MODERATOR_NAME);
                intent.putExtra(Constants.MODERATOR_MOBILE, MODERATOR_MOBILE);
                intent.putExtra(Constants.WALLET_BALANCE, WALLET_BALANCE);
                intent.putExtra(Constants.LOCATION, dataSet.get(position).getId());
                intent.putExtra(Constants.LOCATION_NAME, dataSet.get(position).getName());
                v.getContext().startActivity(intent);
            }
        });

        location_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), PlayMatkaActivity.class);
                intent.putExtra(Constants.USER_NAME, USER_NAME);
                intent.putExtra(Constants.MODERATOR_NAME, MODERATOR_NAME);
                intent.putExtra(Constants.MODERATOR_MOBILE, MODERATOR_MOBILE);
                intent.putExtra(Constants.WALLET_BALANCE, WALLET_BALANCE);
                intent.putExtra(Constants.LOCATION, dataSet.get(position).getId());
                intent.putExtra(Constants.LOCATION_NAME, dataSet.get(position).getName());
                v.getContext().startActivity(intent);
            }
        });

        last_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayMatkaActivity.class);
                intent.putExtra(Constants.USER_NAME, USER_NAME);
                intent.putExtra(Constants.MODERATOR_NAME, MODERATOR_NAME);
                intent.putExtra(Constants.MODERATOR_MOBILE, MODERATOR_MOBILE);
                intent.putExtra(Constants.WALLET_BALANCE, WALLET_BALANCE);
                intent.putExtra(Constants.LOCATION, dataSet.get(position).getId());
                intent.putExtra(Constants.LOCATION_NAME, dataSet.get(position).getName());
                v.getContext().startActivity(intent);
            }
        });

        new_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayMatkaActivity.class);
                intent.putExtra(Constants.USER_NAME, USER_NAME);
                intent.putExtra(Constants.MODERATOR_NAME, MODERATOR_NAME);
                intent.putExtra(Constants.MODERATOR_MOBILE, MODERATOR_MOBILE);
                intent.putExtra(Constants.WALLET_BALANCE, WALLET_BALANCE);
                intent.putExtra(Constants.LOCATION, dataSet.get(position).getId());
                intent.putExtra(Constants.LOCATION_NAME, dataSet.get(position).getName());

                v.getContext().startActivity(intent);
            }
        });

        location_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayMatkaActivity.class);
                intent.putExtra(Constants.USER_NAME, USER_NAME);
                intent.putExtra(Constants.MODERATOR_NAME, MODERATOR_NAME);
                intent.putExtra(Constants.MODERATOR_MOBILE, MODERATOR_MOBILE);
                intent.putExtra(Constants.WALLET_BALANCE, WALLET_BALANCE);
                intent.putExtra(Constants.LOCATION, dataSet.get(position).getId());
                intent.putExtra(Constants.LOCATION_NAME, dataSet.get(position).getName());
                v.getContext().startActivity(intent);
            }
        });

        return convertView;
    }

}
