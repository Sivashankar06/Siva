package hobby.siva.smsapplication.data;

import android.app.Activity;
import android.database.Cursor;
import android.provider.Telephony;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
public class SMSReader implements ISMSReader{

    @Override
    public void readSMS (Activity actContext) {
        // DI should give Alert and Permission checker
        Cursor cur = actContext.getContentResolver().query(Telephony.Sms.Inbox.CONTENT_URI, null, null, null,null);
        
    }
}
