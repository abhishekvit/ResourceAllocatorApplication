package com.example.abhishek.assigmentproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ABHISHEK on 9/24/2017.
 */

public class CustomAdapterAsset extends RecyclerView.Adapter<CustomAdapterAsset.MyViewHolder> {

    private ArrayList<AssetBean> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewAssetMake;
        TextView textViewAssetAllocated;
        //ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewAssetMake = (TextView) itemView.findViewById(R.id.TextViewAssetMake);
            this.textViewAssetAllocated = (TextView) itemView.findViewById(R.id.TextViewAssetAllocated);
            //this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public CustomAdapterAsset(ArrayList<AssetBean> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.asset_card_view, parent, false);

        view.setOnClickListener(EmployeeViewActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewAssetMake = holder.textViewAssetMake;
        TextView textViewAssetAllocated = holder.textViewAssetAllocated;
        //ImageView imageView = holder.imageViewIcon;

        textViewAssetMake.setText(dataSet.get(listPosition).getAssetMake());
        textViewAssetAllocated.setText(dataSet.get(listPosition).getAllocatedTo());
        //imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}