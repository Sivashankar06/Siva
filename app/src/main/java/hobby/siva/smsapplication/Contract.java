package hobby.siva.smsapplication;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;

import hobby.siva.smsapplication.pojo.SMS;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
public interface Contract {

    interface IModel {

        ArrayList<SMS> getInitialSMS(Activity actContext);

    }

    interface IView {

        void setInitialMessages(ArrayList<SMS> messages);

        void onNewMessage(ArrayList<SMS> messages);

        void showPlaceHolderWithMessage(String message);

        void hidePlaceHolderWithMessage();

    }

    interface IPresenter {

        void populateSMS();

        void onPermissionRequestFinished();

        void onActivityPause();

        void onActivityResume();

        void onNewSMSReceived(SMS message);

    }
}