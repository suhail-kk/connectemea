package com.example.emea.Activity;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.material.textfield.TextInputEditText;

public class Education implements Parcelable {
    String school, sciencesslcbox, socialsciencesslcbox, sub1box, collegename, coursename;

    public Education() {

    }

    public Education(String school, String sciencesslcbox, String socialsciencesslcbox,String sub1box,String collegename,String coursename) {
        this.school = school;
        this.sciencesslcbox = sciencesslcbox;
        this.socialsciencesslcbox = socialsciencesslcbox;
        this.sub1box = sub1box;
        this.collegename = collegename;
        this.coursename = coursename;
    }

    protected Education(Parcel in) {
        school = in.readString();
        sciencesslcbox = in.readString();
        socialsciencesslcbox = in.readString();
        sub1box = in.readString();
        collegename = in.readString();
        coursename = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(school);
        dest.writeString(sciencesslcbox);
        dest.writeString(socialsciencesslcbox);
        dest.writeString(sub1box);
        dest.writeString(collegename);
        dest.writeString(coursename);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Education> CREATOR = new Creator<Education>() {
        @Override
        public Education createFromParcel(Parcel in) {
            return new Education(in);
        }

        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSciencesslcbox() {
        return sciencesslcbox;
    }

    public void setSciencesslcbox(String sciencesslcbox) {
        this.sciencesslcbox = sciencesslcbox;
    }

    public String getSocialsciencesslcbox() {
        return socialsciencesslcbox;
    }

    public void setSocialsciencesslcbox(String socialsciencesslcbox) {
        this.socialsciencesslcbox = socialsciencesslcbox;
    }

    public String getSub1box() {
        return sub1box;
    }

    public void setSub1box(String sub1box) {
        this.sub1box = sub1box;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
}


