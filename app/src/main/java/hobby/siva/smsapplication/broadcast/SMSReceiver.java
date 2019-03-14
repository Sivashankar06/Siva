package hobby.siva.smsapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import hobby.siva.smsapplication.Contract;
import hobby.siva.smsapplication.pojo.SMS;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 14/03/19
 */
public class SMSReceiver extends BroadcastReceiver {

    private Contract.IPresenter mListener;

    public SMSReceiver(Contract.IPresenter listener){
        mListener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle data = intent.getExtras();
        Object[] pdus = (Object[]) data.get("pdus");
        for (Object pdu : pdus) {
            SmsMessage message = SmsMessage.createFromPdu((byte[]) pdu);
            String message1 = "Sender : " + message.getDisplayOriginatingAddress()
                    + "Email From: " + message.getEmailFrom()
                    + "Emal Body: " + message.getEmailBody()
                    + "Display message body: " + message.getDisplayMessageBody()
                    + "Time in millisecond: " + message.getTimestampMillis()
                    + "Message: " + message.getMessageBody();
            Log.d("Siva : ", message1);
            mListener.onNewSMSReceived(new SMS(message.getOriginatingAddress(), message.getMessageBody(), message.getTimestampMillis()));
        }
    }
}