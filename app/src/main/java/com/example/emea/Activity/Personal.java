package com.example.emea.Activity;

import android.os.Parcel;
import android.os.Parcelable;

public class Personal implements Parcelable {
    String name,admissionNo,yearOfAdmission,rollNo;
    public Personal(){

    }
    public Personal(String name, String rollNo, String admissionNo, String yearOfAdmission){
        this.name=name;
        this.rollNo=rollNo;
        this.admissionNo=admissionNo;
        this.yearOfAdmission=yearOfAdmission;
    }


    protected Personal(Parcel in) {
        name = in.readString();
        admissionNo = in.readString();
        yearOfAdmission = in.readString();
        rollNo = in.readString();
    }

    public static final Creator<Personal> CREATOR = new Creator<Personal>() {
        @Override
        public Personal createFromParcel(Parcel in) {
            return new Personal(in);
        }

        @Override
        public Personal[] newArray(int size) {
            return new Personal[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getAdmissionNo() {
        return admissionNo;
    }

    public String getYearOfAdmission() {
        return yearOfAdmission;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    public void setYearOfAdmission(String yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(admissionNo);
        dest.writeString(yearOfAdmission);
        dest.writeString(rollNo);
    }
}
