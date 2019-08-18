package in.co.sattamaster.ui.History;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import in.co.sattamaster.R;
import in.co.sattamaster.ui.Result.PastResultPOJO;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<HistoryResponse> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mData = new ArrayList<>();
    }

    public void addAll(List<HistoryResponse> moveResults) {
        for (HistoryResponse result : moveResults) {
            add(result);
        }

    }

    public void add(HistoryResponse r) {
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

        holder.bid_location.setText(mData.get(position).getCentreName());
        holder.bid_type.setText(mData.get(position).getBidDate());
        holder.bid_time.setText(mData.get(position).getCoinBalanceCost());
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

        ViewHolder(View itemView) {
            super(itemView);
            bid_location = itemView.findViewById(R.id.bid_location);
            bid_type = itemView.findViewById(R.id.bid_type);
            bid_time = itemView.findViewById(R.id.bid_time);
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
