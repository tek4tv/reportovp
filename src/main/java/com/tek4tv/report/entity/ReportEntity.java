package com.tek4tv.report.entity;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "report")
public class ReportEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "account")
    private String account;
    @Column(name = "age")
    private String age;
    @Column(name = "active_user")
    private Long activeUser;
    @Column(name = "active_media")
    private Long activeMedia;
    @Column(name = "ad_mode_begin")
    private Long adModeBegin;
    @Column(name = "ad_mode_complete")
    private Long adModeComplete;
    @Column(name = "bytes_delivered")
    private String bytesDelivered;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "daily_unique_viewers")
    private Long dailyUniqueViewers;
    @Column(name = "date")
    private String date;
    @Column(name = "date_hour")
    private String dateHour;
    @Column(name = "destination_domain")
    private String destinationDomain;
    @Column(name = "destination_path")
    private String destinationPath;
    @Column(name = "device_os")
    private String deviceOs;
    @Column(name = "device_type")
    private String deviceType;
    @Column(name = "engagement_score")
    private String engagementScore;
    @Column(name = "play_rate")
    private String playRate;
    @Column(name = "play_request")
    private Long playRequest;
    @Column(name = "referrer_domain")
    private String referrerDomain;
    @Column(name = "source_type")
    private String sourceType;
    @Column(name = "video")
    private String video;
    @Column(name = "video_duration")
    private Long videoDuration;
    @Column(name = "video_name")
    private String videoName;
    @Column(name = "video_impression")
    private String videoImpression;
    @Column(name = "video_percent_viewed")
    private String videoPercentViewed;
    @Column(name = "video_second_viewed")
    private String videoSecondViewed;
    @Column(name = "video_view")
    private String videoView;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Long getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Long activeUser) {
        this.activeUser = activeUser;
    }

    public Long getActiveMedia() {
        return activeMedia;
    }

    public void setActiveMedia(Long activeMedia) {
        this.activeMedia = activeMedia;
    }

    public Long getAdModeBegin() {
        return adModeBegin;
    }

    public void setAdModeBegin(Long adModeBegin) {
        this.adModeBegin = adModeBegin;
    }

    public Long getAdModeComplete() {
        return adModeComplete;
    }

    public void setAdModeComplete(Long adModeComplete) {
        this.adModeComplete = adModeComplete;
    }

    public String getBytesDelivered() {
        return bytesDelivered;
    }

    public void setBytesDelivered(String bytesDelivered) {
        this.bytesDelivered = bytesDelivered;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getDailyUniqueViewers() {
        return dailyUniqueViewers;
    }

    public void setDailyUniqueViewers(Long dailyUniqueViewers) {
        this.dailyUniqueViewers = dailyUniqueViewers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateHour() {
        return dateHour;
    }

    public void setDateHour(String dateHour) {
        this.dateHour = dateHour;
    }

    public String getDestinationDomain() {
        return destinationDomain;
    }

    public void setDestinationDomain(String destinationDomain) {
        this.destinationDomain = destinationDomain;
    }

    public String getDestinationPath() {
        return destinationPath;
    }

    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    public String getDeviceOs() {
        return deviceOs;
    }

    public void setDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getEngagementScore() {
        return engagementScore;
    }

    public void setEngagementScore(String engagementScore) {
        this.engagementScore = engagementScore;
    }

    public String getPlayRate() {
        return playRate;
    }

    public void setPlayRate(String playRate) {
        this.playRate = playRate;
    }

    public Long getPlayRequest() {
        return playRequest;
    }

    public void setPlayRequest(Long playRequest) {
        this.playRequest = playRequest;
    }

    public String getReferrerDomain() {
        return referrerDomain;
    }

    public void setReferrerDomain(String referrerDomain) {
        this.referrerDomain = referrerDomain;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Long getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(Long videoDuration) {
        this.videoDuration = videoDuration;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoImpression() {
        return videoImpression;
    }

    public void setVideoImpression(String videoImpression) {
        this.videoImpression = videoImpression;
    }

    public String getVideoPercentViewed() {
        return videoPercentViewed;
    }

    public void setVideoPercentViewed(String videoPercentViewed) {
        this.videoPercentViewed = videoPercentViewed;
    }

    public String getVideoSecondViewed() {
        return videoSecondViewed;
    }

    public void setVideoSecondViewed(String videoSecondViewed) {
        this.videoSecondViewed = videoSecondViewed;
    }

    public String getVideoView() {
        return videoView;
    }

    public void setVideoView(String videoView) {
        this.videoView = videoView;
    }
}
