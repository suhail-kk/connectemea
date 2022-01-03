package com.example.emea.Activity;

import android.os.Parcel;
import android.os.Parcelable;

public class Family implements Parcelable {
    String fathernameedittext,mothernameedittext,guardiannameedittext;

    public Family(){

    }
    public Family(String fathernameedittext, String mothernameedittext, String guardiannameedittext){
        this.fathernameedittext=fathernameedittext;
        this.mothernameedittext=mothernameedittext;
        this.guardiannameedittext=guardiannameedittext;

    }

    protected Family(Parcel in) {
        fathernameedittext = in.readString();
        mothernameedittext = in.readString();
        guardiannameedittext = in.readString();
    }

    public static final Creator<Family> CREATOR = new Creator<Family>() {
        @Override
        public Family createFromParcel(Parcel in) {
            return new Family(in);
        }

        @Override
        public Family[] newArray(int size) {
            return new Family[size];
        }
    };

    public String getFathernameedittext() {
        return fathernameedittext;
    }

    public void setFathernameedittext(String fathernameedittext) {
        this.fathernameedittext = fathernameedittext;
    }

    public String getMothernameedittext() {
        return mothernameedittext;
    }

    public void setMothernameedittext(String mothernameedittext) {
        this.mothernameedittext = mothernameedittext;
    }

    public String getGuardiannameedittext() {
        return guardiannameedittext;
    }

    public void setGuardiannameedittext(String guardiannameedittext) {
        this.guardiannameedittext = guardiannameedittext;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fathernameedittext);
        dest.writeString(mothernameedittext);
        dest.writeString(guardiannameedittext);
    }
}