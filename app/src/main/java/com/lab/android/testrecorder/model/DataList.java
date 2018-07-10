package com.lab.android.testrecorder.model;

/*
Created by Shivichu on 10/7/18
*/

public class DataList {

    String sDate,sFileName,sDuration;

    public DataList(){

    }

    public DataList(String fileName,String date, String duration){

        this.sDate = date;
        this.sFileName = fileName;
        this.sDuration = duration;

    }

    public String getsFileName() {
        return sFileName;
    }

    public void setsFileName(String sFileName) {
        this.sFileName = sFileName;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String getsDuration() {
        return sDuration;
    }

    public void setsDuration(String sDuration) {
        this.sDuration = sDuration;
    }
}
