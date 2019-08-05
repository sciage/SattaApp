package in.co.sattamaster.ui.autocomplete;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.co.sattamaster.R;
import in.co.sattamaster.ui.login.AllModerators;

public class UserPresenter extends RecyclerViewPresenter<AllModerators> {

    protected Adapter adapter;
    List<AllModerators> groups_joined;

    public UserPresenter(Context context, List<AllModerators> groups_joined) {
        super(context);
        this.groups_joined = groups_joined;
    }

    @Override
    protected PopupDimensions getPopupDimensions() {
        PopupDimensions dims = new PopupDimensions();
        dims.width = 600;
        dims.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        return dims;
    }

    @Override
    protected RecyclerView.Adapter instantiateAdapter() {
        adapter = new Adapter();
        return adapter;
    }

    @Override
    protected void onQuery(@Nullable CharSequence query) {
        if (TextUtils.isEmpty(query)) {
            adapter.setData(groups_joined);
        } else {
            query = query.toString().toLowerCase();
            List<AllModerators> list = new ArrayList<>();
            for (AllModerators u : groups_joined) {
                try {
                    if (u.getName().toLowerCase().contains(query) ||
                            u.getName().toLowerCase().contains(query)) {
                        list.add(u);
                    }
                }
                catch (NullPointerException e){
                    Log.e("empty", e.getMessage());
                }
            }
            adapter.setData(list);
          //  Log.e("GroupUserPresenter", "found "+list.size()+" GroupUsers for query "+query);
        }
        adapter.notifyDataSetChanged();
    }

    class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

        private List<AllModerators> data;

        public class Holder extends RecyclerView.ViewHolder {
            private View root;
            private TextView fullname;
            private TextView GroupUsername;
            public Holder(View itemView) {
                super(itemView);
                root = itemView;
                fullname = ((TextView) itemView.findViewById(R.id.name));
                GroupUsername = ((TextView) itemView.findViewById(R.id.username));
            }
        }

        public void setData(List<AllModerators> data) {
            this.data = data;
        }

        @Override
        public int getItemCount() {
            return (isEmpty()) ? 1 : data.size();
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(getContext()).inflate(R.layout.moderatorlist, parent, false));
        }

        private boolean isEmpty() {
            return data == null || data.isEmpty();
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            if (isEmpty()) {
                holder.fullname.setText("No Moderator here!");
                holder.GroupUsername.setText("Sorry!");
                holder.root.setOnClickListener(null);
                return;
            }
            final AllModerators GroupUser = data.get(position);
            holder.fullname.setText(GroupUser.getName());
            holder.GroupUsername.setText("@" + GroupUser.getPhone());
            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dispatchClick(GroupUser);
                }
            });
        }
    }
}
