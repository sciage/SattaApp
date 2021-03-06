package in.co.sattamaster.ui.Homepage;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import in.co.sattamaster.R;
import in.co.sattamaster.ui.DateTime.Pico;
import in.co.sattamaster.ui.DateTime.codec.Type;
import in.co.sattamaster.ui.PlayMatka.PlayMatkaActivity;
import in.co.sattamaster.ui.base.Constants;

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

    Date ghaziabadDayBeforeTime;
    Date ghaziabadDayAfterTime;
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

    Calendar currentCalender;

    public static final String TIME_FORMAT = "h:mm";


    public LocationGridAdapter(Context context, Date trueDate) {
        this.trueDate = trueDate;
        mContext = context;
    }

    public void addAll(List<LocationPojo> moveResults) {
        for (LocationPojo result : moveResults) {
            add(result);
            notifyDataSetChanged();
        }
    }

    public void AddActivityData(String USER_NAME, String MODERATOR_NAME, String MODERATOR_MOBILE, String WALLET_BALANCE, Context context){
        this.USER_NAME = USER_NAME;
        this.MODERATOR_NAME = MODERATOR_NAME;
        this.MODERATOR_MOBILE = MODERATOR_MOBILE;
        this.WALLET_BALANCE = WALLET_BALANCE;
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
                    gotoNextPage(v, position);
                }
            });

            last_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotoNextPage(v, position);
                }
            });

            new_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotoNextPage(v, position);
                }
            });

            location_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotoNextPage(v, position);
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
            currentCalender = toCalendar(trueDate); // current time


            Calendar ghaziabadDayBefore = toCalendar(trueDate);
          //  createNewCalender(disawarBefore, 4, 30);
            Calendar ghaziabadDayBefore02 = createNewCalender(ghaziabadDayBefore, 11, 30);
            ghaziabadDayBeforeTime = ghaziabadDayBefore02.getTime();

            Calendar ghaziabadDayAfter = toCalendar(trueDate);
            Calendar ghaziabadDayAfter02 = createNewCalender(ghaziabadDayAfter, 12, 30);
            ghaziabadDayAfterTime = ghaziabadDayAfter02.getTime();


            Calendar disawarBefore = toCalendar(trueDate);
          //  createNewCalender(disawarBefore, 4, 30);
            Calendar disawarBefore02 = createNewCalender(disawarBefore, 4, 30);
             disawarBeforeDate = disawarBefore02.getTime();

            Calendar disawarAfter = toCalendar(trueDate);
            Calendar disawarAfter02 = createNewCalender(disawarAfter, 5, 40);
             disawarAfterDate = disawarAfter02.getTime();


            Calendar faridabadBefore = toCalendar(trueDate);
           // createNewCalender(faridabadBefore, 17, 30);
            Calendar faridabadBefore02 = createNewCalender(faridabadBefore, 17, 30);
             faridabadBeforeTime = faridabadBefore02.getTime();

            Calendar faridabadAfter = toCalendar(trueDate);
            Calendar faridabadAfter02 = createNewCalender(faridabadAfter, 18, 40);
             faridabadAfterTime = faridabadAfter02.getTime();

            Calendar ghaziabadBefore = toCalendar(trueDate);
            Calendar ghaziabadBefore02 = createNewCalender(ghaziabadBefore, 19, 30);
             ghaziabadBeforeTime = ghaziabadBefore02.getTime();

            Calendar ghaziabadAfter = toCalendar(trueDate);
            Calendar ghaziabadAfter02 = createNewCalender(ghaziabadAfter, 20, 40);
             ghaziabadAfterTime = ghaziabadAfter02.getTime();

            Calendar galiBefore = toCalendar(trueDate);
            Calendar galiBefore02 = createNewCalender(galiBefore, 22, 0);
             galiBeforeTime = galiBefore02.getTime();

            Calendar galiAfter = toCalendar(trueDate);
            Calendar galiAfter02 = createNewCalender(galiAfter, 23, 30);
             galiAfterTime = galiAfter02.getTime();

            Calendar rewariBefore = toCalendar(trueDate);
            Calendar rewariBefore02 = createNewCalender(rewariBefore, 20, 30);
             rewariBeforeTime = rewariBefore02.getTime();

            Calendar rewariAfter = toCalendar(trueDate); // current time
            Calendar rewariAfter02 = createNewCalender(rewariAfter, 21, 0);
             rewariAfterTime = rewariAfter02.getTime();


            switch (dataSet.get(position).getId()){
                case "5":

                    if (trueDate.after(disawarBeforeDate) && trueDate.before(disawarAfterDate)){
                        currentTest.setVisibility(View.VISIBLE);
                        currentTest.setText("Bidding Stopped");
                    }
                    break;
                case "6":

                    if (trueDate.after(faridabadBeforeTime) && trueDate.before(faridabadAfterTime)){
                        currentTest.setVisibility(View.VISIBLE);
                        currentTest.setText("Bidding Stopped");
                    }

                    break;
                case "7":

                    if (trueDate.after(ghaziabadBeforeTime) && trueDate.before(ghaziabadAfterTime)){
                        currentTest.setVisibility(View.VISIBLE);
                        currentTest.setText("Bidding Stopped");
                    }

                    break;
                case "8":

                    if (trueDate.after(galiBeforeTime) && trueDate.before(galiAfterTime)){
                        currentTest.setVisibility(View.VISIBLE);
                        currentTest.setText("Bidding Stopped");
                    }

                    break;

                case "12":

                    if (trueDate.after(rewariBeforeTime) && trueDate.before(rewariAfterTime)){
                        currentTest.setVisibility(View.VISIBLE);
                        currentTest.setText("Bidding Stopped");
                    }

                    break;


            }

            location_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playMatkaIntent(v, dataSet.get(position).getId(), position);
                }
            });

            location_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    playMatkaIntent(v, dataSet.get(position).getId(), position);
                }
            });

            last_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playMatkaIntent(v, dataSet.get(position).getId(), position);
                }
            });

            new_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playMatkaIntent(v, dataSet.get(position).getId(), position);
                }
            });

            location_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playMatkaIntent(v, dataSet.get(position).getId(), position);
                }
            });



        }



        return convertView;
    }

    private Calendar createNewCalender(Calendar calenderName, int calenderHour, int calenderMin){

     //   Calendar calenderName = Calendar.getInstance();
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


    private void playMatkaIntent(View v, String position02, int position) {
        switch (position02) {
            case "5":
                if (trueDate.after(disawarBeforeDate) && trueDate.before(disawarAfterDate)) {
                    currentTest.setVisibility(View.VISIBLE);
                    currentTest.setText("Bidding Stopped");
                    biddingClosed();
                } else {
                    gotoNextPage(v, position);
                }

                break;
                case "13":
                    //Date ghaziabadBeforeTime;
                    //    Date ghaziabadAfterTime;

                    if (trueDate.after(ghaziabadDayAfterTime) && trueDate.before(ghaziabadDayBeforeTime)) {
                    currentTest.setVisibility(View.VISIBLE);
                    currentTest.setText("Bidding Stopped");
                    biddingClosed();
                } else {
                    gotoNextPage(v, position);
                }

                break;
            case "6":
                if (trueDate.after(faridabadBeforeTime) && trueDate.before(faridabadAfterTime)) {
                    currentTest.setVisibility(View.VISIBLE);
                    currentTest.setText("Bidding Stopped");
                    biddingClosed();
                } else {
                    gotoNextPage(v, position);
                }
                break;
            case "7":
                if (trueDate.after(ghaziabadBeforeTime) && trueDate.before(ghaziabadAfterTime)) {
                    currentTest.setVisibility(View.VISIBLE);
                    currentTest.setText("Bidding Stopped");
                    biddingClosed();
                } else {
                    gotoNextPage(v, position);
                }

                break;
            case "8":

                if (trueDate.after(galiBeforeTime) && trueDate.before(galiAfterTime)) {
                    currentTest.setVisibility(View.VISIBLE);
                    currentTest.setText("Bidding Stopped");
                    biddingClosed();
                } else {
                    gotoNextPage(v, position);
                }

                break;
            case "12":

                if (trueDate.after(rewariBeforeTime) && trueDate.before(rewariAfterTime)) {
                    currentTest.setVisibility(View.VISIBLE);
                    currentTest.setText("Bidding Stopped");
                    biddingClosed();
                } else {
                    gotoNextPage(v, position);
                }

                break;
            default:



                break;
        }
    }

    private void gotoNextPage(View v, int position){
        Intent intent = new Intent(v.getContext(), PlayMatkaActivity.class);
        intent.putExtra(Constants.USER_NAME, USER_NAME);
        intent.putExtra(Constants.MODERATOR_NAME, MODERATOR_NAME);
        intent.putExtra(Constants.MODERATOR_MOBILE, MODERATOR_MOBILE);
        intent.putExtra(Constants.WALLET_BALANCE, WALLET_BALANCE);
        intent.putExtra(Constants.LOCATION, dataSet.get(position).getId());
        intent.putExtra(Constants.LOCATION_NAME, dataSet.get(position).getName());
        v.getContext().startActivity(intent);
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
