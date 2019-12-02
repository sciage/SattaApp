package in.co.sattamaster.ui.History;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.co.sattamaster.R;

/**
 * Created by User on 07.12.2016.
 */

public class HistoryDetailsAdapter extends RecyclerView.Adapter<HistoryDetailsAdapter.MessageViewHolder> {
    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;

    private final static int MAXIMUM_VISIBLE_ITEM_COUNT = 4;

    private final Context mContext;
    protected List<HistoryBidHeader> mMessageList;
    private List<MessageViewHolder> mMessageHolderList = new ArrayList<>();
    protected String commentReplyMessage;

    public HistoryDetailsAdapter(Context context, List<HistoryBidHeader> mMessageList) {
        mContext = context;
        this.mMessageList = mMessageList;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_message, parent, false);

        MessageViewHolder messageViewHolder = new MessageViewHolder(v);
        mMessageHolderList.add(messageViewHolder);

        return messageViewHolder;
    }

    public void clear() {
        mMessageList.clear();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        holder.onBind(position, mMessageList.get(position));
    }


    public void addMessage(HistoryBidHeader messageItem) {
        mMessageList.add(messageItem);

        int position = mMessageList.size() - 1;
        notifyItemInserted(position);
    }

    private MessageViewHolder getViewHolderByPosition(int position) {
        for (MessageViewHolder viewHolder : mMessageHolderList) {
            if (viewHolder.getBoundPosition() == position) {
                return viewHolder;
            }
        }
        return null;
    }

    @Override
    public int getItemCount() {
        if (mMessageList == null) {
            return 0;
        } else {
            return mMessageList.size();
        }

    }

    @Override
    public int getItemViewType(int position) {
        //   return (position == dataSet.size() - 1) ? VIEW_ITEM : VIEW_PROG;
        // current   return dataSet.get(position) != null ? VIEW_ITEM : VIEW_PROG;

        return mMessageList.get((mMessageList.size() - 1)) != null ? VIEW_ITEM : VIEW_PROG;

        //  return mMessageList.get((mMessageList.size() - 1)) != null ? VIEW_ITEM : VIEW_PROG;
    }

    public interface InsertMessageListener {
        void onMessageInserted(int position);
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        private static final float ALPHA_INVISIBLE = 0f;
        private static final float ALPHA_VISIBLE = 1f;
        private static final int ANIMATION_DELAY = 5000;
        private final Handler mDelayHandler = new Handler();
        private View mHolderView;
        private int mPosition;

        private Animation mFadeOutAnimation;
        private boolean isAnimating = false;
        private boolean isVisible = true;


        private TextView bid_type;
        private TextView winOrLoss;
        private TextView winningAmount;
        private TextView bid_balance;

        protected View messageReplyProgress;

        public CommentReplyAdapter commentReplyAdapter;
        private RecyclerView replyRecyclerview;
        private LinearLayoutManager mReplyLinearLayoutManager;


        private Animation.AnimationListener mFadeOutAnimationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                isAnimating = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mHolderView.setAlpha(ALPHA_INVISIBLE);
                isAnimating = false;
                isVisible = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };


        public MessageViewHolder(final View itemView) {
            super(itemView);
            mHolderView = itemView;

            winningAmount = (TextView) itemView.findViewById(R.id.winningAmount);
            bid_type = (TextView) itemView.findViewById(R.id.bid_type);
            messageReplyProgress = itemView.findViewById(R.id.messageReplyProgress);
            winOrLoss = (TextView) itemView.findViewById(R.id.winOrLoss);

            bid_balance = (TextView) itemView.findViewById(R.id.bid_balance);

            replyRecyclerview = (RecyclerView) itemView.findViewById(R.id.reply_comment_recyclerview);


            mFadeOutAnimation = AnimationUtils.loadAnimation(mContext, R.anim.fade_out_anim);
            mFadeOutAnimation.setAnimationListener(mFadeOutAnimationListener);

            messageReplyProgress.setVisibility(View.GONE);

        }


        private void remove(int mPosition) {
            mMessageList.remove(mPosition);
            notifyItemRemoved(mPosition);

            notifyItemRangeChanged(mPosition, getItemCount());
        }

        public void onBind(int position, HistoryBidHeader messageItem) {

            mPosition = position;
            mHolderView.setAlpha(ALPHA_VISIBLE);
            isVisible = true;


            if (messageItem.getDidWin() == null){
                winOrLoss.setText("Win or Loss : Pending");

            } else {
                if (messageItem.getDidWin().toString().equals("true")){
                    winOrLoss.setText(String.valueOf("Win or Loss " + " : " + "Win"));
                   // winningAmount.setText();

                } else {
                    winOrLoss.setText(String.valueOf("Win or Loss " + " : " + "Loss"));
                }

            }

            // winOrLoss.setText(CurrentTime.getCurrentTime(messageItem.getCommentTime(), itemView.getContext()));
            commentReplyAdapter = new CommentReplyAdapter(itemView.getContext(), mMessageList.get(position).getData());

            mReplyLinearLayoutManager = new LinearLayoutManager(itemView.getContext()) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            mReplyLinearLayoutManager.setStackFromEnd(true);
//        mLinearLayoutManager.setReverseLayout(true);

            replyRecyclerview.setLayoutManager(mReplyLinearLayoutManager);
            replyRecyclerview.addItemDecoration(new SimpleDividerItemDecoration(itemView.getContext()));
            replyRecyclerview.setAdapter(commentReplyAdapter);

            bid_balance.setText(String.valueOf("Total Bid Placed " +" : " + messageItem.getCoinBalanceCost()));
            bid_type.setText(String.valueOf("Bid Type " + " : " + getLocationName(messageItem.getType())));

        }

        private String getLocationName(String locationName){
            if (locationName.equalsIgnoreCase("JODI")){
                return "COMBINATION";
            } else return locationName;
        }

        public CommentReplyAdapter getCommentReplyAdapter() {
            return commentReplyAdapter;
        }

        // Todo open chat with random bid_type
     /*   private void userProfile(View view, HistoryBidHeader messageItem) {
            if (messageItem.getCommentUserId().equals(MySharedPreferences.getUserId(recyclerviewpreferences))){
                view.getContext().startActivity(new Intent(view.getContext(), ProfileActivity.class));
            } else {
                Intent intent = new Intent(view.getContext(), SecondProfile.class);
                intent.putExtra(Constants.SECOND_PROFILE_ID, messageItem.getCommentUserId());
                view.getContext().startActivity(intent);
            }
        } */


        public int getBoundPosition() {
            return mPosition;
        }

        public boolean isAnimating() {
            return isAnimating;
        }

        public boolean isVisible() {
            return isVisible;
        }
    }
}
