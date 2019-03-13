package hobby.siva.smsapplication.ui;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import hobby.siva.smsapplication.R;
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
        View view = mInflater.inflate(R.layout.sms_list_item_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SMS listItem = mSms.get(position);
        ((ItemViewHolder)holder).nameText.setText(listItem.getSender());
        ((ItemViewHolder)holder).messageText.setText(listItem.getMessageBody());
        ((ItemViewHolder)holder).timeStampText.setText(listItem.getTime()+"");
        ((ItemViewHolder)holder).timeStampText.setVisibility(position % 3 == 0 ? View.VISIBLE : View.GONE); // TODO
    }

    @Override
    public int getItemCount() {
        return mSms.size();
    }

    public void addAll(ArrayList<SMS> messages) {
        mSms.addAll(messages);
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView nameText;
        public TextView messageText;
        public TextView timeStampText;

        public ItemViewHolder(View view) {
            super(view);
            nameText = view.findViewById(R.id.sender_name);
            messageText = view.findViewById(R.id.message);
            timeStampText = view.findViewById(R.id.time_stamp);
        }
    }
}