package hobby.siva.smsapplication.ui;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import hobby.siva.smsapplication.pojo.SMS;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
public class SMSAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<SMS> mSms = new ArrayList<>();
    private LayoutInflater mInflater;

    public SMSAdapter(Activity context) {
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SMS listItem = mSms.get(position);
    }

    @Override
    public int getItemCount() {
        return mSms.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView timeStampText;
        public TextView messageText;
        public TextView nameText;

        public ItemViewHolder(View view) {
            super(view);
        }
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView headerText;

        public HeaderViewHolder(View view) {
            super(view);
        }
    }
}