package com.integro.dbhs.apis;

import com.integro.dbhs.model.AnnouncementList;
import com.integro.dbhs.model.CoverPhotosList;
import com.integro.dbhs.model.NewsLetterList;
import com.integro.dbhs.model.NewsList;
import com.integro.dbhs.model.NotificationList;
import com.integro.dbhs.model.PrincipalMessageList;
import com.integro.dbhs.model.UpcomingEventsList;
import com.integro.dbhs.model.VideosList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {

    @FormUrlEncoded
    @POST("dbhs_news.php")
    Call<NewsList>getNewsList(@Field("updated_at")String updated_at);

    @FormUrlEncoded
    @POST("dbhs_notification.php")
    Call<NotificationList>getNotificationList(@Field("updated_at")String updated_at);

    @FormUrlEncoded
    @POST("dbhs_events.php")
    Call<UpcomingEventsList>getUpcomingEventsList(@Field("updated_at")String updated_at);

    @FormUrlEncoded
    @POST("dbhs_coverphoto.php")
    Call<CoverPhotosList>getCoverPhotosList(@Field("updated_at")String updated_at);

    @FormUrlEncoded
    @POST("dbhs_newsletter.php")
    Call<NewsLetterList>getNewsLetterList(@Field("updated_at")String updated_at);

    @GET("dbhs_announcement.php")
    Call<AnnouncementList>getAnnouncementList();

    @FormUrlEncoded
    @POST("dbhs_principal.php")
    Call<PrincipalMessageList>getPrincipalMessageList(@Field("updated_at")String updated_at);

    @FormUrlEncoded
    @POST("dbhs_videos.php")
    Call<VideosList> getVideos(String date);
}
