package in.co.sattamaster.ui.History;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.co.sattamaster.R;


/**
 * Created by harishpc on 6/15/2017.
 */
public class CommentReplyAdapter extends RecyclerView.Adapter<CommentReplyAdapter.ReplyMessageViewHolder> {

    private final static int MAXIMUM_VISIBLE_ITEM_COUNT = 4;
    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;

    private SharedPreferences preferences;
    private final Context mContext;
    protected List<HistoryBidData> mMessageList;
    private List<ReplyMessageViewHolder> mMessageHolderList = new ArrayList<>();


    public CommentReplyAdapter(Context context, List<HistoryBidData> mMessageList) {
        mContext = context;
        this.mMessageList = mMessageList;
    }

    @Override
    public ReplyMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_message_reply, parent, false);

        ReplyMessageViewHolder messageViewHolder = new ReplyMessageViewHolder(v);
        mMessageHolderList.add(messageViewHolder);

        return messageViewHolder;
    }

    @Override
    public void onBindViewHolder(ReplyMessageViewHolder holder, int position) {
        holder.onBind(position, mMessageList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mMessageList == null){
            return 0;
        } else {
            return mMessageList.size();
        }

    }

    @Override
    public int getItemViewType(int position) {
        //   return (position == dataSet.size() - 1) ? VIEW_ITEM : VIEW_PROG;
        /// current   return dataSet.get(position) != null ? VIEW_ITEM : VIEW_PROG;

        return mMessageList.get((mMessageList.size() - 1)) != null ? VIEW_ITEM : VIEW_PROG;

        // return mMessageList.get((mMessageList.size() - 1)) != null ? VIEW_ITEM : VIEW_PROG;
    }

    public void addMessage(HistoryBidData messageItem) {
        mMessageList.add(messageItem);

        int position = mMessageList.size() - 1;
     //   mInsertMessageListener.onMessageInserted(position);
        notifyItemInserted(position);
    }

    private ReplyMessageViewHolder getViewHolderByPosition(int position) {
        for (ReplyMessageViewHolder viewHolder : mMessageHolderList) {
            if (viewHolder.getBoundPosition() == position) {
                return viewHolder;
            }
        }
        return null;
    }

    public interface InsertReplyMessageListener {
        void onMessageInserted(int position);
    }

    class ReplyMessageViewHolder extends RecyclerView.ViewHolder {

        private static final float ALPHA_INVISIBLE = 0f;
        private static final float ALPHA_VISIBLE = 1f;
        private static final int ANIMATION_DELAY = 5000;
        private final Handler mDelayHandler = new Handler();
        private View mHolderView;
        private HistoryBidData user_comment;

        private Animation mFadeOutAnimation;
        private boolean isAnimating = false;
        private boolean isVisible = true;

        private TextView bid_number;
        private TextView bid_amount;
        private PopupMenu popupMenu;
        
        protected int likeReplyCounter;
        protected View messageReplyProgress;
        protected boolean like_reply_true = false;
        protected int mPosition;



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

        public ReplyMessageViewHolder(final View itemView) {
            super(itemView);
            mHolderView = itemView;

            messageReplyProgress = itemView.findViewById(R.id.messageReplyProgress_reply);
            
            bid_amount = (TextView) itemView.findViewById(R.id.bid_amount);
            bid_number = (TextView) itemView.findViewById(R.id.bid_number);

            mFadeOutAnimation = AnimationUtils.loadAnimation(mContext, R.anim.fade_out_anim);
            mFadeOutAnimation.setAnimationListener(mFadeOutAnimationListener);
            messageReplyProgress.setVisibility(View.GONE);
        }
        
        
        public void onBind(int position, HistoryBidData messageItem) {


            user_comment = messageItem;
            mHolderView.setAlpha(ALPHA_VISIBLE);
            isVisible = true;
            

            bid_amount.setText(String.valueOf("Bid Amount " + " : " + messageItem.getAmount()));
            bid_number.setText(String.valueOf("Bid Number " + " : " + messageItem.getNumber()));

          //  winOrLoss.setText(CurrentTime.getCurrentTime(messageItem.getCommentTime(), itemView.getContext()));
            


        }

        // TOdo add code to open private chat  or code to enter bid_number while using reply
   /*     private void userProfile(View view, HistoryBidData messageItem) {
            if (messageItem.getId_user_name().equals(MySharedPreferences.getUserId(recyclerviewpreferences))){
                view.getContext().startActivity(new Intent(view.getContext(), ProfileActivity.class));
            } else {
                Intent intent = new Intent(view.getContext(), SecondProfile.class);
                intent.putExtra(Constants.SECOND_PROFILE_ID, messageItem.getId_user_name());
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

    /*
    private void postCommentReplyLike(String id_post_comment_reply, String post_comment_reply_id) throws Exception {
        getBus.post(new Account.sendCommentLike(id_post_comment_reply, post_comment_reply_id, "1"));

    }

    private void postCommentReplyUnLike(String id_post_comment_reply, String post_comment_reply_id) throws Exception {
        getBus.post(new Account.sendCommentLike(id_post_comment_reply, post_comment_reply_id, null));

    }

    private void postCommentReplyLikeNotification(String  user_id_who_will_receive_notification, String random_user_id_of_comment_user) throws Exception {
        getBus.post(new Account.sendLikeUserId(user_id_who_will_receive_notification, random_user_id_of_comment_user));

    }
    */


}