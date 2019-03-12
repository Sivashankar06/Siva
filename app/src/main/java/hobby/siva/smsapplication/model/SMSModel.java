package hobby.siva.smsapplication.model;

import android.app.Activity;
import android.database.Cursor;
import android.provider.Telephony;

import javax.inject.Inject;

import hobby.siva.smsapplication.Contract;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
public class SMSModel implements Contract.IModel {

    @Inject
    public SMSModel(){}

    @Override
    public void readSMS(Activity actContext) {
        // DI should give Alert and Permission checker
        Cursor cur = actContext.getContentResolver().query(Telephony.Sms.Inbox.CONTENT_URI, null, null, null,null);
        String sms = "";
        while (cur.moveToNext()) {
            sms += "From :" + cur.getString(2) + " : " + cur.getString(11)+"\n";
        }
    }
}
