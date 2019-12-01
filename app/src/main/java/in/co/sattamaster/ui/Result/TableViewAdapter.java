package in.co.sattamaster.ui.Result;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import in.co.sattamaster.R;

public class TableViewAdapter extends RecyclerView.Adapter {
    List<PastResultPOJO> mData;
    private LayoutInflater mInflater;


    public TableViewAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mData = new ArrayList<>();
    }

    public void addAll(List<PastResultPOJO> moveResults) {
        for (PastResultPOJO result : moveResults) {
            add(result);
        }

    }

    public void add(PastResultPOJO r) {
        mData.add(r);
        notifyItemInserted(mData.size() - 1);

    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.table_list_item, parent, false);

        return new RowViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RowViewHolder rowViewHolder = (RowViewHolder) holder;

            rowViewHolder.date.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.id_location_value.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.id_location_value_time.setBackgroundResource(R.drawable.table_content_cell_bg);

            rowViewHolder.date.setText(mData.get(position).getCreatedAt());
            rowViewHolder.id_location_value.setText(mData.get(position).getNumber());
            rowViewHolder.id_location_value_time.setText(mData.get(position).getCreatedAtTime());
    }



    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        protected TextView date;
        protected TextView id_location_value_time;
        protected TextView id_location_value;

        public RowViewHolder(View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date_id);
            id_location_value = itemView.findViewById(R.id.id_location_value);
            id_location_value_time = itemView.findViewById(R.id.id_location_value_time);
        }
    }
}
