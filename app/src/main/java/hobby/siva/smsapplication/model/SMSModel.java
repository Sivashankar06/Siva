package hobby.siva.smsapplication.model;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.Telephony;

import java.util.ArrayList;

import javax.inject.Inject;

import hobby.siva.smsapplication.Contract;
import hobby.siva.smsapplication.pojo.SMS;
import hobby.siva.smsapplication.util.TimeValidator;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
public class SMSModel implements Contract.IModel {

    private static final String TAG = SMSModel.class.getSimpleName();

    private ArrayList<SMS> mSMSList = new ArrayList<>();

    @Inject
    public SMSModel(){}

    @Override
    public ArrayList<SMS> getInitialSMS(Activity actContext) {
        mSMSList.clear();
        String[] projection = new String[]{
                Telephony.Sms.Inbox.DATE,
                Telephony.Sms.Inbox.BODY,
                Telephony.Sms.Inbox.ADDRESS
        };
        ContentResolver resolver = actContext.getContentResolver();
        if(resolver != null) {
            Cursor cur = resolver.query(Telephony.Sms.Inbox.CONTENT_URI, projection, null, null,null);
            if(cur != null) {
                while (cur.moveToNext()) {
                    String msgTime = cur.getString(cur.getColumnIndex(Telephony.Sms.Inbox.DATE));
                    if(TimeValidator.isToday(msgTime)) {
                        SMS sms = new SMS(cur.getString(cur.getColumnIndex(Telephony.Sms.Inbox.ADDRESS)),
                                cur.getString(cur.getColumnIndex(Telephony.Sms.Inbox.BODY)), Long.parseLong(msgTime));
                        mSMSList.add(sms);
                    } else {
                        break;
                    }
                }
                cur.close();
            }
        }
        return mSMSList;
    }
}