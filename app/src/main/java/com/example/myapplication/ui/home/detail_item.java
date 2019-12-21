package com.example.myapplication.ui.home;

import android.os.Parcel;
import android.os.Parcelable;

public class detail_item implements Parcelable {
    private String courseid;
    private String name;
    private String code;
    private String categoryId;
    private String description;
    private String price;
    private String status;
    private String openDate;
    private String lastUpdateOn;
    private String level;
    private String shared;
    private String sharedUrl;
    private String avatar;
    private String bigAvatar;
    private String certification;
    private String certificationDuration;


    public detail_item(String courseid, String name,String code,String categoryId,String description,String price, String status, String openDate,
            String lastUpdateOn,String level, String shared, String sharedUrl,String avatar,String bigAvatar,String certification,
            String certificationDuration) {
        this.courseid = courseid;
        this.name = name;
        this.code = code;
        this.categoryId = categoryId;
        this.description = description;
        this.price = price;
        this.status = status;
        this.openDate = openDate;
        this.lastUpdateOn = lastUpdateOn;
        this.level = level;
        this.shared = shared;
        this.sharedUrl = sharedUrl;
        this.avatar = avatar;
        this.bigAvatar = bigAvatar;
        this.certification = certification;
        this.certificationDuration = certificationDuration;

    }

    protected detail_item(Parcel in) {
        courseid = in.readString();
        name = in.readString();
        code = in.readString();
        categoryId = in.readString();
        description = in.readString();
        price = in.readString();
        status = in.readString();
        openDate = in.readString();
        lastUpdateOn = in.readString();
        level = in.readString();
        shared = in.readString();
        sharedUrl = in.readString();
        avatar = in.readString();
        bigAvatar = in.readString();
        certification = in.readString();
        certificationDuration = in.readString();
    }

    public static final Creator<detail_item> CREATOR = new Creator<detail_item>() {
        @Override
        public detail_item createFromParcel(Parcel in) {
            detail_item detail_item = new detail_item(in.readString(),in.readString(),in.readString(),in.readString(),
                    in.readString(),in.readString(),in.readString(),in.readString(),
                    in.readString(),in.readString(),in.readString(),in.readString(),
                    in.readString(),in.readString(),in.readString(),in.readString());


            return detail_item ;
        }

        @Override
        public detail_item[] newArray(int size) {
            return new detail_item[size];
        }
    };

    public String getCourseid() {
        return courseid;
    }

    public String getName() {
        return name;
    }

    public String getCode(){return code;}

    public String getCategoryId() {return categoryId; }

    public String getDescription() {
        return description;
    }

    public String getPrice() { return price; }

    public String getStatus() { return status; }

    public String getOpenDate() { return openDate; }

    public String getLastUpdateOn() { return lastUpdateOn; }

    public String getLevel() { return level; }

    public String getShared() { return shared; }

    public String getSharedUrl() { return sharedUrl; }

    public String getAvatar() { return avatar; }

    public String getBigAvatar() { return bigAvatar; }

    public String getCertification() { return certification; }

    public String getCertificationDuration() { return certificationDuration; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(courseid);
        parcel.writeString(name);
        parcel.writeString(code);
        parcel.writeString(categoryId);
        parcel.writeString(description);
        parcel.writeString(price);
        parcel.writeString(status);
        parcel.writeString(openDate);
        parcel.writeString(lastUpdateOn);
        parcel.writeString(level);
        parcel.writeString(shared);
        parcel.writeString(sharedUrl);
        parcel.writeString(avatar);
        parcel.writeString(bigAvatar);
        parcel.writeString(certification);
        parcel.writeString(certificationDuration);
    }
}
