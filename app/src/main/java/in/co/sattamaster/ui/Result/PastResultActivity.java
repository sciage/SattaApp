package in.co.sattamaster.ui.Result;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import in.co.sattamaster.R;
import in.co.sattamaster.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class PastResultActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_result);

        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Past Results");

        RecyclerView recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);

        TableViewAdapter adapter = new TableViewAdapter(getMovieList());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void setUp() {

    }

    private List<ResultPojo> getMovieList() {
        List<ResultPojo> movieList = new ArrayList<>();
        // src Wikipedia
        movieList.add(new ResultPojo("10-07-2019", "22", "33", "44", "55", "66"));
        movieList.add(new ResultPojo("10-07-2019", "2", "33", "5", "55", "66"));
        movieList.add(new ResultPojo("10-07-2019", "22", "4", "44", "55", "66"));
        movieList.add(new ResultPojo("10-07-2019", "3", "33", "6", "55", "66"));
        movieList.add(new ResultPojo("10-07-2019", "22", "33", "7", "55", "66"));
        movieList.add(new ResultPojo("10-07-2019", "6", "9", "44", "55", "66"));
        movieList.add(new ResultPojo("10-07-2019", "22", "33", "44", "55", "66"));
        movieList.add(new ResultPojo("10-07-2019", "22", "33", "44", "55", "66"));

        return movieList;
    }
}
