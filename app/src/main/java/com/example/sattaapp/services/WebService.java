package com.example.sattaapp.services;

public interface WebService {

    /*

    @GET("posts.php")
    Observable<List<PostsModel>> getLatestFeed(@Query("user_id") String userID,
                                               @Query("page") int page);

    @GET("https://graph.facebook.com/v2.9/me/friends")
    Observable<MainResponse> getFriends(@Query("access_token") String access_token,
                                        @Query("limit") String limit,
                                        @Query("after") String afterPage);

    @GET("https://graph.facebook.com/v2.9/me/friends")
    Observable<MainResponse> getFriendsFirst(@Query("access_token") String access_token,
                                             @Query("limit") String limit);

    @GET("get_messages_new02.php")
    Observable<List<MessagePojo>> getChatMessages(@Query("from_user_id") String userID,
                                                  @Query("user_id") String user_id,
                                                  @Query("token") String token,
                                                  @Query("to_user_id") String toUserID);

    @GET("get_all_chats_new.php")
    Observable<List<ChatDialogPojo>> getAllChatMessages(@Query("user_id") String userID,
                                                        @Query("token") String token);

    @GET("get_all_categories_joined.php")
    Observable<List<CategoryJoined>> getAllCategoryJoined(@Query("user_id") String userID);



    @GET("get_trending_hastags_new.php")
    Observable<List<AllPopularTagsPojo>> getPopularHashTags();

    // Todo donot know about this call
    @GET("posts.php")
    Observable<List<PostsModel>> getFollowers(@Query("user_id") String userID,
                                              @Query("follower") String user_id);

    @GET("posts.php")
    Observable<List<PostsModel>> getPopulars(@Query("user_id") String userID,
                                             @Query("popular") String booleann,
                                             @Query("page") int page);

    @GET("posts.php")
    Observable<List<PostsModel>> getUserFeed(@Query("id_user_name") String id_user_name,
                                                  @Query("user_id") String user_id,
                                                  @Query("filtered") String group_post,
                                                  @Query("page") int page);

    @GET("posts.php")
    Observable<List<PostsModel>> getHistoryFeed(@Query("id_user_name") String id_user_name,
                                                  @Query("user_id") String user_id,
                                                  @Query("group_post") String group_post,
                                                  @Query("page") int page);
    @GET("posts_single.php")
    Observable<List<PostsModel>> getSinglePost(@Query("id_posts") String booleann,
                                               @Query("user_id") String user_id);

    @GET("posts.php")
    Observable<List<PostsModel>> getSingleUserPosts(@Query("id_user") String id_user,
                                                    @Query("user_id") String user_id,
                                                    @Query("page") int page);

    @GET("posts.php")
    Observable<List<PostsModel>> getUserFollowerPost(@Query("follower") String follower,
                                                     @Query("user_id") String user_id,
                                                     @Query("page") int page);

    @GET("posts.php")
    Observable<List<PostsModel>> getActivityPosts(@Query("id_user") String id_user,
                                                  @Query("filtered") String filtered,
                                                  @Query("user_id") String user_id,
                                                  @Query("page") int page);

    @GET("posts.php")
    Observable<List<PostsModel>> getContactPosts(@Query("id_user_name") String id_user_name,
                                                 @Query("user_id") String user_id,
                                                 @Query("contacts") String contacts,
                                                 @Query("page") int page);

    @GET("posts.php")
    Observable<List<PostsModel>> getFacebookPosts(@Query("id_user_name") String id_user_name,
                                                  @Query("user_id") String user_id,
                                                  @Query("facebookId") String contacts,
                                                  @Query("page") int page);

    @GET("get_groups.php")
    Observable<List<CommunityGroupPojoNew>> getUserJoinedGroupsFirstPage(@Query("user_id") String user_id,
                                                                @Query("below18") String below18,
                                                                @Query("joined") String joined,
                                                                @Query("page") int page);


    @GET("get_groups_not_joined_below18.php")
    Observable<List<CommunityGroupPojo>> getUserJoinedGroupsFirstPage(@Query("user_id") String userID,
                                                        @Query("page") int page);

    @GET("get_groups_not_joined_below18.php")
    Observable<List<CommunityGroupPojo>> getUserJoinedGroupsBelow18(@Query("user_id") String userID,
                                                                    @Query("below18") String below18,
                                                        @Query("page") int page);

    @GET("get_groups_joined.php")
    Observable<List<GroupUser>> getJoinedGroups(@Query("user_id") String userID);

    @GET("get_all_groups.php")
    Observable<List<GroupUser>> getAllGroups(@Query("user_id") String userID);

    @GET("get_groups_specific.php")
    Observable<List<CommunityGroupPojo>> getGroupSpecific(@Query("group_id") String group_id,
                                                        @Query("user_id") String userID,
                                                        @Query("page") int page);

    @GET("posts.php")
    Observable<List<PostsModel>> getPopularPost(@Query("popularPostId") String popularPostId,
                                                @Query("user_id") String userID,
                                                @Query("page") int page);

    @GET("get_comments_reply.php")
    Observable<List<PostUserCommentModel>> getUserComments(
            @Query("id_posts") String id_posts,
            @Query("user_id") String userID,
            @Query("token") String token);

    @GET("posts.php")
    Observable<List<PostsModel>> getGroupPosts(@Query("group_id") String group_id,
                                                  @Query("user_id") String userID,
                                                  @Query("page") int page);

    @GET("likes_get_single.php")
    Observable<PostLikesResponse> likes(@Query("user_id") String userId,
                                        @Query("post_id") String postId,
                                        @Query("like") int like,
                                        @Query("token") String token);

    @GET("hugs_get_single.php")
    Observable<PostLikesResponse> hugs(@Query("user_id") String userId,
                                        @Query("post_id") String postId,
                                        @Query("hug") int hug,
                                        @Query("token") String token);

    @FormUrlEncoded
    @POST("insert_popular_post.php")
    Observable<SuccessResponse> insertPopularPost(@Field("post_id") String post_id,
                                        @Field("post_text") String post_text,
                                                  @Field("user_id") String userID,
                                                  @Field("token") String token);

    @FormUrlEncoded
    @POST("join_category.php")
    Observable<InsertGroupPOJO> joinCategory(@Field("user_id") String user_id,
                                        @Field("group_ids") String group_ids);

    @FormUrlEncoded
    @POST("save_token.php")
    Observable<SuccessResponse> onlyToken(@Field("id_user_name") String userId,
                                    @Field("pushnotificationToken") String token);

    @FormUrlEncoded
    @POST("get_all_chats_new_delete.php")
    Observable<SuccessResponse> deleteEntireChat(@Field("user_id") String userId,
                                    @Field("user_id_second") String user_id_second,
                                    @Field("token") String token);

    @FormUrlEncoded
    @POST("insert_new_custom_name.php")
    Observable<SuccessResponse> insert_new_custom_name(@Field("username") String username,
                                    @Field("avatar_url") String avatar_url,
                                    @Field("senderId") String senderId,
                                    @Field("receiverId") String receiverId);

    @FormUrlEncoded
    @POST("block_user_insert.php")
    Observable<UserResponse> blockUserInsert(@Field("user_id") String currentUserId,
                                    @Field("blocked_id") String userToBeBlockedId,
                                    @Field("token") String token);

    @FormUrlEncoded
    @POST("insert_new_settings.php")
    Observable<SuccessResponse> InsertNewSettings(@Field("age_range") String age_range,
                                    @Field("gender") String gender,
                                    @Field("adult_filter") String adult_filter,
                                    @Field("block_premium_search") String block_premium_search,
                                    @Field("id_user_name") String id_user_name);

    @FormUrlEncoded
    @POST("block_user_delete.php")
    Observable<UserResponse> blockUserDelete(@Field("user_id") String currentUserId,
                                    @Field("blocked_id") String userToBeBlockedId,
                                    @Field("token") String token);


    @GET("unlike_get.php")
    Observable<PostLikesResponse> unlikes(@Query("user_id") String userId,
                                          @Query("post_id") String postId,
                                          @Query("like") int like,
                                          @Query("hug") int hug);

    @FormUrlEncoded
    @POST("login_new_current_latest.php")
    Observable<LoginResponse> login(
            @Field("name") String name,
            @Field("email") String email,
            @Field("user_id") String userId,
            @Field("deviceId") String deviceId,
            @Field("socialNetwork") String socialNetwork
    );

    @FormUrlEncoded
    @POST("login_new_current_skip.php")
    Observable<LoginResponse> profileSkipLogin(
            @Field("name") String name,
            @Field("email") String email,
            @Field("user_id") String userId,
            @Field("deviceId") String deviceId,
            @Field("socialNetwork") String socialNetwork
    );

    @FormUrlEncoded
    @POST("login_new_current_latest.php")
    Observable<LoginResponse> login(
            @Field("deviceId") String deviceId,
            @Field("socialNetwork") String socialNetwork
    );

    /*
    @FormUrlEncoded
    @POST("login_new_current.php")
    Observable<LoginResponse> loginWithoutProfile(
            @Field("name") String name,
            @Field("email") String email,
            @Field("user_id") String userId
    );
    */

    /*
    @FormUrlEncoded
    @POST("postStatust.php")
    Observable<UserResponse> postStatus(
            @Field("user_id") String user_id,
            @Field("post_text") String postStatus,
            @Field("image_url") String image_url,
            @Field("group_id") String group_id,
            @Field("cat_id") String cat_id,
            @Field("feeling_id") String feeling_id,
            @Field("type") String type,
            @Field("adult_filter") String adult_filter
    );



    @GET("get_likers.php")
    Observable<PostSuperUserListModel> getInteractionPosts(
            @Query("id_posts") String id_posts,
            @Query("user_id") String userID,
            @Query("token") String token);

    @GET("get_random_name_comment.php")
    Observable<CheckRandomUserNamePojo> get_random_name_before_notification(
            @Query("id_user_name") String id_user_name,
            @Query("id_posts") String id_posts
    );

    @GET("get_notification.php")
    Observable<List<NotificationPojo>> getNotificationPosts(
            @Query("id_user_name") String id_posts,
            @Query("page") String page);

    @GET("get_notification.php")
    Observable<List<NotificationPojo>> getPushNotification(
            @Query("id_user_name") String id_posts,
            @Query("page") String page);

    @FormUrlEncoded
    @POST("register_mobile.php")
    Observable<BaseResponse> registerMobile(
            @Field("id_user_name") String user_id,
            @Field("phone_number") String phone_number
    );

    // Todo adding all contacts mobile left
    @FormUrlEncoded
    @POST("register_user_contacts.php")
    Observable<ContactAddResponse> addAllContacts(
            @Field("id_user_name") String user_id,
            @Field("contacts") String contacts,
            @Field("givenContact") String givenContact
    );

    // Todo adding all contacts mobile left
    @FormUrlEncoded
    @POST("register_facebook_friends.php")
    Observable<ContactAddResponse> addAllFacebookId(
            @Field("id_user_name") String user_id,
            @Field("facebook_id") String contacts
    );

  /*  @FormUrlEncoded
    @POST("follower_post.php")
    Observable<UserResponse> addFollower(
            @Field("user_id") String user_id,
            @Field("followers") String follower_id,
            @Field("token") String token,
            @Field("action") String action
    );
    */

    /*
    @FormUrlEncoded
    @POST("update_adult.php")
    Observable<SuccessResponse> updateAdult(
            @Field("id_posts") String id_posts,
            @Field("adult_filter") String adult_filter
    );


    /*@GET("follower_get.php")
    Observable<ProfileFollowerUserList> getUserFollow(@Query("user_id") String user_id,
                                                      @Query("token") String token);*/

    /*
    @GET("update_gender.php")
    Observable<SuccessResponse> update_gender(@Query("id_user_name") String id_user_name,
                                                      @Query("gender") String gender);

    @GET("update_age.php")
    Observable<SuccessResponse> update_age(@Query("id_user_name") String id_user_name,
                                                      @Query("age") String gender);

    @GET("get_push_token.php")
    Observable<List<PushTokenCheck>> pushToken(@Query("user_id") String user_id);

    @GET("follower_get.php")
    Observable<ProfileFollowerUserList> getUserFollowing(@Query("follower_id") String feeling_id,
                                                         @Query("user_id") String userID,
                                                         @Query("token") String token);

    @GET("block_user_check.php")
    Observable<SuccessResponse> block_user_check(@Query("blocked_id") String blocked_id,
                                                         @Query("user_id") String user_id,
                                                         @Query("token") String token);

    @GET("get_user_profile.php")
    Observable<ProfileMain> getUserProfile(
            @Query("user_id") String user_id);

    @Headers("Accept: multipart/form-data")
    @Multipart
    @POST("php-storage-2/upload.php")
    Observable<String> uploadFile(@Part MultipartBody.Part file);

    @POST("http://notification.beacandid.com/fcmClientServer/fcm")
    Observable<String> getResponse(
            @Query("dataMsg") String dataMessage,
            @Query("chatText") String chatText,
            @Query("randomSenderId") String randomSenderid,
            @Query("randomReceiverId") String randomReceiverId,
            @Query("chatOnPostId") String chatOnPostId
    );

    @POST("http://notification.beacandid.com/fcmClientServer/fcm")
    Observable<String> getImageResponse(
            @Query("dataMsg") String dataMessage,
            @Query("chatImage") String chatText,
            @Query("randomSenderId") String randomSenderid,
            @Query("randomReceiverId") String randomReceiverId,
            @Query("chatOnPostId") String chatOnPostId

    );


    @GET("http://notification.beacandid.com/fcmClientServer/fcm")
    Observable<String> sendLikeNotification(
            @Query("dataMsg") String dataMessage,
            @Query("randomReceiverId") String randomReceivedId,
            @Query("randomSenderId") String randomSenderId
    );

    @GET("http://notification.beacandid.com/fcmClientServer/fcm")
    Observable<String> sendFollowNotification(
            @Query("dataMsg") String dataMessage,
            @Query("randomSenderId") String randomSenderid,
            @Query("randomReceiverId") String randomReceiverId
    );

    @FormUrlEncoded
    @POST("postComments.php")
    Observable<PostCommentReplyPojo> sendComment(
            @Field("id_user_name") String user_id,
            @Field("id_post_user_name") String id_post_user_name,
            @Field("id_posts") String id_posts,
            @Field("message") String message,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("postComments_reply.php")
    Observable<PostCommentReplyPojo> sendCommentReply(
            @Field("id_post_comments") String id_post_comments,
            @Field("id_user_name") String user_id,
            @Field("id_post_user_name") String id_post_user_name,
            @Field("id_posts") String id_posts,
            @Field("message") String message,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("insert_comment_like.php")
    Observable<SuccessResponse> sendCommentLike(
            @Field("id_post_comment") String id_post_comment,
            @Field("id_user_name") String id_user_name,
            @Field("comment_likes") String comment_likes,
            @Field("user_id") String user_id,
            @Field("token") String token,
            @Field("post_comment_id") String post_comment_id
    );

    @FormUrlEncoded
    @POST("insert_comment_reply_like.php")
    Observable<SuccessResponse> sendCommentReplyLike(
            @Field("id_post_comment_reply") String id_post_comment_reply,
            @Field("id_user_name") String id_user_name,
            @Field("likes") String likes,
            @Field("post_comment_reply_id") String post_comment_reply_id,
            @Field("user_id") String user_id,
            @Field("token") String token

    );

    @FormUrlEncoded
    @POST("report_abuse.php")
    Observable<SuccessResponse> reportAbuse(
            @Field("id_user_name") String id_user_name,
            @Field("sender_user_id") String sender_user_id,
            @Field("id_posts") String id_posts,
            @Field("token") String token,
            @Field("abuse_message") String message
    );

    @FormUrlEncoded
    @POST("insertCategory_new.php")
    Observable<NewCategoryAdded> insertCategory(
            @Field("category") String category,
            @Field("user_id") String userID,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("update_post.php")
    Observable<SuccessResponse> deletePost(
            @Field("id_posts") String category,
            @Field("action") String action
    );

    @FormUrlEncoded
    @POST("update_location.php")
    Observable<SuccessResponse> updateLocation(
            @Field("id_user_name") String id_user_name,
            @Field("givenLocation") String location
    );

    @FormUrlEncoded
    @POST("update_facebook.php")
    Observable<SuccessResponse> updateFacebook(
            @Field("id_user_name") String id_user_name,
            @Field("facebook") String facebook
    );

    @FormUrlEncoded
    @POST("update_post.php")
    Observable<SuccessResponse> updatePost(
            @Field("id_posts") String category,
            @Field("action") String action,
            @Field("text_status") String text_status
    );

    @FormUrlEncoded
    @POST("update_profile.php")
    Observable<SuccessResponse>  updateProfile(
            @Field("id_user_name") String id_user_name,
            @Field("avatar_url") Uri avatar_url,
            @Field("user_nick_name") String user_nick_name,
            @Field("user_nick_name_enc") String user_nick_name_enc,
            @Field("age") String age,
            @Field("token") String token,
            @Field("gender") String gender,
            @Field("about_me") String about_me
    );

    @FormUrlEncoded
    @POST("insertImageUrl.php")
    Observable<SuccessResponse> insertImage(
            @Field("image_url") String image_url,
            @Field("user_id") String user_id,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("delete_chat.php")
    Observable<UserResponse> deleteChat(
            @Field("messageId") String messageId,
            @Field("user_id") String userID,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("delete_comment.php")
    Observable<UserResponse> deleteComment(
            @Field("id_post_comments") String id_post_comments,
            @Field("user_id") String userID,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("delete_comment_reply.php")
    Observable<UserResponse> deleteCommentReply(
            @Field("id_post_comment_reply") String id_post_comment_reply,
            @Field("user_id") String userID,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("save_token.php")
    Observable<SuccessResponse> save_token(
            @Field("id_user_name") String id_user_name,
            @Field("pushnotificationToken") String pushnotificationToken
    );

    @GET("get_search_groups.php")
    Observable<List<CommunityGroupPojo>> getSearchGroups(
            @Query("search_word") String search_word,
            @Query("user_id") String chatText
    );

    @FormUrlEncoded
    @POST("insert_group.php")
    Observable<GroupsCreatePOJO> addGroup(
            @Field("id_categories") String id_categories,
            @Field("user_id") String user_id,
            @Field("group_name") String group_name,
            @Field("group_image") String group_image,
            @Field("group_description") String group_description
    );

    @FormUrlEncoded
    @POST("insert_group.php")
    Observable<GroupsCreatePOJO> addGroup(
            @Field("id_categories") String id_categories,
            @Field("user_id") String user_id,
            @Field("group_name") String group_name
    );

    @FormUrlEncoded
    @POST("join_group.php")
    Observable<InsertGroupPOJO> joinGroup(
            @Field("group_ids") String id_categories,
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("join_category.php")
    Observable<InsertGroupPOJO> categoryGroup(
            @Field("category_ids") String id_categories,
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("unjoin_group.php")
    Observable<InsertGroupPOJO> unJoinGroup(
            @Field("group_ids") String id_categories,
            @Field("user_id") String user_id
    );

    @GET("check_group_name.php")
    Observable<SuccessResponse> checkGroup(
            @Query("group_name") String group_name);

*/
}
