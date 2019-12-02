package in.co.sattamaster.ui.Homepage;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import in.co.sattamaster.R;
import in.co.sattamaster.ui.DateTime.Pico;
import in.co.sattamaster.ui.DateTime.codec.Type;
import in.co.sattamaster.ui.Homepage.LocationPojo;
import in.co.sattamaster.ui.PlayMatka.PlayMatkaActivity;
import in.co.sattamaster.ui.base.Constants;
import in.co.sattamaster.ui.base.MySharedPreferences;

public class LocationGridAdapter extends BaseAdapter {
    private List<LocationPojo> dataSet = new ArrayList<>();
    private Context mContext;
    String USER_NAME;
    String MODERATOR_NAME;
    String MODERATOR_MOBILE;
    String WALLET_BALANCE;
    Date trueDate;
    Date LastTimeDate;
    long timeInMilliseconds;
    private Context context;

    Date disawarBeforeDate;
    Date disawarAfterDate;
    Date faridabadBeforeTime;
    Date faridabadAfterTime;
    Date ghaziabadBeforeTime;
    Date ghaziabadAfterTime;
    Date galiBeforeTime;
    Date galiAfterTime;
    Date rewariBeforeTime;
    Date rewariAfterTime;

    TextView currentTest;
    AlertDialog.Builder alertDialogBuilder;

    Calendar currentTime;

    public static final String TIME_FORMAT = "h:mm";


    public LocationGridAdapter(Context context) {
        mContext = context;
    }

    public void addAll(List<LocationPojo> moveResults) {
        for (LocationPojo result : moveResults) {
            add(result);
            notifyDataSetChanged();
        }
    }

    public void AddActivityData(String USER_NAME, String MODERATOR_NAME, String MODERATOR_MOBILE, String WALLET_BALANCE, Date trueDate, Context context){
        this.USER_NAME = USER_NAME;
        this.MODERATOR_NAME = MODERATOR_NAME;
        this.MODERATOR_MOBILE = MODERATOR_MOBILE;
        this.WALLET_BALANCE = WALLET_BALANCE;
        this.trueDate = trueDate;
        this.context = context;
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

        if (dataSet.get(position).getHourly()){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.squareitem_hourly,
                    null);



            Calendar calendar = Calendar.getInstance();
            Pico pico = new Pico(convertView.getContext(), null, Type.CALENDAR);

            TextView location_name = (TextView) convertView.findViewById(R.id.location_id);
            TextView last_time = (TextView) convertView.findViewById(R.id.last_time);
            TextView new_time = (TextView) convertView.findViewById(R.id.new_time);

            TextView current_time = (TextView) convertView.findViewById(R.id.current_time);
            TextView new_time_current = (TextView) convertView.findViewById(R.id.new_time_current);

            TextView last_time_upcoming = (TextView) convertView.findViewById(R.id.last_time_upcoming);
            TextView new_time_upcoming = (TextView) convertView.findViewById(R.id.new_time_upcoming);

            last_time.setText(pico.getHourBefore(calendar));
            current_time.setText(pico.getHourCurrent(calendar));
            last_time_upcoming.setText(pico.getHourNext(calendar));


            ConstraintLayout location_back = (ConstraintLayout) convertView.findViewById(R.id.location_back);

            location_name.setText(dataSet.get(position).getName());

            if (dataSet.get(position).getNumberLast() != null){
                new_time.setText(dataSet.get(position).getNumberLast());
            } else {
                new_time.setText("XX");
            }

            if (dataSet.get(position).getNumberCurrent() != null){
                new_time_current.setText(dataSet.get(position).getNumberCurrent());
            } else {
                new_time.setText("XX");

            }




            new_time_upcoming.setText("XX");

            location_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playMatkaIntent(v, position);
                }
            });

            last_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playMatkaIntent(v, position);
                }
            });

            new_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playMatkaIntent(v, position);
                }
            });

            location_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playMatkaIntent(v, position);
                }
            });

        } else {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.squareitem,
                    null);

            TextView location_name = (TextView) convertView.findViewById(R.id.location_id);
            currentTest = (TextView) convertView.findViewById(R.id.currentTest);
            TextView location_time = (TextView) convertView.findViewById(R.id.location_time);
            TextView last_time = (TextView) convertView.findViewById(R.id.last_time);
            TextView new_time = (TextView) convertView.findViewById(R.id.new_time);
            ConstraintLayout location_back = (ConstraintLayout) convertView.findViewById(R.id.location_back);

            currentTest.setVisibility(View.INVISIBLE);
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
            currentTime = toCalendar(trueDate);

            Calendar disawarBefore = Calendar.getInstance();
            createNewCalender(disawarBefore, 4, 30);
             disawarBeforeDate = disawarBefore.getTime();

            Calendar disawarAfter = Calendar.getInstance();
            createNewCalender(disawarAfter, 5, 0);
             disawarAfterDate = disawarAfter.getTime();

            Calendar faridabadBefore = Calendar.getInstance();
            createNewCalender(faridabadBefore, 17, 30);
             faridabadBeforeTime = faridabadBefore.getTime();

            Calendar faridabadAfter = Calendar.getInstance();
            createNewCalender(faridabadAfter, 18, 0);
             faridabadAfterTime = faridabadAfter.getTime();

            Calendar ghaziabadBefore = Calendar.getInstance();
            createNewCalender(ghaziabadBefore, 19, 30);
             ghaziabadBeforeTime = ghaziabadBefore.getTime();

            Calendar ghaziabadAfter = Calendar.getInstance();
            createNewCalender(ghaziabadAfter, 20, 0);
             ghaziabadAfterTime = ghaziabadAfter.getTime();

            Calendar galiBefore = Calendar.getInstance();
            createNewCalender(galiBefore, 22, 30);
             galiBeforeTime = galiBefore.getTime();

            Calendar galiAfter = Calendar.getInstance();
            createNewCalender(galiAfter, 23, 0);
             galiAfterTime = galiAfter.getTime();

            Calendar rewariBefore = Calendar.getInstance();
            createNewCalender(rewariBefore, 20, 30);
             rewariBeforeTime = rewariBefore.getTime();

            Calendar rewariAfter = Calendar.getInstance();
            createNewCalender(rewariAfter, 21, 0);
             rewariAfterTime = rewariAfter.getTime();


            switch (dataSet.get(position).getId()){
                case "5":

                    if (currentTime.after(disawarBeforeDate) && currentTime.before(disawarAfterDate)){
                        currentTest.setVisibility(View.VISIBLE);
                        currentTest.setText("Bidding Stopped");
                    }
                    break;
                case "6":

                    if (currentTime.after(faridabadBeforeTime) && currentTime.before(faridabadAfterTime)){
                        currentTest.setVisibility(View.VISIBLE);
                        currentTest.setText("Bidding Stopped");
                    }

                    break;
                case "7":

                    if (currentTime.after(ghaziabadBeforeTime) && currentTime.before(ghaziabadAfterTime)){
                        currentTest.setVisibility(View.VISIBLE);
                        currentTest.setText("Bidding Stopped");
                    }

                    break;
                case "8":

                    if (currentTime.after(galiBeforeTime) && currentTime.before(galiAfterTime)){
                        currentTest.setVisibility(View.VISIBLE);
                        currentTest.setText("Bidding Stopped");
                    }

                    break;

                case "12":

                    if (currentTime.after(rewariBeforeTime) && currentTime.before(rewariAfterTime)){
                        currentTest.setVisibility(View.VISIBLE);
                        currentTest.setText("Bidding Stopped");
                    }

                    break;


            }

            location_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playMatkaIntent(v, position);
                }
            });

            location_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    playMatkaIntent(v, position);
                }
            });

            last_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playMatkaIntent(v, position);
                }
            });

            new_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playMatkaIntent(v, position);
                }
            });

            location_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playMatkaIntent(v, position);
                }
            });



        }



        return convertView;
    }

    private Calendar createNewCalender(Calendar calenderName, int calenderHour, int calenderMin){

      //  Calendar faridabadBefore = Calendar.getInstance();
        calenderName.set(Calendar.HOUR_OF_DAY, calenderHour);
        calenderName.set(Calendar.MINUTE,calenderMin);
        calenderName.set(Calendar.SECOND,0);
        calenderName.set(Calendar.MILLISECOND,0);

        return calenderName;

    }

    public Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public Calendar toAfterCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, 30);
        return cal;
    }




    private void playMatkaIntent(View v, int position) {

        if (currentTime.after(disawarBeforeDate) && currentTime.before(disawarAfterDate)){
            currentTest.setVisibility(View.VISIBLE);
            currentTest.setText("Bidding Stopped");
            biddingClosed();
        } else if (currentTime.after(faridabadBeforeTime) && currentTime.before(faridabadAfterTime)){
            currentTest.setVisibility(View.VISIBLE);
            currentTest.setText("Bidding Stopped");
            biddingClosed();
        }else if (currentTime.after(ghaziabadBeforeTime) && currentTime.before(ghaziabadAfterTime)){
            currentTest.setVisibility(View.VISIBLE);
            currentTest.setText("Bidding Stopped");
            biddingClosed();
        } else if (currentTime.after(galiBeforeTime) && currentTime.before(galiAfterTime)){
            currentTest.setVisibility(View.VISIBLE);
            currentTest.setText("Bidding Stopped");
            biddingClosed();
        } else if (currentTime.after(rewariBeforeTime) && currentTime.before(rewariAfterTime)){
            currentTest.setVisibility(View.VISIBLE);
            currentTest.setText("Bidding Stopped");
            biddingClosed();
        } else {
            Intent intent = new Intent(v.getContext(), PlayMatkaActivity.class);
            intent.putExtra(Constants.USER_NAME, USER_NAME);
            intent.putExtra(Constants.MODERATOR_NAME, MODERATOR_NAME);
            intent.putExtra(Constants.MODERATOR_MOBILE, MODERATOR_MOBILE);
            intent.putExtra(Constants.WALLET_BALANCE, WALLET_BALANCE);
            intent.putExtra(Constants.LOCATION, dataSet.get(position).getId());
            intent.putExtra(Constants.LOCATION_NAME, dataSet.get(position).getName());
            v.getContext().startActivity(intent);
        }

    }

    private void biddingClosed() {
        alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("Bidding Closed");
        alertDialogBuilder.setMessage("Bidding cannot be done");
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        alertDialogBuilder.show();
    }

}
