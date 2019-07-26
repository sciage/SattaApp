package in.co.sattamaster.ui.Result;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import in.co.sattamaster.R;

public class TableViewAdapter extends RecyclerView.Adapter {
    List<ResultPojo> movieList;

    public TableViewAdapter(List<ResultPojo> movieList) {
        this.movieList = movieList;
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

        int rowPos = rowViewHolder.getAdapterPosition();

        if (rowPos == 0) {
            // Header Cells. Main Headings appear here
            rowViewHolder.date.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.desawar.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.faridabad.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.gaziabad.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.gali.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.rewari.setBackgroundResource(R.drawable.table_header_cell_bg);

            rowViewHolder.date.setText("Date");
            rowViewHolder.desawar.setText("DSWR");
            rowViewHolder.faridabad.setText("FRBD");
            rowViewHolder.gaziabad.setText("GZBD");
            rowViewHolder.gali.setText("GALI");
            rowViewHolder.rewari.setText("RWRI");
        } else {
            ResultPojo modal = movieList.get(rowPos-1);

            // Content Cells. Content appear here
            rowViewHolder.date.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.desawar.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.faridabad.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.gaziabad.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.gali.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.rewari.setBackgroundResource(R.drawable.table_content_cell_bg);

            rowViewHolder.date.setText(modal.getDate_id()+"");
            rowViewHolder.desawar.setText(modal.getId_desawar());
            rowViewHolder.faridabad.setText(modal.getId_faridabad()+"");
            rowViewHolder.gaziabad.setText(modal.getId_gaziabad()+"");
            rowViewHolder.gali.setText(modal.getId_gaziabad()+"");
            rowViewHolder.rewari.setText(modal.getId_gaziabad()+"");
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size()+1; // one more to add header row
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        protected TextView date;
        protected TextView desawar;
        protected TextView faridabad;
        protected TextView gaziabad;
        protected TextView gali;
        protected TextView rewari;

        public RowViewHolder(View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date_id);
            desawar = itemView.findViewById(R.id.id_desawar);
            faridabad = itemView.findViewById(R.id.id_faridabad);
            gaziabad = itemView.findViewById(R.id.id_gaziabad);
            gali = itemView.findViewById(R.id.id_gali);
            rewari = itemView.findViewById(R.id.id_rewari);
        }
    }
}
