package com.lab.android.testrecorder.model;

/*
Created by Shivichu on 10/7/18
*/

import java.util.List;

public class SectionedDataList {

    String sDate;
    List<DataList> dataList;

    public SectionedDataList(){

    }

    public SectionedDataList(String date, List<DataList> itemList){

        this.sDate = date;
        this.dataList = itemList;

    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public List<DataList> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataList> dataList) {
        this.dataList = dataList;
    }
}
