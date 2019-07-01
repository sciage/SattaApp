package com.example.sattaapp.di.rxbus;

/**
 * Created by amitshekhar on 06/02/17.
 */

public class Events {

    private Events() {

    }

    public static class TapEvent {

    }

    public static class AutoEvent {

    }

    public static class deleteComment {
        public String id_post_comments;
        public String user_id;
        public String id_posts;

        public deleteComment(String id_post_comments, String user_id, String id_posts) {
            this.id_post_comments = id_post_comments;
            this.user_id = user_id;
            this.id_posts = id_posts;
        }
    }

    public static class sendCommentLike {
        public String id_post_comment;
        public String like;

        public sendCommentLike(String id_post_comment, String like) {
            this.id_post_comment = id_post_comment;
            this.like = like;
        }
    }

}
