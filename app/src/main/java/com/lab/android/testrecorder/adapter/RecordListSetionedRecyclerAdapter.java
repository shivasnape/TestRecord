package com.lab.android.testrecorder.adapter;

/*
Created by Shivichu on 10/7/18
*/

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.lab.android.testrecorder.R;
import com.lab.android.testrecorder.model.DataList;
import com.lab.android.testrecorder.model.SectionedDataList;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecordListSetionedRecyclerAdapter extends com.wesix.witscon.adapter.SectionedRecyclerViewAdapter<RecyclerView.ViewHolder> {


    private List<SectionedDataList> allData;
    private Context mContext;
    Context context;

    public RecordListSetionedRecyclerAdapter(Context context,List<SectionedDataList> data) {
        this.mContext = context;
        this.allData = data;
    }


    @Override
    public int getSectionCount() {
        return allData.size();
    }

    @Override
    public int getItemCount(int section) {
        return allData.get(section).getDataList().size();

    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int section) {

        String sectionName = allData.get(section).getsDate();
        SectionViewHolder sectionViewHolder = (SectionViewHolder) holder;
        sectionViewHolder.sectionTitle.setText(sectionName);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int section, final int relativePosition, int absolutePosition) {

        final List<DataList> itemsInSection = allData.get(section).getDataList();
//        String itemName = itemsInSection.get(relativePosition).getsTypeName();
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
//        itemViewHolder.itemTitle.setText(itemName);
        // Try to put a image . for sample i set background color in xml layout file
        // itemViewHolder.itemImage.setBackgroundColor(Color.parseColor("#01579b"));

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, boolean header) {
        View v = null;
        context = parent.getContext();
        if (header)
        {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_section_common, parent, false);
            return new SectionViewHolder(v);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_record_list_layout, parent, false);
            return new ItemViewHolder(v);
        }

    }


    // SectionViewHolder Class for Sections
    public static class SectionViewHolder extends RecyclerView.ViewHolder {


        final TextView sectionTitle;

        public SectionViewHolder(View itemView) {
            super(itemView);

            sectionTitle = (TextView) itemView.findViewById(R.id.sectionTitle);


        }
    }

    // ItemViewHolder Class for Items in each Section
    public static class ItemViewHolder extends RecyclerView.ViewHolder {

//        final TextView itemTitle;
//        final ImageView itemImage;

        public ItemViewHolder(View itemView) {
            super(itemView);




           /* itemTitle = (TextView) itemView.findViewById(R.id.itemTitle);
            itemImage = (ImageView) itemView.findViewById(R.id.itemImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(v.getContext(), itemTitle.getText(), Toast.LENGTH_SHORT).show();

                }
            });*/



        }
    }


    private String changDateFormat(String date) {

        Date fDate = null;
        String outPut = null;


        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "dd/MM/yyyy";

        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        try {
            fDate = inputFormat.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        outPut = outputFormat.format(fDate);

        return outPut;

    }

}
