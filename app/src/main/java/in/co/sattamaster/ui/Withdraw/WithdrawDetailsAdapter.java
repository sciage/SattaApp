package in.co.sattamaster.ui.Withdraw;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.co.sattamaster.R;
import in.co.sattamaster.ui.History.HistoryDetailsActivity;
import in.co.sattamaster.ui.base.Constants;

public class WithdrawDetailsAdapter extends RecyclerView.Adapter<WithdrawDetailsAdapter.ViewHolder> {
    private List<WithdrawDetailsPojo.Data> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    WithdrawDetailsAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mData = new ArrayList<>();
    }

    public void addAll(List<WithdrawDetailsPojo.Data> moveResults) {
        for (WithdrawDetailsPojo.Data result : moveResults) {
            add(result);
        }
    }

    public void add(WithdrawDetailsPojo.Data r) {
        mData.add(r);
        notifyItemInserted(mData.size() - 1);

    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.number_reveal.setText("Withdrawl Amount : " +  mData.get(position).getAmount());
        if ( mData.get(position).getCompleted()){

            holder.bid_location.setText("Transanction Status : Done");
        } else {
            holder.bid_location.setText("Transanction Status : Pending");

        }

        holder.bid_type.setText("Withdrawl Date : " +  mData.get(position).getCreatedAt());
    }


    // total number of rows
    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView bid_location;
        private TextView bid_type;
        private TextView bid_time;
        private TextView number_reveal;
        private ConstraintLayout history_back;

        ViewHolder(View itemView) {
            super(itemView);
            number_reveal = itemView.findViewById(R.id.number_reveal);
            bid_location = itemView.findViewById(R.id.bid_location);
            bid_type = itemView.findViewById(R.id.bid_type);
            bid_time = itemView.findViewById(R.id.bid_balance);
            history_back = (ConstraintLayout)itemView.findViewById(R.id.history_back);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
  //  String getItem(int id) {
    //    return mData.get(id);
   // }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
