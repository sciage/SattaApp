package in.co.sattamaster.ui.Homepage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import in.co.sattamaster.R;
import in.co.sattamaster.SquareLayout;
import in.co.sattamaster.ui.Contact.ContactUsActivity;
import in.co.sattamaster.ui.History.HistoryActivity;
import in.co.sattamaster.ui.History.HistoryDetailsActivity;
import in.co.sattamaster.ui.Result.ResultActivity;
import in.co.sattamaster.ui.Withdraw.WithdrawActivity;
import in.co.sattamaster.ui.Withdraw.WithdrawDetailsActivity;
import in.co.sattamaster.ui.base.Constants;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends BaseAdapter{
    private UserObject dataSet;


    public static class Item{
        public String text;
        public int resId;
    }

    public void addAll(UserObject moveResults) {
            dataSet = moveResults;
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

        Item object06 = new Item();
        object06.text = "Withdraw History";
        mItems.add(object06);
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
        ImageView home_page_image = (ImageView) convertView.findViewById(R.id.home_page_image);

        SquareLayout box_back = (SquareLayout) convertView.findViewById(R.id.mainPageBack);


        location_id.setText(mItems.get(position).text);

        if (position == 0){
            home_page_image.setImageDrawable(convertView.getResources().getDrawable(R.drawable.numbers));

            box_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), LocationPageActivity.class);
                    intent.putExtra(Constants.USER_NAME, dataSet.getUser().getName());
                    intent.putExtra(Constants.USER_MOBILE, dataSet.getUser().getPhone());
                    intent.putExtra(Constants.MODERATOR_NAME, dataSet.getUser().getProfile().getModerator().getName());
                    intent.putExtra(Constants.MODERATOR_MOBILE, dataSet.getUser().getProfile().getModerator().getPhone());
                    intent.putExtra(Constants.WALLET_BALANCE, dataSet.getUser().getProfile().getCoinBalance());
                    v.getContext().startActivity(intent);
                }
            });
        } else if (position == 1){
            home_page_image.setImageDrawable(convertView.getResources().getDrawable(R.drawable.mail));

            box_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ContactUsActivity.class);
                    intent.putExtra(Constants.USER_NAME, dataSet.getUser().getName());
                    intent.putExtra(Constants.USER_MOBILE, dataSet.getUser().getPhone());
                    intent.putExtra(Constants.MODERATOR_NAME, dataSet.getUser().getProfile().getModerator().getName());
                    intent.putExtra(Constants.MODERATOR_MOBILE, dataSet.getUser().getProfile().getModerator().getPhone());
                    intent.putExtra(Constants.WALLET_BALANCE, dataSet.getUser().getProfile().getCoinBalance());
                    v.getContext().startActivity(intent);
                }
            });
        } else if (position == 2){
            home_page_image.setImageDrawable(convertView.getResources().getDrawable(R.drawable.withdraw));

            box_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), WithdrawActivity.class);
                    intent.putExtra(Constants.USER_NAME, dataSet.getUser().getName());
                    intent.putExtra(Constants.USER_MOBILE, dataSet.getUser().getPhone());
                    intent.putExtra(Constants.MODERATOR_NAME, dataSet.getUser().getProfile().getModerator().getName());
                    intent.putExtra(Constants.MODERATOR_MOBILE, dataSet.getUser().getProfile().getModerator().getPhone());
                    intent.putExtra(Constants.WALLET_BALANCE, dataSet.getUser().getProfile().getCoinBalance());
                    v.getContext().startActivity(intent);
                }
            });
        } else if (position == 3){
            home_page_image.setImageDrawable(convertView.getResources().getDrawable(R.drawable.history));

            box_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), HistoryActivity.class);
                    intent.putExtra(Constants.USER_NAME, dataSet.getUser().getName());
                    intent.putExtra(Constants.USER_MOBILE, dataSet.getUser().getPhone());
                    intent.putExtra(Constants.MODERATOR_NAME, dataSet.getUser().getProfile().getModerator().getName());
                    intent.putExtra(Constants.MODERATOR_MOBILE, dataSet.getUser().getProfile().getModerator().getPhone());
                    intent.putExtra(Constants.WALLET_BALANCE, dataSet.getUser().getProfile().getCoinBalance());
                    v.getContext().startActivity(intent);
                }
            });
        } else if (position == 4){
            home_page_image.setImageDrawable(convertView.getResources().getDrawable(R.drawable.result));

            box_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), ResultActivity.class);
                    intent.putExtra(Constants.USER_NAME, dataSet.getUser().getName());
                    intent.putExtra(Constants.USER_MOBILE, dataSet.getUser().getPhone());
                    intent.putExtra(Constants.MODERATOR_NAME, dataSet.getUser().getProfile().getModerator().getName());
                    intent.putExtra(Constants.MODERATOR_MOBILE, dataSet.getUser().getProfile().getModerator().getPhone());
                    intent.putExtra(Constants.WALLET_BALANCE, dataSet.getUser().getProfile().getCoinBalance());
                    v.getContext().startActivity(intent);
                }
            });
        }else if (position == 5){
            home_page_image.setImageDrawable(convertView.getResources().getDrawable(R.drawable.result));

            box_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), WithdrawDetailsActivity.class);
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
